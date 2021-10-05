package gov.va.api.health.r4.api.datatypes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import gov.va.api.health.fhir.api.AsList;
import gov.va.api.health.r4.api.Fhir;
import gov.va.api.health.r4.api.elements.Element;
import gov.va.api.health.r4.api.elements.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Schema(description = "http://hl7.org/fhir/R4/datatypes.html#SampledData")
public class SampledData implements AsList<SampledData>, Element {
  @Pattern(regexp = Fhir.ID)
  String id;

  @Valid List<Extension> extension;

  @NotNull @Valid SimpleQuantity origin;

  @NotNull BigDecimal period;

  BigDecimal factor;

  BigDecimal lowerLimit;

  BigDecimal upperLimit;

  @NotNull
  @Min(1)
  Integer dimensions;

  String data;
}
