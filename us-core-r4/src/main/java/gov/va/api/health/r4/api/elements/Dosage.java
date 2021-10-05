package gov.va.api.health.r4.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Range;
import gov.va.api.health.r4.api.datatypes.Ratio;
import gov.va.api.health.r4.api.datatypes.SimpleQuantity;
import gov.va.api.health.r4.api.datatypes.Timing;
import gov.va.api.health.validation.api.ZeroOrOneOf;
import gov.va.api.health.validation.api.ZeroOrOneOfs;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
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
@Schema(description = "https://www.hl7.org/fhir/R4/dosage.html")
@ZeroOrOneOf(
    fields = {"asNeededBoolean", "asNeededCodeableConcept"},
    message = "Only one asNeeded field may be specified")
public class Dosage implements AsList<Dosage>, BackboneElement {

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Valid List<Extension> modifierExtension;

  Integer sequence;

  @Pattern(regexp = Fhir.STRING)
  String text;

  @Valid List<CodeableConcept> additionalInstruction;

  @Pattern(regexp = Fhir.STRING)
  String patientInstruction;

  @Valid Timing timing;

  Boolean asNeededBoolean;

  @Valid CodeableConcept asNeededCodeableConcept;

  @Valid CodeableConcept site;

  @Valid CodeableConcept route;

  @Valid CodeableConcept method;

  @Valid List<DoseAndRate> doseAndRate;

  @Valid Ratio maxDosePerPeriod;

  @Valid SimpleQuantity maxDosePerAdministration;

  @Valid SimpleQuantity maxDosePerLifetime;

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "DosageDoseAndRate")
  @ZeroOrOneOfs({
    @ZeroOrOneOf(
        fields = {"doseRange", "doseQuantity"},
        message = "Only one dose field may be specified"),
    @ZeroOrOneOf(
        fields = {"rateRatio", "rateRange", "rateQuantity"},
        message = "Only one rate field may be specified")
  })
  public static class DoseAndRate implements AsList<DoseAndRate>, Element {

    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid CodeableConcept type;

    @Valid Range doseRange;

    @Valid SimpleQuantity doseQuantity;

    @Valid Ratio rateRatio;

    @Valid Range rateRange;

    @Valid SimpleQuantity rateQuantity;
  }
}
