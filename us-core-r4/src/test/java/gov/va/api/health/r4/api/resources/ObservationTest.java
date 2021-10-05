package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleKnownTypes;
import gov.va.api.health.r4.api.samples.SampleObservations;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class ObservationTest {

  private final SampleObservations data = SampleObservations.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildObservationBundles() {
    Observation.Entry entry =
        Observation.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://observation.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://observation.com/1")
                    .build()
                    .asList())
            .resource(data.observation())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    Observation.Bundle bundle =
        Observation.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://observation.com/2")
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void observation() {
    assertRoundTrip(data.observation());
  }

  @Test
  public void relatedGroups() {
    ExactlyOneOfVerifier.builder()
        .sample(data.observation())
        .fieldPrefix("effective")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
    ZeroOrOneOfVerifier.builder()
        .sample(data.observation())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }

  @Test
  public void validationFailsGivenBadCategorySystem() {
    assertThat(violationsOf(data.observation().category(data.codeableConcept().asList())))
        .isNotEmpty();
  }

  @Test
  public void validationPassesGivenGoodCategory() {
    assertThat(
            violationsOf(
                data.observation()
                    .category()
                    .get(0)
                    .coding()
                    .get(0)
                    .system("http://terminology.hl7.org/CodeSystem/observation-category")
                    .code("laboratory")))
        .isEmpty();
  }

  private <T> Set<ConstraintViolation<T>> violationsOf(T object) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    return factory.getValidator().validate(object);
  }
}
