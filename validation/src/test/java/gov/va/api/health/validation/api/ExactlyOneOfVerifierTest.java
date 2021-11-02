package gov.va.api.health.validation.api;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class ExactlyOneOfVerifierTest {
  @Test
  public void blankPrefixIsAnIllegalArgument() {
    Map<String, Supplier<?>> stringTypes = Map.of("", () -> "hello");
    Map<Class<?>, Supplier<?>> types = Map.of(String.class, () -> "hello", Integer.class, () -> 1);
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          ExactlyOneOfVerifier.builder()
              .sample(new ExactlyOne("exactly", null))
              .fieldPrefix("")
              .knownTypes(types)
              .stringTypes(stringTypes)
              .build()
              .verify();
        });
  }

  @Test
  public void exactlyBoth() {
    Map<String, Supplier<?>> stringTypes = Map.of("", () -> "hello");
    Map<Class<?>, Supplier<?>> types = Map.of(String.class, () -> "hello", Integer.class, () -> 1);
    assertThrows(
        IllegalStateException.class,
        () -> {
          ExactlyOneOfVerifier.builder()
              .sample(new ExactlyOne("exactly", 1))
              .fieldPrefix("exactlyOne")
              .knownTypes(types)
              .stringTypes(stringTypes)
              .build()
              .verify();
        });
  }

  @Test
  public void exactlyNeither() {
    Map<String, Supplier<?>> stringTypes = Map.of("", () -> "hello");
    Map<Class<?>, Supplier<?>> types = Map.of(String.class, () -> "hello", Integer.class, () -> 1);
    assertThrows(
        IllegalStateException.class,
        () -> {
          ExactlyOneOfVerifier.builder()
              .sample(new ExactlyOne(null, null))
              .fieldPrefix("exactlyOne")
              .knownTypes(types)
              .stringTypes(stringTypes)
              .build()
              .verify();
        });
  }

  @Test
  public void exactlyOneInteger() {
    Map<String, Supplier<?>> stringTypes = Map.of("", () -> "hello");
    Map<Class<?>, Supplier<?>> types = Map.of(String.class, () -> "hello", Integer.class, () -> 1);
    ExactlyOneOfVerifier.builder()
        .sample(new ExactlyOne(null, 1))
        .fieldPrefix("exactlyOne")
        .knownTypes(types)
        .stringTypes(stringTypes)
        .build()
        .verify();
  }

  @Test
  public void exactlyOneString() {
    Map<String, Supplier<?>> stringTypes = Map.of("", () -> "hello");
    Map<Class<?>, Supplier<?>> types = Map.of(String.class, () -> "hello", Integer.class, () -> 1);
    ExactlyOneOfVerifier.builder()
        .sample(new ExactlyOne("exactly", null))
        .fieldPrefix("exactlyOne")
        .knownTypes(types)
        .stringTypes(stringTypes)
        .build()
        .verify();
  }

  @Data
  @AllArgsConstructor
  @ExactlyOneOf(fields = {"exactlyOneString", "exactlyOneInt"})
  private class ExactlyOne {
    String exactlyOneString;

    Integer exactlyOneInt;
  }
}
