package gov.va.api.health.stu3.api.bundle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.va.api.health.stu3.api.Fhir;
import gov.va.api.health.stu3.api.datatypes.Signature;
import gov.va.api.health.stu3.api.elements.Meta;
import gov.va.api.health.stu3.api.resources.Resource;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "http://hl7.org/fhir/STU3/bundle.html")
public abstract class AbstractBundle<N extends AbstractEntry<?>> implements Resource {
  @NotBlank protected String resourceType;

  @Pattern(regexp = Fhir.ID)
  protected String id;

  @Valid protected Meta meta;

  @Pattern(regexp = Fhir.URI)
  protected String implicitRules;

  @Pattern(regexp = Fhir.CODE)
  protected String language;

  @NotNull protected BundleType type;

  @Min(0)
  protected Integer total;

  @Valid protected List<BundleLink> link;

  @Valid
  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  protected List<N> entry;

  @Valid protected Signature signature;

  @SuppressWarnings("unused")
  public enum BundleType {
    document,
    message,
    transaction,
    @JsonProperty("transaction-response")
    transaction_response,
    batch,
    @JsonProperty("batch-response")
    batch_response,
    history,
    searchset,
    collection
  }
}
