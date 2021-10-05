package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Appointment;
import gov.va.api.health.r4.api.resources.Appointment.AppointmentStatus;
import gov.va.api.health.r4.api.resources.Appointment.Participant;
import gov.va.api.health.r4.api.resources.Appointment.ParticipationStatus;
import gov.va.api.health.r4.api.resources.Appointment.Required;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleAppointments {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Appointment appointment() {
    return Appointment.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(identifier().asList())
        .status(AppointmentStatus.booked)
        .cancelationReason(codeableConcept())
        .serviceCategory(codeableConcept().asList())
        .serviceType(codeableConcept().asList())
        .specialty(codeableConcept().asList())
        .appointmentType(codeableConcept())
        .reasonCode(codeableConcept().asList())
        .reasonReference(reference().asList())
        .priority(1)
        .description("Sample Appointment Description")
        .supportingInformation(reference().asList())
        .start("2015-02-07T13:28:17.239+02:00")
        .end("2015-02-07T15:28:17.239+02:00")
        .minutesDuration(120)
        .slot(reference().asList())
        .created("2015-02-07T13:28:17-05:00")
        .comment("Sample Appointment Comment")
        .patientInstruction("Sample Appt Patient Instruction")
        .basedOn(reference().asList())
        .participant(participant().asList())
        .requestedPeriod(period().asList())
        .build();
  }

  public Participant participant() {
    return Participant.builder()
        .type(codeableConcept().asList())
        .actor(reference())
        .required(Required.required)
        .status(ParticipationStatus.accepted)
        .period(period())
        .build();
  }
}
