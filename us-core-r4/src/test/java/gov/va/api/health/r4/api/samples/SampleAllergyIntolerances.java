package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.AllergyIntolerance;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public final class SampleAllergyIntolerances {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public AllergyIntolerance allergyIntolerance() {
    return AllergyIntolerance.builder()
        .id("2222")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .clinicalStatus(codeableConcept())
        .verificationStatus(codeableConcept())
        .type(AllergyIntolerance.Type.allergy)
        .category(List.of(AllergyIntolerance.Category.food))
        .criticality(AllergyIntolerance.Criticality.high)
        .code(codeableConcept())
        .patient(reference())
        .encounter(reference())
        .onsetDateTime("2015-04-15T04:00:00Z")
        .recordedDate("2015-04-15T04:00:00Z")
        .recorder(reference())
        .asserter(reference())
        .lastOccurence("2015-04-15T04:00:00Z")
        .note(annotation().asList())
        .reaction(reaction().asList())
        .build();
  }

  public AllergyIntolerance.Reaction reaction() {
    return AllergyIntolerance.Reaction.builder()
        .id("1111")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .substance(codeableConcept())
        .manifestation(codeableConcept().asList())
        .description("Test Reaction Description")
        .onset("2015-04-15T04:00:00Z")
        .severity(AllergyIntolerance.Severity.severe)
        .exposureRoute(codeableConcept())
        .note(annotation().asList())
        .build();
  }
}
