package gov.va.api.health.stu3.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.stu3.api.Fhir;
import gov.va.api.health.stu3.api.datatypes.CodeableConcept;
import gov.va.api.health.stu3.api.datatypes.Coding;
import gov.va.api.health.stu3.api.datatypes.ContactDetail;
import gov.va.api.health.stu3.api.datatypes.SimpleResource;
import gov.va.api.health.stu3.api.datatypes.UsageContext;
import gov.va.api.health.stu3.api.elements.BackboneElement;
import gov.va.api.health.stu3.api.elements.Extension;
import gov.va.api.health.stu3.api.elements.Meta;
import gov.va.api.health.stu3.api.elements.Narrative;
import gov.va.api.health.stu3.api.elements.Reference;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
public class CapabilityStatement implements AsList<CapabilityStatement>, DomainResource {
  @NotBlank @Builder.Default String resourceType = "CapabilityStatement";

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Valid Narrative text;
  @Valid List<SimpleResource> contained;
  @Valid List<Extension> extension;
  @Valid List<Extension> modifierExtension;

  @Pattern(regexp = Fhir.URI)
  String url;

  String version;
  String name;
  String title;
  @NotNull Status status;
  Boolean experimental;

  @NotBlank
  @Pattern(regexp = Fhir.DATETIME)
  String date;

  String publisher;
  @Valid List<ContactDetail> contact;

  String description;
  List<UsageContext> useContext;
  List<CodeableConcept> jurisdiction;
  String purpose;
  String copyright;
  @NotNull Kind kind;
  List<@Pattern(regexp = Fhir.URI) String> instantiates;
  @Valid Software software;
  @Valid Implementation implementation;
  @NotBlank String fhirVersion;
  @NotNull AcceptUnknown acceptUnknown;

  @NotNull
  @Size(min = 1)
  List<@Pattern(regexp = Fhir.CODE) String> format;

  List<@Pattern(regexp = Fhir.CODE) String> patchFormat;
  List<@Pattern(regexp = Fhir.URI) String> implementationGuide;
  @Valid List<Reference> profile;
  @Valid List<Rest> rest;
  @Valid List<Messaging> messaging;
  @Valid List<Document> document;

  @SuppressWarnings("unused")
  public enum AcceptUnknown {
    no,
    extensions,
    elements,
    both
  }

  @SuppressWarnings("unused")
  public enum Kind {
    instance,
    capability,
    requirements
  }

  @SuppressWarnings("unused")
  public enum Status {
    draft,
    active,
    retired,
    unknown
  }

  @SuppressWarnings("unused")
  public enum RestMode {
    client,
    server
  }

  @SuppressWarnings("unused")
  public enum DocumentMode {
    producer,
    consumer
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
    uri
  }

  @SuppressWarnings("unused")
  public enum SearchParamModifier {
    missing,
    exact,
    contains,
    not,
    text,
    in,
    @JsonProperty("not-in")
    not_in,
    below,
    above,
    type
  }

  @SuppressWarnings("unused")
  public enum ResourceInteractionCode {
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
  public enum RestResourceVersion {
    @JsonProperty("no-version")
    no_version,
    versioned,
    @JsonProperty("versioned-update")
    versioned_update
  }

  @SuppressWarnings("unused")
  public enum RestInteractionCode {
    transaction,
    @JsonProperty("search-system")
    search_system,
    @JsonProperty("history-system")
    history_system,
    batch
  }

  @SuppressWarnings("unused")
  public enum RestTransactionMode {
    @JsonProperty("not-supported")
    not_supported,
    batch,
    transaction,
    both
  }

  @SuppressWarnings("unused")
  public enum MessagingEventCategory {
    Consequence,
    Currency,
    Notification
  }

  @SuppressWarnings("unused")
  public enum MessagingEventMode {
    sender,
    receiver
  }

  @SuppressWarnings("unused")
  public enum DeleteCode {
    @JsonProperty("not-supported")
    not_supported,
    single,
    multiple
  }

  @SuppressWarnings("unused")
  public enum SupportedMessageMode {
    sender,
    receiver
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
    String documentation;
    @NotNull @Valid Reference profile;
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
    @NotBlank String description;

    @Pattern(regexp = Fhir.URI)
    String url;
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

    String documentation;

    MessagingSupportedMessage supportedMessage;

    @NotEmpty
    @Size(min = 1)
    @Valid
    List<MessagingEvent> event;
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
    @NotNull @Valid Coding protocol;

    @NotEmpty
    @Pattern(regexp = Fhir.URI)
    String address;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class MessagingEvent implements AsList<MessagingEvent>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @NotNull @Valid Coding code;
    @Valid MessagingEventCategory category;
    @NotNull @Valid MessagingEventMode mode;

    @NotBlank
    @Pattern(regexp = Fhir.CODE)
    String focus;

    @NotNull @Valid Reference request;
    @NotNull @Valid Reference response;
    String documentation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class MessagingSupportedMessage
      implements AsList<MessagingSupportedMessage>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @NotNull SupportedMessageMode code;
    @NotNull Reference definition;
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
    @NotNull ResourceInteractionCode code;
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
    String documentation;

    @Valid RestSecurity security;

    @NotEmpty
    @Size(min = 1)
    @Valid
    List<RestResource> resource;

    @Valid List<RestInteraction> interaction;
    RestTransactionMode transactionMode;
    @Valid List<SearchParam> searchParam;
    @Valid List<RestOperation> operation;
    List<@Pattern(regexp = Fhir.URI) String> compartment;
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
    @NotNull RestInteractionCode code;
    String documentation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class RestOperation implements AsList<RestOperation>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @NotBlank String name;
    @NotNull @Valid Reference definition;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class RestResource implements AsList<RestResource>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotBlank
    @Pattern(regexp = Fhir.CODE)
    String type;

    @Valid Reference profile;

    String documentation;

    @NotEmpty
    @Size(min = 1)
    @Valid
    List<ResourceInteraction> interaction;

    RestResourceVersion versioning;
    Boolean readHistory;
    Boolean updateCreate;
    Boolean conditionalCreate;
    Boolean conditionalRead;
    Boolean conditionalUpdate;
    DeleteCode conditionalDelete;

    List<String> searchInclude;
    List<String> searchRevInclude;
    @Valid List<SearchParam> searchParam;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class RestSecurity implements AsList<RestSecurity>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    Boolean cors;
    @Valid List<CodeableConcept> service;
    String description;
    @Valid List<SecurityCertificate> certificate;
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
    @NotBlank String name;

    @Pattern(regexp = Fhir.URI)
    String definition;

    @NotNull SearchParamType type;
    String documentation;
    List<@Pattern(regexp = Fhir.CODE) String> target;
    @Valid List<SearchParamModifier> modifier;
    List<String> chain;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class SecurityCertificate implements AsList<SecurityCertificate>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.CODE)
    String type;

    @Pattern(regexp = Fhir.BASE64)
    String blob;
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
    @NotBlank String name;
    String version;

    @Pattern(regexp = Fhir.DATETIME)
    String releaseDate;
  }
}
