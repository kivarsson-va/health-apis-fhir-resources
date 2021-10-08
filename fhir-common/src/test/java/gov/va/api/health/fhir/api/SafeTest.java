package gov.va.api.health.fhir.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SafeTest {

  @Test
  void list() {
    assertThat(Safe.list(null)).isEmpty();
    assertThat(Safe.stream(List.of(1, 2, 3))).containsExactly(1, 2, 3);
  }

  @Test
  void stream() {
    assertThat(Safe.stream(null)).hasSize(0);
    assertThat(Safe.stream(List.of(1, 2, 3))).hasSize(3);
  }
}
