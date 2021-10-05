package gov.va.api.health.r4.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.elements.BackboneElement;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.elements.Narrative;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(
    description = "https://www.hl7.org/fhir/R4/operationoutcome.html",
    example =
        "${r4.operationOutcome:gov.va.api.health.r4.api.swaggerexamples"
            + ".SwaggerOperationOutcome#operationOutcome}")
public class OperationOutcome implements AsList<OperationOutcome>, DomainResource {
  @NotBlank @Builder.Default String resourceType = "OperationOutcome";

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Valid Narrative text;

  @Valid List<Resource> contained;

  @Valid List<Extension> modifierExtension;

  @Valid List<Extension> extension;

  @NotEmpty @Valid List<Issue> issue;

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
  @Schema(
      description =
          "https://www.hl7.org/fhir/R4/operationoutcome-definitions.html#OperationOutcome.issue")
  public static class Issue implements AsList<Issue>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;

    @Valid List<Extension> extension;

    @NotNull IssueSeverity severity;

    @NotBlank
    @Pattern(regexp = Fhir.CODE)
    @Schema(description = "https://www.hl7.org/fhir/R4/valueset-issue-type.html")
    String code;

    @Valid CodeableConcept details;

    @Pattern(regexp = Fhir.STRING)
    String diagnostics;

    List<@Pattern(regexp = Fhir.STRING) String> location;

    List<@Pattern(regexp = Fhir.STRING) String> expression;

    @SuppressWarnings("unused")
    public enum IssueSeverity {
      fatal,
      error,
      warning,
      information
    }
  }
}
