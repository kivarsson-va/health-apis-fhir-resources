package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.ExactlyOneOfVerifier;
import gov.va.api.health.r4.api.ZeroOrOneOfVerifier;
import gov.va.api.health.r4.api.samples.SampleExplanationOfBenefits;
import org.junit.Test;

public class ExplanationOfBenefitsTest {

  private final SampleExplanationOfBenefits data = SampleExplanationOfBenefits.get();

  @Test
  public void explanationOfBenefits() {
    assertRoundTrip(data.explanationOfBenefit());
  }

  @Test
  public void relatedGroups() {
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfo())
        .fieldPrefix("timing")
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfo())
        .fieldPrefix("value")
        .build()
        .verify();
    ExactlyOneOfVerifier.builder()
        .sample(data.diagnosis())
        .fieldPrefix("diagnosis")
        .build()
        .verify();
    ExactlyOneOfVerifier.builder()
        .sample(data.procedure())
        .fieldPrefix("procedure")
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder().sample(data.accident()).fieldPrefix("location").build().verify();
    ZeroOrOneOfVerifier.builder().sample(data.item()).fieldPrefix("serviced").build().verify();
    ZeroOrOneOfVerifier.builder().sample(data.item()).fieldPrefix("location").build().verify();
    ZeroOrOneOfVerifier.builder().sample(data.addItem()).fieldPrefix("serviced").build().verify();
    ZeroOrOneOfVerifier.builder().sample(data.addItem()).fieldPrefix("location").build().verify();
    ZeroOrOneOfVerifier.builder().sample(data.financial()).fieldPrefix("allowed").build().verify();
    ZeroOrOneOfVerifier.builder().sample(data.financial()).fieldPrefix("used").build().verify();
  }
}
