package gov.va.api.health.fhir.api.visitor;

import java.lang.reflect.Field;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("ClassCanBeRecord")
class RootInspectionLocation implements InspectionLocation {

  Object value;

  @Override
  public Field field() {
    return null;
  }

  @Override
  public int index() {
    return NOT_INDEXED;
  }

  @Override
  public InspectionLocation parent() {
    return null;
  }

  @Override
  public String toString() {
    return "~";
  }
}
