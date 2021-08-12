package gov.va.api.health.fhir.api.visitor;

import java.lang.reflect.Field;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings("ClassCanBeRecord")
class IndexedInspectionLocation implements InspectionLocation {

  InspectionLocation parent;

  Object value;

  Field field;

  int index;

  @Override
  public String toString() {
    return parent + "." + field.getName() + "[" + index + "]";
  }
}
