package gov.va.api.health.fhir.api.visitor;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

/** Provides inspection capability to an object graph. */
@Builder
public class Inspector {

  @NonNull private final Object root;
  @NonNull private final Visitor visitor;

  /**
   * Track items that have been already visited. We use an Identity map to ensure that different,
   * but equal values in more than location in the tree are visited, for example, a bundle that a
   * reference to patient in each resource. Each patient reference is _equal_, but different. We
   * want to allow the visitor to see each one individually.
   */
  private final IdentityHashMap<Object, Boolean> visited = new IdentityHashMap<>();

  /**
   * In addition to numbers, strings, booleans, temporal objects, additional types can be excluded
   * from introspection on a case-by-case basis. For example, you may want to skip Extension,
   * CodeableConcept, Coding, Quantity, Range, etc.
   */
  @Builder.Default private final Set<Class<?>> doNotIntrospect = Set.of();

  public void inspect() {
    inspectRecursively(new RootInspectionLocation(root));
  }

  private void inspectIterable(InspectionLocation location, Iterable<?> iterable) {
    int index = 0;
    for (Object value : iterable) {
      var indexedLocation =
          new IndexedInspectionLocation(location.parent(), value, location.field(), index);
      index++;
      if (isVisitUseful(value.getClass())) {
        inspectRecursively(indexedLocation);
      }
    }
  }

  private void inspectRecursively(InspectionLocation location) {
    if (location == null || location.value() == null) {
      return;
    }

    if (visited.containsKey(location.value())) {
      return;
    }
    visited.put(location.value(), true);

    if (location.value() instanceof Iterable<?>) {
      if (isVisitingListUseful(location)) {
        visitor.visit(location);
      }
      inspectIterable(location, (Iterable<?>) location.value());
      return;
    }

    if (location.value() instanceof Map<?, ?>) {
      if (isVisitingMapUseful(location)) {
        visitor.visit(location);
      }
      inspectIterable(location, ((Map<?, ?>) location.value()).values());
      return;
    }

    visitor.visit(location);

    ReflectionUtils.doWithFields(
        location.value().getClass(), visitField(location.value(), location), this::isVisitUseful);
  }

  private boolean isVisitUseful(Class<?> type) {
    return !type.isPrimitive()
        && !type.isEnum()
        && !Number.class.isAssignableFrom(type)
        && !CharSequence.class.isAssignableFrom(type)
        && !Temporal.class.isAssignableFrom(type)
        && !Date.class.isAssignableFrom(type)
        && !Calendar.class.isAssignableFrom(type)
        && !doNotIntrospect.contains(type);
  }

  private boolean isVisitUseful(Field field) {
    return !Modifier.isStatic(field.getModifiers()) && isVisitUseful(field.getType());
  }

  private boolean isVisitingCollectionUseful(InspectionLocation location, int typeParameterIndex) {
    if (location.field() == null) {
      return false;
    }
    var genericType = location.field().getGenericType();
    if (!(genericType instanceof ParameterizedType)) {
      return false;
    }
    var typeArgs = ((ParameterizedType) genericType).getActualTypeArguments();
    if (typeArgs.length < typeParameterIndex + 1) {
      return false;
    }
    var type = typeArgs[typeParameterIndex];
    if (!(type instanceof Class<?>)) {
      return false;
    }
    return isVisitUseful((Class<?>) type);
  }

  private boolean isVisitingListUseful(InspectionLocation location) {
    return isVisitingCollectionUseful(location, 0);
  }

  private boolean isVisitingMapUseful(InspectionLocation location) {
    return isVisitingCollectionUseful(location, 1);
  }

  private FieldCallback visitField(Object node, InspectionLocation location) {
    return field -> {
      ReflectionUtils.makeAccessible(field);
      var fieldValue = ReflectionUtils.getField(field, node);
      if (fieldValue == null) {
        return;
      }
      InspectionLocation fieldLocation =
          new NonIndexedInspectionLocation(location, fieldValue, field);
      inspectRecursively(fieldLocation);
    };
  }
}
