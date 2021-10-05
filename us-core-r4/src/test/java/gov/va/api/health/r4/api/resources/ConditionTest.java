package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleConditions;
import org.junit.jupiter.api.Test;

public class ConditionTest {
  private final SampleConditions samples = SampleConditions.get();

  @Test
  public void bundlerCanBuildConditionBundles() {
    Condition.Bundle bundle =
        Condition.Bundle.builder()
            .type(AbstractBundle.BundleType.searchset)
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://condition.com/bundle")
                    .build()
                    .asList())
            .entry(
                Condition.Entry.builder()
                    .extension(samples.extension().asList())
                    .fullUrl("http://condition.com")
                    .id("1234")
                    .link(
                        BundleLink.builder()
                            .relation(BundleLink.LinkRelation.self)
                            .url("http://condition.com/entry")
                            .build()
                            .asList())
                    .resource(samples.condition())
                    .search(samples.search())
                    .request(samples.request())
                    .response(samples.response())
                    .build()
                    .asList())
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  public void condition() {
    assertRoundTrip(samples.condition());
  }
}
