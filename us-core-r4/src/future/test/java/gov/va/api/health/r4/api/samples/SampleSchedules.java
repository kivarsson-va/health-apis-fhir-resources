package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Schedule;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleSchedules {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Schedule schedule() {
    return Schedule.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(List.of(identifier()))
        .active(true)
        .serviceCategory(List.of(codeableConcept()))
        .serviceType(List.of(codeableConcept()))
        .specialty(List.of(codeableConcept()))
        .actor(List.of(reference()))
        .planningHorizon(period())
        .comment("comment")
        .build();
  }
}
