package gov.va.api.health.dstu2.api.swaggerexamples;

import static java.util.Arrays.asList;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.Address;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.datatypes.ContactPoint;
import gov.va.api.health.dstu2.api.datatypes.HumanName;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.Practitioner;
import java.util.List;

public class SwaggerPractitioner {
  /**
   * An example Practitioner.
   *
   * @return an example Practitioner.
   */
  public static Practitioner practitioner() {
    return Practitioner.builder()
        .id("I2-HRJI2MVST2IQSPR7U5SACWIWZA000000")
        .active(true)
        .name(
            HumanName.builder()
                .family(asList("DOE922"))
                .given(asList("JANE460"))
                .prefix(asList("DR."))
                .suffix(asList("MD"))
                .build())
        .telecom(
            asList(
                ContactPoint.builder()
                    .system(ContactPoint.ContactPointSystem.phone)
                    .value("555-555-1137")
                    .use(ContactPoint.ContactPointUse.work)
                    .build(),
                ContactPoint.builder()
                    .system(ContactPoint.ContactPointSystem.phone)
                    .value("555-4055")
                    .use(ContactPoint.ContactPointUse.home)
                    .build(),
                ContactPoint.builder()
                    .system(ContactPoint.ContactPointSystem.pager)
                    .value("5-541")
                    .use(ContactPoint.ContactPointUse.mobile)
                    .build()))
        .address(
            List.of(
                Address.builder()
                    .line(List.of("555 E 5TH ST", "SUITE B"))
                    .city("CHEYENNE")
                    .state("WYOMING")
                    .postalCode("82001")
                    .build()))
        .gender(Practitioner.Gender.female)
        .birthDate("1964-02-23")
        .practitionerRole(
            asList(
                Practitioner.PractitionerRole.builder()
                    .managingOrganization(
                        Reference.builder()
                            .reference(
                                "https://sandbox-api.va.gov/services/fhir/v0/dstu2/Organization/I2-AKOTGEFSVKFJOPUKHIVJAH5VQU000000")
                            .display("CHEYENNE VA MEDICAL")
                            .build())
                    .role(
                        CodeableConcept.builder()
                            .coding(
                                asList(
                                    Coding.builder()
                                        .system("http://hl7.org/fhir/practitioner-role")
                                        .code("PHYSICIAN")
                                        .display("PSYCHOLOGIST")
                                        .build()))
                            .text("PSYCHOLOGIST")
                            .build())
                    .location(
                        asList(
                            Reference.builder()
                                .reference(
                                    "https://sandbox-api.va.gov/services/fhir/v0/dstu2/Location/I2-3JYDMXC6RXTU4H25KRVXATSEJQ000000")
                                .display("ZZCHY LASTNAME MEDICAL")
                                .build()))
                    .healthcareService(
                        asList(Reference.builder().display("MEDICAL SERVICE").build()))
                    .build()))
        .build();
  }

  /**
   * An example Practitioner.Bundle.
   *
   * @return an example Practitioner.Bundle.
   */
  public static Practitioner.Bundle practitionerBundle() {
    return Practitioner.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            asList(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/dstu2/Practitioner?identifier=I2-HRJI2MVST2IQSPR7U5SACWIWZA000000&page=1&_count=30")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/dstu2/Practitioner?identifier=I2-HRJI2MVST2IQSPR7U5SACWIWZA000000&page=1&_count=30")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/dstu2/Practitioner?identifier=I2-HRJI2MVST2IQSPR7U5SACWIWZA000000&page=1&_count=30")
                    .build()))
        .entry(
            asList(
                Practitioner.Entry.builder()
                    .fullUrl(
                        "https://sandbox-api.va.gov/services/fhir/v0/dstu2/Practitioner/I2-HRJI2MVST2IQSPR7U5SACWIWZA000000")
                    .resource(practitioner())
                    .search(Search.builder().mode(SearchMode.match).build())
                    .build()))
        .build();
  }
}
