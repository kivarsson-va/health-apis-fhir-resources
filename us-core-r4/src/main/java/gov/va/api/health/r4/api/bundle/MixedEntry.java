package gov.va.api.health.r4.api.bundle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.elements.Extension;
import gov.va.api.health.r4.api.resources.Resource;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "https://hl7.org/fhir/R4/bundle.html")
public final class MixedEntry extends AbstractEntry<Resource> implements AsList<MixedEntry> {
  /** Builder constructor. */
  @Builder
  public MixedEntry(
      @Pattern(regexp = Fhir.ID) String id,
      @Valid List<Extension> extension,
      @Valid List<Extension> modifierExtension,
      @Valid List<BundleLink> link,
      @Pattern(regexp = Fhir.URI) String fullUrl,
      @Valid Resource resource,
      @Valid AbstractEntry.Search search,
      @Valid Request request,
      @Valid Response response) {
    super(id, extension, modifierExtension, link, fullUrl, resource, search, request, response);
  }
}
