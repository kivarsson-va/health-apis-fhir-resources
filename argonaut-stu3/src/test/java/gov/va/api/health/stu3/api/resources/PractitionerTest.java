package gov.va.api.health.stu3.api.resources;

import gov.va.api.health.stu3.api.RoundTrip;
import gov.va.api.health.stu3.api.bundle.AbstractBundle;
import gov.va.api.health.stu3.api.bundle.BundleLink;
import gov.va.api.health.stu3.api.samples.SamplePractitioners;
import org.junit.jupiter.api.Test;

public class PractitionerTest {
  private final SamplePractitioners data = SamplePractitioners.get();

  @Test
  public void bundlerCanBuildMedicationBundles() {
    Practitioner.Entry entry =
        Practitioner.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://practitioner.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://practitioner.com/1"))
                    .build()
                    .asList())
            .resource(data.practitioner())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Practitioner.Bundle bundle =
        Practitioner.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://practitioner.com/2"))
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    RoundTrip.assertRoundTrip(bundle);
  }

  @Test
  public void practitioner() {
    RoundTrip.assertRoundTrip(data.practitioner());
  }
}
