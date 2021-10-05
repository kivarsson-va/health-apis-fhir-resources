package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.DiagnosticReport;
import java.util.List;

public class SwaggerDiagnosticReport {
  /**
   * An example DiagnosticReport.
   *
   * @return an example DiagnosticReport.
   */
  public static final DiagnosticReport diagnosticReport() {
    return DiagnosticReport.builder()
        .id("0757389a-6e06-51bd-aac0-bd0244e51e46")
        .status(DiagnosticReport.Code._final)
        .category(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/ValueSet/diagnostic-service-sections")
                        .code("LAB")
                        .display("Laboratory")
                        .build()
                        .asList())
                .build())
        .code(CodeableConcept.builder().text("panel").build())
        .effectiveDateTime("2011-04-04T01:15:52Z")
        .issued("2011-04-04T01:15:52Z")
        .subject(
            Reference.builder()
                .reference("https://sandbox-api.va.gov/services/argonaut/v0/Patient/2000163")
                .display("Mr. Aurelio227 Cruickshank494")
                .build())
        .build();
  }

  /**
   * An example DiagnosticReport.Bundle.
   *
   * @return an example DiagnosticReport.Bundle.
   */
  public static final DiagnosticReport.Bundle diagnosticReportBundle() {
    return DiagnosticReport.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/DiagnosticReport?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/DiagnosticReport?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/DiagnosticReport?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            DiagnosticReport.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/DiagnosticReport/0757389a-6e06-51bd-aac0-bd0244e51e46")
                .resource(diagnosticReport())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
