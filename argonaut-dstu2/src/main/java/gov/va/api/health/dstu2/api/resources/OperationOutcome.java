package gov.va.api.health.dstu2.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.dstu2.api.Fhir;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.SimpleResource;
import gov.va.api.health.dstu2.api.elements.BackboneElement;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.elements.Meta;
import gov.va.api.health.dstu2.api.elements.Narrative;
import gov.va.api.health.fhir.api.AsList;
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
    description = "https://www.hl7.org/fhir/operationoutcome.html",
    example =
        "${dstu2.operationOutcome:gov.va.api.health.dstu2.api.swaggerexamples"
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

  @Valid List<SimpleResource> contained;

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
          "https://www.hl7.org/fhir/operationoutcome-definitions.html#OperationOutcome.issue")
  public static class Issue implements AsList<Issue>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> modifierExtension;

    @Valid List<Extension> extension;

    @NotNull OperationOutcome.Issue.IssueSeverity severity;

    @NotBlank
    @Pattern(regexp = Fhir.CODE)
    @Schema(description = "http://hl7.org/fhir/DSTU2/valueset-issue-type.html")
    String code;

    @Valid CodeableConcept details;

    String diagnostics;

    List<String> location;

    List<String> expression;

    @SuppressWarnings("unused")
    public enum IssueSeverity {
      fatal,
      error,
      warning,
      information
    }
  }
}
