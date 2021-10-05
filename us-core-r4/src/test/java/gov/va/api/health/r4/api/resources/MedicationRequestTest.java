package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.samples.SampleKnownTypes;
import gov.va.api.health.r4.api.samples.SampleMedicationRequests;
import gov.va.api.health.validation.api.ExactlyOneOfExtensionVerifier;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import org.junit.jupiter.api.Test;

public class MedicationRequestTest {
  private final SampleMedicationRequests samples = SampleMedicationRequests.get();

  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  void bundlerCanBuildMedicationRequestBundles() {
    MedicationRequest.Bundle bundle =
        MedicationRequest.Bundle.builder()
            .type(AbstractBundle.BundleType.searchset)
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://medicationrequest.com/bundle")
                    .build()
                    .asList())
            .entry(
                MedicationRequest.Entry.builder()
                    .extension(samples.extension().asList())
                    .fullUrl("http://medicationrequest.com")
                    .id("1234")
                    .link(
                        BundleLink.builder()
                            .relation(BundleLink.LinkRelation.self)
                            .url("http://medicationrequest.com/entry")
                            .build()
                            .asList())
                    .resource(samples.medicationRequest())
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
        .sample(samples.medicationRequestWithDataAbsentReason())
        .fieldPrefix("medication")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();

    ExactlyOneOfExtensionVerifier.builder()
        .sample(samples.medicationRequestWithDataAbsentReason())
        .field("requester")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .extensionClass(Extension.class)
        .build()
        .verify();
  }

  @Test
  void medicationRequest() {
    assertRoundTrip(samples.medicationRequest());
  }

  @Test
  void zeroOrOneOfTest() {
    ZeroOrOneOfVerifier.builder()
        .sample(samples.medicationRequestWithDataAbsentReason())
        .fieldPrefix("reported")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }
}
