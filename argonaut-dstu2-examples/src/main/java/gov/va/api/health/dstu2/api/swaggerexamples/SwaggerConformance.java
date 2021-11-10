package gov.va.api.health.dstu2.api.swaggerexamples;

import static gov.va.api.health.dstu2.api.datatypes.ContactPoint.ContactPointSystem.email;
import static gov.va.api.health.dstu2.api.resources.Conformance.AcceptUnknown;
import static gov.va.api.health.dstu2.api.resources.Conformance.Contact;
import static gov.va.api.health.dstu2.api.resources.Conformance.Implementation;
import static gov.va.api.health.dstu2.api.resources.Conformance.Kind.capability;
import static gov.va.api.health.dstu2.api.resources.Conformance.ResourceInteraction;
import static gov.va.api.health.dstu2.api.resources.Conformance.ResourceInteractionCode;
import static gov.va.api.health.dstu2.api.resources.Conformance.Rest;
import static gov.va.api.health.dstu2.api.resources.Conformance.RestMode.server;
import static gov.va.api.health.dstu2.api.resources.Conformance.RestResource;
import static gov.va.api.health.dstu2.api.resources.Conformance.RestSecurity;
import static gov.va.api.health.dstu2.api.resources.Conformance.SearchParam;
import static gov.va.api.health.dstu2.api.resources.Conformance.SearchParamType;
import static gov.va.api.health.dstu2.api.resources.Conformance.Software;

import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.datatypes.ContactPoint;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.Conformance;
import java.util.List;

public final class SwaggerConformance {
  /** Example Conformance. */
  public static Conformance conformance() {
    return Conformance.builder()
        .id("example-api-capability")
        .version("1.23.456")
        .name("API Management Platform | Example - US Core")
        .publisher("Department of Veterans Affairs")
        .contact(
            Contact.builder()
                .name("Example Contact")
                .telecom(
                    ContactPoint.builder()
                        .system(email)
                        .value("example.email@foo.com")
                        .build()
                        .asList())
                .build()
                .asList())
        .date("2021-11-10T17:00:00Z")
        .description("Read and search support for FHIR resources.")
        .kind(capability)
        .software(
            Software.builder()
                .name("gov.va.api.examples:example-app")
                .version("1.23.456")
                .releaseDate("2021-11-01T17:00:00Z")
                .build())
        .implementation(
            Implementation.builder()
                .description("API Management Platform | Example - US Core")
                .url("https://sandbox-api.va.gov/services/fhir/r4")
                .build())
        .fhirVersion("1.0.2")
        .acceptUnknown(AcceptUnknown.no)
        .format(List.of("application/json", "application/fhir+json", "application/json+fhir"))
        .rest(
            Rest.builder()
                .mode(server)
                .security(
                    RestSecurity.builder()
                        .extension(
                            List.of(
                                Extension.builder()
                                    .extension(
                                        List.of(
                                            Extension.builder()
                                                .url("token")
                                                .valueUri(
                                                    "https://sandbox-api.va.gov/example/token")
                                                .build(),
                                            Extension.builder()
                                                .url("authorize")
                                                .valueUri(
                                                    "https://sandbox-api.va.gov/example/authorize")
                                                .build(),
                                            Extension.builder()
                                                .url("manage")
                                                .valueUri(
                                                    "https://sandbox-api.va.gov/example/manage")
                                                .build(),
                                            Extension.builder()
                                                .url("revoke")
                                                .valueUri(
                                                    "https://sandbox-api.va.gov/example/revoke")
                                                .build()))
                                    .url(
                                        "http://fhir-registry.smarthealthit.org/StructureDefinition/oauth-uris")
                                    .build()))
                        .cors(true)
                        .service(
                            CodeableConcept.builder()
                                .coding(
                                    Coding.builder()
                                        .system(
                                            "http://terminology.hl7.org/CodeSystem/restful-security-service")
                                        .code("SMART-on-FHIR")
                                        .display("SMART-on-FHIR")
                                        .build()
                                        .asList())
                                .text("SMART-on-FHIR")
                                .build()
                                .asList())
                        .description("http://docs.smarthealthit.org/")
                        .build())
                .resource(
                    List.of(
                        RestResource.builder()
                            .type("Example Resource")
                            .profile(
                                Reference.builder()
                                    .reference("http://example-resource-profile.com")
                                    .build())
                            .interaction(
                                List.of(
                                    ResourceInteraction.builder()
                                        .code(ResourceInteractionCode.search_type)
                                        .documentation("Example search interaction.")
                                        .build(),
                                    ResourceInteraction.builder()
                                        .code(ResourceInteractionCode.read)
                                        .documentation("Example read interaction.")
                                        .build()))
                            .searchParam(
                                SearchParam.builder()
                                    .name("example_param")
                                    .type(SearchParamType.token)
                                    .build()
                                    .asList())
                            .build()))
                .build()
                .asList())
        .build();
  }
}
