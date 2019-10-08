package gov.va.api.health.r4.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.Address;
import gov.va.api.health.r4.api.datatypes.Attachment;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Money;
import gov.va.api.health.r4.api.datatypes.Period;
import gov.va.api.health.r4.api.datatypes.Quantity;
import gov.va.api.health.r4.api.datatypes.SimpleQuantity;
import gov.va.api.health.r4.api.datatypes.SimpleResource;
import gov.va.api.health.r4.api.elements.BackboneElement;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.elements.Narrative;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.validation.api.ExactlyOneOf;
import gov.va.api.health.validation.api.ZeroOrOneOf;
import gov.va.api.health.validation.api.ZeroOrOneOfs;
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
@JsonAutoDetect(
  fieldVisibility = JsonAutoDetect.Visibility.ANY,
  isGetterVisibility = JsonAutoDetect.Visibility.NONE
)
@Schema(description = "https://www.hl7.org/fhir/R4/claim.html", example = "SWAGGER_EXAMPLE_CLAIM")
public class Claim implements Resource {

  // Ancestor -- Resource
  @Pattern(regexp = Fhir.ID)
  String id;

  @NotBlank String resourceType;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  // Ancestor -- DomainResource
  @Valid Narrative text;

  @Valid List<SimpleResource> contained;

  @Valid List<Extension> extension;

  @Valid List<Extension> modifierExtension;

  // Claim Resource
  @Valid List<Identifier> identifier;

  @NotNull Status status;

  @NotNull @Valid CodeableConcept type;

  @Valid CodeableConcept subType;

  @NotNull Use use;

  @NotNull @Valid Reference patient;

  @Valid Period billablePeriod;

  @NotBlank
  @Pattern(regexp = Fhir.DATETIME)
  String created;

  @Valid Reference enterer;

  @Valid Reference insurer;

  @NotNull @Valid Reference provider;

  @NotNull @Valid CodeableConcept priority;

  @Valid CodeableConcept fundsReserve;

  @Valid List<Related> related;

  @Valid Reference prescription;

  @Valid Reference originalPrescription;

  @Valid Payee payee;

  @Valid Reference referral;

  @Valid Reference facility;

  @Valid List<CareTeam> careTeam;

  @Valid List<SupportingInfo> supportingInfo;

  @Valid List<Diagnosis> diagnosis;

  @Valid List<Procedure> procedure;

  @NotEmpty @Valid List<Insurance> insurance;

  @Valid Accident accident;

  @Valid List<Item> item;

  @Valid Money total;

  public enum Status {
    active,
    cancelled,
    draft,
    @JsonProperty("entered-in-error")
    entered_in_error
  }

  public enum Use {
    claim,
    preauthorization,
    predetermination
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimRelated")
  public static class Related implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @Valid Reference claim;

    @Valid CodeableConcept relationship;

    @Valid Identifier reference;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimPayee")
  public static class Payee implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotNull @Valid CodeableConcept type;

    @Valid Reference party;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimCareTeam")
  public static class CareTeam implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank
    @Pattern(regexp = Fhir.POSITIVE_INT)
    String sequence;

    @NotNull @Valid Reference provider;

    @Pattern(regexp = Fhir.BOOLEAN)
    String responsible;

    @Valid CodeableConcept role;

    @Valid CodeableConcept qualification;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimSupportingInfo")
  @ZeroOrOneOfs({
    @ZeroOrOneOf(
      fields = {"timingDate", "timingPeriod"},
      message = "Only one timing field may be specified"
    ),
    @ZeroOrOneOf(
      fields = {
        "valueBoolean",
        "valueString",
        "valueQuantity",
        "valueAttachment",
        "valueReference"
      },
      message = "Only one value field may be specified"
    )
  })
  public static class SupportingInfo implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank
    @Pattern(regexp = Fhir.POSITIVE_INT)
    String sequence;

    @NotNull @Valid CodeableConcept category;

    @Valid CodeableConcept code;

    @Pattern(regexp = Fhir.DATE)
    String timingDate;

    @Valid Period timingPeriod;

    @Pattern(regexp = Fhir.BOOLEAN)
    String valueBoolean;

    @Pattern(regexp = Fhir.STRING)
    String valueString;

    @Valid Quantity valueQuantity;

    @Valid Attachment valueAttachment;

    @Valid Reference valueReference;

    @Valid CodeableConcept reason;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimDiagnosis")
  @ExactlyOneOf(
    fields = {"diagnosisCodeableConcept", "diagnosisReference"},
    message = "diagnosisCodeableConcept or diagnosisReference, but not both"
  )
  public static class Diagnosis implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank
    @Pattern(regexp = Fhir.POSITIVE_INT)
    String sequence;

    @Valid CodeableConcept diagnosisCodeableConcept;

    @Valid Reference diagnosisReference;

    @Valid List<CodeableConcept> type;

    @Valid CodeableConcept onAdmission;

