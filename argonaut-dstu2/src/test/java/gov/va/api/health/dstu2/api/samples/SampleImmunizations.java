package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.DataAbsentReason;
import gov.va.api.health.dstu2.api.DataAbsentReason.Reason;
import gov.va.api.health.dstu2.api.resources.Immunization;
import gov.va.api.health.dstu2.api.resources.Immunization.Explanation;
import gov.va.api.health.dstu2.api.resources.Immunization.Reaction;
import gov.va.api.health.dstu2.api.resources.Immunization.Status;
import gov.va.api.health.dstu2.api.resources.Immunization.VaccinationProtocol;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleImmunizations {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Explanation explanation() {
    return Explanation.builder()
        .id("2222")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .reason(codeableConcept().asList())
        .reasonNotGiven(codeableConcept().asList())
        .build();
  }

  public Immunization immunization() {
    return Immunization.builder()
        .id("2222")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .status(Status.stopped)
        .date("2000-10-01")
        .vaccineCode(codeableConcept())
        .patient(reference())
        .wasNotGiven(true)
        .reported(true)
        .performer(reference())
        .requester(reference())
        .encounter(reference())
        .manufacturer(reference())
        .location(reference())
        .lotNumber("107")
        .expirationDate("2000-10-01")
        .site(codeableConcept())
        .route(codeableConcept())
        .doseQuantity(simpleQuantity())
        .note(annotation().asList())
        .explanation(explanation())
        .reaction(reaction().asList())
        .vaccinationProtocol(vaccinationProtocol().asList())
        .build();
  }

  public Immunization immunizationWithDataAbsentReasons() {
    return immunization()
        .status(null)
        ._status(DataAbsentReason.of(Reason.unsupported))
        .reported(false)
        ._reported(DataAbsentReason.of(Reason.unsupported))
        .vaccinationProtocol(vaccinationProtocolWithDataAbsentReasons().asList());
  }

  public Reaction reaction() {
    return Reaction.builder()
        .id("2222")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .date("2000-10-01")
        .detail(reference())
        .reported(true)
        .build();
  }

  public VaccinationProtocol vaccinationProtocol() {
    return VaccinationProtocol.builder()
        .id("4444")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .doseSequence(1)
        .description("Test Description")
        .authority(reference())
        .series("Test Series")
        .seriesDoses(1)
        .targetDisease(codeableConcept().asList())
        .doseStatus(codeableConcept())
        .doseStatusReason(codeableConcept())
        .build();
  }

  public VaccinationProtocol vaccinationProtocolWithDataAbsentReasons() {
    return VaccinationProtocol.builder()
        .targetDisease(null)
        ._targetDisease(DataAbsentReason.of(Reason.unsupported))
        .doseStatus(null)
        ._doseStatus(DataAbsentReason.of(Reason.unsupported))
        .build();
  }
}
