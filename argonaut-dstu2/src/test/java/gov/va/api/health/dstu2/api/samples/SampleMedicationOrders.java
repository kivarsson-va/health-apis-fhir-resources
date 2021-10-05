package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.MedicationOrder;
import gov.va.api.health.dstu2.api.resources.MedicationOrder.DispenseRequest;
import gov.va.api.health.dstu2.api.resources.MedicationOrder.DosageInstruction;
import gov.va.api.health.dstu2.api.resources.MedicationOrder.Status;
import gov.va.api.health.dstu2.api.resources.MedicationOrder.Substitution;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleMedicationOrders {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public DispenseRequest dispenseRequest() {
    return DispenseRequest.builder()
        .id("2222")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .medicationCodeableConcept(codeableConcept())
        .validityPeriod(period())
        .numberOfRepeatsAllowed(10)
        .quantity(simpleQuantity())
        .expectedSupplyDuration(duration())
        .build();
  }

  public DosageInstruction dosageInstruction() {
    return DosageInstruction.builder()
        .id("2222")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .text("Hello Text")
        .additionalInstructions(codeableConcept())
        .timing(timing())
        .asNeededBoolean(true)
        .siteCodeableConcept(codeableConcept())
        .route(codeableConcept())
        .method(codeableConcept())
        .doseQuantity(simpleQuantity())
        .rateRange(range())
        .maxDosePerDay(ratio())
        .build();
  }

  public MedicationOrder medicationOrder() {
    return MedicationOrder.builder()
        .id("2222")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .dateWritten("2000-10-01")
        .status(Status.active)
        .dateEnded("2000-10-01")
        .reasonEnded(codeableConcept())
        .patient(reference())
        .prescriber(reference())
        .reasonCodeableConcept(codeableConcept())
        .note("Hello Note")
        .medicationReference(reference())
        .dosageInstruction(dosageInstruction().asList())
        .dispenseRequest(dispenseRequest())
        .substitution(substitution())
        .priorPrescription(reference())
        .build();
  }

  public Substitution substitution() {
    return Substitution.builder()
        .id("2222")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(codeableConcept())
        .reason(codeableConcept())
        .build();
  }
}
