package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Immunization;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleImmunizations {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Immunization.Education education() {
    return Immunization.Education.builder()
        .id("654")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .documentType("GoodNightType")
        .reference("http://GoodNightType.com")
        .presentationDate("2015-04-15T04:00:00Z")
        .publicationDate("2015-04-15T04:00:00Z")
        .build();
  }

  public Immunization immunization() {
    return Immunization.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .status(Immunization.Status.entered_in_error)
        .statusReason(codeableConcept())
        .vaccineCode(codeableConcept())
        .patient(reference())
        .encounter(reference())
        .occurrenceDateTime("2015-04-15T04:00:00Z")
        .recorded("2015-04-15T04:00:00Z")
        .primarySource(Boolean.FALSE)
        .reportOrigin(codeableConcept())
        .location(reference())
        .manufacturer(reference())
        .lotNumber("1")
        .expirationDate("2015-04-15T04:00:00Z")
        .site(codeableConcept())
        .route(codeableConcept())
        .doseQuantity(simpleQuantity())
        .performer(performer().asList())
        .note(annotation().asList())
        .reasonCode(codeableConcept().asList())
        .reasonReference(reference().asList())
        .isSubpotent(Boolean.TRUE)
        .subpotentReason(codeableConcept().asList())
        .education(education().asList())
        .programEligibility(codeableConcept().asList())
        .fundingSource(codeableConcept())
        .reaction(reaction().asList())
        .protocolApplied(protocolApplied().asList())
        .build();
  }

  public Immunization.Performer performer() {
    return Immunization.Performer.builder()
        .id("987")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .actor(reference())
        .function(codeableConcept())
        .build();
  }

  public Immunization.ProtocolApplied protocolApplied() {
    return Immunization.ProtocolApplied.builder()
        .id("0")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .series("GoodNightSeries")
        .authority(reference())
        .targetDisease(codeableConcept().asList())
        .seriesDosesPositiveInt(1)
        .doseNumberString("2")
        .build();
  }

  public Immunization.Reaction reaction() {
    return Immunization.Reaction.builder()
        .id("321")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .date("2015-04-15T04:00:00Z")
        .detail(reference())
        .reported(Boolean.FALSE)
        .build();
  }
}
