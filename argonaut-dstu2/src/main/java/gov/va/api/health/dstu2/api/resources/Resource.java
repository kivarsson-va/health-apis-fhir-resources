package gov.va.api.health.dstu2.api.resources;

import gov.va.api.health.dstu2.api.elements.Meta;
import gov.va.api.health.fhir.api.IsResource;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "https://www.hl7.org/fhir/resource.html")
public interface Resource extends IsResource {

  String implicitRules();

  String language();

  Meta meta();
}
