package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType.searchset;

import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.r4.api.resources.Coverage.Bundle;
import gov.va.api.health.r4.api.resources.Coverage.Entry;
import gov.va.api.health.r4.api.samples.SampleCoverages;
import gov.va.api.health.r4.api.samples.SampleKnownTypes;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import org.junit.jupiter.api.Test;

public class CoverageTest {

  private final SampleCoverages data = SampleCoverages.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildCoverageBundles() {
    Entry entry =
        Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://coverage.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://coverage/1")
                    .build()
                    .asList())
            .resource(data.coverageWithValueQuanitity())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Bundle bundle =
        Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url("http://coverage.com/2")
                    .build()
                    .asList())
            .type(searchset)
            .signature(data.signature())
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void coverage() {
    assertRoundTrip(data.coverageWithValueQuanitity());
    assertRoundTrip(data.coverageWithValueMoney());
  }

  @Test
  public void relatedGroups() {
    ExactlyOneOfVerifier.builder()
        .sample(data.costToBeneficiaryWithValueQuantity())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }
}
