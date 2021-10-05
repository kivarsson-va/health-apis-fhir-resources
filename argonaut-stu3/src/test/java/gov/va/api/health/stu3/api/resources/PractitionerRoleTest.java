package gov.va.api.health.stu3.api.resources;

import gov.va.api.health.stu3.api.RoundTrip;
import gov.va.api.health.stu3.api.bundle.AbstractBundle;
import gov.va.api.health.stu3.api.bundle.BundleLink;
import gov.va.api.health.stu3.api.samples.SamplePractitionerRoles;
import org.junit.jupiter.api.Test;

public class PractitionerRoleTest {
  private final SamplePractitionerRoles data = SamplePractitionerRoles.get();

  @Test
  public void bundlerCanBuildMedicationBundles() {
    PractitionerRole.Entry entry =
        PractitionerRole.Entry.builder()
            .extension(data.extension().asList())
            .fullUrl("http://practitionerRole.com")
            .id("123")
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://practitionerRole.com/1"))
                    .build()
                    .asList())
            .resource(data.practitionerRole())
            .search(data.search())
            .request(data.request())
            .response(data.response())
            .build();

    PractitionerRole.Bundle bundle =
        PractitionerRole.Bundle.builder()
            .entry(entry.asList())
            .link(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(("http://practitionerRole.com/2"))
                    .build()
                    .asList())
            .type(AbstractBundle.BundleType.searchset)
            .build();

    RoundTrip.assertRoundTrip(bundle);
  }

  @Test
  public void practitionerRole() {
    RoundTrip.assertRoundTrip(data.practitionerRole());
  }
}
