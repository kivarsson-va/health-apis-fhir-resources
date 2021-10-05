package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.datatypes.HumanName;
import gov.va.api.health.dstu2.api.datatypes.Identifier;
import gov.va.api.health.dstu2.api.elements.Extension;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.Patient;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleExtensions {
  List<Identifier> identifier() {
    List<Identifier> identifiers = new LinkedList<>();
    identifiers.add(
        Identifier.builder()
            .use(Identifier.IdentifierUse.usual)
            .type(
                CodeableConcept.builder()
                    .coding(
                        Coding.builder().system("http://test-code").code("C0D3").build().asList())
                    .build())
            .system("http://test-system")
            .value("123456789")
            .assigner(Reference.builder().display("tester-test-index").build())
            .build());

    return identifiers;
  }

  public List<Extension> multipleOptionalEthnicityExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> ethnicityExtensions = new LinkedList<>();
    ethnicityExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/ValueSet/v3-Ethnicity")
                    .code("2135-2")
                    .display("Hispanic or Latino")
                    .build())
            .build());
    ethnicityExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Ethnicity")
                    .code("2137-8")
                    .display("Spaniard")
                    .build())
            .build());
    ethnicityExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Ethnicity")
                    .code("2138-6")
                    .display("Andalusian")
                    .build())
            .build());
    ethnicityExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Ethnicity")
                    .code("2139-4")
                    .display("Asturian")
                    .build())
            .build());
    ethnicityExtensions.add(Extension.builder().url("text").valueString("Spaniard").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());
    return extensions;
  }

  public List<Extension> multipleOptionalRaceExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> raceExtensions = new LinkedList<>();
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("1002-5")
                    .display("American Indian or Alaska Native")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("2028-9")
                    .display("Asian")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("2054-5")
                    .display("Black or African American")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("1004-1")
                    .display("American Indian")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("1006-6")
                    .display("Abenaki")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("1008-2")
                    .display("Algonquian")
                    .build())
            .build());
    raceExtensions.add(Extension.builder().url("text").valueString("testa").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-race")
            .extension(raceExtensions)
            .build());
    return extensions;
  }

  public List<HumanName> name() {
    return HumanName.builder()
        .use(HumanName.NameUse.usual)
        .text("FOOMAN FOO")
        .family(List.of("FOO"))
        .given(List.of("FOOMAN"))
        .build()
        .asList();
  }

  public List<Extension> noRequiredEthnicityExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> ethnicityExtensions = new LinkedList<>();
    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());
    return extensions;
  }

  public List<Extension> noRequiredRaceExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> raceExtensions = new LinkedList<>();
    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-race")
            .extension(raceExtensions)
            .build());
    return extensions;
  }

  public List<Extension> nullEthnicityExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> raceExtensions = new LinkedList<>();
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/ValueSet/v3-Ethnicity")
                    .code("2135-2")
                    .display("Hispanic or Latino")
                    .build())
            .build());
    raceExtensions.add(Extension.builder().url("text").valueString("tester").build());
    extensions.add(Extension.builder().url("http://test-race").extension(raceExtensions).build());
    extensions.add(Extension.builder().url("http://test-birthsex").valueCode("M").build());
    return extensions;
  }

  public List<Extension> nullRaceExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> ethnicityExtensions = new LinkedList<>();
    ethnicityExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/ValueSet/v3-Ethnicity")
                    .code("2135-2")
                    .display("Hispanic or Latino")
                    .build())
            .build());
    ethnicityExtensions.add(Extension.builder().url("text").valueString("Spaniard").build());
    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());
    extensions.add(Extension.builder().url("http://test-birthsex").valueCode("M").build());
    return extensions;
  }

  private Patient patientWith(List<Extension> extension) {
    return Patient.builder()
        .extension(extension)
        .identifier(identifier())
        .gender(Patient.Gender.unknown)
        .name(name())
        .build();
  }

  public Patient patientWithMultipleOptionalEthnicityExtension() {
    return patientWith(multipleOptionalEthnicityExtension());
  }

  public Patient patientWithMultipleOptionalRaceExtension() {
    return patientWith(multipleOptionalRaceExtension());
  }

  public Patient patientWithNoRequiredEthnicityExtension() {
    return patientWith(noRequiredEthnicityExtension());
  }

  public Patient patientWithNoRequiredRaceExtension() {
    return patientWith(noRequiredRaceExtension());
  }

  public Patient patientWithNullEthnicityExtension() {
    return patientWith(nullEthnicityExtension());
  }

  public Patient patientWithNullRaceExtension() {
    return patientWith(nullRaceExtension());
  }

  public Patient patientWithSingleOptionalEthnicityExtension() {
    return patientWith(singleOptionalEthnicityExtension());
  }

  public Patient patientWithSingleOptionalRaceExtension() {
    return patientWith(singleOptionalRaceExtension());
  }

  public Patient patientWithSingleRequiredEthnicityExtension() {
    return patientWith(singleRequiredEthnicityExtension());
  }

  public Patient patientWithSingleRequiredRaceExtension() {
    return patientWith(singleRequiredRaceExtension());
  }

  public Patient patientWithTooManyOptionalEthnicityExtension() {
    return patientWith(tooManyOptionalEthnicityExtension());
  }

  public Patient patientWithTooManyOptionalRaceExtension() {
    return patientWith(tooManyOptionalRaceExtension());
  }

  public Patient patientWithTooManyRequiredEthnicityExtension() {
    return patientWith(tooManyRequiredEthnicityExtension());
  }

  public Patient patientWithTooManyRequiredRaceExtension() {
    return patientWith(tooManyRequiredRaceExtension());
  }

  List<Extension> singleOptionalEthnicityExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> ethnicityExtensions = new LinkedList<>();
    ethnicityExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/ValueSet/v3-Ethnicity")
                    .code("2135-2")
                    .display("Hispanic or Latino")
                    .build())
            .build());
    ethnicityExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Ethnicity")
                    .code("2137-8")
                    .display("Spaniard")
                    .build())
            .build());
    ethnicityExtensions.add(Extension.builder().url("text").valueString("testa").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());
    return extensions;
  }

  List<Extension> singleOptionalRaceExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> raceExtensions = new LinkedList<>();
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("1002-5")
                    .display("American Indian or Alaska Native")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("detailed")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("1004-1")
                    .display("American Indian")
                    .build())
            .build());
    raceExtensions.add(Extension.builder().url("text").valueString("testa").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-race")
            .extension(raceExtensions)
            .build());
    return extensions;
  }

  List<Extension> singleRequiredEthnicityExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> raceExtensions = new LinkedList<>();
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/ValueSet/v3-Ethnicity")
                    .code("2135-2")
                    .display("Hispanic or Latino")
                    .build())
            .build());
    raceExtensions.add(Extension.builder().url("text").valueString("tester").build());

    List<Extension> ethnicityExtensions = new LinkedList<>();
    ethnicityExtensions.add(Extension.builder().url("text").valueString("Spaniard").build());

    extensions.add(Extension.builder().url("http://test-race").extension(raceExtensions).build());
    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());
    extensions.add(Extension.builder().url("http://test-birthsex").valueCode("M").build());
    return extensions;
  }

  List<Extension> singleRequiredRaceExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> raceExtensions = new LinkedList<>();
    raceExtensions.add(
        Extension.builder().url("text").valueString("American Indian or Alaska Native").build());

    List<Extension> ethnicityExtensions = new LinkedList<>();
    ethnicityExtensions.add(Extension.builder().url("text").valueString("Spaniard").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-race")
            .extension(raceExtensions)
            .build());
    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());
    extensions.add(Extension.builder().url("http://test-birthsex").valueCode("M").build());
    return extensions;
  }

  List<Extension> tooManyOptionalEthnicityExtension() {
    List<Extension> extensions = new ArrayList<>(3);
    List<Extension> ethnicityExtensions = new LinkedList<>();

    ethnicityExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/ValueSet/v3-Ethnicity")
                    .code("2135-2")
                    .display("Hispanic or Latino")
                    .build())
            .build());

    ethnicityExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/ValueSet/v3-Ethnicity")
                    .code("2135-2")
                    .display("Hispanic or Latino")
                    .build())
            .build());

    ethnicityExtensions.add(Extension.builder().url("text").valueString("Spaniard").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());

    return extensions;
  }

  List<Extension> tooManyOptionalRaceExtension() {
    List<Extension> extensions = new ArrayList<>(3);
    List<Extension> raceExtensions = new LinkedList<>();
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("1002-5")
                    .display("American Indian or Alaska Native")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("2028-9")
                    .display("Asian")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("2054-5")
                    .display("Black or African American")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("2076-8")
                    .display("Native Hawaiian or Other Pacific Islander")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/Race")
                    .code("2106-3")
                    .display("White")
                    .build())
            .build());
    raceExtensions.add(
        Extension.builder()
            .url("ombCategory")
            .valueCoding(
                Coding.builder()
                    .system("http://hl7.org/fhir/v3/NullFlavor")
                    .code("UNK")
                    .display("Unknown")
                    .build())
            .build());

    raceExtensions.add(Extension.builder().url("text").valueString("American Indian").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-race")
            .extension(raceExtensions)
            .build());

    return extensions;
  }

  List<Extension> tooManyRequiredEthnicityExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> ethnicityExtensions = new LinkedList<>();
    ethnicityExtensions.add(Extension.builder().url("text").valueString("Spaniard").build());
    ethnicityExtensions.add(Extension.builder().url("text").valueString("Andalusian").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(ethnicityExtensions)
            .build());
    return extensions;
  }

  List<Extension> tooManyRequiredRaceExtension() {
    List<Extension> extensions = new ArrayList<>(3);

    List<Extension> raceExtensions = new LinkedList<>();
    raceExtensions.add(Extension.builder().url("text").valueString("American Indian").build());
    raceExtensions.add(Extension.builder().url("text").valueString("Abenaki").build());

    extensions.add(
        Extension.builder()
            .url("http://fhir.org/guides/argonaut/StructureDefinition/argo-ethnicity")
            .extension(raceExtensions)
            .build());
    return extensions;
  }
}
