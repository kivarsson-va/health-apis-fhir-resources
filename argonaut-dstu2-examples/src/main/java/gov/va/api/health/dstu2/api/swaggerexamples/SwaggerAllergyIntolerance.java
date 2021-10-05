package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.Annotation;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.AllergyIntolerance;
import java.util.List;

public class SwaggerAllergyIntolerance {
  /**
   * An example AllergyIntolerance.
   *
   * @return an example AllegryIntolerance.
   */
  public static AllergyIntolerance allergyIntolerance() {
    return AllergyIntolerance.builder()
        .id("6f9a021b-07d5-53c8-8cce-b49a694d4ad9")
        .onset("1995-04-30T01:15:52Z")
        .patient(
            Reference.builder()
                .reference("https://sandbox-api.va.gov/services/argonaut/v0/Patient/2000163")
                .display("Mr. Aurelio227 Cruickshank494")
                .build())
        .substance(CodeableConcept.builder().text("Allergy to peanuts").build())
        .status(AllergyIntolerance.Status.active)
        .type(AllergyIntolerance.Type.allergy)
        .category(AllergyIntolerance.Category.food)
        .note(Annotation.builder().time("1995-04-30T01:15:52Z").text("Allergy to peanuts").build())
        .reaction(
            AllergyIntolerance.Reaction.builder()
                .manifestation(
                    CodeableConcept.builder()
                        .coding(
                            Coding.builder()
                                .display("Inflammation of Skin")
                                .system("urn:oid:2.16.840.1.113883.6.233")
                                .code("2000001")
                                .build()
                                .asList())
                        .text("Inflammation of Skin")
                        .build()
                        .asList())
                .certainty(AllergyIntolerance.Certainty.likely)
                .build()
                .asList())
        .build();
  }

  /**
   * An example AllergyIntolerance.Bundle.
   *
   * @return an example AllegryIntolerance.Bundle.
   */
  public static AllergyIntolerance.Bundle allergyIntoleranceBundle() {
    return AllergyIntolerance.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/AllergyIntolerance?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/AllergyIntolerance?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/AllergyIntolerance?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            AllergyIntolerance.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/AllergyIntolerance/6f9a021b-07d5-53c8-8cce-b49a694d4ad9")
                .resource(allergyIntolerance())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
