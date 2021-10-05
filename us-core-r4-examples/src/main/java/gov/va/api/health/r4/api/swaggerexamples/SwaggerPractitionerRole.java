package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.datatypes.ContactPoint.ContactPointSystem;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.PractitionerRole;
import gov.va.api.health.r4.api.resources.PractitionerRole.DayOfWeek;
import gov.va.api.health.r4.api.resources.PractitionerRole.PractitionerAvailableTime;
import java.util.List;

public class SwaggerPractitionerRole {
  /** An example PractitionerRole. */
  public static PractitionerRole practitionerRole() {
    return PractitionerRole.builder()
        .id("I2-3NOHFSBEAZEKYRMDWVWB7LAFJNCKM3SFLR2CYELHDC7DZ5X3BKGA0000")
        .active(Boolean.TRUE)
        .practitioner(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Practitioner/I2-54WJZ6YHNQICAV4YZRI54BVVCA000000")
                .display("Dr John248 Smith811, MD")
                .build())
        .organization(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Organization/I2-TQFMJ6CCI4V425PUMWP2GRESZM000000")
                .display("LYONS VA MEDICAL CENTER")
                .build())
        .code(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://nucc.org/provider-taxonomy")
                        .code("15")
                        .display("OPTOMETRIST")
                        .build()
                        .asList())
                .build()
                .asList())
        .specialty(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://nucc.org/provider-taxonomy")
                        .code("207Q00000X")
                        .display("Family Medicine")
                        .build()
                        .asList())
                .build()
                .asList())
        .telecom(
            ContactPoint.builder()
                .system(ContactPointSystem.phone)
                .value("333-333-3333")
                .build()
                .asList())
        .availableTime(
            PractitionerAvailableTime.builder()
                .daysOfWeek(List.of(DayOfWeek.mon, DayOfWeek.wed, DayOfWeek.fri))
                .availableStartTime("08:00:00")
                .availableEndTime("15:00:00")
                .build()
                .asList())
        .build();
  }

  /**
   * An example PractitionerRole.
   *
   * @return an example PractitionerRole.
   */
  public static PractitionerRole.Bundle practitionerRoleBundle() {
    return PractitionerRole.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/PractitionerRole?practitioner.identifier=I2-54WJZ6YHNQICAV4YZRI54BVVCA000000&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/PractitionerRole?practitioner.identifier=I2-54WJZ6YHNQICAV4YZRI54BVVCA000000&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/PractitionerRole?practitioner.identifier=I2-54WJZ6YHNQICAV4YZRI54BVVCA000000&page=1&_count=15")
                    .build()))
        .entry(
            PractitionerRole.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/PractitionerRole/I2-3NOHFSBEAZEKYRMDWVWB7LAFJNCKM3SFLR2CYELHDC7DZ5X3BKGA0000")
                .resource(practitionerRole())
                .build()
                .asList())
        .build();
  }
}
