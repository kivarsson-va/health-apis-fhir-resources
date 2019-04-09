package gov.va.api.health.r4.api;

import static gov.va.api.health.r4.api.RoundTrip.assertRoundTrip;
import static java.util.Collections.singletonList;

import gov.va.api.health.r4.api.R4Service.SearchFailed;
import gov.va.api.health.r4.api.R4Service.UnknownResource;
import gov.va.api.health.r4.api.resources.OperationOutcome;
import gov.va.api.health.r4.api.samples.SampleDataTypes;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DataTypesTest {

  private final SampleDataTypes data = SampleDataTypes.get();

  @SuppressWarnings("ThrowableNotThrown")
  @Test
  public void exceptionConstructors() {
    new UnknownResource("some id");
    new SearchFailed("some id", "some reason");
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
            .contained(singletonList(data.resource()))
            .modifierExtension(
                Arrays.asList(
                    data.extension(), data.extensionWithQuantity(), data.extensionWithRatio()))
            .issue(singletonList(data.issue()))
            .build());
  }
}
