package gov.va.api.health.fhir.api.visitor;

import gov.va.api.health.fhir.api.IsReference;
import gov.va.api.health.fhir.api.IsResource;
import java.util.function.BiConsumer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Visitors {

  /**
   * Combine multiple visitors to allow traversing an object graph once, while still maintaining
   * different visitors.
   */
  public static Visitor combine(Visitor... visitors) {
    return (location) -> {
      for (var visitor : visitors) {
        visitor.visit(location);
      }
    };
  }

  /** Create a visitor that only see IsReference instances. */
  public static Visitor referenceVisitor(BiConsumer<InspectionLocation, IsReference> visit) {
    return typeVisitor(IsReference.class, visit);
  }

  /** Create a visitor that only see IsResource instances. */
  public static Visitor resourceVisitor(BiConsumer<InspectionLocation, IsResource> visit) {
    return typeVisitor(IsResource.class, visit);
  }

  /** Create a visitor that only sees the given type of values. */
  public static <T> Visitor typeVisitor(Class<T> type, BiConsumer<InspectionLocation, T> visitor) {
    return (location) -> {
      if (type.isInstance(location.value())) {
        visitor.accept(location, type.cast(location.value()));
      }
    };
  }
}
