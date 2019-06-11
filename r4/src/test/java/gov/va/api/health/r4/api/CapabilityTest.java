package gov.va.api.health.r4.api;

import gov.va.api.health.r4.api.samples.SampleCapabilities;
import org.junit.Test;

public class CapabilityTest {

  @Test
  public void capability() {
    RoundTrip.assertRoundTrip(SampleCapabilities.get().capability());
  }
}
