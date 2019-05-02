package gov.va.api.health.stu3.api;

import static gov.va.api.health.stu3.api.RoundTrip.assertRoundTrip;
import static java.util.Collections.singletonList;

import gov.va.api.health.stu3.api.resources.OperationOutcome;
import gov.va.api.health.stu3.api.samples.SampleDataTypes;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DataTypesTest {

  private final SampleDataTypes data = SampleDataTypes.get();

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
            .modifierExtension(singletonList(data.extension()))
            .issue(singletonList(data.issue()))
            .build());
  }
}
