package gov.va.api.health.r4.api.samples;

import static gov.va.api.health.r4.api.resources.RelatedPerson.Gender.male;

import gov.va.api.health.r4.api.resources.RelatedPerson;
import gov.va.api.health.r4.api.resources.RelatedPerson.Communication;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleRelatedPersons {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Communication communication() {
    return Communication.builder().language(codeableConcept()).preferred(false).build();
  }

  public RelatedPerson relatedPerson() {
    return RelatedPerson.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .active(true)
        .patient(reference())
        .relationship(codeableConcept().asList())
        .name(humanName().asList())
        .telecom(contactPoint().asList())
        .gender(male)
        .birthDate("1998-09-10")
        .address(address().asList())
        .photo(attachment().asList())
        .period(period())
        .communication(communication().asList())
        .build();
  }
}
