package gov.va.api.health.dstu2.api.resources;

import static org.apache.commons.lang3.StringUtils.defaultString;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gov.va.api.health.dstu2.api.Fhir;
import gov.va.api.health.dstu2.api.bundle.AbstractBundle;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Identifier;
import gov.va.api.health.dstu2.api.datatypes.Range;
import gov.va.api.health.dstu2.api.datatypes.Ratio;
import gov.va.api.health.dstu2.api.datatypes.Signature;
import gov.va.api.health.dstu2.api.datatypes.SimpleQuantity;
import gov.va.api.health.dstu2.api.datatypes.SimpleResource;
import gov.va.api.health.dstu2.api.datatypes.Timing;
import gov.va.api.health.dstu2.api.elements.BackboneElement;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.elements.Meta;
import gov.va.api.health.dstu2.api.elements.Narrative;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.fhir.api.FhirDateTime;
import gov.va.api.health.validation.api.ExactlyOneOf;
import gov.va.api.health.validation.api.ZeroOrOneOf;
import gov.va.api.health.validation.api.ZeroOrOneOfs;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@Schema(
    description = "https://www.hl7.org/fhir/DSTU2/medicationdispense.html",
    example =
        "${dstu2.medicationDispense:"
            + "gov.va.api.health.dstu2.api.swaggerexamples."
            + "SwaggerMedicationDispense#medicationDispense}")
@ExactlyOneOf(
    fields = {"medicationCodeableConcept", "medicationReference"},
    message = "Exactly one medication field must be specified")
public class MedicationDispense implements AsList<MedicationDispense>, DomainResource {
  @NotBlank @Builder.Default String resourceType = "MedicationDispense";

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Valid List<SimpleResource> contained;
  @Valid List<Extension> extension;
  @Valid List<Extension> modifierExtension;
  @Valid Identifier identifier;
  @Valid Narrative text;
  @Valid Status status;
  @Valid Reference patient;
  @Valid Reference dispenser;
  @Valid List<Reference> authorizingPrescription;
  @Valid CodeableConcept type;
  @Valid SimpleQuantity quantity;
  @Valid SimpleQuantity daysSupply;
  @Valid Reference medicationReference;
  @Valid CodeableConcept medicationCodeableConcept;

  @Pattern(regexp = Fhir.DATETIME)
  String whenPrepared;

  @Pattern(regexp = Fhir.DATETIME)
  String whenHandedOver;

  @Valid Reference destination;
  @Valid List<Reference> receiver;
  String note;
  @Valid List<DosageInstruction> dosageInstruction;
  @Valid Substitution substitution;

  /**
   * Medication dispense must be prepared before being handed over. This constraint verifies that if
   * both are fields are set, the handed over time is chronologically after the prepared time. See
   * Constraint mdd-1: whenHandedOver cannot be before whenPrepared.
   */
  @JsonIgnore
  @SuppressWarnings("unused")
  @AssertTrue(message = "whenPrepared must be chronologically before whenHandedOver.")
  private boolean isPreparedBeforeHandedOver() {
    if (whenPrepared == null || whenHandedOver == null) {
      return true;
    }
    /*
     * This catch is to avoid having redundant validation errors thrown. We'd like the Pattern regex
     * to be the only one thrown instead of this one with a more generic message.
     */
    try {
      Instant prepared = FhirDateTime.parseDateTime(whenPrepared);
      Instant handedOver = FhirDateTime.parseDateTime(whenHandedOver);
      return !prepared.isAfter(handedOver);
    } catch (IllegalArgumentException e) {
      /*
       * We were not able to understand at least one of the dates. We're going to say this is OK
       * since the regex parser should fail.
       */
      return true;
    }
  }

  public enum Status {
    @JsonProperty("in-progress")
    in_progress,
    @JsonProperty("on-hold")
    on_hold,
    completed,
    @JsonProperty("entered-in-error")
    entered_in_error,
    stopped
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = MedicationDispense.Bundle.BundleBuilder.class)
  @Schema(
      name = "MedicationDispenseBundle",
      example =
          "${dstu2.medicationDispenseBundle:"
              + "gov.va.api.health.dstu2.api.swaggerexamples."
              + "SwaggerMedicationDispense#medicationDispenseBundle}")
  public static class Bundle extends AbstractBundle<Entry> implements AsList<Bundle> {
    /** Builder constructor. */
    @Builder
    public Bundle(
        @NotBlank String resourceType,
        @Pattern(regexp = Fhir.ID) String id,
        @Valid Meta meta,
        @Pattern(regexp = Fhir.URI) String implicitRules,
        @Pattern(regexp = Fhir.CODE) String language,
        @NotNull BundleType type,
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
          type,
          total,
          link,
          entry,
          signature);
    }
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "MedicationDispenseDosageInstruction")
  @ZeroOrOneOfs({
    @ZeroOrOneOf(
        fields = {"asNeededBoolean", "asNeededCodeableConcept"},
        message = "Only one asNeeded field may be specified"),
    @ZeroOrOneOf(
        fields = {"siteCodeableConcept", "siteReference"},
        message = "Only one site field may be specified"),
    @ZeroOrOneOf(
        fields = {"doseRange", "doseQuantity"},
        message = "Only one dose field may be specified"),
    @ZeroOrOneOf(
        fields = {"rateRatio", "rateRange"},
        message = "Only one rate field may be specified")
  })
  public static class DosageInstruction implements AsList<DosageInstruction>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    String text;
    @Valid CodeableConcept additionalInstructions;
    @Valid Timing timing;
    Boolean asNeededBoolean;
    @Valid CodeableConcept asNeededCodeableConcept;
    @Valid CodeableConcept siteCodeableConcept;
    @Valid Reference siteReference;
    @Valid CodeableConcept route;
    @Valid CodeableConcept method;
    @Valid Range doseRange;
    @Valid SimpleQuantity doseQuantity;
    @Valid Ratio rateRatio;
    @Valid Range rateRange;
    @Valid Ratio maxDosePerPeriod;
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = MedicationDispense.Entry.EntryBuilder.class)
  @Schema(name = "MedicationDispenseEntry")
  public static class Entry extends AbstractEntry<MedicationDispense> implements AsList<Entry> {
    @Builder
    public Entry(
        @Pattern(regexp = Fhir.ID) String id,
        @Valid List<Extension> extension,
        @Valid List<Extension> modifierExtension,
        @Valid List<BundleLink> link,
        @Pattern(regexp = Fhir.URI) String fullUrl,
        @Valid MedicationDispense resource,
        @Valid Search search,
        @Valid Request request,
        @Valid Response response) {
      super(id, extension, modifierExtension, link, fullUrl, resource, search, request, response);
    }
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "MedicationDispenseSubstitution")
  public static class Substitution implements AsList<Substitution>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @NotNull @Valid CodeableConcept type;
    @Valid List<CodeableConcept> reason;
    @Valid List<Reference> responsibleParty;
  }
}
