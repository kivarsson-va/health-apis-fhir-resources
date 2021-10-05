package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.HealthcareService;
import gov.va.api.health.r4.api.resources.HealthcareService.AvailableTime;
import gov.va.api.health.r4.api.resources.HealthcareService.AvailableTime.DaysOfWeek;
import gov.va.api.health.r4.api.resources.HealthcareService.Eligibility;
import gov.va.api.health.r4.api.resources.HealthcareService.NotAvailable;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleHealthcareServices {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public AvailableTime availableTime() {
    return AvailableTime.builder()
        .daysOfWeek(List.of(DaysOfWeek.mon, DaysOfWeek.fri))
        .allDay(false)
        .availableStartTime("03:00:00")
        .availableEndTime("05:00:00")
        .build();
  }

  public Eligibility eligibility() {
    return Eligibility.builder().code(codeableConcept()).comment("# comment").build();
  }

  public HealthcareService healthcareService() {
    return HealthcareService.builder()
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
        .providedBy(reference())
        .category(List.of(codeableConcept()))
        .type(List.of(codeableConcept()))
        .specialty(List.of(codeableConcept()))
        .location(List.of(reference()))
        .name("name")
        .comment("comment")
        .extraDetails("# extra details")
        .photo(attachment())
        .telecom(List.of(contactPoint()))
        .coverageArea(List.of(reference()))
        .serviceProvisionCode(List.of(codeableConcept()))
        .eligibility(List.of(eligibility()))
        .program(List.of(codeableConcept()))
        .characteristic(List.of(codeableConcept()))
        .communication(List.of(codeableConcept()))
        .referralMethod(List.of(codeableConcept()))
        .appointmentRequired(true)
        .availableTime(List.of(availableTime()))
        .notAvailable(List.of(notAvailable()))
        .availabilityExceptions("available exceptions")
        .endpoint(List.of(reference()))
        .build();
  }

  public NotAvailable notAvailable() {
    return NotAvailable.builder().description("description").during(period()).build();
  }
}
