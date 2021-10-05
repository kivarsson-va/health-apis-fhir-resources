package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.Device;
import gov.va.api.health.r4.api.resources.Device.DeviceNameType;
import java.util.List;

public class SwaggerDevice {
  /**
   * An example Device.
   *
   * @return an example Device.
   */
  public static Device device() {
    return Device.builder()
        .id("I2-526QWVIAZHOZHCMERY7CQDV7UEAYPJXR4SASZH2FJNN3OUGOZ3QA0000")
        .patient(
            Reference.builder()
                .reference("https://sandbox-api.va.gov/services/fhir/v0/r4/Patient/2000163")
                .display("Mr. Aurelio227 Cruickshank494")
                .build())
        .owner(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Organization/I2-DJAYYHV2W7ISKUFTCHH4XSGVP4000000")
                .display("JONESBORO VA CLINIC")
                .build())
        .type(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://snomed.info/sct")
                        .code("53350007")
                        .display("Prosthesis, device (physical object)")
                        .build()
                        .asList())
                .build())
        .manufacturer("BOSTON SCIENTIFIC")
        .deviceName(
            List.of(
                Device.DeviceName.builder().name("L331").type(DeviceNameType.model_name).build(),
                Device.DeviceName.builder()
                    .name("PACEMAKER")
                    .type(DeviceNameType.user_friendly_name)
                    .build()))
        .lotNumber("A19031")
        .serialNumber("819569")
        .build();
  }

  /**
   * An example Device.
   *
   * @return an example Device.
   */
  public static Device.Bundle deviceBundle() {
    return Device.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Device?patient=2000163&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Device?patient=2000163&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Device?patient=2000163&page=1&_count=15")
                    .build()))
        .entry(
            Device.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Device/I2-526QWVIAZHOZHCMERY7CQDV7UEAYPJXR4SASZH2FJNN3OUGOZ3QA0000")
                .resource(device())
                .build()
                .asList())
        .build();
  }
}
