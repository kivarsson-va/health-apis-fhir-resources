package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Encounter;
import gov.va.api.health.r4.api.resources.Encounter.ClassHistory;
import gov.va.api.health.r4.api.resources.Encounter.Diagnosis;
import gov.va.api.health.r4.api.resources.Encounter.Hospitalization;
import gov.va.api.health.r4.api.resources.Encounter.Location;
import gov.va.api.health.r4.api.resources.Encounter.Participant;
import gov.va.api.health.r4.api.resources.Encounter.Status;
import gov.va.api.health.r4.api.resources.Encounter.StatusHistory;
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

  public ClassHistory classHistory() {
    return ClassHistory.builder()
        .id("0000")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .encounterClass(coding())
        .period(period())
        .build();
  }

  public Diagnosis diagnosis() {
    return Diagnosis.builder()
        .id("1111")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .condition(reference())
        .use(codeableConcept())
        .rank(1)
        .build();
  }

  public Encounter encounter() {
    return Encounter.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(List.of(resource(), resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .status(Status.arrived)
        .statusHistory(List.of(statusHistory(), statusHistory()))
        .encounterClass(coding())
        .classHistory(List.of(classHistory(), classHistory()))
        .type(List.of(codeableConcept(), codeableConcept()))
        .priority(codeableConcept())
        .subject(reference())
        .episodeOfCare(List.of(reference(), reference()))
        .basedOn(List.of(reference(), reference()))
        .participant(List.of(participant(), participant()))
        .appointment(List.of(reference(), reference()))
        .period(period())
        .length(duration())
        .reasonCode(List.of(codeableConcept(), codeableConcept()))
        .reasonReference(List.of(reference(), reference()))
        .diagnosis(List.of(diagnosis(), diagnosis()))
        .account(List.of(reference(), reference()))
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
        .origin(reference())
        .admitSource(codeableConcept())
        .reAdmission(codeableConcept())
        .dietPreference(List.of(codeableConcept(), codeableConcept()))
        .specialCourtesy(List.of(codeableConcept(), codeableConcept()))
        .specialArrangement(List.of(codeableConcept(), codeableConcept()))
        .destination(reference())
        .dischargeDisposition(codeableConcept())
        .build();
  }

  public Location location() {
    return Location.builder()
        .id("3333")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .location(reference())
        .status(Location.Status.planned)
        .physicalType(codeableConcept())
        .period(period())
        .build();
  }

  public Participant participant() {
    return Participant.builder()
        .id("4444")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(List.of(codeableConcept(), codeableConcept()))
        .period(period())
        .individual(reference())
        .build();
  }

  public StatusHistory statusHistory() {
    return StatusHistory.builder()
        .id("5555")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .status(Status.planned)
        .period(period())
        .build();
  }
}
