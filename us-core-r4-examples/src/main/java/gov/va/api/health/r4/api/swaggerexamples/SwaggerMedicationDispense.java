package gov.va.api.health.r4.api.swaggerexamples;

import static gov.va.api.health.r4.api.resources.MedicationDispense.Status.completed;
import static gov.va.api.health.r4.api.resources.MedicationDispense.Substitution;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.AbstractEntry;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.Annotation;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.SimpleQuantity;
import gov.va.api.health.r4.api.datatypes.Timing;
import gov.va.api.health.r4.api.elements.Dosage;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.MedicationDispense;
import java.math.BigDecimal;
import java.util.List;

public class SwaggerMedicationDispense {
  /**
   * An example MedicationDispense.
   *
   * @return an example MedicationDispense.
   */
  public static MedicationDispense medicationDispense() {
    return MedicationDispense.builder()
        .id("meddp0302")
        .status(completed)
        .medicationReference(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Medication"
                        + "/I2-LTU3MVTE2VLWXUQKKCRRTEWJDE000000")
                .display("Azithromycin 250mg capsule")
                .build())
        .subject(
            Reference.builder()
                .reference("https://sandbox-api.va.gov/services/fhir/v0/r4/Patient/32000225")
                .display("Mrs. Sheba703 Harris789")
                .build())
        .authorizingPrescription(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/MedicationRequest/I2-AOV4FXGQLPIXGZPTMTWY7Y7KJ4000000")
                .display("RX")
                .build()
                .asList())
        .whenPrepared("2015-01-15T12:03:52Z")
        .whenHandedOver("2015-01-16T12:03:52Z")
        .quantity(SimpleQuantity.builder().value(BigDecimal.valueOf(60)).unit("Pills").build())
        .daysSupply(SimpleQuantity.builder().value(BigDecimal.valueOf(60)).unit("Days").build())
        .note(Annotation.builder().authorString("Patient told to take with food").build().asList())
        .dosageInstruction(
            Dosage.builder()
                .text("Once per day.")
                .timing(
                    Timing.builder()
                        .code(CodeableConcept.builder().text("As directed by physician.").build())
                        .build())
                .route(CodeableConcept.builder().text("As directed by physician.").build())
                .build()
                .asList())
        .substitution(Substitution.builder().wasSubstituted(false).build())
        .build();
  }

  /**
   * An example MedicationDispense Bundle.
   *
   * @return an example MedicationDispense Bundle.
   */
  public static MedicationDispense.Bundle medicationDispenseBundle() {
    return MedicationDispense.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/"
                            + "MedicationDispense?patient=32000225&intent=order&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/"
                            + "MedicationDispense?patient=32000225&intent=order&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/"
                            + "MedicationDispense?patient=32000225&intent=order&page=1&_count=15")
                    .build()))
        .entry(
            MedicationDispense.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/MedicationDispense/"
                        + "I2-AOV4FXGQLPIXGZPTMTWY7Y7KJ4000000")
                .resource(medicationDispense())
                .search(AbstractEntry.Search.builder().mode(AbstractEntry.SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
