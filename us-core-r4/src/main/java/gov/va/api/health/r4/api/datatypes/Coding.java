package gov.va.api.health.r4.api.datatypes;

import static org.apache.commons.lang3.StringUtils.trimToNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.HasDisplay;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.elements.Element;
import gov.va.api.health.r4.api.elements.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://hl7.org/fhir/R4/datatypes.html#Coding")
public class Coding implements Element, HasDisplay {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.URI)
  String system;

  @Pattern(regexp = Fhir.STRING)
  String version;

  @Pattern(regexp = Fhir.CODE)
  String code;

  @Pattern(regexp = Fhir.STRING)
  String display;

  Boolean userSelected;

  /** All-args builder constructor. */
  @Builder
  public Coding(
      String id,
      List<Extension> extension,
      String system,
      String version,
      String code,
      String display,
      Boolean userSelected) {
    this.id = trimToNull(id);
    this.extension = extension != null && extension.isEmpty() ? null : extension;
    this.system = trimToNull(system);
    this.version = trimToNull(version);
    this.code = trimToNull(code);
    this.display = trimToNull(display);
    this.userSelected = userSelected;
  }
}