    @Valid CodeableConcept packageCode;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimProcedure")
  @ExactlyOneOf(
    fields = {"procedureCodeableConcept", "procedureReference"},
    message = "procedureCodeableConcept or procedureReference, but not both"
  )
  public static class Procedure implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank
    @Pattern(regexp = Fhir.POSITIVE_INT)
    String sequence;

    @Valid List<CodeableConcept> type;

    @Pattern(regexp = Fhir.DATETIME)
    String date;

    @Valid CodeableConcept procedureCodeableConcept;

    @Valid Reference procedureReference;

    @Valid List<Reference> udi;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimInsurance")
  public static class Insurance implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank
    @Pattern(regexp = Fhir.POSITIVE_INT)
    String sequence;

    @NotBlank
    @Pattern(regexp = Fhir.BOOLEAN)
    String focal;

    @Valid Identifier identifier;

    @NotNull @Valid Reference coverage;

    @Pattern(regexp = Fhir.STRING)
    String businessArrangement;

    @Valid List<@Pattern(regexp = Fhir.STRING) String> preAuthRef;

    @Valid Reference claimResponse;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimAccident")
  @ZeroOrOneOf(
    fields = {"locationAddress", "locationReference"},
    message = "Only one location field may be specified"
  )
  public static class Accident implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank
    @Pattern(regexp = Fhir.DATE)
    String date;

    @Valid CodeableConcept type;

    @Valid Address locationAddress;

    @Valid Reference locationReference;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "ClaimItem")
  @ZeroOrOneOfs({
    @ZeroOrOneOf(
      fields = {"servicedDate", "servicedPeriod"},
      message = "Only one serviced field may be specified"
    ),
    @ZeroOrOneOf(
      fields = {"locationCodeableConcept", "locationAddress", "locationReference"},
      message = "Only one location field may be specified"
    )
  })
  public static class Item implements BackboneElement {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank
    @Pattern(regexp = Fhir.POSITIVE_INT)
    String sequence;

    @Valid List<@Pattern(regexp = Fhir.POSITIVE_INT) String> careTeamSequence;

    @Valid List<@Pattern(regexp = Fhir.POSITIVE_INT) String> diagnosisSequence;

    @Valid List<@Pattern(regexp = Fhir.POSITIVE_INT) String> procedureSequence;

    @Valid List<@Pattern(regexp = Fhir.POSITIVE_INT) String> informationSequence;

    @Valid CodeableConcept revenue;

    @Valid CodeableConcept category;

    @NotNull @Valid CodeableConcept productOrService;

    @Valid List<CodeableConcept> modifier;

    @Valid List<CodeableConcept> programCode;

    @Pattern(regexp = Fhir.DATE)
    String servicedDate;

    @Valid Period servicedPeriod;

    @Valid CodeableConcept locationCodeableConcept;

    @Valid Address locationAddress;

    @Valid Reference locationReference;

    @Valid SimpleQuantity quantity;

    @Valid Money unitPrice;

    @Pattern(regexp = Fhir.DECIMAL)
    String factor;

    @Valid Money net;

    @Valid List<Reference> udi;

    @Valid CodeableConcept bodySite;

    @Valid List<CodeableConcept> subSite;

    @Valid List<Reference> encounter;

    @Valid List<Detail> detail;

    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Schema(name = "ClaimItemDetail")
    public static class Detail implements BackboneElement {

      @Pattern(regexp = Fhir.ID)
      String id;

      @Valid List<Extension> extension;

      @Valid List<Extension> modifierExtension;

      @NotBlank
      @Pattern(regexp = Fhir.POSITIVE_INT)
      String sequence;

      @Valid CodeableConcept revenue;

      @Valid CodeableConcept category;

      @NotNull @Valid CodeableConcept productOrService;

      @Valid List<CodeableConcept> modifier;

      @Valid List<CodeableConcept> programCode;

      @Valid SimpleQuantity quantity;

      @Valid Money unitPrice;

      @Pattern(regexp = Fhir.DECIMAL)
      String factor;

      @Valid Money net;

      @Valid List<Reference> udi;

      @Valid List<SubDetail> subDetail;

      @Data
      @Builder
      @NoArgsConstructor(access = AccessLevel.PRIVATE)
      @AllArgsConstructor
      @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
      @Schema(name = "ClaimItemDetailSubDetail")
      public static class SubDetail implements BackboneElement {

        @Pattern(regexp = Fhir.ID)
        String id;

        @Valid List<Extension> extension;

        @Valid List<Extension> modifierExtension;

        @NotBlank
        @Pattern(regexp = Fhir.POSITIVE_INT)
        String sequence;

        @Valid CodeableConcept revenue;

        @Valid CodeableConcept category;

        @NotNull @Valid CodeableConcept productOrService;

        @Valid List<CodeableConcept> modifier;

        @Valid List<CodeableConcept> programCode;

        @Valid SimpleQuantity quantity;

        @Valid Money unitPrice;

        @Pattern(regexp = Fhir.DECIMAL)
        String factor;

        @Valid Money net;

        @Valid List<Reference> udi;
      }
    }
  }
}
