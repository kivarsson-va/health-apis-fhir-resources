package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType;

import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleKnownTypes;
import gov.va.api.health.r4.api.samples.SampleMedicationDispenses;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import org.junit.jupiter.api.Test;

public class MedicationDispenseTest {
  private final SampleMedicationDispenses samples = SampleMedicationDispenses.get();

  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  void bundlerCanBuildMedicationDispenseBundle() {
    MedicationDispense.Bundle bundle =
        MedicationDispense.Bundle.builder()
            .type(BundleType.searchset)
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://medicationdispense.com/bundle")
                    .build()
                    .asList())
            .entry(
                MedicationDispense.Entry.builder()
                    .extension(samples.extension().asList())
                    .fullUrl("http://medicationdispense.com")
                    .id("1243")
                    .link(
                        BundleLink.builder()
                            .relation(BundleLink.LinkRelation.self)
                            .url("http://medicationdispense.com/entry")
                            .build()
                            .asList())
                    .resource(samples.medicationDispense())
                    .search(samples.search())
                    .request(samples.request())
                    .response(samples.response())
                    .build()
                    .asList())
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  void exactlyOneOfTest() {
    ExactlyOneOfVerifier.builder()
        .sample(samples.medicationDispense())
        .fieldPrefix("medication")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }

  @Test
  void medicationDispense() {
    assertRoundTrip(samples.medicationDispense());
  }

  @Test
  void zeroOrOneOfTest() {
    ZeroOrOneOfVerifier.builder()
        .sample(samples.medicationDispense())
        .fieldPrefix("statusReason")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }
}
