package gov.va.api.health.dstu2.api.resources;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.resources.Procedure.Bundle;
import gov.va.api.health.dstu2.api.resources.Procedure.Entry;
import gov.va.api.health.dstu2.api.samples.SampleKnownTypes;
import gov.va.api.health.dstu2.api.samples.SampleProcedures;
import gov.va.api.health.validation.api.ExactlyOneOfExtensionVerifier;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProcedureTest {
  private final SampleProcedures data = SampleProcedures.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildProcedureBundles() {
    Entry entry =
        Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://procedure.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(("http://procedure.com/1"))
                    .build()
                    .asList())
            .resource(data.procedure())
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
                    .url(("http://procedure.com/2"))
                    .build()
                    .asList())
            .type(BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void patient() {
    assertRoundTrip(data.procedure());
  }

  @Test
  public void relatedFields() {
    ZeroOrOneOfVerifier.builder()
        .sample(data.procedure())
        .fieldPrefix("reason")
        .omissions(List.of("reasonNotPerformed"))
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ExactlyOneOfExtensionVerifier.builder()
        .sample(data.procedure())
        .field("status")
        .extensionClass(Extension.class)
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ExactlyOneOfVerifier.builder()
        .sample(data.procedure())
        .fieldPrefix("performed")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }
}
