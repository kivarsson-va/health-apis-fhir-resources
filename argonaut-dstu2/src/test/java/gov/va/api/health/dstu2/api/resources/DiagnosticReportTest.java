package gov.va.api.health.dstu2.api.resources;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.samples.SampleDiagnosticReports;
import gov.va.api.health.dstu2.api.samples.SampleKnownTypes;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class DiagnosticReportTest {
  private final SampleDiagnosticReports data = SampleDiagnosticReports.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void bundlerCanBuildDiagnosticReportBundles() {
    DiagnosticReport.Entry entry =
        DiagnosticReport.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://diagnosticreports.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://diagnosticreport/1"))
                    .build()
                    .asList())
            .resource(data.diagnosticReport())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    DiagnosticReport.Bundle bundle =
        DiagnosticReport.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://diagnosticreport.com/2"))
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  public void diagnosticReport() {
    assertRoundTrip(data.diagnosticReport());
  }

  @Test
  public void relatedGroups() {
    ZeroOrOneOfVerifier.builder()
        .sample(data.diagnosticReport())
        .stringTypes(types.knownStringTypes())
        .knownTypes(types.knownTypes())
        .fieldPrefix("effective")
        .build()
        .verify();
  }

  @Test
  public void validationFailsGivenBadCategory() {
    assertThat(violationsOf(data.diagnosticReport().category(data.codeableConcept()))).isNotEmpty();
  }

  @Test
  public void validationFailsGivenNoCategory() {
    assertThat(violationsOf(data.diagnosticReport().category(null))).isNotEmpty();
  }

  @Test
  public void validationPassesGivenGoodCategory() {
    assertThat(
            violationsOf(
                data.diagnosticReport()
                    .category()
                    .coding()
                    .get(0)
                    .code("http://hl7.org/fhir/ValueSet/diagnostic-service-sections")))
        .isEmpty();
  }

  private <T> Set<ConstraintViolation<T>> violationsOf(T object) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    return factory.getValidator().validate(object);
  }
}
