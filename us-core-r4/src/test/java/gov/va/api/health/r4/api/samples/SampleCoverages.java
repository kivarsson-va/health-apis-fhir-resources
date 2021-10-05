package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Coverage;
import gov.va.api.health.r4.api.resources.Coverage.CostToBeneficiary;
import gov.va.api.health.r4.api.resources.Coverage.CoverageClass;
import gov.va.api.health.r4.api.resources.Coverage.Exception;
import gov.va.api.health.r4.api.resources.Coverage.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleCoverages {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public CostToBeneficiary costToBeneficiaryWithValueMoney() {
    return CostToBeneficiary.builder()
        .type(codeableConcept())
        .valueMoney(money())
        .exception(exception().asList())
        .build();
  }

  public CostToBeneficiary costToBeneficiaryWithValueQuantity() {
    return CostToBeneficiary.builder()
        .type(codeableConcept())
        .valueQuantity(simpleQuantity())
        .exception(exception().asList())
        .build();
  }

  public CoverageClass coverageClass() {
    return CoverageClass.builder()
        .type(codeableConcept())
        .value("Hello value")
        .name("Hello name")
        .build();
  }

  public Coverage coverageWithValueMoney() {
    return Coverage.builder()
        .id("1324")
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
        .policyHolder(reference())
        .subscriber(reference())
        .subscriberId("Hello subscriberId")
        .beneficiary(reference())
        .dependent("Hello dependent")
        .relationship(codeableConcept())
        .period(period())
        .payor(reference().asList())
        .coverageClass(coverageClass().asList())
        .order(1)
        .network("Hello network")
        .costToBeneficiary(costToBeneficiaryWithValueMoney().asList())
        .subrogation(true)
        .contract(reference().asList())
        .build();
  }

  public Coverage coverageWithValueQuanitity() {
    return Coverage.builder()
        .id("1324")
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
        .policyHolder(reference())
        .subscriber(reference())
        .subscriberId("Hello subscriberId")
        .beneficiary(reference())
        .dependent("Hello dependent")
        .relationship(codeableConcept())
        .period(period())
        .payor(reference().asList())
        .coverageClass(coverageClass().asList())
        .order(1)
        .network("Hello network")
        .costToBeneficiary(costToBeneficiaryWithValueQuantity().asList())
        .subrogation(true)
        .contract(reference().asList())
        .build();
  }

  public Exception exception() {
    return Exception.builder().type(codeableConcept()).period(period()).build();
  }
}
