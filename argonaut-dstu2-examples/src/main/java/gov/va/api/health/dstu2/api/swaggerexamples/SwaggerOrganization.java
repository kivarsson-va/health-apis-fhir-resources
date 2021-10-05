package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.Address;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.Organization;
import java.util.List;

public class SwaggerOrganization {
  /**
   * An example Organization.
   *
   * @return an example Organization.
   */
  public static Organization organization() {
    return Organization.builder()
        .id("6a96677d-f487-52bb-befd-6c90c7f49fa6")
        .active(true)
        .type(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/organization-type")
                        .code("prov")
                        .display("Healthcare Provider")
                        .build()
                        .asList())
                .build())
        .name("MANILA-RO")
        .address(
            Address.builder()
                .line(List.of("1501 ROXAS BLVD"))
                .city("PASAY CITY, METRO MANILA")
                .state("PH")
                .postalCode("96515-1100")
                .build()
                .asList())
        .partOf(
            Reference.builder()
                .reference(
                    "https://api.va.gov/services/argonaut/v0/Organization/966f5985-6db7-5c0a-b809-54fcf73d3e1d")
                .display("VA")
                .build())
        .build();
  }

  /**
   * An example Organization.Bundle.
   *
   * @return an example Organization.Bundle.
   */
  public static Organization.Bundle organizationBundle() {
    return Organization.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Organization?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Organization?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Organization?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            Organization.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/Organization/6a96677d-f487-52bb-befd-6c90c7f49fa6")
                .resource(organization())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
