package gov.va.api.health.r4.api.resources;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.samples.SampleDiagnosticReports;
import gov.va.api.health.r4.api.samples.SampleKnownTypes;
import gov.va.api.health.validation.api.ExactlyOneOfVerifier;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

public class DiagnosticReportTest {
  private final SampleDiagnosticReports data = SampleDiagnosticReports.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  void bundlerCanBuildBundles() {
    DiagnosticReport.Entry entry =
        DiagnosticReport.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://diagnosticreport.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url("http://diagnosticreport.com/1")
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
                    .url("http://diagnosticreport.com/2")
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    assertRoundTrip(bundle);
  }

  @Test
  void diagnosticReport() {
    assertRoundTrip(data.diagnosticReport());
  }

  @Test
  void relatedGroups() {
    ExactlyOneOfVerifier.builder()
        .sample(data.diagnosticReport())
        .fieldPrefix("effective")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }

  @Test
  void validationFailsGivenBadCategorySystem() {
    assertThat(violationsOf(data.diagnosticReport().category(data.codeableConcept().asList())))
        .isNotEmpty();
  }

  @Test
  void validationPassesGivenGoodCategory() {
    List<CodeableConcept> validCc =
        CodeableConcept.builder()
            .coding(
                Coding.builder()
                    .system("http://terminology.hl7.org/CodeSystem/v2-0074")
                    .code("LAB")
                    .build()
                    .asList())
            .build()
            .asList();
    assertThat(violationsOf(data.diagnosticReport().category(validCc))).isEmpty();
  }

  private <T> Set<ConstraintViolation<T>> violationsOf(T object) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    return factory.getValidator().validate(object);
  }
}
