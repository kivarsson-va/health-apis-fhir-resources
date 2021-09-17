package gov.va.api.health.r4.api.swaggerexamples;

import static java.util.Arrays.asList;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Quantity;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.InsurancePlan;
import java.math.BigDecimal;
import java.util.List;

public class SwaggerInsurancePlan {
  /**
   * An example InsurancePlan.
   *
   * @return an example InsurancePlan.
   */
  public static InsurancePlan insurancePlan() {
    return InsurancePlan.builder()
        .id("I3-SwwmASPmf4wfRwf8MDEq5HFVr1zZyKlX")
        .extension(
            List.of(
                Extension.builder()
                    .valueBoolean(true)
                    .url(
                        "http://va.gov/fhir/StructureDefinition/insuranceplan-isUtilizationReviewRequired")
                    .build(),
                Extension.builder()
                    .valueBoolean(true)
                    .url(
                        "http://va.gov/fhir/StructureDefinition/insuranceplan-isPreCertificationRequired")
                    .build(),
                Extension.builder()
                    .valueBoolean(false)
                    .url(
                        "http://va.gov/fhir/StructureDefinition/insuranceplan-excludePreexistingConditions")
                    .build(),
                Extension.builder()
                    .valueBoolean(true)
                    .url(
                        "http://va.gov/fhir/StructureDefinition/insuranceplan-areBenefitsAssignable")
                    .build(),
                Extension.builder()
                    .valueBoolean(true)
                    .url(
                        "http://va.gov/fhir/StructureDefinition/insuranceplan-isCertificationRequiredForAmbulatoryCare")
                    .build(),
                Extension.builder()
                    .valueQuantity(
                        Quantity.builder()
                            .value(new BigDecimal("365"))
                            .unit("DAYS")
                            .system(
                                "http://va.gov/fhir/StructureDefinition/insuranceplan-planStandardFilingTimeFrame")
                            .build())
                    .build()))
        .identifier(
            List.of(
                Identifier.builder()
                    .value("FEP")
                    .system("urn:oid:2.16.840.1.113883.3.8901.3.1.355803.28002")
                    .build()))
        .type(
            List.of(
                CodeableConcept.builder()
                    .coding(
                        List.of(
                            Coding.builder()
                                .code("CI")
                                .display("COMMERCIAL")
                                .system("2.16.840.1.113883.3.8901.3.1.355803.8015")
                                .build()))
                    .text("COMMERCIAL")
                    .build()))
        .ownedBy(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/insurance-fhir/v0/site/500/r4/Organization/I3-ZJURFG76GQN5LW7WP56TXADUFM000000")
                .build())
        .plan(
            List.of(
                InsurancePlan.Plan.builder()
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                List.of(
                                    Coding.builder()
                                        .code("40")
                                        .display("PREFERRED PROVIDER ORGANIZATION (PPO)")
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
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan?_id=I3-SwwmASPmf4wfRwf8MDEq5HFVr1zZyKlXe&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan?_id=I3-SwwmASPmf4wfRwf8MDEq5HFVr1zZyKlXee&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan?_id=I3-SwwmASPmf4wfRwf8MDEq5HFVr1zZyKlXe&page=1&_count=15")
                    .build()))
        .entry(
            asList(
                InsurancePlan.Entry.builder()
                    .fullUrl(
                        "https://sandbox-api.va.gov/services/insurance-fhir/v0/r4/InsurancePlan/I3-SwwmASPmf4wfRwf8MDEq5HFVr1zZyKlX")
                    .resource(insurancePlan())
                    .build()))
        .build();
  }
}
