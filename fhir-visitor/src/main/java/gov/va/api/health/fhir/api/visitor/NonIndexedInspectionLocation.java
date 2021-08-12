package gov.va.api.health.fhir.api.visitor;

import java.lang.reflect.Field;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("ClassCanBeRecord")
class NonIndexedInspectionLocation implements InspectionLocation {

  InspectionLocation parent;

  Object value;

  Field field;

  @Override
  public int index() {
    return NOT_INDEXED;
  }

  @Override
  public String toString() {
    return parent + "." + field.getName();
  }
}
