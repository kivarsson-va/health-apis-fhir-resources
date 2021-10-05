package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.resources.Medication;
import java.util.List;

public class SwaggerMedication {
  /**
   * An example Medication.
   *
   * @return an example Medication.
   */
  public static Medication medication() {
    return Medication.builder()
        .id("f4163f35-1565-552b-a1b9-a2f8870e6f4a")
        .code(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("https://www.nlm.nih.gov/research/umls/rxnorm/")
                        .code("895994")
                        .display("120 Fluticasone propionate .044 MG/ACTUAT Inhaler")
                        .build()
                        .asList())
                .text("120 ACTUAT Fluticasone propionate .044 MG/ACTUAT Inhaler")
                .build())
        .product(
            Medication.Product.builder()
                .id("4024655")
                .form(CodeableConcept.builder().text("1 dose(s) 1 time(s) per 1 days").build())
                .build())
        .build();
  }

  /**
   * An example Medication.Bundle.
   *
   * @return an example Medication.Bundle.
   */
  public static final Medication.Bundle medicationBundle() {
    return Medication.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Medication?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Medication?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Medication?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            Medication.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/Medication/f4163f35-1565-552b-a1b9-a2f8870e6f4a")
                .resource(medication())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
