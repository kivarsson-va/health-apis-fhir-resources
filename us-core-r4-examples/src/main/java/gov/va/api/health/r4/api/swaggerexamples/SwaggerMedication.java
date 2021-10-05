package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.Medication;
import java.util.List;

public class SwaggerMedication {
  /**
   * An example Medication.
   *
   * @return an example Medication.
   */
  public static Medication medication() {
    return Medication.builder()
        .id("I2-U4FPJS3E633MAJQBCAA2KAB5BQ000000")
        .status(Medication.Status.active)
        .code(
            CodeableConcept.builder()
                .text("Timoptic 5mg/ml solution")
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/sid/ndc")
                        .code("2501-813-16")
                        .build()
                        .asList())
                .build())
        .manufacturer(Reference.builder().id("org5").display("Aton Pharma Inc").build())
        .form(
            CodeableConcept.builder()
                .text("Opthalmic Solution")
                .coding(
                    Coding.builder()
                        .system("http://snomed.info/sct")
                        .code("75359005")
                        .build()
                        .asList())
                .build())
        .ingredient(
            Medication.Ingredient.builder()
                .itemCodeableConcept(
                    CodeableConcept.builder()
                        .text("Timolol Maleate (substance)")
                        .coding(
                            Coding.builder()
                                .system("http://snomed.info/sct")
                                .code("75359005")
                                .build()
                                .asList())
                        .build())
                .build()
                .asList())
        .batch(Medication.Batch.builder().lotNumber("9494788").expirationDate("2017-05-22").build())
        .build();
  }

  /**
   * An example Medication.
   *
   * @return an example Medication.
   */
  public static Medication.Bundle medicationBundle() {
    return Medication.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Medication?"
                            + "_id=I2-U4FPJS3E633MAJQBCAA2KAB5BQ000000&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Medication?"
                            + "_id=I2-U4FPJS3E633MAJQBCAA2KAB5BQ000000&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Medication?"
                            + "_id=I2-U4FPJS3E633MAJQBCAA2KAB5BQ000000&page=1&_count=15")
                    .build()))
        .entry(
            Medication.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Medication/"
                        + "I2-U4FPJS3E633MAJQBCAA2KAB5BQ000000")
                .resource(medication())
                .build()
                .asList())
        .build();
  }
}
