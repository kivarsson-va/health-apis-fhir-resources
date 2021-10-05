package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Money;
import gov.va.api.health.r4.api.elements.Narrative;
import gov.va.api.health.r4.api.elements.Narrative.NarrativeStatus;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Adjudication;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.CareTeam;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Insurance;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Item;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.ItemDetail;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.ItemSubDetail;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Outcome;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Payee;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Status;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Total;
import gov.va.api.health.r4.api.resources.ExplanationOfBenefit.Use;
import java.math.BigDecimal;
import java.util.List;

public class SwaggerExplanationOfBenefit {
  /**
   * An example ExplanationOfBenefit.
   *
   * @return an example ExplanationOfBenefit.
   */
  public static ExplanationOfBenefit explanationOfBenefit() {
    return ExplanationOfBenefit.builder()
        .id("EB3500")
        .text(
            Narrative.builder()
                .status(NarrativeStatus.generated)
                .div(
                    "<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">A human-readable rendering of the ExplanationOfBenefit</div>")
                .build())
        .identifier(
            Identifier.builder()
                .system("http://www.BenefitsInc.com/fhir/explanationofbenefit")
                .value("987654321")
                .build()
                .asList())
        .status(Status.active)
        .type(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://terminology.hl7.org/CodeSystem/claim-type")
                        .code("oral")
                        .build()
                        .asList())
                .build())
        .use(Use.claim)
        .patient(Reference.builder().reference("Patient/1").build())
        .created("2014-08-16")
        .enterer(Reference.builder().reference("Practitioner/1").build())
        .insurer(Reference.builder().reference("Organization/1").build())
        .provider(Reference.builder().reference("Practitioner/1").build())
        .payee(
            Payee.builder()
                .type(
                    CodeableConcept.builder()
                        .coding(
                            Coding.builder()
                                .system("http://terminology.hl7.org/CodeSystem/payeetype")
                                .code("provider")
                                .build()
                                .asList())
                        .build())
                .party(Reference.builder().reference("Organization/2").build())
                .build())
        .facility(Reference.builder().reference("Location/1").build())
        .claim(Reference.builder().reference("Claim/100150").build())
        .claimResponse(Reference.builder().reference("ClaimResponse/R3500").build())
        .outcome(Outcome.complete)
        .disposition("Claim settled as per contract.")
        .careTeam(
            CareTeam.builder()
                .sequence(1)
                .provider(Reference.builder().reference("Practitioner/example").build())
                .build()
                .asList())
        .insurance(
            Insurance.builder()
                .focal(true)
                .coverage(Reference.builder().reference("Coverage/9876B1").build())
                .build()
                .asList())
        .item(
            List.of(
                Item.builder()
                    .sequence(1)
                    .careTeamSequence(List.of(1))
                    .productOrService(
                        CodeableConcept.builder()
                            .coding(
                                Coding.builder()
                                    .system("http://terminology.hl7.org/CodeSystem/ex-USCLS")
                                    .code("1205")
                                    .build()
                                    .asList())
                            .build())
                    .servicedDate("2014-08-16")
                    .unitPrice(
                        Money.builder().value(new BigDecimal("135.57")).currency("USD").build())
                    .net(Money.builder().value(new BigDecimal("135.57")).currency("USD").build())
                    .udi(Reference.builder().reference("Device/example").build().asList())
                    .encounter(Reference.builder().reference("Encounter/example").build().asList())
                    .adjudication(
                        List.of(
                            Adjudication.builder()
                                .category(
                                    CodeableConcept.builder()
                                        .coding(Coding.builder().code("eligible").build().asList())
                                        .build())
                                .amount(
                                    Money.builder()
                                        .value(new BigDecimal("120.00"))
                                        .currency("USD")
                                        .build())
                                .build(),
                            Adjudication.builder()
                                .category(
                                    CodeableConcept.builder()
                                        .coding(
                                            Coding.builder().code("eligpercent").build().asList())
                                        .build())
                                .value(new BigDecimal("0.8"))
                                .build(),
                            Adjudication.builder()
                                .category(
                                    CodeableConcept.builder()
                                        .coding(Coding.builder().code("benefit").build().asList())
                                        .build())
                                .amount(
                                    Money.builder()
                                        .value(new BigDecimal("96.00"))
                                        .currency("USD")
                                        .build())
                                .build()))
                    .build(),
                Item.builder()
                    .sequence(2)
                    .careTeamSequence(List.of(1))
                    .productOrService(
                        CodeableConcept.builder()
                            .coding(Coding.builder().code("group").build().asList())
                            .build())
                    .servicedDate("2014-08-16")
                    .net(Money.builder().value(new BigDecimal("200.00")).currency("USD").build())
                    .adjudication(
                        Adjudication.builder()
                            .category(
                                CodeableConcept.builder()
                                    .coding(Coding.builder().code("benefit").build().asList())
                                    .build())
                            .amount(
                                Money.builder()
                                    .value(new BigDecimal("180.00"))
                                    .currency("USD")
                                    .build())
                            .build()
                            .asList())
                    .detail(
                        ItemDetail.builder()
                            .sequence(1)
                            .productOrService(
                                CodeableConcept.builder()
                                    .coding(Coding.builder().code("group").build().asList())
                                    .build())
                            .net(
                                Money.builder()
                                    .value(new BigDecimal("200.00"))
                                    .currency("USD")
                                    .build())
                            .udi(Reference.builder().reference("Device/example").build().asList())
                            .adjudication(
                                Adjudication.builder()
                                    .category(
                                        CodeableConcept.builder()
                                            .coding(
                                                Coding.builder().code("benefit").build().asList())
                                            .build())
                                    .amount(
                                        Money.builder()
                                            .value(new BigDecimal("180.00"))
                                            .currency("USD")
                                            .build())
                                    .build()
                                    .asList())
                            .subDetail(
                                ItemSubDetail.builder()
                                    .sequence(1)
                                    .productOrService(
                                        CodeableConcept.builder()
                                            .coding(
                                                Coding.builder()
                                                    .system(
                                                        "http://terminology.hl7.org/CodeSystem/ex-USCLS")
                                                    .code("1205")
                                                    .build()
                                                    .asList())
                                            .build())
                                    .unitPrice(
                                        Money.builder()
                                            .value(new BigDecimal("200.00"))
                                            .currency("USD")
                                            .build())
                                    .net(
                                        Money.builder()
                                            .value(new BigDecimal("200.00"))
                                            .currency("USD")
                                            .build())
                                    .udi(
                                        Reference.builder()
                                            .reference("Device/example")
                                            .build()
                                            .asList())
                                    .adjudication(
                                        List.of(
                                            Adjudication.builder()
                                                .category(
                                                    CodeableConcept.builder()
                                                        .coding(
                                                            Coding.builder()
                                                                .code("eligible")
                                                                .build()
                                                                .asList())
                                                        .build())
                                                .amount(
                                                    Money.builder()
                                                        .value(new BigDecimal("200.00"))
                                                        .currency("USD")
                                                        .build())
                                                .build(),
                                            Adjudication.builder()
                                                .category(
                                                    CodeableConcept.builder()
                                                        .coding(
                                                            Coding.builder()
                                                                .code("eligpercent")
                                                                .build()
                                                                .asList())
                                                        .build())
                                                .amount(
                                                    Money.builder()
                                                        .value(new BigDecimal("0.9"))
                                                        .build())
                                                .build(),
                                            Adjudication.builder()
                                                .category(
                                                    CodeableConcept.builder()
                                                        .coding(
                                                            Coding.builder()
                                                                .code("benefit")
                                                                .build()
                                                                .asList())
                                                        .build())
                                                .amount(
                                                    Money.builder()
                                                        .value(new BigDecimal("180.00"))
                                                        .currency("USD")
                                                        .build())
                                                .build()))
                                    .build()
                                    .asList())
                            .build()
                            .asList())
                    .build()))
        .total(
            List.of(
                Total.builder()
                    .category(
                        CodeableConcept.builder()
                            .coding(Coding.builder().code("submitted").build().asList())
                            .build())
                    .amount(Money.builder().value(new BigDecimal("135.57")).currency("USD").build())
                    .build(),
                Total.builder()
                    .category(
                        CodeableConcept.builder()
                            .coding(Coding.builder().code("benefit").build().asList())
                            .build())
                    .amount(Money.builder().value(new BigDecimal("96.00")).currency("USD").build())
                    .build()))
        .build();
  }

  /**
   * An example Bundle.
   *
   * @return an example Bundle.
   */
  public static ExplanationOfBenefit.Bundle explanationOfBenefitBundle() {
    return ExplanationOfBenefit.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/ExplanationOfBenefit?patient=1008679665V880686&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/ExplanationOfBenefit?patient=1008679665V880686&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/ExplanationOfBenefit?patient=1008679665V880686&page=1&_count=15")
                    .build()))
        .entry(
            ExplanationOfBenefit.Entry.builder().resource(explanationOfBenefit()).build().asList())
        .build();
  }
}
