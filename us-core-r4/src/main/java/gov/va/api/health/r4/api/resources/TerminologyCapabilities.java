package gov.va.api.health.r4.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.ContactDetail;
import gov.va.api.health.r4.api.datatypes.UsageContext;
import gov.va.api.health.r4.api.elements.BackboneElement;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.elements.Meta;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
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
@Schema(description = "https://www.hl7.org/fhir/R4/terminologycapabilities.html")
public class TerminologyCapabilities implements AsList<TerminologyCapabilities>, Resource {
  @NotBlank @Builder.Default String resourceType = "TerminologyCapabilities";

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Pattern(regexp = Fhir.URI)
  String url;

  @Pattern(regexp = Fhir.STRING)
  String version;

  @Pattern(regexp = Fhir.STRING)
  String name;

  @Pattern(regexp = Fhir.STRING)
  String title;

  @NotNull CapabilityStatement.Status status;

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

  @NotNull CapabilityStatement.Kind kind;

  @Valid Software software;

  @Valid Implementation implementation;

  Boolean lockedDate;

  @Valid List<CodeSystem> codeSystem;
  @Valid List<Expansion> expansion;
  @Valid CodeSearch codeSearch;
  @Valid ValidateCode validateCode;
  @Valid Translation translation;
  @Valid Closure closure;

  @SuppressWarnings("unused")
  public enum CodeSearch {
    all,
    explicit
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Closure implements AsList<Closure>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    Boolean translation;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class CodeSystem implements AsList<CodeSystem>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.CANONICAL)
    String uri;

    @Valid List<Version> version;

    Boolean subsumption;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Expansion implements AsList<Expansion>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    Boolean hierarchical;

    Boolean paging;

    Boolean incomplete;

    @Valid List<Parameter> parameter;

    @Pattern(regexp = Fhir.MARKDOWN)
    String textFilter;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Filter implements AsList<Filter>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.CODE)
    @NotNull
    String code;

    @Pattern(regexp = Fhir.CODE)
    @NotEmpty
    List<String> op;
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
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Parameter implements AsList<Parameter>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.CODE)
    @NotEmpty
    String name;

    @Pattern(regexp = Fhir.STRING)
    String documentation;
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
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Translation implements AsList<Translation>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotNull Boolean needsMap;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class ValidateCode implements AsList<ValidateCode>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @NotEmpty Boolean translations;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(
      fieldVisibility = JsonAutoDetect.Visibility.ANY,
      isGetterVisibility = JsonAutoDetect.Visibility.NONE)
  public static class Version implements AsList<Version>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;

    @Pattern(regexp = Fhir.STRING)
    String code;

    Boolean isDefault;

    Boolean compositional;

    @Pattern(regexp = Fhir.CODE)
    List<String> language;

    @Valid List<Filter> filter;

    @Pattern(regexp = Fhir.CODE)
    List<String> property;
  }
}
