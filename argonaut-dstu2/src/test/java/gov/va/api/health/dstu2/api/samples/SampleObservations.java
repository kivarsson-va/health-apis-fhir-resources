package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.resources.Observation;
import gov.va.api.health.dstu2.api.resources.Observation.ObservationComponent;
import gov.va.api.health.dstu2.api.resources.Observation.ObservationReferenceRange;
import gov.va.api.health.dstu2.api.resources.Observation.ObservationRelated;
import gov.va.api.health.dstu2.api.resources.Observation.Status;
import gov.va.api.health.dstu2.api.resources.Observation.Type;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * This class provides data structures that are populated with dummy values, suitable for testing
 * serialization.
 */
@SuppressWarnings("WeakerAccess")
@NoArgsConstructor(staticName = "get")
public class SampleObservations {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  private CodeableConcept category() {
    return CodeableConcept.builder()
        .coding(
            Coding.builder()
                .system("http://hl7.org/fhir/observation-category")
                .code("ok")
                .build()
                .asList())
        .text("dat category")
        .build();
  }

  public ObservationComponent component() {
    return ObservationComponent.builder()
        .id("0000")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .code(codeableConcept())
        .valueCodeableConcept(codeableConcept())
        .dataAbsentReason(codeableConcept())
        .referenceRange(referenceRange().asList())
        .build();
  }

  public Observation observation() {
    return Observation.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .status(Status.registered)
        .category(category())
        .code(codeableConcept())
        .subject(reference())
        .encounter(reference())
        .effectiveDateTime("2000-01-01T00:00:00-00:00")
        .issued("2000-01-01T00:00:00-00:00")
        .performer(reference().asList())
        .valueSampledData(sampledData())
        .dataAbsentReason(codeableConcept())
        .interpretation(codeableConcept())
        .comments("HelloText")
        .bodySite(codeableConcept())
        .method(codeableConcept())
        .specimen(reference())
        .device(reference())
        .referenceRange(referenceRange().asList())
        .related(related().asList())
        .component(component().asList())
        .build();
  }

  public ObservationReferenceRange referenceRange() {
    return ObservationReferenceRange.builder()
        .id("0000")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .low(simpleQuantity())
        .high(simpleQuantity())
        .meaning(codeableConcept())
        .age(range())
        .text("HelloText")
        .build();
  }

  public ObservationRelated related() {
    return ObservationRelated.builder()
        .id("0000")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .type(Type.has_member)
        .target(reference())
        .build();
  }
}
