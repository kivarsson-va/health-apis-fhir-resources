package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Slot;
import gov.va.api.health.r4.api.resources.Slot.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleSlots {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Slot slot() {
    return Slot.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(List.of(identifier()))
        .serviceCategory(List.of(codeableConcept()))
        .serviceType(List.of(codeableConcept()))
        .specialty(List.of(codeableConcept()))
        .appointmentType(codeableConcept())
        .schedule(reference())
        .status(Status.busy)
        .start("2017-01-01T00:00:00Z")
        .end("2017-01-01T00:00:00Z")
        .overbooked(true)
        .comment("comment")
        .build();
  }
}
