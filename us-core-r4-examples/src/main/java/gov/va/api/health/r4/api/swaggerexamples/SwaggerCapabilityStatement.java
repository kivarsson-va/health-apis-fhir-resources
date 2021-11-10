package gov.va.api.health.r4.api.swaggerexamples;

import static gov.va.api.health.r4.api.datatypes.ContactPoint.ContactPointSystem.email;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.CapabilityResource;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.Implementation;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.Kind.capability;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.ReferencePolicy;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.ResourceInteraction;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.Rest;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.RestMode.server;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.SearchParam;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.SearchParamType;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.Security;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.Software;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.Status.active;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.TypeRestfulInteraction;
import static gov.va.api.health.r4.api.resources.CapabilityStatement.Versioning;

import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.ContactDetail;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.resources.CapabilityStatement;
import java.util.List;

public final class SwaggerCapabilityStatement {
  /** Example CapabilityStatement. */
  public static CapabilityStatement capabilityStatement() {
    return CapabilityStatement.builder()
        .id("example-api-capability")
        .version("1.23.456")
        .name("API Management Platform | Example - US Core")
        .title("API Management Platform | Example - US Core")
        .status(active)
        .experimental(false)
        .date("2021-11-10T17:00:00Z")
        .publisher("Department of Veterans Affairs")
        .contact(
            ContactDetail.builder()
                .name("Example Contact")
                .telecom(
                    ContactPoint.builder()
                        .system(email)
                        .value("example.email@foo.com")
                        .build()
                        .asList())
                .build()
                .asList())
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
        .fhirVersion("4.0.1")
        .format(List.of("application/json", "application/fhir+json"))
        .rest(
            Rest.builder()
                .mode(server)
                .security(
                    Security.builder()
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
                        CapabilityResource.builder()
                            .type("Example Resource")
                            .profile("http://example-resource-profile.com")
                            .interaction(
                                List.of(
                                    ResourceInteraction.builder()
                                        .code(TypeRestfulInteraction.search_type)
                                        .documentation("Example search interaction.")
                                        .build(),
                                    ResourceInteraction.builder()
                                        .code(TypeRestfulInteraction.read)
                                        .documentation("Example read interaction.")
                                        .build()))
                            .versioning(Versioning.no_version)
                            .referencePolicy(List.of(ReferencePolicy.literal))
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
