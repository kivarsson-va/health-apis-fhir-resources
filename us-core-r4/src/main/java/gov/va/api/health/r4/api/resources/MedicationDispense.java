package gov.va.api.health.r4.api.resources;

import static org.apache.commons.lang3.StringUtils.defaultString;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.AbstractEntry;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.Annotation;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Signature;
import gov.va.api.health.r4.api.datatypes.SimpleQuantity;
import gov.va.api.health.r4.api.elements.BackboneElement;
import gov.va.api.health.r4.api.elements.Dosage;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.elements.Narrative;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.validation.api.ExactlyOneOf;
import gov.va.api.health.validation.api.ZeroOrOneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
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
    description = "http://hl7.org/fhir/medicationdispense.html",
    example =
        "${r4.medication:gov.va.api.health."
            + "r4.api.swaggerexamples.SwaggerMedicationDispense#medicationDispense}")
@ZeroOrOneOf(
    fields = {"statusReasonCodeableConcept", "statusReasonReference"},
    message = "statusReasonCodeableConcept or statusReasonReference, but not both.")
@ExactlyOneOf(
    fields = {"medicationCodeableConcept", "medicationReference"},
    message = "medicationCodeableConcept or medicationReference, but not both.")
public class MedicationDispense implements AsList<MedicationDispense>, Resource {
  // Ancestors
  @NotBlank @Builder.Default String resourceType = "MedicationDispense";

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

  // Medication Dispense
  @Valid List<Identifier> identifier;

  @Valid @NotNull Status status; // required
  @Valid CodeableConcept statusReasonCodeableConcept;
  @Valid Reference statusReasonReference;

  @Valid List<CodeableConcept> category;

  @Valid CodeableConcept medicationCodeableConcept;
  @Valid Reference medicationReference;

  @Valid @NotNull Reference subject;

  @Valid Reference context;

  @Valid List<Reference> supportingInformation;

  @Valid Performer performer;

  @Valid Reference location;

  @Valid List<Reference> authorizingPrescription;

  @Valid CodeableConcept type;

  @Valid SimpleQuantity quantity;

  @Valid SimpleQuantity daysSupply;

  // why was authoredOn @NotNull?
  @Pattern(regexp = Fhir.DATETIME)
  String whenPrepared;

  // whenHandedOver cannot be before whenPrepared
  @Pattern(regexp = Fhir.DATETIME)
  String whenHandedOver;

  @Valid Reference destination;

  @Valid List<Reference> receiver;

  @Valid List<Annotation> note;

  @Valid List<Dosage> dosageInstruction;

  @Valid Substitution substitution;

  @Valid List<Reference> detectedIssue;

  @Valid List<Reference> eventHistory;

  // preparation | in-progress | cancelled | on-hold | completed | entered-in-error | stopped |
  // declined | unknown
  public enum Status {
    preparation,
    @JsonProperty("in-progress")
    in_progress,
    cancelled,
    @JsonProperty("on-hold")
    on_hold,
    completed,
    @JsonProperty("entered-in-error")
    entered_in_error,
    stopped,
    declined,
    unknown
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "MedicationDispensePerformer")
  public static class Performer implements AsList<Performer>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;
    @Valid List<Extension> modifierExtension;

    @Valid CodeableConcept function;
    @Valid @NotNull Reference actor; // required
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = Bundle.BundleBuilder.class)
  @Schema(
      name = "MedicationDispenseBundle",
      example =
          "${r4.medicationDispenseBundle:gov.va.api.health."
              + "r4.api.swaggerexamples.SwaggerMedicationDispense#medicationDispenseBundle}")
  public static class Bundle extends AbstractBundle<Entry> implements AsList<Bundle> {
    /** Build a Medication Dispense bundle. */
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
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = Entry.EntryBuilder.class)
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
        @Valid AbstractEntry.Search search,
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

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotNull Boolean wasSubstituted;

    @Valid CodeableConcept type;

    @Valid List<CodeableConcept> reason;

    @Valid List<Reference> responsibleParty;
  }
}
