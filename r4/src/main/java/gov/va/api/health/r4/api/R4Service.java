package gov.va.api.health.r4.api;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import javax.ws.rs.Path;

@OpenAPIDefinition(
  info =
      @Info(
        title = "Urgent Care Eligibility",
        version = "v1",
        description =
            "FHIR (Fast Healthcare Interoperability Resources) specification defines a set of"
                + " \"Resources\" that represent granular clinical concepts."
                + "This is FHIR version R4."
      ),
  servers = {
    @Server(
      url = "https://dev-api.va.gov/services/argonaut/v0/",
      description = "Development server - url not definitive."
    )
  },
  externalDocs =
      @ExternalDocumentation(
        description = "R4 Resources",
        url = "https://www.hl7.org/fhir/R4/index.html"
      )
)
@Path("/")
public interface R4Service extends CoverageApi, CoverageEligibilityResponseApi {
  class R4ServiceException extends RuntimeException {
    R4ServiceException(String message) {
      super(message);
    }
  }

  class SearchFailed extends R4ServiceException {
    public SearchFailed(String id, String reason) {
      super(id + " Reason: " + reason);
    }
  }

  class UnknownResource extends R4ServiceException {
    public UnknownResource(String id) {
      super(id);
    }
  }
}
