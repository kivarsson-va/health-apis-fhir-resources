package gov.va.api.health.dstu2.api.resources;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.resources.MedicationDispense.Bundle;
import gov.va.api.health.dstu2.api.resources.MedicationDispense.Entry;
import gov.va.api.health.dstu2.api.samples.SampleKnownTypes;
import gov.va.api.health.dstu2.api.samples.SampleMedicationDispenses;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class MedicationDispenseTest {
  private final SampleMedicationDispenses data = SampleMedicationDispenses.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildMedicationDispenseBundles() {
    Entry entry =
        Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://medicationdispense.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url("http://medicationdispense/123")
                    .build()
                    .asList())
            .resource(data.medicationDispense())
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
                    .url("https://medicationdispense?patient=456")
                    .build()
                    .asList())
            .type(BundleType.searchset)
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  public void medicationDispense() {
    assertRoundTrip(data.medicationDispense());
  }

  @Test
  public void relatedFields() {
    ExactlyOneOfVerifier.builder()
        .sample(data.medicationDispense())
        .fieldPrefix("medication")
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.medicationDispense().dosageInstruction().get(0))
        .fieldPrefix("rate")
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.medicationDispense().dosageInstruction().get(0))
        .fieldPrefix("asNeeded")
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.medicationDispense().dosageInstruction().get(0))
        .fieldPrefix("site")
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.medicationDispense().dosageInstruction().get(0))
        .fieldPrefix("dose")
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .build()
        .verify();
  }

  @Test
  public void validationFailsGivenEarlyHandedOver() {
    assertThat(
            violationsOf(
                data.medicationDispense()
                    .whenPrepared("2019-02-01T04:00:00Z")
                    .whenHandedOver("2019-01-01T13:00:00Z")))
        .isNotEmpty();
  }

  @Test
  public void validationIgnoresMissingWhenPrepared() {
    assertThat(violationsOf(data.medicationDispense().whenPrepared(null))).isEmpty();
  }

  @Test
  public void validationPassesGivenGoodPreparedAndHandedOver() {
    assertThat(
            violationsOf(
                data.medicationDispense()
                    .whenPrepared("2019-01-01T04:00:00Z")
                    .whenHandedOver("2019-01-02T04:00:00Z")))
        .isEmpty();
  }

  @Test
  public void validationReturnsOnlyRegexViolationForBadDate() {
    Set<ConstraintViolation<MedicationDispense>> violations =
        violationsOf(data.medicationDispense().whenPrepared("not-a-date"));
    assertThat(violations).isNotEmpty();
    // Checking to make sure no message about the dates being in the wrong order comes back
    assertThat(violations)
        .filteredOn(violation -> violation.getMessage().contains("before"))
        .isEmpty();
  }

  private <T> Set<ConstraintViolation<T>> violationsOf(T object) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    return factory.getValidator().validate(object);
  }
}
