package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.r4.api.samples.SampleKnownTypes;
import gov.va.api.health.r4.api.samples.SampleProcedures;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import org.junit.jupiter.api.Test;

public class ProcedureTest {
  private final SampleProcedures samples = SampleProcedures.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildProcedureBundles() {
    Procedure.Bundle bundle =
        Procedure.Bundle.builder()
            .type(BundleType.searchset)
            .link(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url("http://procedure.com/bundle")
                    .build()
                    .asList())
            .entry(
                Procedure.Entry.builder()
                    .extension(samples.extension().asList())
                    .fullUrl("http://procedure.com")
                    .id("1234")
                    .link(
                        BundleLink.builder()
                            .relation(BundleLink.LinkRelation.self)
                            .url("http://procedure.com/entry")
                            .build()
                            .asList())
                    .resource(samples.procedure())
                    .search(samples.search())
                    .request(samples.request())
                    .response(samples.response())
                    .build()
                    .asList())
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  public void procedure() {
    assertRoundTrip(samples.procedure());
  }

  @Test
  public void relatedGroupsTest() {
    ExactlyOneOfVerifier.builder()
        .sample(samples.procedure())
        .fieldPrefix("performed")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }
}
