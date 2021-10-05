package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Organization;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleOrganizations {

  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Organization organization() {
    return Organization.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .active(true)
        .name("Goodnight Club")
        .alias(List.of("Nap-time Club"))
        .telecom(List.of(contactPoint(), contactPoint()))
        .address(List.of(address(), address()))
        .build();
  }
}
