package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Medication;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleMedications {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Medication.Batch batch() {
    return Medication.Batch.builder()
        .id("806")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .lotNumber("9995")
        .expirationDate("2015-04-15T04:00:00Z")
        .build();
  }

  public Medication.Ingredient ingredient() {
    return Medication.Ingredient.builder()
        .id("509")
        .extension(extension().asList())
        .itemCodeableConcept(codeableConcept())
        .isActive(true)
        .strength(ratio())
        .build();
  }

  public Medication medication() {
    return Medication.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .code(codeableConcept())
        .status(Medication.Status.entered_in_error)
        .manufacturer(reference())
        .form(codeableConcept())
        .amount(ratio())
        .ingredient(ingredient().asList())
        .batch(batch())
        .build();
  }
}
