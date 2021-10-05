package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Patient;
import gov.va.api.health.r4.api.resources.Patient.Communication;
import gov.va.api.health.r4.api.resources.Patient.Gender;
import gov.va.api.health.r4.api.resources.Patient.Link;
import gov.va.api.health.r4.api.resources.Patient.PatientContact;
import gov.va.api.health.r4.api.resources.Patient.Type;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SamplePatients {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Communication communication() {
    return Communication.builder().language(codeableConcept()).preferred(true).build();
  }

  public Link link() {
    return Link.builder().other(reference()).type(Type.seealso).build();
  }

  public Patient patient() {
    return Patient.builder()
        .id("1324")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(usCoreEthnicityExtension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .active(true)
        .name(humanName().asList())
        .telecom(contactPoint().asList())
        .gender(Gender.unknown)
        .birthDate("2000-01-01")
        .deceasedBoolean(true)
        .address(address().asList())
        .maritalStatus(codeableConcept())
        .multipleBirthInteger(2)
        .photo(attachment().asList())
        .contact(patientContact().asList())
        .communication(communication().asList())
        .generalPractitioner(reference().asList())
        .managingOrganization(reference())
        .link(link().asList())
        .build();
  }

  public PatientContact patientContact() {
    return PatientContact.builder()
        .relationship(codeableConcept().asList())
        .name(humanName())
        .telecom(contactPoint().asList())
        .address(address())
        .gender(Gender.unknown)
        .organization(reference())
        .period(period())
        .build();
  }
}
