package gov.va.api.health.r4.api.samples;

import static gov.va.api.health.r4.api.resources.MedicationDispense.Performer;
import static gov.va.api.health.r4.api.resources.MedicationDispense.Status;
import static gov.va.api.health.r4.api.resources.MedicationDispense.Substitution;
import static gov.va.api.health.r4.api.resources.MedicationDispense.builder;

import gov.va.api.health.r4.api.resources.MedicationDispense;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleMedicationDispenses {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public MedicationDispense medicationDispense() {
    return builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .status(Status.preparation)
        .statusReasonCodeableConcept(codeableConcept())
        .category(codeableConcept().asList())
        .medicationCodeableConcept(codeableConcept())
        .subject(reference())
        .context(reference())
        .supportingInformation(reference().asList())
        .performer(performer())
        .location(reference())
        .authorizingPrescription(reference().asList())
        .type(codeableConcept())
        .quantity(simpleQuantity())
        .daysSupply(simpleQuantity())
        .whenPrepared("2015-04-15T04:00:00Z")
        .whenHandedOver("2015-04-15T08:00:00Z")
        .destination(reference())
        .receiver(reference().asList())
        .note(annotation().asList())
        .dosageInstruction(dosage().asList())
        .substitution(substitution())
        .detectedIssue(reference().asList())
        .eventHistory(reference().asList())
        .build();
  }

  public Performer performer() {
    return Performer.builder().actor(reference()).function(codeableConcept()).build();
  }

  public Substitution substitution() {
    return Substitution.builder()
        .wasSubstituted(false)
        .type(codeableConcept())
        .reason(codeableConcept().asList())
        .responsibleParty(reference().asList())
        .build();
  }
}
