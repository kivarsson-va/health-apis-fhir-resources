package gov.va.api.health.validation.api;

public class ExactlyOneOfValidator extends AbstractSetFieldCounter<ExactlyOneOf> {

  @Override
  protected String[] fields() {
    return annotation.fields();
  }

  @Override
  protected boolean isNumberOfFieldsSetValid(int numberOfFieldsSet) {
    return numberOfFieldsSet == 1;
  }
}
