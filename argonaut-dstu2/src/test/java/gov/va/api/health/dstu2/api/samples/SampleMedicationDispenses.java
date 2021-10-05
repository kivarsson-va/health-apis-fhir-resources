package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.MedicationDispense;
import gov.va.api.health.dstu2.api.resources.MedicationDispense.DosageInstruction;
import gov.va.api.health.dstu2.api.resources.MedicationDispense.Status;
import gov.va.api.health.dstu2.api.resources.MedicationDispense.Substitution;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleMedicationDispenses {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public DosageInstruction dosageInstruction() {
    return DosageInstruction.builder()
        .id("123")
        .modifierExtension(extension().asList())
        .extension(extension().asList())
        .text("Take orally, morning and night")
        .additionalInstructions(codeableConcept())
        .timing(timing())
        .asNeededBoolean(false)
        .siteCodeableConcept(codeableConcept())
        .route(codeableConcept())
        .method(codeableConcept())
        .doseQuantity(simpleQuantity())
        .rateRatio(ratio())
        .maxDosePerPeriod(ratio())
        .build();
  }

  public MedicationDispense medicationDispense() {
    return MedicationDispense.builder()
        .id("789")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("English")
        .contained(simpleResourceList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier())
        .text(narrative())
        .status(Status.completed)
        .patient(reference())
        .dispenser(reference())
        .authorizingPrescription(reference().asList())
        .type(codeableConcept())
        .quantity(simpleQuantity())
        .daysSupply(simpleQuantity())
        .medicationReference(reference())
        .whenPrepared("2018-01-02T04:00:00Z")
        .whenHandedOver("2018-01-04T04:00:00Z")
        .destination(reference())
        .receiver(reference().asList())
        .note("Do not feed to dogs")
        .dosageInstruction(dosageInstruction().asList())
        .substitution(substitution())
        .build();
  }

  public Substitution substitution() {
    return Substitution.builder()
        .id("456")
        .modifierExtension(extension().asList())
        .extension(extension().asList())
        .type(codeableConcept())
        .reason(codeableConcept().asList())
        .responsibleParty(reference().asList())
        .build();
  }
}
