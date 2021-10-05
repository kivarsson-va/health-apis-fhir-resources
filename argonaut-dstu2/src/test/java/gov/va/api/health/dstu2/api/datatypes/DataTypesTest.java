package gov.va.api.health.dstu2.api.datatypes;

import static gov.va.api.health.dstu2.api.RoundTrip.assertRoundTrip;

import gov.va.api.health.dstu2.api.resources.OperationOutcome;
import gov.va.api.health.dstu2.api.samples.SampleDataTypes;
import gov.va.api.health.dstu2.api.samples.SampleKnownTypes;
import gov.va.api.health.validation.api.ZeroOrOneOfVerifier;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DataTypesTest {

  private final SampleDataTypes data = SampleDataTypes.get();
  private final SampleKnownTypes types = SampleKnownTypes.get();

  @Test
  public void dataTypes() {
    assertRoundTrip(data.age());
    assertRoundTrip(data.annotation());
    assertRoundTrip(data.sampledData());
    assertRoundTrip(data.range());
  }

  @Test
  public void extension() {
    ZeroOrOneOfVerifier.builder()
        .sample(SampleDataTypes.get().extension())
        .fieldPrefix("value")
        .knownTypes(types.knownTypes())
        .stringTypes(types.knownStringTypes())
        .build()
        .verify();
  }

  @Test
  public void operationOutcome() {
    assertRoundTrip(
        OperationOutcome.builder()
            .id("4321")
            .meta(data.meta())
            .implicitRules("http://HelloRules.com")
            .language("Hello Language")
            .text(data.narrative())
            .contained(data.resource().asList())
            .modifierExtension(
                List.of(data.extension(), data.extensionWithQuantity(), data.extensionWithRatio()))
            .issue(data.issue().asList())
            .build());
  }
}
