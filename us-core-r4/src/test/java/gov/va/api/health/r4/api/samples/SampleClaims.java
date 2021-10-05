package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Claim;
import gov.va.api.health.r4.api.resources.Claim.Accident;
import gov.va.api.health.r4.api.resources.Claim.CareTeam;
import gov.va.api.health.r4.api.resources.Claim.Diagnosis;
import gov.va.api.health.r4.api.resources.Claim.Insurance;
import gov.va.api.health.r4.api.resources.Claim.Item;
import gov.va.api.health.r4.api.resources.Claim.Item.Detail;
import gov.va.api.health.r4.api.resources.Claim.Item.Detail.SubDetail;
import gov.va.api.health.r4.api.resources.Claim.Payee;
import gov.va.api.health.r4.api.resources.Claim.Procedure;
import gov.va.api.health.r4.api.resources.Claim.Related;
import gov.va.api.health.r4.api.resources.Claim.Status;
import gov.va.api.health.r4.api.resources.Claim.SupportingInfo;
import gov.va.api.health.r4.api.resources.Claim.Use;
import java.math.BigDecimal;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleClaims {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  /*
   * Accident is missing optional 0..1 location[x] field
   */
  public Accident accident() {
    return Accident.builder().date("1905-08-23").type(codeableConcept()).build();
  }

  public Accident accidentWithLocationAddress() {
    return accident().locationAddress(address());
  }

  public Accident accidentWithLocationReference() {
    return accident().locationReference(reference());
  }

  public CareTeam careTeam() {
    return CareTeam.builder()
        .sequence(1)
        .provider(reference())
        .responsible(true)
        .role(codeableConcept())
        .qualification(codeableConcept())
        .build();
  }

  public Claim claim() {
    return Claim.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .status(Status.active)
        .type(codeableConcept())
        .subType(codeableConcept())
        .use(Use.claim)
        .patient(reference())
        .billablePeriod(period())
        .created("2017-01-01T00:00:00.000Z")
        .enterer(reference())
        .insurer(reference())
        .provider(reference())
        .priority(codeableConcept())
        .fundsReserve(codeableConcept())
        .related(related().asList())
        .prescription(reference())
        .originalPrescription(reference())
        .payee(payee())
        .referral(reference())
        .facility(reference())
        .careTeam(careTeam().asList())
        .supportingInfo(
            List.of(
                supportingInfo(),
                supportingInfoWithTimingDate(),
                supportingInfoWithTimingDateAndValueAttachment(),
                supportingInfoWithTimingDateAndValueQuantity(),
                supportingInfoWithTimingDateAndValueReference(),
                supportingInfoWithTimingDateAndValueString(),
                supportingInfoWithTimingDateAndValueBoolean(),
                supportingInfoWithTimingPeriod(),
                supportingInfoWithTimingPeriodAndValueAttachment(),
                supportingInfoWithTimingPeriodAndValueQuantity(),
                supportingInfoWithTimingPeriodAndValueReference(),
                supportingInfoWithTimingPeriodAndValueString(),
                supportingInfoWithTimingPeriodAndValueBoolean()))
        .diagnosis(List.of(diagnosisWithCodeableConcept(), diagnosisWithReference()))
        .procedure(List.of(procedureWithCodeableConcept(), procedureWithReference()))
        .insurance(insurance().asList())
        .accident(accidentWithLocationAddress())
        .item(
            List.of(
                item(),
                itemWithServicedDateAndLocationAddress(),
                itemWithServicedDateAndLocationCodeableConcept(),
                itemWithServicedDateAndLocationReference(),
                itemWithServicedPeriodAndLocationAddress(),
                itemWithServicedPeriodAndLocationCodeableConcept(),
                itemWithServicedPeriodAndLocationReference()))
        .total(money())
        .build();
  }

  public Detail detail() {
    return Detail.builder()
        .sequence(1)
        .revenue(codeableConcept())
        .category(codeableConcept())
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .programCode(codeableConcept().asList())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("1.0"))
        .net(money())
        .udi(reference().asList())
        .subDetail(subDetail().asList())
        .build();
  }

  public Diagnosis diagnosisWithCodeableConcept() {
    return incompleteDiagnosis().diagnosisCodeableConcept(codeableConcept());
  }

  public Diagnosis diagnosisWithReference() {
    return incompleteDiagnosis().diagnosisReference(reference());
  }

  /*
   * Diagnosis is missing required 1..1 diagnosis[x] field
   */
  private Diagnosis incompleteDiagnosis() {
    return Diagnosis.builder()
        .sequence(1)
        .type(codeableConcept().asList())
        .onAdmission(codeableConcept())
        .packageCode(codeableConcept())
        .build();
  }

  /*
   * Procedure is missing required 1..1 procedure[x] field
   */
  private Procedure incompleteProcedure() {
    return Procedure.builder()
        .sequence(1)
        .type(codeableConcept().asList())
        .date("2017-01-01T00:00:00.000Z")
        .udi(reference().asList())
        .build();
  }

  public Insurance insurance() {
    return Insurance.builder()
        .sequence(1)
        .focal(true)
        .identifier(identifier())
        .coverage(reference())
        .businessArrangement("business arrangement")
        .preAuthRef(List.of("pre auth ref"))
        .claimResponse(reference())
        .build();
  }

  /*
   * Item is missing optional serviced[x] and location[x] fields
   */
  public Item item() {
    return Item.builder()
        .sequence(1)
        .careTeamSequence(List.of(1))
        .diagnosisSequence(List.of(1))
        .procedureSequence(List.of(1))
        .informationSequence(List.of(1))
        .revenue(codeableConcept())
        .category(codeableConcept())
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .programCode(codeableConcept().asList())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("1.0"))
        .net(money())
        .udi(reference().asList())
        .bodySite(codeableConcept())
        .subSite(codeableConcept().asList())
        .encounter(reference().asList())
        .detail(detail().asList())
        .build();
  }

  public Item itemWithServicedDateAndLocationAddress() {
    return item().servicedDate("1905-08-23").locationAddress(address());
  }

  public Item itemWithServicedDateAndLocationCodeableConcept() {
    return item().servicedDate("1905-08-23").locationCodeableConcept(codeableConcept());
  }

  public Item itemWithServicedDateAndLocationReference() {
    return item().servicedDate("1905-08-23").locationReference(reference());
  }

  public Item itemWithServicedPeriodAndLocationAddress() {
    return item().servicedPeriod(period()).locationAddress(address());
  }

  public Item itemWithServicedPeriodAndLocationCodeableConcept() {
    return item().servicedPeriod(period()).locationCodeableConcept(codeableConcept());
  }

  public Item itemWithServicedPeriodAndLocationReference() {
    return item().servicedPeriod(period()).locationReference(reference());
  }

  public Payee payee() {
    return Payee.builder().type(codeableConcept()).party(reference()).build();
  }

  public Procedure procedureWithCodeableConcept() {
    return incompleteProcedure().procedureCodeableConcept(codeableConcept());
  }

  public Procedure procedureWithReference() {
    return incompleteProcedure().procedureReference(reference());
  }

  public Related related() {
    return Related.builder()
        .claim(reference())
        .relationship(codeableConcept())
        .reference(identifier())
        .build();
  }

  public SubDetail subDetail() {
    return SubDetail.builder()
        .sequence(1)
        .revenue(codeableConcept())
        .category(codeableConcept())
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .programCode(codeableConcept().asList())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("1.0"))
        .net(money())
        .udi(reference().asList())
        .build();
  }

  /*
   * SupportingInfo is missing optional 0..1 timing[x] and 0..1 value[x] fields
   */
  public SupportingInfo supportingInfo() {
    return SupportingInfo.builder()
        .sequence(1)
        .category(codeableConcept())
        .code(codeableConcept())
        .reason(codeableConcept())
        .build();
  }

  public SupportingInfo supportingInfoWithTimingDate() {
    return supportingInfo().timingDate("1905-08-23");
  }

  public SupportingInfo supportingInfoWithTimingDateAndValueAttachment() {
    return supportingInfoWithTimingDate().valueAttachment(attachment());
  }

  public SupportingInfo supportingInfoWithTimingDateAndValueBoolean() {
    return supportingInfoWithTimingDate().valueBoolean(true);
  }

  public SupportingInfo supportingInfoWithTimingDateAndValueQuantity() {
    return supportingInfoWithTimingDate().valueQuantity(quantity());
  }

  public SupportingInfo supportingInfoWithTimingDateAndValueReference() {
    return supportingInfoWithTimingDate().valueReference(reference());
  }

  public SupportingInfo supportingInfoWithTimingDateAndValueString() {
    return supportingInfoWithTimingDate().valueString("value");
  }

  public SupportingInfo supportingInfoWithTimingPeriod() {
    return supportingInfo().timingPeriod(period());
  }

  public SupportingInfo supportingInfoWithTimingPeriodAndValueAttachment() {
    return supportingInfoWithTimingPeriod().valueAttachment(attachment());
  }

  public SupportingInfo supportingInfoWithTimingPeriodAndValueBoolean() {
    return supportingInfoWithTimingPeriod().valueBoolean(true);
  }

  public SupportingInfo supportingInfoWithTimingPeriodAndValueQuantity() {
    return supportingInfoWithTimingPeriod().valueQuantity(quantity());
  }

  public SupportingInfo supportingInfoWithTimingPeriodAndValueReference() {
    return supportingInfoWithTimingPeriod().valueReference(reference());
  }

  public SupportingInfo supportingInfoWithTimingPeriodAndValueString() {
    return supportingInfoWithTimingPeriod().valueString("value");
  }
}
