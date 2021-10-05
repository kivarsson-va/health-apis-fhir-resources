package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleDevices;
import org.junit.jupiter.api.Test;

public class DeviceTest {
  private final SampleDevices samples = SampleDevices.get();

  @Test
  public void bundlerCanBuildDeviceBundles() {
    Device.Bundle bundle =
        Device.Bundle.builder()
            .type(BundleType.searchset)
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://device.com/bundle")
                    .build()
                    .asList())
            .entry(
                Device.Entry.builder()
                    .extension(samples.extension().asList())
                    .fullUrl("http://device.com")
                    .id("1234")
                    .link(
                        BundleLink.builder()
                            .relation(BundleLink.LinkRelation.self)
                            .url("http://device.com/entry")
                            .build()
                            .asList())
                    .resource(samples.device())
                    .search(samples.search())
                    .request(samples.request())
                    .response(samples.response())
                    .build()
                    .asList())
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  public void device() {
    assertRoundTrip(samples.device());
  }
}
