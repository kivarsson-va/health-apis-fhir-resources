package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.CoverageEligibilityRequest;
import gov.va.api.health.r4.api.resources.CoverageEligibilityRequest.Insurance;
import gov.va.api.health.r4.api.resources.CoverageEligibilityRequest.Item;
import gov.va.api.health.r4.api.resources.CoverageEligibilityRequest.Item.Diagnosis;
import gov.va.api.health.r4.api.resources.CoverageEligibilityRequest.Purpose;
import gov.va.api.health.r4.api.resources.CoverageEligibilityRequest.Status;
import gov.va.api.health.r4.api.resources.CoverageEligibilityRequest.SupportingInfo;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleCoverageEligibilityRequests {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public CoverageEligibilityRequest coverageEligibilityRequest() {
    return CoverageEligibilityRequest.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(List.of(identifier()))
        .status(Status.active)
        .priority(codeableConcept())
        .purpose(List.of(Purpose.auth_requirements))
        .patient(reference())
        .created("2017-01-01T00:00:00.000Z")
        .enterer(reference())
        .provider(reference())
        .insurer(reference())
        .facility(reference())
        .supportingInfo(List.of(supportingInfo()))
        .insurance(List.of(insurance()))
        .item(List.of(item()))
        .build();
  }

  public CoverageEligibilityRequest coverageEligibilityRequestWithServicedDate() {
    return coverageEligibilityRequest().servicedDate("1905-08-23");
  }

  public CoverageEligibilityRequest coverageEligibilityRequestWithServicedPeriod() {
    return coverageEligibilityRequest().servicedPeriod(period());
  }

  public Diagnosis diagnosisWithCodeableConcept() {
    return Diagnosis.builder().diagnosisCodeableConcept(codeableConcept()).build();
  }

  public Diagnosis diagnosisWithReference() {
    return Diagnosis.builder().diagnosisReference(reference()).build();
  }

  public Insurance insurance() {
    return Insurance.builder()
        .focal(true)
        .coverage(reference())
        .businessArrangement("businessArrangement")
        .build();
  }

  public Item item() {
    return Item.builder()
        .supportingInfoSequence(List.of(1))
        .category(codeableConcept())
        .productOrService(codeableConcept())
        .modifier(List.of(codeableConcept()))
        .provider(reference())
        .quantity(simpleQuantity())
        .unitPrice(money())
        .facility(reference())
        .diagnosis(List.of(diagnosisWithCodeableConcept(), diagnosisWithReference()))
        .detail(List.of(reference()))
        .build();
  }

  public SupportingInfo supportingInfo() {
    return SupportingInfo.builder().sequence(1).information(reference()).appliesToAll(true).build();
  }
}
