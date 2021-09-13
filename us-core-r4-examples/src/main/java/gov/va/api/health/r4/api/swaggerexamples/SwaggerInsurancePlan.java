package gov.va.api.health.r4.api.swaggerexamples;

import static java.util.Arrays.asList;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.InsurancePlan;
import java.util.List;

public class SwaggerInsurancePlan {
  /**
   * An example InsurancePlan.
   *
   * @return an example InsurancePlan.
   */
  public static InsurancePlan insurancePlan() {
    return InsurancePlan.builder()
        .id("I3-000000000000000000")
        .status(InsurancePlan.Status.active)
        .name("BCBS")
        .type(
            List.of(
                CodeableConcept.builder()
                    .coding(
                        List.of(
                            Coding.builder()
                                .code("medical")
                                .display("Medical")
                                .system("2.16.840.1.113883.3.8901.3.1.355803.8014")
                                .build()))
                    .build()))
        .identifier(
            List.of(
                Identifier.builder()
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                List.of(
                                    Coding.builder()
                                        .code("group number")
                                        .display("Group Number")
                                        .build()))
                            .build())
                    .value("123456")
                    .system("urn:oid:2.16.840.1.113883.3.8901.3.1.355803.28002")
                    .build(),
                Identifier.builder()
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                List.of(
                                    Coding.builder().code("plan id").display("Plan Id").build()))
                            .build())
                    .value("ABC000000000")
                    .system("urn:oid:2.16.840.1.113883.3.8901.3.1.355803.68001")
                    .build()))
        .ownedBy(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/Organization/I3-ZJURFG76GQN5LW7WP56TXADUFM000000")
                .display("Blue Cross Blue Shield")
                .build())
        .plan(
            List.of(
                InsurancePlan.Plan.builder()
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                List.of(
                                    Coding.builder()
                                        .code("High Deductable")
                                        .system("urn:oid:2.16.840.1.113883.3.8901.3.1.355803.8009")
                                        .build()))
                            .build())
                    .build()))
        .build();
  }

  /**
   * An example InsurancePlan.
   *
   * @return an example InsurancePlan.
   */
  public static InsurancePlan.Bundle insurancePlanBundle() {
    return InsurancePlan.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            asList(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan?status=active&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan?status=active&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan?status=active&page=1&_count=15")
                    .build()))
        .entry(
            asList(
                InsurancePlan.Entry.builder()
                    .fullUrl(
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan/I3-000000000000000000")
                    .resource(insurancePlan())
                    .build()))
        .build();
  }
}
