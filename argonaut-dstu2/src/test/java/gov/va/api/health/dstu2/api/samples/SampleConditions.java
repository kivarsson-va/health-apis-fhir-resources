package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Condition;
import gov.va.api.health.dstu2.api.resources.Condition.ClinicalStatusCode;
import gov.va.api.health.dstu2.api.resources.Condition.Evidence;
import gov.va.api.health.dstu2.api.resources.Condition.Stage;
import gov.va.api.health.dstu2.api.resources.Condition.VerificationStatusCode;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleConditions {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Condition condition() {
    return Condition.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .patient(reference())
        .encounter(reference())
        .asserter(reference())
        .dateRecorded("2000-10-01")
        .code(codeableConcept())
        .category(codeableConcept())
        .clinicalStatus(ClinicalStatusCode.active)
        .verificationStatus(VerificationStatusCode.provisional)
        .severity(codeableConcept())
        .onsetAge(age())
        .abatementBoolean(true)
        .stage(stage())
        .evidence(evidence().asList())
        .bodySite(codeableConcept().asList())
        .notes("HelloText")
        .build();
  }

  public Evidence evidence() {
    return Evidence.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .code(codeableConcept())
        .detail(reference().asList())
        .build();
  }

  public Stage stage() {
    return Stage.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .summary(codeableConcept())
        .assessment(reference().asList())
        .build();
  }
}
