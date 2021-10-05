package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Practitioner;
import gov.va.api.health.dstu2.api.resources.Practitioner.Gender;
import gov.va.api.health.dstu2.api.resources.Practitioner.PractitionerRole;
import gov.va.api.health.dstu2.api.resources.Practitioner.Qualification;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SamplePractitioners {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Practitioner practitioner() {
    return Practitioner.builder()
        .id("2222")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .active(true)
        .name(dataTypes.humanName())
        .telecom(dataTypes.contactPoint().asList())
        .address(dataTypes.address().asList())
        .gender(Gender.male)
        .birthDate("2000-10-01")
        .photo(dataTypes.attachment().asList())
        .practitionerRole(
            PractitionerRole.builder()
                .managingOrganization(dataTypes.reference())
                .role(dataTypes.codeableConcept())
                .specialty(dataTypes.codeableConceptList())
                .period(dataTypes.period())
                .location(dataTypes.referenceList())
                .healthcareService(dataTypes.referenceList())
                .build()
                .asList())
        .qualification(
            Qualification.builder()
                .identifier(dataTypes.identifier().asList())
                .code(dataTypes.codeableConcept())
                .period(dataTypes.period())
                .issuer(dataTypes.reference())
                .build()
                .asList())
        .communication(dataTypes.codeableConceptList())
        .build();
  }
}
