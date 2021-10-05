package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.Claim;
import java.util.List;

public class SwaggerClaim {
  /**
   * An example Claim.
   *
   * @return an example Claim.
   */
  public static Claim claim() {
    return Claim.builder()
        .id("1234509876")
        .status(Claim.Status.active)
        .type(
            CodeableConcept.builder()
                .coding(Coding.builder().code("institutional").build().asList())
                .text("Hospital, clinic and typically inpatient claims.")
                .build())
        .use(Claim.Use.claim)
        .patient(Reference.builder().display("Patient/1239908V993").build())
        .created("2019-10-23T20:48:30.000-06:00")
        .provider(Reference.builder().display("Organization/11153").build())
        .priority(
            CodeableConcept.builder()
                .coding(Coding.builder().code("normal").build().asList())
                .text("With best effort.")
                .build())
        .procedure(
            Claim.Procedure.builder()
                .sequence(78362914)
                .type(
                    CodeableConcept.builder()
                        .coding(Coding.builder().code("primary").build().asList())
                        .text("The first procedure in a series required to address problem.")
                        .build()
                        .asList())
                .date("2019-04-12")
                .procedureCodeableConcept(
                    CodeableConcept.builder()
                        .coding(Coding.builder().code("39216").build().asList())
                        .text("Minimally Invasive Lumbar Spinal Fusion")
                        .build())
                .build()
                .asList())
        .insurance(
            Claim.Insurance.builder()
                .sequence(122)
                .focal(true)
                .coverage(Reference.builder().display("Coverage/98203441").build())
                .build()
                .asList())
        .build();
  }

  /**
   * An example Bundle.
   *
   * @return an example Bundle.
   */
  public static Claim.Bundle claimBundle() {
    return Claim.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Claim?patient=1008679665V880686&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Claim?patient=1008679665V880686&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Claim?patient=1008679665V880686&page=1&_count=15")
                    .build()))
        .entry(Claim.Entry.builder().resource(claim()).build().asList())
        .build();
  }
}
