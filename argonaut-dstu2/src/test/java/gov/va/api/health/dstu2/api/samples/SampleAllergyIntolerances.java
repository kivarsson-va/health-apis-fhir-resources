package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.AllergyIntolerance;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance.Category;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance.Certainty;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance.Criticality;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance.Reaction;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance.Severity;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance.Status;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance.Type;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleAllergyIntolerances {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public AllergyIntolerance allergyIntolerance() {
    return AllergyIntolerance.builder()
        .id("2222")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .onset("2015-04-15T04:00:00Z")
        .recordedDate("2015-04-15T04:00:00Z")
        .recorder(reference())
        .patient(reference())
        .reporter(reference())
        .substance(codeableConcept())
        .status(Status.active)
        .criticality(Criticality.CRITL)
        .type(Type.allergy)
        .category(Category.food)
        .lastOccurence("2015-04-15T04:00:00Z")
        .note(annotation())
        .reaction(reaction().asList())
        .build();
  }

  public Reaction reaction() {
    return Reaction.builder()
        .id("1111")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .substance(codeableConcept())
        .certainty(Certainty.unlikely)
        .manifestation(codeableConcept().asList())
        .description("Test Reaction Description")
        .onset("2015-04-15T04:00:00Z")
        .severity(Severity.severe)
        .exposureRoute(codeableConcept())
        .note(annotation())
        .build();
  }
}
