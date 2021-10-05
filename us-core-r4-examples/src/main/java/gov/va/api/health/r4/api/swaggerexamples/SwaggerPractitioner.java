package gov.va.api.health.r4.api.swaggerexamples;

import static gov.va.api.health.r4.api.datatypes.ContactPoint.ContactPointUse;
import static gov.va.api.health.r4.api.resources.Practitioner.Bundle;
import static gov.va.api.health.r4.api.resources.Practitioner.GenderCode;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.AbstractEntry;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.Address;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.datatypes.ContactPoint.ContactPointSystem;
import gov.va.api.health.r4.api.datatypes.HumanName;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.resources.Practitioner;
import java.util.List;

public class SwaggerPractitioner {
  /** An example Practitioner. */
  public static Practitioner practitioner() {
    return Practitioner.builder()
        .id("I2-HRJI2MVST2IQSPR7U5SACWIWZA000000")
        .identifier(
            Identifier.builder()
                .system("http://hl7.org/fhir/sid/us-npi")
                .value("1932127842")
                .build()
                .asList())
        .active(Boolean.TRUE)
        .name(
            HumanName.builder()
                .family("DOE922")
                .given(List.of("JANE460"))
                .prefix(List.of("DR."))
                .suffix(List.of("MD"))
                .build()
                .asList())
        .telecom(
            List.of(
                ContactPoint.builder()
                    .system(ContactPointSystem.phone)
                    .value("555-555-1137")
                    .use(ContactPointUse.work)
                    .build(),
                ContactPoint.builder()
                    .system(ContactPointSystem.phone)
                    .value("555-4055")
                    .use(ContactPointUse.home)
                    .build(),
                ContactPoint.builder()
                    .system(ContactPointSystem.pager)
                    .value("5-541")
                    .use(ContactPointUse.mobile)
                    .build()))
        .address(
            Address.builder()
                .line(List.of("555 E 5TH ST", "SUITE B"))
                .city("CHEYENNE")
                .state("WYOMING")
                .postalCode("82001")
                .build()
                .asList())
        .gender(GenderCode.female)
        .birthDate("1964-02-23")
        .build();
  }

  /** An example Practitioner Bundle. */
  public static Bundle practitionerBundle() {
    return Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Practitioner?identifier=http%3A%2F%2Fhl7.org%2Ffhir%2Fsid%2Fus-npi%7C1932127842&_count=30&page=1")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Practitioner?identifier=http%3A%2F%2Fhl7.org%2Ffhir%2Fsid%2Fus-npi%7C1932127842&_count=30&page=1")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Practitioner?identifier=http%3A%2F%2Fhl7.org%2Ffhir%2Fsid%2Fus-npi%7C1932127842&_count=30&page=1")
                    .build()))
        .entry(
            Practitioner.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Practitioner/I2-HRJI2MVST2IQSPR7U5SACWIWZA000000")
                .resource(practitioner())
                .search(AbstractEntry.Search.builder().mode(AbstractEntry.SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
