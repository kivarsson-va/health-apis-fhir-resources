package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.CodeableConcept;
import gov.va.api.health.dstu2.api.datatypes.Coding;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.Appointment;
import java.util.List;

public class SwaggerAppointment {
  /**
   * An example Appointment.
   *
   * @return an example Appointment.
   */
  public static Appointment appointment() {
    return Appointment.builder()
        .id("0be173b4-721c-554e-ba7d-966d04633b68")
        .status(Appointment.Status.cancelled)
        .description("Scheduled Visit")
        .start("2006-06-30T17:00:00Z")
        .participant(
            List.of(
                Appointment.Participant.builder()
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                Coding.builder()
                                    .system("http://hl7.org/fhir/v3/ParticipationType")
                                    .code("PART")
                                    .display("Participation")
                                    .build()
                                    .asList())
                            .build()
                            .asList())
                    .actor(
                        Reference.builder()
                            .reference(
                                "https://www.freedomstream.io/Argonaut/api/Patient/185601V825290")
                            .display("VETERAN,JOHN Q")
                            .build())
                    .required(Appointment.Participant.RequiredCode.required)
                    .status(Appointment.Participant.ParticipantStatus.accepted)
                    .build(),
                Appointment.Participant.builder()
                    .type(
                        CodeableConcept.builder()
                            .coding(
                                Coding.builder()
                                    .system("http://hl7.org/fhir/v3/ParticipationType")
                                    .code("PART")
                                    .display("Participation")
                                    .build()
                                    .asList())
                            .build()
                            .asList())
                    .actor(
                        Reference.builder()
                            .reference(
                                "https://www.freedomstream.io/Argonaut/api/Location/71fed7fc-d060-5a35-bba9-e89fd7cdb4e6")
                            .display("ZZZTG SURG POD SCHEULLER COBI")
                            .build())
                    .required(Appointment.Participant.RequiredCode.required)
                    .status(Appointment.Participant.ParticipantStatus.accepted)
                    .build()))
        .build();
  }

  /**
   * An example Appointment.Bundle.
   *
   * @return an example Appointment.Bundle.
   */
  public static Appointment.Bundle appointmentBundle() {
    return Appointment.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Appointment?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Appointment?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Appointment?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            Appointment.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/Appointment/0be173b4-721c-554e-ba7d-966d04633b68")
                .resource(appointment())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
