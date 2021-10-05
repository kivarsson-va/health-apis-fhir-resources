package gov.va.api.health.stu3.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.fhir.api.HasDisplay;
import gov.va.api.health.stu3.api.Fhir;
import gov.va.api.health.stu3.api.elements.Element;
import gov.va.api.health.stu3.api.elements.Extension;
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
@Schema(description = "http://hl7.org/fhir/STU3/datatypes.html#CodeableConcept")
public class CodeableConcept implements AsList<CodeableConcept>, Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Valid List<Coding> coding;
  String text;

  /**
   * Return a usuable text value that has been explicitly set or is promoted from a display of an
   * inner coding.
   */
  @JsonProperty
  public String text() {
    return HasDisplay.anyDisplay(text, coding);
  }
}
