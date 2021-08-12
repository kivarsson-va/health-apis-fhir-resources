package gov.va.api.health.fhir.api.visitor;

import java.lang.reflect.Field;

public interface InspectionLocation {

  int NOT_INDEXED = -1;

  /** Field on parent location value. */
  Field field();

  int index();

  default boolean isIndexed() {
    return index() != NOT_INDEXED;
  }

  default boolean isRoot() {
    return parent() == null;
  }

  InspectionLocation parent();

  Object value();
}
