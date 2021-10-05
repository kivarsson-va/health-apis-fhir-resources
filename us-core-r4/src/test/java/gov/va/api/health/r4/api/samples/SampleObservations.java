package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.resources.Observation;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleObservations {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public CodeableConcept category() {
    return CodeableConcept.builder()
        .coding(
            Coding.builder()
                .system("http://terminology.hl7.org/CodeSystem/observation-category")
                .code("laboratory")
                .build()
                .asList())
        .build();
  }

  public Observation.Component component() {
    return Observation.Component.builder()
        .id("1234")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .code(codeableConcept())
        .valuePeriod(period())
        .dataAbsentReason(codeableConcept())
        .interpretation(codeableConcept().asList())
        .referenceRange(referenceRange().asList())
        .build();
  }

  public Observation observation() {
    return Observation.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .basedOn(reference().asList())
        .partOf(reference().asList())
        .status(Observation.ObservationStatus.unknown)
        .category(category().asList())
        .code(codeableConcept())
        .subject(reference())
        .focus(reference().asList())
        .encounter(reference())
        .effectiveDateTime("2015-04-15T04:00:00Z")
        .issued("2015-04-15T04:00:00Z")
        .performer(reference().asList())
        .valueQuantity(quantity())
        .dataAbsentReason(codeableConcept())
        .interpretation(codeableConcept().asList())
        .note(annotation().asList())
        .bodySite(codeableConcept())
        .method(codeableConcept())
        .specimen(reference())
        .device(reference())
        .referenceRange(referenceRange().asList())
        .hasMember(reference().asList())
        .derivedFrom(reference().asList())
        .component(component().asList())
        .build();
  }

  public Observation.ReferenceRange referenceRange() {
    return Observation.ReferenceRange.builder()
        .id("1234")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .low(simpleQuantity())
        .high(simpleQuantity())
        .type(codeableConcept())
        .appliesTo(codeableConcept().asList())
        .age(range())
        .text("Best Test Text")
        .build();
  }
}
