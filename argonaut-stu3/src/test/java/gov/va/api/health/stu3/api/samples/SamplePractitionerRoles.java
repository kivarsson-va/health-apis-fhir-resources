package gov.va.api.health.stu3.api.samples;

import gov.va.api.health.stu3.api.datatypes.ContactPoint;
import gov.va.api.health.stu3.api.datatypes.Identifier;
import gov.va.api.health.stu3.api.elements.Meta;
import gov.va.api.health.stu3.api.elements.Narrative;
import gov.va.api.health.stu3.api.resources.PractitionerRole;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SamplePractitionerRoles {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public PractitionerRole practitionerRole() {
    return PractitionerRole.builder()
        .id("2222")
        .meta(Meta.builder().build())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(Narrative.builder().build())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(Identifier.builder().build().asList())
        .active(true)
        .telecom(ContactPoint.builder().build().asList())
        .build();
  }
}
