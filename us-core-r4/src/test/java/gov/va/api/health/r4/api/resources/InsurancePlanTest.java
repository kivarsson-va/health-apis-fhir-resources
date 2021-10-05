package gov.va.api.health.r4.api.resources;

import gov.va.api.health.r4.api.RoundTrip;
import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleInsurancePlans;
import org.junit.jupiter.api.Test;

public class InsurancePlanTest {
  private final SampleInsurancePlans data = SampleInsurancePlans.get();

  @Test
  public void bundlerCanBuildInsurancePlanBundles() {
    InsurancePlan.Entry entry =
        InsurancePlan.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://InsurancePlan.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://InsurancePlan.com/1")
                    .build()
                    .asList())
            .resource(data.insurancePlan())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();
    InsurancePlan.Bundle bundle =
        InsurancePlan.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://InsurancePlan.com/2")
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();
    RoundTrip.assertRoundTrip(bundle);
  }

  @Test
  public void insurancePlan() {
    RoundTrip.assertRoundTrip(data.insurancePlan());
  }
}
