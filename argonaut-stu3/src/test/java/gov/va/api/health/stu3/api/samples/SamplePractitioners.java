package gov.va.api.health.stu3.api.samples;

import gov.va.api.health.stu3.api.datatypes.HumanName;
import gov.va.api.health.stu3.api.datatypes.Identifier;
import gov.va.api.health.stu3.api.elements.Meta;
import gov.va.api.health.stu3.api.elements.Narrative;
import gov.va.api.health.stu3.api.resources.Practitioner;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SamplePractitioners {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Practitioner practitioner() {
    return Practitioner.builder()
        .id("2222")
        .meta(Meta.builder().build())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(Narrative.builder().build())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(Identifier.builder().build().asList())
        .active(true)
        .name(HumanName.builder().build().asList())
        .telecom(dataTypes.contactPoint().asList())
        .address(dataTypes.address().asList())
        .gender(Practitioner.Gender.male)
        .birthDate("2000-10-01")
        .photo(dataTypes.attachment().asList())
        .qualification(
            Practitioner.Qualification.builder()
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
