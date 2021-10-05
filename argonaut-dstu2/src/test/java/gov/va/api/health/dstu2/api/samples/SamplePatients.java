package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.datatypes.Attachment;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.resources.Patient;
import gov.va.api.health.dstu2.api.resources.Patient.Communication;
import gov.va.api.health.dstu2.api.resources.Patient.Contact;
import gov.va.api.health.dstu2.api.resources.Patient.PatientLink;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * This class provides data structures that are populated with dummy values, suitable for testing
 * serialization.
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SamplePatients {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Communication communication() {
    return Communication.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .language(language())
        .preferred(false)
        .build();
  }

  Contact contact() {
    return Contact.builder()
        .id("0000")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .relationship(relationship().asList())
        .name(humanName())
        .telecom(contactPointList())
        .address(address())
        .gender(Patient.Gender.unknown)
        .organization(reference())
        .period(period())
        .build();
  }

  public CodeableConcept language() {
    return CodeableConcept.builder().coding(coding().asList()).text("HelloText").build();
  }

  public Patient.PatientLink link() {
    return PatientLink.builder()
        .id("7777")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .other(reference())
        .type("HelloType")
        .build();
  }

  public CodeableConcept maritalStatus() {
    return CodeableConcept.builder().coding(coding().asList()).text("HelloText").build();
  }

  public Patient patient() {
    return Patient.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .active(true)
        .name(humanName().asList())
        .telecom(contactPointList())
        .gender(Patient.Gender.unknown)
        .birthDate("2000-01-01")
        .deceasedBoolean(false)
        .address(address().asList())
        .maritalStatus(maritalStatus())
        .multipleBirthBoolean(false)
        .photo(photo().asList())
        .contact(contact().asList())
        .communication(communication().asList())
        .careProvider(reference().asList())
        .managingOrganization(reference())
        .link(link().asList())
        .build();
  }

  public Attachment photo() {
    return Attachment.builder()
        .contentType("HelloType")
        .language("HelloLanguage")
        .data("SSBqdXN0IGF0ZSBhIHBlYW51dAo=")
        .url("http://HelloUrl.com")
        .size(1)
        .hash("SSBqdXN0IGF0ZSBhIHBlYW51dAo=")
        .title("HelloTitle")
        .creation("2000-01-01T00:00:00-00:00")
        .build();
  }

  public CodeableConcept relationship() {
    return CodeableConcept.builder().coding(coding().asList()).text("HelloText").build();
  }
}
