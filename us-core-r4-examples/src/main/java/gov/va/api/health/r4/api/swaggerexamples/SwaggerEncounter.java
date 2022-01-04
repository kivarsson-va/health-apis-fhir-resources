package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.Period;
import gov.va.api.health.r4.api.elements.Meta;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.Encounter;
import java.util.List;

public class SwaggerEncounter {
  /** Sample encounter. */
  public static Encounter encounter() {
    return Encounter.builder()
        .id("I2-5WR43OIGY4625GCVOZTBYODWIEVVWLDDWEDSXUTTHZCTHKKBIDTQ0000")
        .meta(Meta.builder().lastUpdated("2021-12-01T00:00:00Z").build())
        .status(Encounter.Status.finished)
        .type(CodeableConcept.builder().text("inpatient").build().asList())
        .serviceType(CodeableConcept.builder().text("inpatient").build())
        .subject(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient/1017283148V813263")
                .display("Mr. Aurelio227 Cruickshank494")
                .build())
        .period(Period.builder().start("2021-11-29").end("2021-12-01").build())
        .reasonCode(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://www.va.gov/Terminology/VistADefinedTerms/9000010-.07")
                        .version("9")
                        .code("780.4")
                        .display("DIZZINESS AND GIDDINESS")
                        .build()
                        .asList())
                .text("DIZZINESS AND GIDDINESS")
                .build()
                .asList())
        .hospitalization(
            Encounter.Hospitalization.builder()
                .dischargeDisposition(
                    CodeableConcept.builder()
                        .coding(
                            Coding.builder()
                                .system(
                                    "http://terminology.hl7.org/CodeSystem/discharge-disposition")
                                .code("X")
                                .display("RETURN TO COMMUNITY-INDEPENDENT")
                                .build()
                                .asList())
                        .text("RETURN TO COMMUNITY-INDEPENDENT")
                        .build())
                .build())
        .location(
            Encounter.Location.builder()
                .location(
                    Reference.builder()
                        .reference(
                            "https://sandbox-api.va.gov/services/fhir/v0/r4/Location/I2-2FPCKUIXVR7RJLLG34XVWGZERM000000")
                        .display("MENTAL HEALTH SERVICES")
                        .build())
                .build()
                .asList())
        .serviceProvider(
            Reference.builder()
                .reference(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Organization/I2-YCRI7L52BYQL63ZFALGWIWF2WU000000")
                .display("WASHINGTON VA MEDICAL CENTER")
                .build())
        .encounterClass(Coding.builder().display("IMP").build())
        .build();
  }

  /** Sample encounter bundle. */
  public static Encounter.Bundle encounterBundle() {
    return Encounter.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Encounter?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Encounter?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Encounter?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            Encounter.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/fhir/v0/r4/Encounter/I2-5WR43OIGY4625GCVOZTBYODWIEVVWLDDWEDSXUTTHZCTHKKBIDTQ0000")
                .resource(encounter())
                .build()
                .asList())
        .build();
  }
}
