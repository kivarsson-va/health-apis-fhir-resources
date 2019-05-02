package gov.va.api.health.stu3.api.samples;

import static java.util.Collections.singletonList;

import gov.va.api.health.stu3.api.resources.Appointment;
import gov.va.api.health.stu3.api.resources.Appointment.Participant;
import gov.va.api.health.stu3.api.resources.Appointment.ParticipantRequired;
import gov.va.api.health.stu3.api.resources.Appointment.ParticipantStatus;
import gov.va.api.health.stu3.api.resources.Appointment.Status;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleAppointments {

  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Appointment appointment() {
    return Appointment.builder()
        .identifier(singletonList(identifier()))
        .status(Status.entered_in_error)
        .serviceCategory(codeableConcept())
        .serviceType(singletonList(codeableConcept()))
        .specialty(singletonList(codeableConcept()))
        .appointmentType(codeableConcept())
        .reason(singletonList(codeableConcept()))
        .indication(singletonList(reference()))
        .priority(1)
        .description("Appointment description")
        .supportingInformation(singletonList(reference()))
        .start("1970-01-01T00:00:00Z")
        .end("1970-01-01T00:00:00Z")
        .minutesDuration(15)
        .slot(singletonList(reference()))
        .created("1970-01-01T00:00:00Z")
        .comment("Appointment comment")
        .incomingReferral(singletonList(reference()))
        .participant(singletonList(participant()))
        .requestedPeriod(singletonList(period()))
        .build();
  }

  public Participant participant() {
    return Participant.builder()
        .type(singletonList(codeableConcept()))
        .actor(reference())
        .required(ParticipantRequired.required)
        .status(ParticipantStatus.accepted)
        .build();
  }
}
