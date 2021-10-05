package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Encounter;
import gov.va.api.health.dstu2.api.resources.Encounter.EncounterClass;
import gov.va.api.health.dstu2.api.resources.Encounter.EncounterLocation;
import gov.va.api.health.dstu2.api.resources.Encounter.Hospitalization;
import gov.va.api.health.dstu2.api.resources.Encounter.Participant;
import gov.va.api.health.dstu2.api.resources.Encounter.Status;
import gov.va.api.health.dstu2.api.resources.Encounter.StatusHistory;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * This class provides data structures that are populated with dummy values, suitable for testing
 * serialization.
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleEncounters {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Encounter encounter() {
    return Encounter.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .status(Status.arrived)
        .statusHistory(statusHistory().asList())
        .encounterClass(EncounterClass.ambulatory)
        .type(codeableConceptList())
        .priority(codeableConceptList())
        .patient(reference())
        .episodeOfCare(referenceList())
        .incomingReferral(referenceList())
        .participant(participant().asList())
        .appointment(reference())
        .period(period())
        .length(duration())
        .reason(codeableConceptList())
        .indication(referenceList())
        .hospitalization(hospitalization())
        .location(location().asList())
        .serviceProvider(reference())
        .partOf(reference())
        .build();
  }

  public Hospitalization hospitalization() {
    return Hospitalization.builder()
        .id("2222")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .preAdmissionIdentifier(identifier())
        .origin(reference())
        .admitSource(codeableConcept())
        .admittingDiagnosis(referenceList())
        .reAdmission(codeableConcept())
        .dietPreference(codeableConceptList())
        .specialCourtesy(codeableConceptList())
        .specialArrangement(codeableConceptList())
        .destination(reference())
        .dischargeDisposition(codeableConcept())
        .dischargeDiagnosis(referenceList())
        .build();
  }

  public EncounterLocation location() {
    return EncounterLocation.builder()
        .id("3333")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .location(reference())
        .status(EncounterLocation.Status.active)
        .period(period())
        .build();
  }

  public Participant participant() {
    return Participant.builder()
        .id("1111")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(codeableConceptList())
        .period(period())
        .individual(reference())
        .build();
  }

  public StatusHistory statusHistory() {
    return StatusHistory.builder()
        .id("0000")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .status(Status.planned)
        .period(period())
        .build();
  }
}
