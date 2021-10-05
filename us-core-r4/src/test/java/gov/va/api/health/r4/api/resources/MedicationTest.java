package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleMedications;
import org.junit.jupiter.api.Test;

public class MedicationTest {
  private final SampleMedications samples = SampleMedications.get();

  @Test
  void bundlerCanBuildMedicationBundles() {
    Medication.Bundle bundle =
        Medication.Bundle.builder()
            .type(AbstractBundle.BundleType.searchset)
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://medication.com/bundle")
                    .build()
                    .asList())
            .entry(
                Medication.Entry.builder()
                    .extension(samples.extension().asList())
                    .fullUrl("http://medication.com")
                    .id("1234")
                    .link(
                        BundleLink.builder()
                            .relation(BundleLink.LinkRelation.self)
                            .url("http://medication.com/entry")
                            .build()
                            .asList())
                    .resource(samples.medication())
                    .search(samples.search())
                    .request(samples.request())
                    .response(samples.response())
                    .build()
                    .asList())
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  void medication() {
    assertRoundTrip(samples.medication());
  }
}
