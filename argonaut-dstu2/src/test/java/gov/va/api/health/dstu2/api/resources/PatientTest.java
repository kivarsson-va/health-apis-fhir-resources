package gov.va.api.health.dstu2.api.resources;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.resources.Patient.Bundle;
import gov.va.api.health.dstu2.api.resources.Patient.Entry;
import gov.va.api.health.dstu2.api.samples.SampleKnownTypes;
import gov.va.api.health.dstu2.api.samples.SamplePatients;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import org.junit.jupiter.api.Test;

public class PatientTest {
  private final SamplePatients data = SamplePatients.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildPatientBundles() {
    Entry entry =
        Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://patient.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(("http://patient.com/1"))
                    .build()
                    .asList())
            .resource(data.patient())
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
                    .url(("http://patient.com/2"))
                    .build()
                    .asList())
            .type(BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void patient() {
    assertRoundTrip(data.patient());
  }

  @Test
  public void relatedGroups() {
    ZeroOrOneOfVerifier.builder()
        .sample(data.patient())
        .fieldPrefix("deceased")
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.patient())
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .fieldPrefix("multipleBirth")
        .build()
        .verify();
  }
}
