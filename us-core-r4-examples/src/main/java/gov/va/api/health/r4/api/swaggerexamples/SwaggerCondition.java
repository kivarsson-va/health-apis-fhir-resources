package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.Condition;
import java.util.List;

public class SwaggerCondition {
  /**
   * An example Condition.
   *
   * @return an example Condition.
   */
  public static Condition condition() {
    return Condition.builder()
        .id("I2-U4FPJS3E633MAJQBCAA2KAB5BQ000000")
        .clinicalStatus(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/R4/valueset-condition-clinical.html")
                        .code("active")
                        .build()
                        .asList())
                .build())
        .verificationStatus(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/R4/valueset-condition-ver-status.html")
                        .code("unconfirmed")
                        .build()
                        .asList())
                .build())
        .category(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system(
                            "https://build.fhir.org/ig/HL7/US-Core-R4/ValueSet-us-core-condition-category.html")
                        .code("problem-list-item")
                        .build()
                        .asList())
                .build()
                .asList())
        .code(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .code("38341003")
                        .system("http://www.snomed.org/snomed-ct")
                        .display("Hypertension")
                        .build()
                        .asList())
                .text("Hypertension")
                .build())
        .subject(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient/1017283148V813263")
                .display("Mr. Aurelio227 Cruickshank494")
                .build())
        .onsetDateTime("2013-04-15T01:15:52Z")
        .recordedDate("2013-04-14")
        .build();
  }

  /**
   * An example Condition.Bundle.
   *
   * @return an example Condition.Bundle.
   */
  public static Condition.Bundle conditionBundle() {
    return Condition.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Condition?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Condition?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Condition?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            Condition.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Condition/I2-U4FPJS3E633MAJQBCAA2KAB5BQ000000")
                .resource(condition())
                .build()
                .asList())
        .build();
  }
}
