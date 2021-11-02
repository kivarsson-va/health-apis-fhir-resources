package gov.va.api.health.validation.api;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
final class Checks {
  static void checkState(boolean expression) {
    if (!expression) {
      throw new IllegalStateException();
    }
  }

  static void checkState(boolean expression, @NonNull Object errorMessage) {
    if (!expression) {
      throw new IllegalStateException(String.valueOf(errorMessage));
    }
  }
}
