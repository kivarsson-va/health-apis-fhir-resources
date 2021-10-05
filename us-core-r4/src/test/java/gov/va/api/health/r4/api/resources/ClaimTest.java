package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType.searchset;

import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.r4.api.resources.Claim.Bundle;
import gov.va.api.health.r4.api.resources.Claim.Entry;
import gov.va.api.health.r4.api.samples.SampleClaims;
import gov.va.api.health.r4.api.samples.SampleKnownTypes;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import org.junit.jupiter.api.Test;

public class ClaimTest {

  private final SampleClaims data = SampleClaims.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildClaimBundles() {
    Entry entry =
        Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://localhost")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://localhost/1")
                    .build()
                    .asList())
            .resource(data.claim())
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
                    .url("http://localhost/2")
                    .build()
                    .asList())
            .type(searchset)
            .signature(data.signature())
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  public void claim() {
    assertRoundTrip(data.claim());
  }

  @Test
  public void relatedGroups() {
    ZeroOrOneOfVerifier.builder()
        .sample(data.accidentWithLocationAddress())
        .fieldPrefix("location")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.accidentWithLocationReference())
        .fieldPrefix("location")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfoWithTimingDateAndValueAttachment())
        .fieldPrefix("timing")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfoWithTimingPeriodAndValueAttachment())
        .fieldPrefix("timing")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfoWithTimingDateAndValueAttachment())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfoWithTimingDateAndValueBoolean())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfoWithTimingDateAndValueQuantity())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfoWithTimingDateAndValueReference())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.supportingInfoWithTimingDateAndValueString())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ExactlyOneOfVerifier.builder()
        .sample(data.diagnosisWithCodeableConcept())
        .fieldPrefix("diagnosis")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ExactlyOneOfVerifier.builder()
        .sample(data.diagnosisWithReference())
        .fieldPrefix("diagnosis")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ExactlyOneOfVerifier.builder()
        .sample(data.procedureWithCodeableConcept())
        .fieldPrefix("procedure")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ExactlyOneOfVerifier.builder()
        .sample(data.procedureWithReference())
        .fieldPrefix("procedure")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.itemWithServicedDateAndLocationAddress())
        .fieldPrefix("serviced")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.itemWithServicedPeriodAndLocationAddress())
        .fieldPrefix("serviced")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.itemWithServicedDateAndLocationAddress())
        .fieldPrefix("location")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.itemWithServicedDateAndLocationCodeableConcept())
        .fieldPrefix("location")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.itemWithServicedDateAndLocationReference())
        .fieldPrefix("location")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }
}
