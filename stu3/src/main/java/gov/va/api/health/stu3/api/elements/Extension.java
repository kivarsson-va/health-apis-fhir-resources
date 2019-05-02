package gov.va.api.health.stu3.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.stu3.api.Fhir;
import gov.va.api.health.stu3.api.datatypes.CodeableConcept;
import gov.va.api.health.stu3.api.datatypes.Coding;
import gov.va.api.health.stu3.api.datatypes.Identifier;
import gov.va.api.health.stu3.api.datatypes.Period;
import gov.va.api.health.stu3.api.datatypes.Signature;
import gov.va.api.health.validation.api.ZeroOrOneOf;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
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
@Schema(description = "http://hl7.org/fhir/STU3/extensibility.html#Extension")
@ZeroOrOneOf(
  fields = {
    "valueInteger",
    "valueUnsignedInt",
    "valuePositiveInt",
    "valueDecimal",
    "valueDateTime",
    "valueDate",
    "valueTime",
    "valueInstant",
    "valueString",
    "valueUri",
    "valueOid",
    "valueUuid",
    "valueId",
    "valueBoolean",
    "valueCode",
    "valueMarkdown",
    "valueBase64Binary",
    "valueCoding",
    "valueCodeableConcept",
    "valueIdentifier",
    "valueQuantity",
    "valueAttachment",
    "valueSampledData",
    "valueRange",
    "valuePeriod",
    "valueRatio",
    "valueHumanName",
    "valueAddress",
    "valueContactPoint",
    "valueTiming",
    "valueReference",
    "valueAnnotation",
    "valueSignature",
    "valueMeta"
  },
  message = "Only one value type may be specified"
)
public class Extension implements Element {

  @Pattern(regexp = Fhir.ID)
  String id;

  @Pattern(regexp = Fhir.URI)
  String url;

  @Valid List<Extension> extension;

  Integer valueInteger;

  @Min(1)
  Integer valueUnsignedInt;

  @PositiveOrZero() Integer valuePositiveInt;

  Double valueDecimal;

  @Pattern(regexp = Fhir.DATETIME)
  String valueDateTime;

  @Pattern(regexp = Fhir.DATE)
  String valueDate;

  @Pattern(regexp = Fhir.TIME)
  String valueTime;

  @Pattern(regexp = Fhir.INSTANT)
  String valueInstant;

  String valueString;

  @Pattern(regexp = Fhir.URI)
  String valueUri;

  @Pattern(regexp = Fhir.OID)
  String valueOid;

  @Pattern(regexp = Fhir.URI)
  String valueUuid;

  Boolean valueBoolean;

  @Pattern(regexp = Fhir.CODE)
  String valueCode;

  String valueMarkdown;

  @Pattern(regexp = Fhir.BASE64)
  String valueBase64Binary;

  @Valid Coding valueCoding;
  @Valid CodeableConcept valueCodeableConcept;
  @Valid Identifier valueIdentifier;
  @Valid Meta valueMeta;
  @Valid Period valuePeriod;
  @Valid Reference valueReference;
  @Valid Signature valueSignature;
}
