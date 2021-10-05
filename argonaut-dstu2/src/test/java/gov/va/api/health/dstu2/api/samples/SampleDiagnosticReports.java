package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.resources.DiagnosticReport;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleDiagnosticReports {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  private CodeableConcept category() {
    return CodeableConcept.builder()
        .coding(
            Coding.builder()
                .system("http://hl7.org/fhir/ValueSet/diagnostic-service-sections")
                .code("LAB")
                .display("Laboratory")
                .build()
                .asList())
        .text("dat category")
        .build();
  }

  private CodeableConcept codeCodeableConcept() {
    return CodeableConcept.builder().coding(codeCodingList()).text("panel").build();
  }

  private List<Coding> codeCodingList() {
    return Coding.builder().system("http://HelloSystem.com").code("Hello Code").build().asList();
  }

  public DiagnosticReport diagnosticReport() {
    return DiagnosticReport.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .status(DiagnosticReport.Code._final)
        .category(category())
        .code(codeCodeableConcept())
        .subject(reference())
        .encounter(reference())
        .effectiveDateTime("2013-06-21T20:05:12Z")
        .issued("2013-06-21T19:03:16Z")
        .performer(reference())
        .conclusion("The end.")
        .codedDiagnosis(List.of(codeableConcept(), codeableConcept()))
        .presentedForm(List.of(attachment(), attachment()))
        .build();
  }
}
