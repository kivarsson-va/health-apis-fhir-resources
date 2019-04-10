package gov.va.api.health.r4.api.validation;

public class ZeroOrOneOfValidator extends AbstractSetFieldCounter<ZeroOrOneOf> {

  @Override
  protected String[] fields() {
    return annotation.fields();
  }

  @Override
  protected boolean isNumberOfFieldsSetValid(int numberOfFieldsSet) {
    return numberOfFieldsSet <= 1;
  }
}
