package gov.va.api.health.dstu2.api.resources;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.samples.SampleMedications;
import org.junit.jupiter.api.Test;

public class MedicationTest {
  private final SampleMedications data = SampleMedications.get();

  @Test
  public void bundlerCanBuildMedicationBundles() {
    Medication.Entry entry =
        Medication.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://medication.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://medication.com/1"))
                    .build()
                    .asList())
            .resource(data.medication())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Medication.Bundle bundle =
        Medication.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://medication.com/2"))
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void medication() {
    assertRoundTrip(data.medication());
  }
}
