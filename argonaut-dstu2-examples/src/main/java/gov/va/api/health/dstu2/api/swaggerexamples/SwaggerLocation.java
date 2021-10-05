package gov.va.api.health.dstu2.api.swaggerexamples;

import gov.va.api.health.dstu2.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.Search;
import gov.va.api.health.dstu2.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.dstu2.api.bundle.BundleLink;
import gov.va.api.health.dstu2.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.dstu2.api.datatypes.Address;
import gov.va.api.health.dstu2.api.elements.Reference;
import gov.va.api.health.dstu2.api.resources.Location;
import java.util.List;

public class SwaggerLocation {
  /**
   * An example Location.
   *
   * @return an example Location.
   */
  public static Location location() {
    return Location.builder()
        .id("96aee2f5-a2ce-588f-8352-f6ea61f0959d")
        .status(Location.Status.active)
        .name("VAMC ALBANY")
        .description("VAMC ALBANY")
        .mode(Location.Mode.instance)
        .address(
            Address.builder()
                .line(List.of("113 Holland Avenue"))
                .city("ALBANY")
                .state("NEW YORK")
                .build())
        .managingOrganization(
            Reference.builder()
                .reference(
                    "https://www.freedomstream.io/Argonaut/api/Organization/e207c621-f467-5983-a6d1-868f33cefa95")
                .display("ZZ ALBANY")
                .build())
        .build();
  }

  /**
   * An example Location.Bundle.
   *
   * @return an example Location.Bundle.
   */
  public static Location.Bundle locationBundle() {
    return Location.Bundle.builder()
        .type(BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Location?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Location?patient=1017283148V813263&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/argonaut/v0/Location?patient=1017283148V813263&page=1&_count=15")
                    .build()))
        .entry(
            Location.Entry.builder()
                .fullUrl(
                    "https://sandbox-api.va.gov/services/argonaut/v0/Location/96aee2f5-a2ce-588f-8352-f6ea61f0959d")
                .resource(location())
                .search(Search.builder().mode(SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
