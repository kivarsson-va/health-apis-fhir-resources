package gov.va.api.health.dstu2.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.dstu2.api.Fhir;
import gov.va.api.health.dstu2.api.elements.Element;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.validation.api.ExactlyOneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "http://hl7.org/fhir/DSTU2/datatypes.html#Signature")
@ExactlyOneOf(fields = {"whoUri", "whoReference"})
public class Signature implements AsList<Signature>, Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Valid @NotEmpty List<Coding> type;

  @NotNull
  @Pattern(regexp = Fhir.INSTANT)
  String when;

  @Pattern(regexp = Fhir.URI)
  String whoUri;

  @Valid Reference whoReference;

  @NotEmpty
  @Pattern(regexp = Fhir.CODE)
  String contentType;

  @NotEmpty
  @Pattern(regexp = Fhir.BASE64)
  String blob;
}
