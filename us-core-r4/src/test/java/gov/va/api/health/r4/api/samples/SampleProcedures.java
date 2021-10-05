package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Procedure;
import gov.va.api.health.r4.api.resources.Procedure.FocalDevice;
import gov.va.api.health.r4.api.resources.Procedure.Performer;
import gov.va.api.health.r4.api.resources.Procedure.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleProcedures {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public FocalDevice focalDevice() {
    return FocalDevice.builder()
        .id("987")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .action(codeableConcept())
        .manipulated(reference())
        .build();
  }

  public Performer performer() {
    return Performer.builder()
        .id("987")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .actor(reference())
        .function(codeableConcept())
        .onBehalfOf(reference())
        .build();
  }

  public Procedure procedure() {
    return Procedure.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .instantiatesCanonical(reference().asList())
        .instantiatesUri("http://InstantiateGoodnight.com")
        .basedOn(reference().asList())
        .partOf(reference().asList())
        .status(Status.completed)
        .statusReason(codeableConcept())
        .category(codeableConcept())
        .code(codeableConcept())
        .subject(reference())
        .encounter(reference())
        .performedDateTime("2015-04-15T04:00:00Z")
        .recorder(reference())
        .asserter(reference())
        .performer(performer().asList())
        .location(reference())
        .reasonCode(codeableConcept().asList())
        .reasonReference(reference().asList())
        .bodySite(codeableConcept().asList())
        .outcome(codeableConcept())
        .report(reference().asList())
        .complication(codeableConcept().asList())
        .complicationDetail(reference().asList())
        .followUp(codeableConcept().asList())
        .note(annotation().asList())
        .focalDevice(focalDevice().asList())
        .usedReference(reference().asList())
        .usedCode(codeableConcept().asList())
        .build();
  }
}
