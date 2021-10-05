package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.r4.api.bundle.AbstractEntry.Search;
import gov.va.api.health.r4.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.Procedure;
import gov.va.api.health.r4.api.resources.Procedure.Status;
import java.util.List;

public class SwaggerProcedure {
  /**
   * An example Procedure.
   *
   * @return an example Procedure.
   */
  public static Procedure procedure() {
    return Procedure.builder()
        .id("I2-AOV4FXGQLPIXGZPTMTWY7Y7KJ4000000")
        .subject(
            Reference.builder()
                .reference("https://sandbox-api.va.gov/services/r4/v0/Patient/32000225")
                .display("Mrs. Sheba703 Harris789")
                .build())
        .status(Status.completed)
        .code(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .code("XXXXX")
                        .system("http://www.ama-assn.org/go/cpt")
                        .display("Renal dialysis (procedure)")
                        .build()
                        .asList())
                .build())
        .performedDateTime("1996-06-25T02:42:52Z")
        .location(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/r4/v0/Location/I2-C4YZL2HYFARY5F75TSUENODC6U000000")
                .display("Behavioral Health Facility")
                .build())
        .build();
  }

  /**
   * An example Procedure.
   *
   * @return an example Procedure.
   */
  public static Procedure.Bundle procedureBundle() {
    return Procedure.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/r4/v0/Procedure?patient=32000225&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/r4/v0/Procedure?patient=32000225&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/r4/v0/Procedure?patient=32000225&page=1&_count=15")
                    .build()))
        .entry(
            Procedure.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/r4/v0/Procedure/I2-AOV4FXGQLPIXGZPTMTWY7Y7KJ4000000")
                .resource(procedure())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
