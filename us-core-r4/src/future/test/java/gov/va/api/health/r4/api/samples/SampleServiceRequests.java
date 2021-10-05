package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.ServiceRequest;
import gov.va.api.health.r4.api.resources.ServiceRequest.Intent;
import gov.va.api.health.r4.api.resources.ServiceRequest.Priority;
import gov.va.api.health.r4.api.resources.ServiceRequest.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleServiceRequests {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public ServiceRequest serviceRequest() {
    return ServiceRequest.builder()
        .id("1234")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(List.of(extension(), extension()))
        .modifierExtension(List.of(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(List.of(identifier()))
        .instantiatesCanonical(List.of("canonical"))
        .instantiatesUri(List.of("uri"))
        .basedOn(List.of(reference()))
        .replaces(List.of(reference()))
        .requisition(identifier())
        .status(Status.active)
        .intent(Intent.plan)
        .category(List.of(codeableConcept()))
        .priority(Priority.asap)
        .doNotPerform(false)
        .code(codeableConcept())
        .orderDetail(List.of(codeableConcept()))
        .quantityQuantity(quantity())
        .subject(reference())
        .encounter(reference())
        .occurrencePeriod(period())
        .asNeededBoolean(true)
        .authoredOn("2015-02-07T13:28:17-05:00")
        .requester(reference())
        .performerType(codeableConcept())
        .performer(List.of(reference()))
        .locationCode(List.of(codeableConcept()))
        .locationReference(List.of(reference()))
        .reasonCode(List.of(codeableConcept()))
        .reasonReference(List.of(reference()))
        .insurance(List.of(reference()))
        .supportingInfo(List.of(reference()))
        .specimen(List.of(reference()))
        .bodySite(List.of(codeableConcept()))
        .note(List.of(annotation()))
        .patientInstruction("patient instruction")
        .relevantHistory(List.of(reference()))
        .build();
  }
}
