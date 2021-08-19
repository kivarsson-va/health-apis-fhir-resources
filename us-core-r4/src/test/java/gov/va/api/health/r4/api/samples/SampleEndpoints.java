package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Endpoint;
import gov.va.api.health.r4.api.resources.Endpoint.EndpointStatus;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleEndpoints {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Endpoint endpoint() {
    return Endpoint.builder()
        .status(EndpointStatus.active)
        .name("Example endpoint")
        .connectionType(coding())
        .address("http://example.com/r4")
        .managingOrganization(dataTypes.reference())
        .build();
  }
}
