package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.InsurancePlan;
import gov.va.api.health.r4.api.resources.InsurancePlan.Contact;
import gov.va.api.health.r4.api.resources.InsurancePlan.Coverage;
import gov.va.api.health.r4.api.resources.InsurancePlan.Plan;
import gov.va.api.health.r4.api.resources.InsurancePlan.Plan.GeneralCost;
import gov.va.api.health.r4.api.resources.InsurancePlan.Plan.SpecificCost;
import gov.va.api.health.r4.api.resources.InsurancePlan.Plan.SpecificCost.Benefit;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleInsurancePlans {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  private Coverage.Benefit benefit() {
    return Coverage.Benefit.builder()
        .id("id")
        .extension(List.of(extension()))
        .modifierExtension(List.of(extension()))
        .requirement("requirement")
        .type(codeableConcept())
        .limit(List.of(limit()))
        .build();
  }

  private Contact contact() {
    return Contact.builder()
        .address(address())
        .modifierExtension(List.of(extension()))
        .extension(List.of(extension()))
        .id("id")
        .name(humanName())
        .purpose(codeableConcept())
        .telecom(List.of(contactPoint()))
        .build();
  }

  private Benefit.Cost cost() {
    return Benefit.Cost.builder()
        .applicability(codeableConcept())
        .extension(List.of(extension()))
        .modifierExtension(List.of(extension()))
        .id("id")
        .qualifiers(List.of(codeableConcept()))
        .value(quantity())
        .type(codeableConcept())
        .build();
  }

  private Coverage coverage() {
    return InsurancePlan.Coverage.builder()
        .type(codeableConcept())
        .id("id")
        .network(List.of(reference()))
        .benefit(List.of(benefit()))
        .build();
  }

  private GeneralCost generalCost() {
    return GeneralCost.builder()
        .cost(money())
        .comment("comment")
        .groupSize(1)
        .id("id")
        .extension(List.of(extension()))
        .modifierExtension(List.of(extension()))
        .type(codeableConcept())
        .build();
  }

  public InsurancePlan insurancePlan() {
    return InsurancePlan.builder()
        .identifier(List.of(identifier()))
        .administeredBy(reference())
        .alias(List.of("alias"))
        .contained(List.of(resource()))
        .coverageArea(List.of(reference()))
        .endpoint(List.of(reference()))
        .extension(List.of(extension()))
        .name("name")
        .implicitRules("implicitRules")
        .id("id")
        .status(InsurancePlan.Status.active)
        .language("language")
        .modifierExtension(List.of(extension()))
        .meta(meta())
        .network(List.of(reference()))
        .ownedBy(reference())
        .period(period())
        .text(narrative())
        .resourceType("InsurancePlan")
        .plan(List.of(plan()))
        .contact(List.of(contact()))
        .coverage(List.of(coverage()))
        .type(List.of(codeableConcept()))
        .build();
  }

  private Coverage.Benefit.Limit limit() {
    return Coverage.Benefit.Limit.builder()
        .code(codeableConcept())
        .extension(List.of(extension()))
        .id("id")
        .value(quantity())
        .modifierExtension(List.of(extension()))
        .build();
  }

  private Plan plan() {
    return Plan.builder()
        .coverageArea(List.of(reference()))
        .extension(List.of(extension()))
        .id("id")
        .identifier(List.of(identifier()))
        .modifierExtension(List.of(extension()))
        .network(List.of(reference()))
        .type(codeableConcept())
        .network(List.of(reference()))
        .generalCost(List.of(generalCost()))
        .specificCost(List.of(specificCost()))
        .build();
  }

  private SpecificCost specificCost() {
    return SpecificCost.builder()
        .id("id")
        .category(codeableConcept())
        .extension(List.of(extension()))
        .benefit(List.of(specificCostBenefit()))
        .build();
  }

  private Benefit specificCostBenefit() {
    return Benefit.builder()
        .cost(List.of(cost()))
        .id("id")
        .extension(List.of(extension()))
        .modifierExtension(List.of(extension()))
        .type(codeableConcept())
        .build();
  }
}
