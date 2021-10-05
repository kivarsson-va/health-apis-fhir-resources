package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Device;
import gov.va.api.health.r4.api.resources.Device.DeviceNameType;
import gov.va.api.health.r4.api.resources.Device.Status;
import gov.va.api.health.r4.api.resources.Device.UdiEntryType;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleDevices {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Device device() {
    return Device.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .definition(reference())
        .udiCarrier(deviceIdentifier())
        .status(Status.active)
        .statusReason(codeableConcept().asList())
        .distinctIdentifier("Blah")
        .manufacturer("BOSTON SCIENTIFIC")
        .manufactureDate("2015-04-15T04:00:00Z")
        .expirationDate("2045-04-15T04:00:00Z")
        .lotNumber("1")
        .serialNumber("SERIAL-1234")
        .deviceName(deviceName().asList())
        .modelNumber("12345")
        .partNumber("12346")
        .type(codeableConcept())
        .specialization(specialization().asList())
        .version(version().asList())
        .property(property().asList())
        .patient(reference())
        .owner(reference())
        .contact(contactPoint().asList())
        .location(reference())
        .url("http://DeviceIssuer.com")
        .note(annotation().asList())
        .safety(codeableConcept().asList())
        .parent(reference())
        .build();
  }

  public Device.DeviceIdentifier deviceIdentifier() {
    return Device.DeviceIdentifier.builder()
        .id("999")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .deviceIdentifier("SomeDeviceId")
        .issuer("http://DeviceIssuer.com")
        .jurisdiction("http://DeviceJurisdiction.com")
        .carrierAidc( // DeviceAIDCValue
            "RGV2aWNlQUlEQ1ZhbHVl")
        .carrierHrf("CarrierHRF")
        .entryType(UdiEntryType.unknown)
        .build();
  }

  public Device.DeviceName deviceName() {
    return Device.DeviceName.builder()
        .id("998")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .name("PACEMAKER")
        .type(DeviceNameType.user_friendly_name)
        .build();
  }

  public Device.Property property() {
    return Device.Property.builder()
        .id("996")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(codeableConcept())
        .valueQuantity(quantity().asList())
        .valueCode(codeableConcept().asList())
        .build();
  }

  public Device.Specialization specialization() {
    return Device.Specialization.builder()
        .id("997")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .systemType(codeableConcept())
        .version("1")
        .build();
  }

  public Device.Version version() {
    return Device.Version.builder()
        .id("996")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(codeableConcept())
        .component(identifier())
        .value("1")
        .build();
  }
}
