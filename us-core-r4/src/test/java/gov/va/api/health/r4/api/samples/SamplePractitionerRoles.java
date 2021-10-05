package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.PractitionerRole;
import gov.va.api.health.r4.api.resources.PractitionerRole.DayOfWeek;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SamplePractitionerRoles {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public PractitionerRole.PractitionerAvailableTime availableTime() {
    return PractitionerRole.PractitionerAvailableTime.builder()
        .id("999")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .daysOfWeek(List.of(DayOfWeek.fri))
        .allDay(false)
        .availableStartTime("08:00:00")
        .availableEndTime("12:00:00")
        .build();
  }

  public PractitionerRole.PractitionerNotAvailable notAvailable() {
    return PractitionerRole.PractitionerNotAvailable.builder()
        .id("998")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .description("Bye")
        .during(period())
        .build();
  }

  public PractitionerRole practitionerRole() {
    return PractitionerRole.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .identifier(identifier().asList())
        .active(true)
        .period(period())
        .practitioner(reference())
        .organization(reference())
        .code(codeableConcept().asList())
        .specialty(codeableConcept().asList())
        .location(reference().asList())
        .healthcareService(reference().asList())
        .telecom(contactPoint().asList())
        .availableTime(availableTime().asList())
        .notAvailable(notAvailable().asList())
        .availabilityExceptions("Mondays")
        .endpoint(reference().asList())
        .build();
  }
}
