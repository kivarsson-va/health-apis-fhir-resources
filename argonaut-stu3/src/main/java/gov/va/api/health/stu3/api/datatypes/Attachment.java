package gov.va.api.health.stu3.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.stu3.api.Fhir;
import gov.va.api.health.stu3.api.elements.Element;
import gov.va.api.health.stu3.api.elements.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "http://hl7.org/fhir/STU3/datatypes.html#Attachment")
public class Attachment implements AsList<Attachment>, Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.CODE)
  String contentType;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Pattern(regexp = Fhir.BASE64)
  String data;

  @Pattern(regexp = Fhir.URI)
  String url;

  @Min(0)
  Integer size;

  @Pattern(regexp = Fhir.BASE64)
  String hash;

  String title;

  @Pattern(regexp = Fhir.DATETIME)
  String creation;
}
