package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleImmunizations;
import org.junit.jupiter.api.Test;

public class ImmunizationTest {
  private final SampleImmunizations samples = SampleImmunizations.get();

  @Test
  void bundlerCanBuildImmunizationBundles() {
    Immunization.Bundle bundle =
        Immunization.Bundle.builder()
            .type(AbstractBundle.BundleType.searchset)
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://immunization.com/bundle")
                    .build()
                    .asList())
            .entry(
                Immunization.Entry.builder()
                    .extension(samples.extension().asList())
                    .fullUrl("http://immunization.com")
                    .id("1234")
                    .link(
                        BundleLink.builder()
                            .relation(BundleLink.LinkRelation.self)
                            .url("http://immunization.com/entry")
                            .build()
                            .asList())
                    .resource(samples.immunization())
                    .search(samples.search())
                    .request(samples.request())
                    .response(samples.response())
                    .build()
                    .asList())
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  void immunization() {
    assertRoundTrip(samples.immunization());
  }
}
