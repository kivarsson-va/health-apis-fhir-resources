package gov.va.api.health.r4.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.elements.Element;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.validation.api.ZeroOrOneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
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
@Schema(description = "https://www.hl7.org/fhir/R4/datatypes.html#Timing")
public class Timing implements AsList<Timing>, Element {

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  List<@Pattern(regexp = Fhir.DATETIME) String> event;

  @Valid Repeat repeat;

  @Valid CodeableConcept code;

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(name = "TimingRepeat")
  @ZeroOrOneOf(
      fields = {"boundsDuration", "boundsRange", "boundsPeriod"},
      message = "Only one bounds field may be specified")
  public static class Repeat implements AsList<Repeat>, Element {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid Duration boundsDuration;

    @Valid Range boundsRange;

    @Valid Period boundsPeriod;

    @Min(1)
    Integer count;

    @Min(1)
    Integer countMax;

    BigDecimal duration;

    BigDecimal durationMax;

    UnitOfTime durationUnit;

    @Min(1)
    Integer frequency;

    @Min(1)
    Integer frequencyMax;

    BigDecimal period;

    BigDecimal periodMax;

    UnitOfTime periodUnit;

    @Valid List<DayOfWeek> dayOfWeek;

    List<@Pattern(regexp = Fhir.TIME) String> timeOfDay;

    List<EventTime> when;

    @Min(0)
    Integer offset;

    public enum UnitOfTime {
      s,
      min,
      h,
      d,
      wk,
      mo,
      a;
    }

    public enum DayOfWeek {
      mon,
      tue,
      wed,
      thu,
      fri,
      sat,
      sun;
    }

    public enum EventTime {
      MORN,
      @JsonProperty("MORN.early")
      MORN_early,
      @JsonProperty("MORN.late")
      MORN_late,
      NOON,
      AFT,
      @JsonProperty("AFT.early")
      AFT_early,
      @JsonProperty("AFT.late")
      AFT_late,
      EVE,
      @JsonProperty("EVE.early")
      EVE_early,
      @JsonProperty("EVE.late")
      EVE_late,
      NIGHT,
      PHS,
      HS,
      WAKE,
      C,
      CM,
      CD,
      CV,
      AC,
      ACM,
      ACD,
      ACV,
      PC,
      PCM,
      PCD,
      PCV;
    }
  }
}
