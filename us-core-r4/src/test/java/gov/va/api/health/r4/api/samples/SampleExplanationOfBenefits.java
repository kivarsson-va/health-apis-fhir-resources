package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.ExplanationOfBenefit;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Accident;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.AddItem;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.AddItemDetail;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.AddItemSubDetail;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Adjudication;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.BenefitBalance;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.CareTeam;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Diagnosis;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Financial;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Insurance;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Item;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.ItemDetail;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.ItemSubDetail;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Outcome;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Payee;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Payment;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Procedure;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.ProcessNote;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Related;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Status;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.SupportingInfo;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Total;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Type;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Use;
import java.math.BigDecimal;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleExplanationOfBenefits {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Accident accident() {
    return Accident.builder()
        .date("2017-01-01")
        .type(codeableConcept())
        .locationAddress(address())
        .build();
  }

  public AddItem addItem() {
    return AddItem.builder()
        .itemSequence(List.of(1))
        .detailSequence(List.of(1))
        .subDetailSequence(List.of(1))
        .provider(reference().asList())
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .programCode(codeableConcept().asList())
        .servicedPeriod(period())
        .locationCodeableConcept(codeableConcept())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("10.0"))
        .net(money())
        .bodySite(codeableConcept())
        .subSite(codeableConcept().asList())
        .noteNumber(List.of(1))
        .adjudication(adjudication().asList())
        .detail(addItemDetail().asList())
        .build();
  }

  public AddItemDetail addItemDetail() {
    return AddItemDetail.builder()
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("10.0"))
        .net(money())
        .noteNumber(List.of(1))
        .adjudication(adjudication().asList())
        .subDetail(addItemSubDetail().asList())
        .build();
  }

  public AddItemSubDetail addItemSubDetail() {
    return AddItemSubDetail.builder()
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("10.0"))
        .net(money())
        .noteNumber(List.of(1))
        .adjudication(adjudication().asList())
        .build();
  }

  public Adjudication adjudication() {
    return Adjudication.builder()
        .category(codeableConcept())
        .reason(codeableConcept())
        .amount(money())
        .value(new BigDecimal("10.0"))
        .build();
  }

  public BenefitBalance benefitBalance() {
    return BenefitBalance.builder()
        .category(codeableConcept())
        .excluded(true)
        .name("name")
        .description("description")
        .network(codeableConcept())
        .unit(codeableConcept())
        .term(codeableConcept())
        .financial(financial().asList())
        .build();
  }

  public CareTeam careTeam() {
    return CareTeam.builder()
        .sequence(1)
        .provider(reference())
        .responsible(false)
        .role(codeableConcept())
        .qualification(codeableConcept())
        .build();
  }

  public ItemDetail detail() {
    return ItemDetail.builder()
        .sequence(1)
        .revenue(codeableConcept())
        .category(codeableConcept())
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .programCode(codeableConcept().asList())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("10.0"))
        .net(money())
        .udi(reference().asList())
        .noteNumber(List.of(1))
        .adjudication(adjudication().asList())
        .subDetail(itemSubDetail().asList())
        .build();
  }

  public Diagnosis diagnosis() {
    return Diagnosis.builder()
        .sequence(1)
        .diagnosisCodeableConcept(codeableConcept())
        .type(codeableConcept().asList())
        .onAdmission(codeableConcept())
        .packageCode(codeableConcept())
        .build();
  }

  public ExplanationOfBenefit explanationOfBenefit() {
    return ExplanationOfBenefit.builder()
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
        .fundsReserveRequested(codeableConcept())
        .fundsReserve(codeableConcept())
        .related(related().asList())
        .prescription(reference())
        .originalPrescription(reference())
        .payee(payee())
        .referral(reference())
        .facility(reference())
        .claim(reference())
        .claimResponse(reference())
        .outcome(Outcome.complete)
        .disposition("disposition")
        .preAuthRef(List.of("preAuthRef"))
        .preAuthRefPeriod(period().asList())
        .careTeam(careTeam().asList())
        .supportingInfo(supportingInfo().asList())
        .diagnosis(diagnosis().asList())
        .procedure(procedure().asList())
        .precedence(1)
        .insurance(insurance().asList())
        .accident(accident())
        .item(item().asList())
        .addItem(addItem().asList())
        .adjudication(adjudication().asList())
        .total(total().asList())
        .payment(payment())
        .formCode(codeableConcept())
        .form(attachment())
        .processNote(processNote().asList())
        .benefitPeriod(period())
        .benefitBalance(benefitBalance().asList())
        .build();
  }

  public Financial financial() {
    return Financial.builder()
        .type(codeableConcept())
        .allowedMoney(money())
        .usedMoney(money())
        .build();
  }

  public Insurance insurance() {
    return Insurance.builder()
        .focal(false)
        .coverage(reference())
        .preAuthRef(List.of("preAuthRef"))
        .build();
  }

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
        .servicedPeriod(period())
        .locationReference(reference())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("10.0"))
        .net(money())
        .udi(reference().asList())
        .bodySite(codeableConcept())
        .subSite(codeableConcept().asList())
        .encounter(reference().asList())
        .noteNumber(List.of(1))
        .adjudication(adjudication().asList())
        .detail(detail().asList())
        .build();
  }

  public ItemSubDetail itemSubDetail() {
    return ItemSubDetail.builder()
        .sequence(1)
        .revenue(codeableConcept())
        .category(codeableConcept())
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .programCode(codeableConcept().asList())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .factor(new BigDecimal("10.0"))
        .net(money())
        .udi(reference().asList())
        .noteNumber(List.of(1))
        .adjudication(adjudication().asList())
        .build();
  }

  public Payee payee() {
    return Payee.builder().type(codeableConcept()).party(reference()).build();
  }

  public Payment payment() {
    return Payment.builder()
        .type(codeableConcept())
        .adjustment(money())
        .adjustmentReason(codeableConcept())
        .date("2017-01-01T00:00:00.000Z")
        .amount(money())
        .identifier(identifier())
        .build();
  }

  public Procedure procedure() {
    return Procedure.builder()
        .sequence(1)
        .type(codeableConcept().asList())
        .date("2017-01-01T00:00:00.000Z")
        .procedureCodeableConcept(codeableConcept())
        .udi(reference().asList())
        .build();
  }

  public ProcessNote processNote() {
    return ProcessNote.builder()
        .number(1)
        .type(Type.display)
        .text("text")
        .language(codeableConcept())
        .build();
  }

  public Related related() {
    return Related.builder()
        .claim(reference())
        .relationship(codeableConcept())
        .reference(identifier())
        .build();
  }

  public SupportingInfo supportingInfo() {
    return SupportingInfo.builder()
        .sequence(1)
        .category(codeableConcept())
        .code(codeableConcept())
        .timingPeriod(period())
        .valueBoolean(false)
        .reason(coding())
        .build();
  }

  public Total total() {
    return Total.builder().category(codeableConcept()).amount(money()).build();
  }
}
