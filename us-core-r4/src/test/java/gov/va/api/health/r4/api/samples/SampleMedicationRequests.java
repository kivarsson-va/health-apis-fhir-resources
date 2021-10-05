package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.DataAbsentReason;
import gov.va.api.health.r4.api.resources.MedicationRequest;
import gov.va.api.health.r4.api.resources.MedicationRequest.DispenseRequest;
import gov.va.api.health.r4.api.resources.MedicationRequest.DispenseRequest.InitialFill;
import gov.va.api.health.r4.api.resources.MedicationRequest.Substitution;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleMedicationRequests {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public DispenseRequest dispenseRequest() {
    return DispenseRequest.builder()
        .initialFill(InitialFill.builder().quantity(simpleQuantity()).duration(duration()).build())
        .dispenseInterval(duration())
        .validityPeriod(period())
        .numberOfRepeatsAllowed(41)
        .quantity(simpleQuantity())
        .expectedSupplyDuration(duration())
        .performer(reference())
        .build();
  }

  public MedicationRequest medicationRequest() {
    return MedicationRequest.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .status(MedicationRequest.Status.active)
        .statusReason(codeableConcept())
        .intent(MedicationRequest.Intent.original_order)
        .category(codeableConcept().asList())
        .priority(MedicationRequest.Priority.asap)
        .doNotPerform(true)
        .reportedBoolean(true)
        .medicationCodeableConcept(codeableConcept())
        .subject(reference())
        .encounter(reference())
        .supportingInformation(reference().asList())
        .authoredOn("2015-04-15T04:00:00Z")
        .requester(reference())
        .performer(reference())
        .performerType(codeableConcept())
        .recorder(reference())
        .reasonCode(codeableConcept().asList())
        .reasonReference(reference().asList())
        .instantiatesCanonical(List.of("canonical"))
        .instantiatesUri(List.of("uri"))
        .basedOn(reference().asList())
        .groupIdentifier(identifier())
        .courseOfTherapyType(codeableConcept())
        .insurance(reference().asList())
        .note(annotation().asList())
        .dosageInstruction(dosage().asList())
        .dispenseRequest(dispenseRequest())
        .substitution(substitution())
        .priorPrescription(reference())
        .detectedIssue(reference().asList())
        .eventHistory(reference().asList())
        .build();
  }

  public MedicationRequest medicationRequestWithDataAbsentReason() {
    return medicationRequest()
        ._requester(DataAbsentReason.of(DataAbsentReason.Reason.unknown))
        .requester(null);
  }

  public Substitution substitution() {
    return Substitution.builder().allowedBoolean(true).reason(codeableConcept()).build();
  }
}
