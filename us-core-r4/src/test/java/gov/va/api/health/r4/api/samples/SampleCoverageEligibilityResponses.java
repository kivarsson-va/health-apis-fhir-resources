package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.DataAbsentReason;
import gov.va.api.health.r4.api.DataAbsentReason.Reason;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Benefit;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.CoverageEligibilityResponseError;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Insurance;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Item;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Outcome;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Purpose;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleCoverageEligibilityResponses {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Benefit benefit() {
    return Benefit.builder()
        .type(codeableConcept())
        .allowedString("Allowed String")
        .usedMoney(money())
        .build();
  }

  public CoverageEligibilityResponse coverageEligibilityResponse() {
    return CoverageEligibilityResponse.builder()
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
        .purpose(List.of(Purpose.benefits))
        .patient(reference())
        .servicedPeriod(period())
        .created("2015-04-15T04:00:00Z")
        .requestor(reference())
        .request(reference())
        .outcome(Outcome.complete)
        .disposition("Hello disposition")
        .insurer(reference())
        .insurance(insurance().asList())
        .preAuthRef("Hello preAuthRef")
        .form(codeableConcept())
        .error(error().asList())
        .build();
  }

  public CoverageEligibilityResponse coverageEligibilityResponseWithDataAbsentReason() {
    return coverageEligibilityResponse()
        ._request(DataAbsentReason.of(Reason.unsupported))
        .request(null);
  }

  public CoverageEligibilityResponseError error() {
    return CoverageEligibilityResponseError.builder().code(codeableConcept()).build();
  }

  public Insurance insurance() {
    return Insurance.builder()
        .coverage(reference())
        .inforce(true)
        .benefitPeriod(period())
        .item(item().asList())
        .build();
  }

  public Insurance insuranceWithDataAbsentReason() {
    return insurance().coverage(null)._coverage(DataAbsentReason.of(Reason.unsupported));
  }

  public Item item() {
    return Item.builder()
        .category(codeableConcept())
        .productOrService(codeableConcept())
        .modifier(codeableConcept().asList())
        .provider(reference())
        .excluded(false)
        .name("Hello name")
        .description("Hello description")
        .network(codeableConcept())
        .unit(codeableConcept())
        .term(codeableConcept())
        .benefit(benefit().asList())
        .authorizationRequired(true)
        .authorizationSupporting(codeableConcept().asList())
        .authorizationUrl("http://example.com")
        .build();
  }
}
