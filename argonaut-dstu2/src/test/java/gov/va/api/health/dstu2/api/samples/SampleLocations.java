package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Location;
import gov.va.api.health.dstu2.api.resources.Location.Mode;
import gov.va.api.health.dstu2.api.resources.Location.Position;
import gov.va.api.health.dstu2.api.resources.Location.Status;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleLocations {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Location location() {
    return Location.builder()
        .status(Status.active)
        .name("My Name")
        .description("Description")
        .mode(Mode.instance)
        .type(dataTypes.codeableConcept())
        .telecom(dataTypes.contactPoint().asList())
        .address(dataTypes.address())
        .physicalType(dataTypes.codeableConcept())
        .position(Position.builder().latitude(3.0).longitude(2.0).altitude(1.0).build())
        .managingOrganization(dataTypes.reference())
        .partOf(dataTypes.reference())
        .build();
  }
}
