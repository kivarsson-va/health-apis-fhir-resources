package gov.va.api.health.stu3.api.resources;

import static java.util.Collections.singletonList;

import gov.va.api.health.stu3.api.RoundTrip;
import gov.va.api.health.stu3.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.stu3.api.bundle.BundleLink;
import gov.va.api.health.stu3.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.stu3.api.resources.Appointment.Bundle;
import gov.va.api.health.stu3.api.resources.Appointment.Entry;
import gov.va.api.health.stu3.api.samples.SampleAppointments;
import org.junit.Test;

public class AppointmentTest {

  private final SampleAppointments data = SampleAppointments.get();

  @Test
  public void appointment() {
    RoundTrip.assertRoundTrip(data.appointment());
  }

  @Test
  public void bundlerCanBuildCoverageBundles() {
    Entry entry =
        Entry.builder()
            .extension(singletonList(data.extension()))
            .fullUrl("http://appointment.com")
            .id("123")
            .link(
                singletonList(
                    BundleLink.builder()
                        .relation(BundleLink.LinkRelation.self)
                        .url(("http://appointment/1"))
                        .build()))
            .resource(data.appointment())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();
    Bundle bundle =
        Bundle.builder()
            .entry(singletonList(entry))
            .link(
                singletonList(
                    BundleLink.builder()
                        .relation(LinkRelation.self)
                        .url(("http://appointment.com/2"))
                        .build()))
            .type(BundleType.searchset)
            .signature(data.signature())
            .build();
    RoundTrip.assertRoundTrip(bundle);
  }
}
