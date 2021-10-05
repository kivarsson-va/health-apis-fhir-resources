package gov.va.api.health.dstu2.api.resources;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.resources.Condition.Bundle;
import gov.va.api.health.dstu2.api.samples.SampleConditions;
import gov.va.api.health.dstu2.api.samples.SampleKnownTypes;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import org.junit.jupiter.api.Test;

public class ConditionTest {
  private final SampleConditions data = SampleConditions.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildConditionBundles() {
    Condition.Entry entry =
        Condition.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://condition.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://condition/1"))
                    .build()
                    .asList())
            .resource(data.condition())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Bundle bundle =
        Condition.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://condition.com/2"))
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void condition() {
    assertRoundTrip(data.condition());
  }

  @Test
  public void relatedGroups() {
    ZeroOrOneOfVerifier.builder()
        .sample(data.condition())
        .fieldPrefix("onset")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.condition())
        .fieldPrefix("abatement")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }
}
