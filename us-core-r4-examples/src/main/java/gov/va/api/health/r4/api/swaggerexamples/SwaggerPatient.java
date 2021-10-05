package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.Address;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.ContactPoint;
import gov.va.api.health.r4.api.datatypes.HumanName;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.resources.Patient;
import java.util.List;

public class SwaggerPatient {
  /**
   * An example Patient.
   *
   * @return an example Patient.
   */
  public static Patient patient() {
    return Patient.builder()
        .id("2000163")
        .extension(
            List.of(
                Extension.builder()
                    .url("http://hl7.org/fhir/us/core/StructureDefinition/us-core-race")
                    .extension(
                        List.of(
                            Extension.builder()
                                .url("ombCategory")
                                .valueCoding(
                                    Coding.builder()
                                        .system(
                                            "https://www.hl7.org/fhir/us/core/CodeSystem-cdcrec.html")
                                        .code("2016-3")
                                        .display("White")
                                        .build())
                                .build(),
                            Extension.builder().url("text").valueString("White").build()))
                    .build(),
                Extension.builder()
                    .url("http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity")
                    .extension(
                        List.of(
                            Extension.builder()
                                .url("ombCategory")
                                .valueCoding(
                                    Coding.builder()
                                        .system(
                                            "https://www.hl7.org/fhir/us/core/CodeSystem-cdcrec.html")
                                        .code("2186-5")
                                        .display("Not Hispanic or Latino")
                                        .build())
                                .build(),
                            Extension.builder()
                                .url("text")
                                .valueString("Not Hispanic or Latino")
                                .build()))
                    .build(),
                Extension.builder()
                    .url("http://hl7.org/fhir/us/core/StructureDefinition/us-core-birthsex")
                    .valueCode("M")
                    .build()))
        .identifier(
            List.of(
                Identifier.builder()
                    .use(Identifier.IdentifierUse.usual)
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                Coding.builder()
                                    .system("http://hl7.org/fhir/v2/0203")
                                    .code("MR")
                                    .build()
                                    .asList())
                            .build())
                    .system("http://va.gov/mpi")
                    .value("2000163")
                    .build(),
                Identifier.builder()
                    .use(Identifier.IdentifierUse.official)
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                Coding.builder()
                                    .system("http://hl7.org/fhir/v2/0203")
                                    .code("SB")
                                    .build()
                                    .asList())
                            .build())
                    .system("http://hl7.org/fhir/sid/us-ssn")
                    .value("999-61-4803")
                    .build()))
        .name(
            HumanName.builder()
                .use(HumanName.NameUse.usual)
                .text("Mr. Aurelio227 Cruickshank494")
                .family("Cruickshank494")
                .given(List.of("Aurelio227"))
                .build()
                .asList())
        .telecom(
            List.of(
                ContactPoint.builder()
                    .system(ContactPoint.ContactPointSystem.phone)
                    .value("5555191065")
                    .use(ContactPoint.ContactPointUse.mobile)
                    .build(),
                ContactPoint.builder()
                    .system(ContactPoint.ContactPointSystem.email)
                    .value("Aurelio227.Cruickshank494@email.example")
                    .build()))
        .gender(Patient.Gender.male)
        .birthDate("1995-02-06")
        .deceasedBoolean(false)
        .address(
            Address.builder()
                .line(List.of("909 Rohan Highlands"))
                .city("Mesa")
                .state("Arizona")
                .postalCode("85120")
                .build()
                .asList())
        .maritalStatus(
            CodeableConcept.builder()
                .coding(
                    Coding.builder()
                        .system("http://hl7.org/fhir/R4/v3/NullFlavor/cs.html")
                        .code("UNK")
                        .display("unknown")
                        .build()
                        .asList())
                .build())
        .build();
  }

  /**
   * An example Bundle.
   *
   * @return an example Bundle.
   */
  public static Patient.Bundle patientBundle() {
    return Patient.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient?identifier=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient?identifier=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/Patient?identifer=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(Patient.Entry.builder().resource(patient()).build().asList())
        .build();
  }
}
