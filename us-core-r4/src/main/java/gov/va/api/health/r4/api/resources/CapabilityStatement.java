package gov.va.api.health.r4.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.ContactDetail;
import gov.va.api.health.r4.api.datatypes.UsageContext;
import gov.va.api.health.r4.api.elements.BackboneElement;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.elements.Narrative;
import gov.va.api.health.r4.api.elements.Reference;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(
    description = "https://www.hl7.org/fhir/R4/capabilitystatement.html",
    example =
        "${r4.capabilityStatement:gov.va.api.health.r4.api.swaggerexamples"
            + ".SwaggerCapabilityStatement#capabilityStatement}")
public class CapabilityStatement implements AsList<CapabilityStatement>, Resource {
  @NotBlank @Builder.Default String resourceType = "CapabilityStatement";

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Valid Narrative text;
  @Valid List<Resource> contained;
  @Valid List<Extension> extension;
  @Valid List<Extension> modifierExtension;

  @Pattern(regexp = Fhir.URI)
  String url;

  @Pattern(regexp = Fhir.STRING)
  String version;

  @Pattern(regexp = Fhir.STRING)
  String name;

  @Pattern(regexp = Fhir.STRING)
  String title;

  @NotNull Status status;

  Boolean experimental;

  @NotBlank
  @Pattern(regexp = Fhir.DATETIME)
  String date;

  @Pattern(regexp = Fhir.STRING)
  String publisher;

  @Valid List<ContactDetail> contact;

  @Pattern(regexp = Fhir.MARKDOWN)
  String description;

  @Valid List<UsageContext> useContext;
  @Valid List<CodeableConcept> jurisdiction;

  @Pattern(regexp = Fhir.MARKDOWN)
  String purpose;

  @Pattern(regexp = Fhir.MARKDOWN)
  String copyright;

  @NotNull Kind kind;

  @Valid List<@Pattern(regexp = Fhir.URI) String> instantiates;

  @Valid List<@Pattern(regexp = Fhir.URI) String> imports;

  @Valid Software software;
  @Valid Implementation implementation;

  @NotBlank
  @Pattern(regexp = Fhir.CODE)
  String fhirVersion;

  @NotEmpty @Valid List<@Pattern(regexp = Fhir.CODE) String> format;

  @Valid List<@Pattern(regexp = Fhir.CODE) String> patchFormat;

  @Valid List<@Pattern(regexp = Fhir.URI) String> implementationGuide;

  @Valid List<Rest> rest;
  @Valid List<Messaging> messaging;
  @Valid List<Document> document;

  @SuppressWarnings("unused")
  public enum ConditionalRead {
    @JsonProperty("not-supported")
    not_supported,
    @JsonProperty("modified-since")
    modified_since,
    @JsonProperty("not-match")
    not_match,
    @JsonProperty("full-support")
    full_support,
  }

  @SuppressWarnings("unused")
  public enum ConditionalDelete {
    @JsonProperty("not-supported")
    not_supported,
    single,
    multiple
  }

  @SuppressWarnings("unused")
  public enum DocumentMode {
    producer,
    consumer
  }

  @SuppressWarnings("unused")
  public enum Kind {
    instance,
    capability,
    requirements
  }

  @SuppressWarnings("unused")
  public enum ReferencePolicy {
    literal,
    logical,
    resolves,
    enforced,
    local
  }

  @SuppressWarnings("unused")
  public enum RestMode {
    client,
    server
  }

  @SuppressWarnings("unused")
  public enum SearchParamType {
    number,
    date,
    string,
    token,
    reference,
    composite,
    quantity,
    uri,
    special
  }

  @SuppressWarnings("unused")
  public enum Status {
    draft,
    active,
    retired,
    unknown
  }

  @SuppressWarnings("unused")
  public enum SupportedMessageMode {
    sender,
    receiver
  }

