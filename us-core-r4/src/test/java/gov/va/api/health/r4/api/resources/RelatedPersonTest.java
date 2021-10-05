package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType.searchset;

import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleRelatedPersons;
import org.junit.jupiter.api.Test;

public class RelatedPersonTest {
  private final SampleRelatedPersons data = SampleRelatedPersons.get();

  @Test
  public void bundlerCanBuildRelatedPersonBundles() {
    RelatedPerson.Entry entry =
        RelatedPerson.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://relatedperson.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://relatedperson/1")
                    .build()
                    .asList())
            .resource(data.relatedPerson())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    RelatedPerson.Bundle bundle =
        RelatedPerson.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://relatedperson.com/2")
                    .build()
                    .asList())
            .type(searchset)
            .signature(data.signature())
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void relatedPerson() {
    assertRoundTrip(data.relatedPerson());
  }
}
