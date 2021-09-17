package gov.va.api.health.r4.api.resources;

import static org.apache.commons.lang3.StringUtils.defaultString;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.AbstractEntry;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.Address;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.datatypes.HumanName;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Money;
import gov.va.api.health.r4.api.datatypes.Period;
import gov.va.api.health.r4.api.datatypes.Quantity;
import gov.va.api.health.r4.api.datatypes.Signature;
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
import javax.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@Schema(
    description = "https://www.hl7.org/fhir/insuranceplan.html",
    example =
        "${r4.insurancePlan:gov.va.api.health.r4.api.swaggerexamples."
            + "SwaggerInsurancePlan#insurancePlan}")
public final class InsurancePlan implements DomainResource {
  @NotBlank @Builder.Default String resourceType = "InsurancePlan";

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

  @Valid List<Identifier> identifier;

  Status status;

  @Valid List<CodeableConcept> type;

  String name;

  List<String> alias;

  @Valid Period period;

  @Valid Reference ownedBy;

  @Valid Reference administeredBy;

  @Valid List<Reference> coverageArea;

  @Valid List<Contact> contact;

  @Valid List<Reference> endpoint;

  @Valid List<Reference> network;

  @Valid List<Coverage> coverage;

  @Valid List<Plan> plan;

  public enum Status {
    draft,
    active,
    retired,
    unknown
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Contact implements BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @Valid CodeableConcept purpose;

    @Valid HumanName name;

    @Valid List<ContactPoint> telecom;

    @Valid Address address;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Coverage implements BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @Valid @NotNull CodeableConcept type;

    @Valid List<Reference> network;

    @Valid @NotEmpty List<Benefit> benefit;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Benefit implements BackboneElement {
      @Pattern(regexp = Fhir.ID)
      String id;

      @Valid List<Extension> extension;

      @Valid List<Extension> modifierExtension;

      @Valid @NotNull CodeableConcept type;

      String requirement;

      @Valid List<Limit> limit;

      @Data
      @Builder
      @AllArgsConstructor
      @NoArgsConstructor(access = AccessLevel.PRIVATE)
      @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
      public static class Limit implements BackboneElement {
        @Pattern(regexp = Fhir.ID)
        String id;

        @Valid List<Extension> extension;

        @Valid List<Extension> modifierExtension;

        @Valid Quantity value;

        @Valid CodeableConcept code;
      }
    }
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Plan implements BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @Valid List<Identifier> identifier;

    @Valid CodeableConcept type;

    @Valid List<Reference> coverageArea;

    @Valid List<Reference> network;

    @Valid List<GeneralCost> generalCost;

    @Valid List<SpecificCost> specificCost;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SpecificCost implements BackboneElement {
      @Pattern(regexp = Fhir.ID)
      String id;

      @Valid List<Extension> extension;

      @Valid List<Extension> modifierExtension;

      @Valid @NotNull CodeableConcept category;

      @Valid List<Benefit> benefit;

      @Data
      @Builder
      @AllArgsConstructor
      @NoArgsConstructor(access = AccessLevel.PRIVATE)
      @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
      public static class Benefit implements BackboneElement {
        @Pattern(regexp = Fhir.ID)
        String id;

        @Valid List<Extension> extension;

        @Valid List<Extension> modifierExtension;

        @Valid @NotNull CodeableConcept type;

        @Valid List<Cost> cost;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
        public static class Cost implements BackboneElement {
          @Pattern(regexp = Fhir.ID)
          String id;

          @Valid List<Extension> extension;

          @Valid List<Extension> modifierExtension;

          @Valid @NotNull CodeableConcept type;

          @Valid CodeableConcept applicability;

          @Valid List<CodeableConcept> qualifiers;

          @Valid Quantity value;
        }
      }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class GeneralCost implements BackboneElement {
      @Pattern(regexp = Fhir.ID)
      String id;

      @Valid List<Extension> extension;

      @Valid List<Extension> modifierExtension;

      @Valid CodeableConcept type;

      @Positive Integer groupSize;

      @Valid Money cost;

      String comment;
    }
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = InsurancePlan.Bundle.BundleBuilder.class)
  @Schema(
      name = "InsurancePlanBundle",
      example =
          "${r4.insurancePlanBundle:gov.va.api.health.r4.api.swaggerexamples."
              + "SwaggerInsurancePlan#insurancePlanBundle}")
  public static final class Bundle extends AbstractBundle<Entry> {
    /** Builder constructor. */
    @Builder
    public Bundle(
        @NotBlank String resourceType,
        @Pattern(regexp = Fhir.ID) String id,
        @Valid Meta meta,
        @Pattern(regexp = Fhir.URI) String implicitRules,
        @Pattern(regexp = Fhir.CODE) String language,
        @Valid Identifier identifier,
        @NotNull AbstractBundle.BundleType type,
        @Pattern(regexp = Fhir.INSTANT) String timestamp,
        @Min(0) Integer total,
        @Valid List<BundleLink> link,
        @Valid List<Entry> entry,
        @Valid Signature signature) {
      super(
          defaultString(resourceType, "Bundle"),
          id,
          meta,
          implicitRules,
          language,
          identifier,
          type,
          timestamp,
          total,
          link,
          entry,
          signature);
    }
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @Schema(name = "InsurancePlanEntry")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = InsurancePlan.Entry.EntryBuilder.class)
  public static final class Entry extends AbstractEntry<InsurancePlan> {
    @Builder
    public Entry(
        @Pattern(regexp = Fhir.ID) String id,
        @Valid List<Extension> extension,
        @Valid List<Extension> modifierExtension,
        @Valid List<BundleLink> link,
        @Pattern(regexp = Fhir.URI) String fullUrl,
        @Valid InsurancePlan resource,
        @Valid Search search,
        @Valid Request request,
        @Valid Response response) {
      super(id, extension, modifierExtension, link, fullUrl, resource, search, request, response);
    }
  }
}