  @SuppressWarnings("unused")
  public enum SystemRestfulInteraction {
    transaction,
    batch,
    @JsonProperty("search-system")
    search_system,
    @JsonProperty("history-system")
    history_system
  }

  @SuppressWarnings("unused")
  public enum TypeRestfulInteraction {
    read,
    vread,
    update,
    patch,
    delete,
    @JsonProperty("history-instance")
    history_instance,
    @JsonProperty("history-type")
    history_type,
    create,
    @JsonProperty("search-type")
    search_type
  }

  @SuppressWarnings("unused")
  public enum Versioning {
    @JsonProperty("no-version")
    no_version,
    versioned,
    @JsonProperty("versioned-update")
    versioned_update
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class CapabilityResource implements AsList<CapabilityResource>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotBlank
    @Pattern(regexp = Fhir.CODE)
    String type;

    @Pattern(regexp = Fhir.URI)
    String profile;

    @Valid List<@Pattern(regexp = Fhir.URI) String> supportedProfile;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;

    @Valid List<ResourceInteraction> interaction;

    Versioning versioning;

    Boolean readHistory;

    Boolean updateCreate;

    Boolean conditionalCreate;

    ConditionalRead conditionalRead;

    Boolean conditionalUpdate;

    ConditionalDelete conditionalDelete;

    List<ReferencePolicy> referencePolicy;

    @Valid List<@Pattern(regexp = Fhir.STRING) String> searchInclude;

    @Valid List<@Pattern(regexp = Fhir.STRING) String> searchRevInclude;

    @Valid List<SearchParam> searchParam;

    @Valid List<Operation> operation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Document implements AsList<Document>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotNull DocumentMode mode;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;

    @NotBlank
    @Pattern(regexp = Fhir.URI)
    String profile;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Implementation implements AsList<Implementation>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotBlank
    @Pattern(regexp = Fhir.STRING)
    String description;

    @Pattern(regexp = Fhir.URI)
    String url;

    @Valid Reference custodian;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Messaging implements AsList<Messaging>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @Valid List<MessagingEndpoint> endpoint;

    @Min(0)
    Integer reliableCache;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;

    @Valid List<SupportedMessage> supportedMessage;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class MessagingEndpoint implements AsList<MessagingEndpoint>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotNull Coding protocol;

    @NotBlank
    @Pattern(regexp = Fhir.URI)
    String address;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Operation implements AsList<Operation>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotBlank
    @Pattern(regexp = Fhir.STRING)
    String name;

    @NotBlank
    @Pattern(regexp = Fhir.URI)
    String definition;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class ResourceInteraction implements AsList<ResourceInteraction>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotNull TypeRestfulInteraction code;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Rest implements AsList<Rest>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotNull RestMode mode;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;

    @Valid Security security;
    @Valid List<CapabilityResource> resource;
    @Valid List<RestInteraction> interaction;
    SearchParam searchParam;
    Operation operation;

    @Pattern(regexp = Fhir.URI)
    String compartment;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class RestInteraction implements AsList<RestInteraction>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotNull SystemRestfulInteraction code;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class SearchParam implements AsList<SearchParam>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotBlank
    @Pattern(regexp = Fhir.STRING)
    String name;

    @Pattern(regexp = Fhir.URI)
    String definition;

    @NotNull SearchParamType type;

    @Pattern(regexp = Fhir.MARKDOWN)
    String documentation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Security implements AsList<Security>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    Boolean cors;
    @Valid List<CodeableConcept> service;

    @Pattern(regexp = Fhir.MARKDOWN)
    String description;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Software implements AsList<Software>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotBlank
    @Pattern(regexp = Fhir.STRING)
    String name;

    @Pattern(regexp = Fhir.STRING)
    String version;

    @Pattern(regexp = Fhir.DATETIME)
    String releaseDate;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class SupportedMessage implements AsList<SupportedMessage>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotNull SupportedMessageMode mode;

    @NotBlank
    @Pattern(regexp = Fhir.URI)
    String definition;
  }
}
