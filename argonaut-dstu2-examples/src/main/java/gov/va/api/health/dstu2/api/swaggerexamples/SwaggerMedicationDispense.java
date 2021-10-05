package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.datatypes.Identifier;
import gov.va.api.health.dstu2.api.datatypes.SimpleQuantity;
import gov.va.api.health.dstu2.api.datatypes.Timing;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.MedicationDispense;
import java.util.List;

public class SwaggerMedicationDispense {
  /**
   * An example MedicationDispense.
   *
   * @return an example MedicationDispense.
   */
  public static MedicationDispense medicationDispense() {
    return MedicationDispense.builder()
        .id("3ba8c63c-bac2-5f98-b7cd-161792919216")
        .identifier(
            Identifier.builder()
                .use(Identifier.IdentifierUse.usual)
                .system("http://va.gov/cdw")
                .value("185601V825290")
                .build())
        .status(MedicationDispense.Status.completed)
        .patient(
            Reference.builder()
                .reference("https://sandbox-api.va.gov/services/argonaut/v0/Patient/185601V825290")
                .display("VETERAN,JOHN Q")
                .build())
        .dispenser(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/argonaut/v0/Practitioner/a98d6c9c-c5bd-58a5-a5d0-0da31cafd37c")
                .display("SMITH,ATTENDING C")
                .build())
        .authorizingPrescription(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/argonaut/v0/MedicationOrder/8c95153c-817b-53f3-8166-55b1e01ac2a2")
                .display("OUTPATIENT PHARMACY")
                .build()
                .asList())
        .type(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/v3/ActCode")
                        .code("FF")
                        .display("First Fill")
                        .build()
                        .asList())
                .build())
        .quantity(SimpleQuantity.builder().value(240D).unit("ML").build())
        .daysSupply(
            SimpleQuantity.builder()
                .value(15D)
                .unit("Day")
                .system("http://unitsofmeasure.org")
                .code("D")
                .build())
        .medicationReference(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/argonaut/v0/Medication/b07873cb-24cb-5aa7-a0be-78b7ac5aee22")
                .display("CODEINE 10/GG 100MG/5ML (ALC-F/SF) LIQ")
                .build())
        .whenPrepared("2015-04-15T04:00:00Z")
        .dosageInstruction(
            MedicationDispense.DosageInstruction.builder()
                .text(
                    "TAKE 1 TEASPOONFUL BY MOUTH EVERY 6 HOURS AS NEEDED FOR COUGH CAN TAKE  "
                        + "2 TEASPOONS AT BEDTIME IF NEEDED. USE SPARINGLY")
                .additionalInstructions(
                    CodeableConcept.builder()
                        .text(
                            "FOR COUGH can take 2 teaspoons at bedtime if needed. "
                                + "Use sparingly")
                        .build())
                .timing(
                    Timing.builder().code(CodeableConcept.builder().text("PRN").build()).build())
                .asNeededBoolean(true)
                .route(CodeableConcept.builder().text("ORAL").build())
                .doseQuantity(SimpleQuantity.builder().value(1D).build())
                .build()
                .asList())
        .build();
  }

  /**
   * An example MedicationDispense.Bundle.
   *
   * @return an example MedicationDispense.Bundle.
   */
  public static MedicationDispense.Bundle medicationDispenseBundle() {
    return MedicationDispense.Bundle.builder()
        .type(BundleType.searchset)
        .total(1155)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/MedicationDispense?patient=185601V825290&page=1&_count=1")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/MedicationDispense?patient=185601V825290&page=1&_count=1")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.next)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/MedicationDispense?patient=185601V825290&page=2&_count=1")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/MedicationDispense?patient=185601V825290&page=1155&_count=1")
                    .build()))
        .entry(
            MedicationDispense.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/MedicationDispense/2f587c16-5182-59a5-bdcb-518c7c501f37")
                .resource(medicationDispense())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
