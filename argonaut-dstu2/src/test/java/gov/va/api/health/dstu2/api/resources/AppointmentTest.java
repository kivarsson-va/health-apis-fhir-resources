package gov.va.api.health.dstu2.api.resources;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.samples.SampleAppointments;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
  private final SampleAppointments data = SampleAppointments.get();

  @Test
  public void appointment() {
    assertRoundTrip(data.appointment());
  }

  @Test
  public void bundlerCanBuildAppointmentBundles() {
    Appointment.Entry entry =
        Appointment.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://Appointment.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://Appointment.com/1"))
                    .build()
                    .asList())
            .resource(data.appointment())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();
    Appointment.Bundle bundle =
        Appointment.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://Appointment.com/2"))
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();
    assertRoundTrip(bundle);
  }
}
