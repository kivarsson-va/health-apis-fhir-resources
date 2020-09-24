package gov.va.api.health.r4.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.datatypes.Address;
import gov.va.api.health.r4.api.datatypes.Attachment;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.ContactDetail;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.datatypes.HumanName;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Money;
import gov.va.api.health.r4.api.datatypes.Period;
import gov.va.api.health.r4.api.datatypes.Quantity;
import gov.va.api.health.r4.api.datatypes.Range;
import gov.va.api.health.r4.api.datatypes.Ratio;
import gov.va.api.health.r4.api.datatypes.Signature;
import gov.va.api.health.r4.api.datatypes.UsageContext;
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
@Schema(description = "http://hl7.org/fhir/R4/extensibility.html#extension")
@ZeroOrOneOf(
    fields = {
      "valueBase64Binary",
      "valueBoolean",
      "valueCode",
      "valueDate",
      "valueDateTime",
      "valueDecimal",
      "valueId",
      "valueInstant",
      "valueInteger",
      "valueMarkdown",
      "valuePositiveInt",
      "valueString",
      "valueUnsignedInt",
      "valueUri",
      "valueAddress",
      "valueAttachment",
      "valueCodeableConcept",
      "valueCoding",
      "valueContactPoint",
      "valueHumanName",
      "valueIdentifier",
      "valueMoney",
      "valuePeriod",
      "valueQuantity",
      "valueRange",
      "valueRatio",
      "valueReference",
      "valueSignature",
      "valueContactDetail",
      "valueUsageContext",
    },
    message = "Only one value type may be specified")
public class Extension implements Element {

  @Pattern(regexp = Fhir.ID)
  String id;

  @Pattern(regexp = Fhir.URI)
  String url;

  @Valid List<Extension> extension;

  @Pattern(regexp = Fhir.BASE64)
  String valueBase64Binary;

  Boolean valueBoolean;

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

  @Min(1)
  Integer valuePositiveInt;

  @Pattern(regexp = Fhir.STRING)
  String valueString;

  @Min(0)
  Integer valueUnsignedInt;

  @Pattern(regexp = Fhir.URI)
  String valueUri;

  @Valid Address valueAddress;

  @Valid Attachment valueAttachment;

  @Valid CodeableConcept valueCodeableConcept;

  @Valid Coding valueCoding;

  @Valid ContactPoint valueContactPoint;

  @Valid HumanName valueHumanName;

  @Valid Identifier valueIdentifier;

  @Valid Money valueMoney;

  @Valid Period valuePeriod;

  @Valid Quantity valueQuantity;

  @Valid Range valueRange;

  @Valid Ratio valueRatio;

  @Valid Reference valueReference;

  @Valid Signature valueSignature;

  @Valid ContactDetail valueContactDetail;

  @Valid UsageContext valueUsageContext;
}