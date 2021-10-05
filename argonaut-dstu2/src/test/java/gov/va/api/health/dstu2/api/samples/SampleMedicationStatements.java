package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.MedicationStatement;
import gov.va.api.health.dstu2.api.resources.MedicationStatement.Dosage;
import gov.va.api.health.dstu2.api.resources.MedicationStatement.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * This class provides data structures that are populated with dummy values, suitable for testing
 * serialization.
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleMedicationStatements {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  private Dosage dosage() {
    return Dosage.builder()
        .id("2222")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .text("Hello Text")
        .timing(timing())
        .asNeededBoolean(true)
        .siteCodeableConcept(codeableConcept())
        .route(codeableConcept())
        .method(codeableConcept())
        .doseQuantity(simpleQuantity())
        .rateRange(range())
        .maxDosePerPeriod(ratio())
        .build();
  }

  private List<Dosage> dosageList() {
    return dosage().asList();
  }

  public MedicationStatement medicationStatement() {
    return MedicationStatement.builder()
        .id("ms1")
        .meta(meta())
        .implicitRules("rules")
        .language("murican!")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .patient(reference())
        .informationSource(reference())
        .dateAsserted("2005-01-21T07:57:00.000Z")
        .status(Status.active)
        .wasNotTaken(true)
        .reasonNotTaken(codeableConceptList())
        .reasonForUseReference(reference())
        .effectiveDateTime("2005-01-21T07:57:00.001Z")
        .note("neato")
        .supportingInformation(referenceList())
        .medicationReference(reference())
        .dosage(dosageList())
        .build();
  }

  public MedicationStatement medicationStatementWithAlternateValues() {
    return medicationStatement()
        .reasonForUseReference(null)
        .reasonForUseCodeableConcept(codeableConcept())
        .medicationReference(null)
        .medicationCodeableConcept(codeableConcept())
        .effectiveDateTime(null)
        .effectivePeriod(period());
  }
}
