package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Condition;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleConditions {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Condition condition() {
    return Condition.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .clinicalStatus(codeableConcept())
        .verificationStatus(codeableConcept())
        .category(codeableConcept().asList())
        .severity(codeableConcept())
        .bodySite(codeableConcept().asList())
        .subject(reference())
        .encounter(reference())
        .onsetDateTime("2015-04-15T04:00:00Z")
        .abatementDateTime("2015-04-15T04:00:00Z")
        .recordedDate("2015-04-15T04:00:00Z")
        .recorder(reference())
        .asserter(reference())
        .stage(stage().asList())
        .evidence(evidence().asList())
        .note(annotation().asList())
        .build();
  }

  public Condition.Evidence evidence() {
    return Condition.Evidence.builder()
        .id("9012")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .code(codeableConcept().asList())
        .detail(reference().asList())
        .build();
  }

  public Condition.Stage stage() {
    return Condition.Stage.builder()
        .id("5678")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .summary(codeableConcept())
        .assessment(reference().asList())
        .type(codeableConcept())
        .build();
  }
}
