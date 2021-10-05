package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleLocations;
import org.junit.jupiter.api.Test;

public class LocationTest {
  private final SampleLocations data = SampleLocations.get();

  @Test
  public void bundlerCanBuildLocationBundles() {
    Location.Entry entry =
        Location.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://location.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://location.com/1")
                    .build()
                    .asList())
            .resource(data.location())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Location.Bundle bundle =
        Location.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://location.com/2")
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void location() {
    assertRoundTrip(data.location());
  }
}
