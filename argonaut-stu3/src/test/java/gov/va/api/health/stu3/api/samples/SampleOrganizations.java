package gov.va.api.health.stu3.api.samples;

import gov.va.api.health.stu3.api.datatypes.Address;
import gov.va.api.health.stu3.api.datatypes.Identifier;
import gov.va.api.health.stu3.api.resources.Organization;
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
        .identifier(Identifier.builder().build().asList())
        .active(true)
        .type(codeableConcept().asList())
        .name("Hello Name")
        .telecom(contactPoint().asList())
        .address(Address.builder().build().asList())
        .partOf(reference())
        .contact(
            Organization.Contact.builder()
                .purpose(codeableConcept())
                .name(humanName())
                .telecom(contactPoint().asList())
                .address(address())
                .build()
                .asList())
        .build();
  }
}
