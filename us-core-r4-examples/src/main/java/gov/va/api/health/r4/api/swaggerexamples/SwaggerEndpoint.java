package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.resources.Endpoint;
import java.util.List;

public class SwaggerEndpoint {
  /**
   * An example Endpoint.
   *
   * @return an example Endpoint.
   */
  public static Endpoint endpoint() {
    return Endpoint.builder()
        .id("I3-000000000000000000")
        .status(Endpoint.EndpointStatus.active)
        .connectionType(
            Coding.builder()
                .code("hl7-fhir-rest")
                .display("hl7-fhir-rest")
                .system("http://terminology.hl7.org/CodeSystem/endpoint-connection-type")
                .build())
        .payloadType(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .code("any")
                        .display("Any")
                        .system("http://terminology.hl7.org/CodeSystem/endpoint-payload-type")
                        .build()
                        .asList())
                .text("Any")
                .build()
                .asList())
        .payloadMimeType(List.of("application/json", "application/fhir+json"))
        .address("https://sandbox-api.va.gov/services/clinical-fhir/v0/site/500/r4")
        .name("CAMP MASTER")
        .build();
  }

  /**
   * An example Endpoint.
   *
   * @return an example Endpoint.
   */
  public static Endpoint.Bundle endpointBundle() {
    return Endpoint.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/clinical-fhir/v0/r4/Endpoint?status=active&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/clinical-fhir/v0/r4/Endpoint?status=active&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/clinical-fhir/v0/r4/Endpoint?status=active&page=1&_count=15")
                    .build()))
        .entry(
            Endpoint.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/clinical-fhir/v0/r4/Endpoint/I3-000000000000000000")
                .resource(endpoint())
                .build()
                .asList())
        .build();
  }
}
