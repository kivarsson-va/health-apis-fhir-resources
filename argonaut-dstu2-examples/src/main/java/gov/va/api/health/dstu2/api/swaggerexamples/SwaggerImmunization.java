package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.Immunization;
import java.util.List;

public class SwaggerImmunization {
  /**
   * An example Immunization.
   *
   * @return an example Immunization.
   */
  public static Immunization immunization() {
    return Immunization.builder()
        .id("1fd82e3a-a95b-5c04-9a68-c8ddf740ea0c")
        .status(Immunization.Status.completed)
        .date("2017-04-24T01:15:52Z")
        .vaccineCode(
            CodeableConcept.builder()
                .text("meningococcal MCV4P")
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/sid/cvx")
                        .code("114")
                        .build()
                        .asList())
                .build())
        .patient(
            Reference.builder()
                .reference("https://sandbox-api.va.gov/services/argonaut/v0/Patient/2000163")
                .display("Mr. Aurelio227 Cruickshank494")
                .build())
        .wasNotGiven(false)
        ._reported(
            Extension.builder()
                .extension(
                    Extension.builder()
                        .url("http://hl7.org/fhir/StructureDefinition/data-absent-reason")
                        .valueCode("unsupported")
                        .build()
                        .asList())
                .build())
        .reaction(
            Immunization.Reaction.builder()
                .detail(Reference.builder().display("Lethargy").build())
                .build()
                .asList())
        .build();
  }

  /**
   * An example Immunization.Bundle.
   *
   * @return an example Immunization.Bundle.
   */
  public static Immunization.Bundle immunizationBundle() {
    return Immunization.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Immunization?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Immunization?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Immunization?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            Immunization.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/Immunization/1fd82e3a-a95b-5c04-9a68-c8ddf740ea0c")
                .resource(immunization())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
