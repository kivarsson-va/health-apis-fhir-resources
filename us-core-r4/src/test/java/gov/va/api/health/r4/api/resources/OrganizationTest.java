package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.samples.SampleOrganizations;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class OrganizationTest {
  private final SampleOrganizations data = SampleOrganizations.get();

  @Test
  public void bundlerCanBuildOrganizationBundles() {
    Organization.Entry entry =
        Organization.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://organization.com")
            .id("1234")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://organization.com/1")
                    .build()
                    .asList())
            .resource(data.organization())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();
    Organization.Bundle bundle =
        Organization.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://organization.com/2")
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();
    assertRoundTrip(bundle);
  }

  @Test
  public void organization() {
    assertRoundTrip(data.organization());
  }

  @Test
  public void sliceValidationHandlesNullIdentifierList() {
    assertThat(violationsOf(data.organization().identifier(null))).isEmpty();
  }

  @Test
  public void validationFailsGivenBadAddressLineCount() {
    assertThat(
            violationsOf(
                data.organization()
                    .address(data.address().line(List.of("a", "b", "c", "d", "e")).asList())))
        .isNotEmpty();
  }

  @Test
  public void validationFailsGivenBadIdentifierSlice() {
    assertThat(
            violationsOf(
                data.organization()
                    .identifier(
                        List.of(
                            data.identifier().id("123").system("http://hl7.org/fhir/sid/us-npi"),
                            data.identifier().id("987").system("http://hl7.org/fhir/sid/us-npi")))))
        .isNotEmpty();
  }

  @Test
  public void validationPassesGivenGoodAddressLineCount() {
    assertThat(
            violationsOf(
                data.organization()
                    .address(data.address().line(List.of("a", "b", "c", "d")).asList())))
        .isEmpty();
    assertThat(violationsOf(data.organization().address(data.address().line(null).asList())))
        .isEmpty();
  }

  private <T> Set<ConstraintViolation<T>> violationsOf(T object) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    return factory.getValidator().validate(object);
  }
}
