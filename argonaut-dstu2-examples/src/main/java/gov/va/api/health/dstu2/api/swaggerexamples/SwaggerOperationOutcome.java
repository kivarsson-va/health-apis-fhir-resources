package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.resources.OperationOutcome;

public class SwaggerOperationOutcome {
  /**
   * An example OperationOutcome.
   *
   * @return an example OperationOutcome.
   */
  public static OperationOutcome operationOutcome() {
    return OperationOutcome.builder()
        .issue(
            OperationOutcome.Issue.builder()
                .severity(OperationOutcome.Issue.IssueSeverity.error)
                .code("request error")
                .details(
                    CodeableConcept.builder().text("This request can not be processed").build())
                .build()
                .asList())
        .build();
  }
}
