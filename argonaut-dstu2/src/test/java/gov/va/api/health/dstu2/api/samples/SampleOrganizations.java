package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Organization;
import gov.va.api.health.dstu2.api.resources.Organization.OrganizationContact;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleOrganizations {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Organization organization() {
    return Organization.builder()
        .id("2222")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .active(true)
        .type(codeableConcept())
        .name("Hello Name")
        .telecom(contactPoint().asList())
        .address(address().asList())
        .partOf(reference())
        .contact(
            OrganizationContact.builder()
                .purpose(codeableConcept())
                .name(humanName())
                .telecom(contactPoint().asList())
                .address(address())
                .build()
                .asList())
        .build();
  }
}
