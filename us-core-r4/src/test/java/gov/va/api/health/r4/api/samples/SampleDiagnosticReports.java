package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.resources.DiagnosticReport;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleDiagnosticReports {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  private CodeableConcept categorySliceLab() {
    return CodeableConcept.builder()
        .coding(
            Coding.builder()
                .system("http://terminology.hl7.org/CodeSystem/v2-0074")
                .code("LAB")
                .build()
                .asList())
        .build();
  }

  public DiagnosticReport diagnosticReport() {
    return DiagnosticReport.builder()
        .id("123")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .basedOn(reference().asList())
        .status(DiagnosticReport.DiagnosticReportStatus.unknown)
        .category(categorySliceLab().asList())
        .code(codeableConcept())
        .subject(reference())
        .encounter(reference())
        .effectiveDateTime("2020-07-20T12:47:00Z")
        .issued("2020-07-20T12:47:00Z")
        .performer(reference().asList())
        .resultsInterpreter(reference().asList())
        .specimen(reference().asList())
        .result(reference().asList())
        .imagingStudy(reference().asList())
        .media(media().asList())
        .conclusion("Concluded")
        .conclusionCode(codeableConcept().asList())
        .presentedForm(attachment().asList())
        .build();
  }

  private DiagnosticReport.Media media() {
    return DiagnosticReport.Media.builder()
        .id("123")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .comment("Commented")
        .link(reference())
        .build();
  }
}
