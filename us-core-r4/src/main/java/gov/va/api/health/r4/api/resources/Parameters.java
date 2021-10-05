package gov.va.api.health.r4.api.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.Address;
import gov.va.api.health.r4.api.datatypes.Age;
import gov.va.api.health.r4.api.datatypes.Annotation;
import gov.va.api.health.r4.api.datatypes.Attachment;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.ContactDetail;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.datatypes.Contributor;
import gov.va.api.health.r4.api.datatypes.DataRequirement;
import gov.va.api.health.r4.api.datatypes.Duration;
import gov.va.api.health.r4.api.datatypes.Expression;
import gov.va.api.health.r4.api.datatypes.HumanName;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Money;
import gov.va.api.health.r4.api.datatypes.ParameterDefinition;
import gov.va.api.health.r4.api.datatypes.Period;
import gov.va.api.health.r4.api.datatypes.Quantity;
import gov.va.api.health.r4.api.datatypes.Range;
import gov.va.api.health.r4.api.datatypes.Ratio;
import gov.va.api.health.r4.api.datatypes.RelatedArtifact;
import gov.va.api.health.r4.api.datatypes.SampledData;
import gov.va.api.health.r4.api.datatypes.Signature;
import gov.va.api.health.r4.api.datatypes.Timing;
import gov.va.api.health.r4.api.datatypes.TriggerDefinition;
import gov.va.api.health.r4.api.datatypes.UsageContext;
import gov.va.api.health.r4.api.elements.BackboneElement;
import gov.va.api.health.r4.api.elements.Dosage;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.validation.api.ZeroOrOneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@Schema(description = "https://www.hl7.org/fhir/R4/parameters.html")
public final class Parameters implements AsList<Parameters>, Resource {
  @NotBlank @Builder.Default String resourceType = "Parameters";

  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid Meta meta;

  @Pattern(regexp = Fhir.URI)
  String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  String language;

  @Valid List<Parameter> parameter;

  @Data
  @Builder
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @JsonAutoDetect(
      fieldVisibility = JsonAutoDetect.Visibility.ANY,
      isGetterVisibility = JsonAutoDetect.Visibility.NONE)
  @Schema(name = "Parameter")
  @ZeroOrOneOf(
      fields = {
        "valueBase64Binary",
        "valueBoolean",
        "valueCanonical",
        "valueCode",
        "valueDate",
        "valueDateTime",
        "valueDecimal",
        "valueId",
        "valueInstant",
        "valueInteger",
        "valueMarkdown",
        "valueOid",
        "valuePositiveInt",
        "valueString",
        "valueTime",
        "valueUnsignedInt",
        "valueUri",
        "valueUrl",
        "valueUuid",
        "valueAddress",
        "valueAge",
        "valueAnnotation",
        "valueAttachment",
        "valueCodeableConcept",
        "valueCoding",
        "valueContactPoint",
        "valueCount",
        "valueDistance",
        "valueDuration",
        "valueHumanName",
        "valueIdentifier",
        "valueMoney",
        "valuePeriod",
        "valueQuantity",
        "valueRange",
        "valueRatio",
        "valueReference",
        "valueSampledData",
        "valueSignature",
        "valueTiming",
        "valueContactDetail",
        "valueContributor",
        "valueDataRequirement",
        "valueExpression",
        "valueParameterDefinition",
        "valueRelatedArtifact",
        "valueTriggerDefinition",
        "valueUsageContext",
        "valueDosage",
        "valueMeta"
      })
  public static final class Parameter implements AsList<Parameter>, BackboneElement {
    @Pattern(regexp = Fhir.ID)
    String id;

    @Valid List<Extension> extension;

    @Valid List<Extension> modifierExtension;

    @NotBlank String name;

    @Pattern(regexp = Fhir.BASE64)
    String valueBase64Binary;

    Boolean valueBoolean;

    @Pattern(regexp = Fhir.CANONICAL)
    String valueCanonical;

    @Pattern(regexp = Fhir.CODE)
    String valueCode;

    @Pattern(regexp = Fhir.DATE)
    String valueDate;

    @Pattern(regexp = Fhir.DATETIME)
    String valueDateTime;

    BigDecimal valueDecimal;

    @Pattern(regexp = Fhir.ID)
    String valueId;

    @Pattern(regexp = Fhir.INSTANT)
    String valueInstant;

    Integer valueInteger;

    @Pattern(regexp = Fhir.MARKDOWN)
    String valueMarkdown;

    @Pattern(regexp = Fhir.OID)
    String valueOid;

    @Min(1)
    Integer valuePositiveInt;

    @Pattern(regexp = Fhir.STRING)
    String valueString;

    @Pattern(regexp = Fhir.TIME)
    String valueTime;

    @Min(0)
    Integer valueUnsignedInt;

    @Pattern(regexp = Fhir.URI)
    String valueUri;

    @Pattern(regexp = Fhir.URI)
    String valueUrl;

    @Pattern(regexp = Fhir.URI)
    String valueUuid;

    @Valid Address valueAddress;

    @Valid Age valueAge;

    @Valid Annotation valueAnnotation;

    @Valid Attachment valueAttachment;

    @Valid CodeableConcept valueCodeableConcept;

    @Valid Coding valueCoding;

    @Valid ContactPoint valueContactPoint;

    @Valid Quantity valueCount;

    @Valid Quantity valueDistance;

    @Valid Duration valueDuration;

    @Valid HumanName valueHumanName;

    @Valid Identifier valueIdentifier;

    @Valid Money valueMoney;

    @Valid Period valuePeriod;

    @Valid Quantity valueQuantity;

    @Valid Range valueRange;

    @Valid Ratio valueRatio;

    @Valid Reference valueReference;

    @Valid SampledData valueSampledData;

    @Valid Signature valueSignature;

    @Valid Timing valueTiming;

    @Valid ContactDetail valueContactDetail;

    @Valid Contributor valueContributor;

    @Valid DataRequirement valueDataRequirement;

    @Valid Expression valueExpression;

    @Valid ParameterDefinition valueParameterDefinition;

    @Valid RelatedArtifact valueRelatedArtifact;

    @Valid TriggerDefinition valueTriggerDefinition;

    @Valid UsageContext valueUsageContext;

    @Valid Dosage valueDosage;

    @Valid Meta valueMeta;

    @Valid Resource resource;

    @Valid List<Parameter> part;
  }
}
