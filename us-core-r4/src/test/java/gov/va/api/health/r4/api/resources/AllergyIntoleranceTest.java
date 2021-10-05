package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.resources.AllergyIntolerance.Bundle;
import gov.va.api.health.r4.api.resources.AllergyIntolerance.Entry;
import gov.va.api.health.r4.api.samples.SampleAllergyIntolerances;
import org.junit.jupiter.api.Test;

public class AllergyIntoleranceTest {
  private final SampleAllergyIntolerances data = SampleAllergyIntolerances.get();

  @Test
  public void allergyIntolerance() {
    assertRoundTrip(data.allergyIntolerance());
  }

  @Test
  public void bundlerCanBuildAllergyIntoleranceBundles() {
    Entry entry =
        Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://AllergyIntolerance.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://AllergyIntolerance.com/1")
                    .build()
                    .asList())
            .resource(data.allergyIntolerance())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Bundle bundle =
        Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://AllergyIntolerance.com/2")
                    .build()
                    .asList())
            .type(BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }
}
