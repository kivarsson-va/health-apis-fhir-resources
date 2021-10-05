package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.resources.Medication;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleMedications {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Medication.Batch batch() {
    return Medication.Batch.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .lotNumber("10")
        .expirationDate("2000-01-01T00:00:00-00:00")
        .build();
  }

  public CodeableConcept code() {
    return CodeableConcept.builder().coding(coding().asList()).text("HelloText").build();
  }

  public CodeableConcept container() {
    return CodeableConcept.builder().coding(coding().asList()).text("HelloText").build();
  }

  public Medication.Content content() {
    return Medication.Content.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .item(reference())
        .amount(simpleQuantity())
        .build();
  }

  public CodeableConcept form() {
    return CodeableConcept.builder().coding(coding().asList()).text("HelloText").build();
  }

  public Medication.Ingredient ingredient() {
    return Medication.Ingredient.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .item(reference())
        .amount(ratio())
        .build();
  }

  public Medication medication() {
    return Medication.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .code(code())
        .isBrand(true)
        .manufacturer(reference())
        .product(product())
        .medicationPackage(medicationPackage())
        .build();
  }

  public Medication.MedicationPackage medicationPackage() {
    return Medication.MedicationPackage.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .container(container())
        .content(content().asList())
        .build();
  }

  public Medication.Product product() {
    return Medication.Product.builder()
        .id("8888")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .form(form())
        .ingredient(ingredient())
        .batch(batch().asList())
        .build();
  }
}
