package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Procedure;
import gov.va.api.health.dstu2.api.resources.Procedure.FocalDevice;
import gov.va.api.health.dstu2.api.resources.Procedure.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleProcedures {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  private FocalDevice focalDevice() {
    return Procedure.FocalDevice.builder()
        .id("2468")
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extension()))
        .action(codeableConcept())
        .manipulated(reference())
        .build();
  }

  Procedure.Performer performer() {
    return Procedure.Performer.builder()
        .id("9876")
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extension()))
        .actor(reference())
        .role(codeableConcept())
        .build();
  }

  public Procedure procedure() {
    return Procedure.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .subject(reference())
        .status(Status.in_progress)
        .category(codeableConcept())
        .code(codeableConcept())
        .notPerformed(false)
        .reasonNotPerformed(List.of(codeableConcept(), codeableConcept()))
        .bodySite(List.of(codeableConcept(), codeableConcept()))
        .reasonCodeableConcept(codeableConcept())
        .performer(List.of(performer(), performer()))
        .performedDateTime("2000-01-01T00:00:00-00:00")
        .encounter(reference())
        .location(reference())
        .outcome(codeableConcept())
        .complication(List.of(codeableConcept(), codeableConcept()))
        .followUp(List.of(codeableConcept(), codeableConcept()))
        .request(reference())
        .notes(List.of(annotation(), annotation()))
        .focalDevice(focalDevice().asList())
        .build();
  }
}
