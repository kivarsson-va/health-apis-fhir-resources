package gov.va.api.health.dstu2.api.resources;

import static org.apache.commons.lang3.StringUtils.defaultString;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import gov.va.api.health.dstu2.api.Fhir;
import gov.va.api.health.dstu2.api.bundle.AbstractBundle;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Duration;
import gov.va.api.health.dstu2.api.datatypes.Identifier;
import gov.va.api.health.dstu2.api.datatypes.Period;
import gov.va.api.health.dstu2.api.datatypes.Signature;
import gov.va.api.health.dstu2.api.datatypes.SimpleResource;
import gov.va.api.health.dstu2.api.elements.BackboneElement;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.elements.Meta;
import gov.va.api.health.dstu2.api.elements.Narrative;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.fhir.api.AsList;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(
    description = "http://www.hl7.org/fhir/DSTU2/encounter.html",
    example =
        "${dstu2.encounter:gov.va.api.health.dstu2.api.swaggerexamples"
            + ".SwaggerEncounter#encounter}")
public class Encounter implements AsList<Encounter>, DomainResource {
  @NotBlank @Builder.Default String resourceType = "Encounter";

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Valid Narrative text;
  @Valid List<SimpleResource> contained;
  @Valid List<Extension> modifierExtension;
  @Valid List<Extension> extension;

  @Valid List<Identifier> identifier;
  @NotNull Encounter.Status status;
  @Valid List<StatusHistory> statusHistory;

  @JsonProperty("class")
  EncounterClass encounterClass;

  @Valid List<CodeableConcept> type;
  @Valid List<CodeableConcept> priority;
  @Valid Reference patient;
  @Valid List<Reference> episodeOfCare;
  @Valid List<Reference> incomingReferral;
  @Valid List<Participant> participant;
  @Valid Reference appointment;
  @Valid Period period;
  @Valid Duration length;
  @Valid List<CodeableConcept> reason;
  @Valid List<Reference> indication;
  @Valid Hospitalization hospitalization;

  @Valid List<EncounterLocation> location;

  @Valid Reference serviceProvider;
  @Valid Reference partOf;

  public enum Status {
    arrived,
    cancelled,
    finished,
    @JsonProperty("in-progress")
    in_progress,
    onleave,
    planned
  }

  public enum EncounterClass {
    ambulatory,
    daytime,
    emergency,
    field,
    home,
    inpatient,
    other,
    outpatient,
    virtual,
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = Encounter.Bundle.BundleBuilder.class)
  @Schema(
      name = "EncounterBundle",
      example =
          "${dstu2.encounterBundle:gov.va.api.health.dstu2.api.swaggerexamples"
              + ".SwaggerEncounter#encounterBundle}")
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
  public static class EncounterLocation implements AsList<EncounterLocation>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @Valid @NotNull Reference location;
    Encounter.EncounterLocation.Status status;
    @Valid Period period;

    public enum Status {
      planned,
      active,
      reserved,
      completed
    }
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @JsonDeserialize(builder = Encounter.Entry.EntryBuilder.class)
  @Schema(name = "EncounterEntry")
  public static class Entry extends AbstractEntry<Encounter> implements AsList<Entry> {
    @Builder
    public Entry(
        @Pattern(regexp = Fhir.ID) String id,
        @Valid List<Extension> extension,
        @Valid List<Extension> modifierExtension,
        @Valid List<BundleLink> link,
        @Pattern(regexp = Fhir.URI) String fullUrl,
        @Valid Encounter resource,
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
  public static class Hospitalization implements AsList<Hospitalization>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @Valid Identifier preAdmissionIdentifier;
    @Valid Reference origin;
    @Valid CodeableConcept admitSource;
    @Valid List<Reference> admittingDiagnosis;
    @Valid CodeableConcept reAdmission;
    @Valid List<CodeableConcept> dietPreference;
    @Valid List<CodeableConcept> specialCourtesy;
    @Valid List<CodeableConcept> specialArrangement;
    @Valid Reference destination;
    @Valid CodeableConcept dischargeDisposition;
    @Valid List<Reference> dischargeDiagnosis;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class Participant implements AsList<Participant>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @Valid List<CodeableConcept> type;
    @Valid Period period;
    @Valid Reference individual;
  }

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  public static class StatusHistory implements AsList<StatusHistory>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;
    @Valid List<Extension> extension;
    @NotNull Encounter.Status status;
    @NotNull @Valid Period period;
  }
}
