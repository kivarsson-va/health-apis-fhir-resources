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
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .requirement("requirement")
        .type(codeableConcept())
        .limit(List.of(limit()))
        .build();
  }

  private Contact contact() {
    return Contact.builder()
        .address(address())
        .modifierExtension(extension().asList())
        .extension(extension().asList())
        .id("id")
        .name(humanName())
        .purpose(codeableConcept())
        .telecom(contactPoint().asList())
        .build();
  }

  private Benefit.Cost cost() {
    return Benefit.Cost.builder()
        .applicability(codeableConcept())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .id("id")
        .qualifiers(codeableConcept().asList())
        .value(quantity())
        .type(codeableConcept())
        .build();
  }

  private Coverage coverage() {
    return InsurancePlan.Coverage.builder()
        .type(codeableConcept())
        .id("id")
        .network(reference().asList())
        .benefit(benefit().asList())
        .build();
  }

  private GeneralCost generalCost() {
    return GeneralCost.builder()
        .cost(money())
        .comment("comment")
        .groupSize(1)
        .id("id")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(codeableConcept())
        .build();
  }

  public InsurancePlan insurancePlan() {
    return InsurancePlan.builder()
        .identifier(identifier().asList())
        .administeredBy(reference())
        .alias(List.of("alias"))
        .contained(List.of(resource()))
        .coverageArea(reference().asList())
        .endpoint(reference().asList())
        .extension(extension().asList())
        .name("name")
        .implicitRules("implicitRules")
        .id("id")
        .status(InsurancePlan.Status.active)
        .language("language")
        .modifierExtension(extension().asList())
        .meta(meta())
        .network(reference().asList())
        .ownedBy(reference())
        .period(period())
        .text(narrative())
        .resourceType("InsurancePlan")
        .plan(plan().asList())
        .contact(contact().asList())
        .coverage(coverage().asList())
        .type(codeableConcept().asList())
        .build();
  }

  private Coverage.Benefit.Limit limit() {
    return Coverage.Benefit.Limit.builder()
        .code(codeableConcept())
        .extension(extension().asList())
        .id("id")
        .value(quantity())
        .modifierExtension(extension().asList())
        .build();
  }

  private Plan plan() {
    return Plan.builder()
        .coverageArea(reference().asList())
        .extension(extension().asList())
        .id("id")
        .identifier(identifier().asList())
        .modifierExtension(extension().asList())
        .network(reference().asList())
        .type(codeableConcept())
        .network(reference().asList())
        .generalCost(generalCost().asList())
        .specificCost(specificCost().asList())
        .build();
  }

  private SpecificCost specificCost() {
    return SpecificCost.builder()
        .id("id")
        .category(codeableConcept())
        .extension(extension().asList())
        .benefit(specificCostBenefit().asList())
        .build();
  }

  private Benefit specificCostBenefit() {
    return Benefit.builder()
        .cost(cost().asList())
        .id("id")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(codeableConcept())
        .build();
  }
}
