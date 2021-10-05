package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Appointment;
import gov.va.api.health.dstu2.api.resources.Appointment.Participant;
import gov.va.api.health.dstu2.api.resources.Appointment.Participant.ParticipantStatus;
import gov.va.api.health.dstu2.api.resources.Appointment.Participant.RequiredCode;
import gov.va.api.health.dstu2.api.resources.Appointment.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleAppointments {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Appointment appointment() {
    return Appointment.builder()
        .id("2222")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .text(narrative())
        .contained(resource().asList())
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .status(Status.proposed)
        .type(dataTypes.codeableConcept())
        .reason(dataTypes.codeableConcept())
        .priority(1)
        .description("Description")
        .start("1970-01-01T00:00:00Z")
        .end("1970-01-01T00:00:00Z")
        .minutesDuration(5)
        .slot(dataTypes.reference().asList())
        .comment("Comment")
        .participant(
            Participant.builder()
                .type(List.of(dataTypes.codeableConcept(), dataTypes.codeableConcept()))
                .actor(dataTypes.reference())
                .required(RequiredCode.information_only)
                .status(ParticipantStatus.needs_action)
                .build()
                .asList())
        .build();
  }
}
