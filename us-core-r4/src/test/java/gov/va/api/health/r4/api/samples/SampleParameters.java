package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.Parameters;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleParameters {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Parameters parameters() {
    return Parameters.builder()
        .id("x")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .parameter(
            Parameters.Parameter.builder()
                .name("Goodnight name")
                .valueBoolean(Boolean.TRUE)
                .part(
                    Parameters.Parameter.builder().name("code").valueCode("focus").build().asList())
                .build()
                .asList())
        .build();
  }

  public Parameters parametersBoolean() {
    return Parameters.builder()
        .id("x")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .parameter(
            Parameters.Parameter.builder()
                .name("Goodnight name")
                .valueBoolean(Boolean.TRUE)
                .build()
                .asList())
        .build();
  }

  public Parameters parametersResource() {
    return Parameters.builder()
        .id("x")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .parameter(
            Parameters.Parameter.builder()
                .name("Goodnight name")
                .resource(SamplePatients.get().patient())
                .build()
                .asList())
        .build();
  }

  public Parameters parametersString() {
    return Parameters.builder()
        .id("x")
        .meta(meta())
        .implicitRules("http://GoodnightRules.com")
        .language("Goodnight Language")
        .parameter(
            Parameters.Parameter.builder()
                .name("Goodnight name")
                .valueString("Some string")
                .build()
                .asList())
        .build();
  }
}
