package gov.va.api.health.validation.api;

import static gov.va.api.health.validation.api.Checks.checkState;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

/**
 * This class will verify fields with a field required by FHIR but not available for us is
 * represented by an ExactlyOneOf annotation that follows the name + _name convention where the
 * _name is an Extension object.
 */
@Slf4j
public class ExactlyOneOfExtensionVerifier<T> extends AbstractRelatedFieldVerifier<T> {
  /** The base of the related fields, e.g. status vs _status. */
  private String baseField;

  /** The extension class being used to verify. */
  private Class<?> extensionClass;

  /**
   * Creates a customizable verifier with different prefixes, known types, and class needed to
   * verify.
   */
  @Builder
  public ExactlyOneOfExtensionVerifier(
      T sample,
      String field,
      Class<?> extensionClass,
      Map<Class<?>, Supplier<?>> knownTypes,
      Map<String, Supplier<?>> stringTypes) {
    super(sample, name -> name.equals(field) || name.equals("_" + field), knownTypes, stringTypes);
    baseField = field;
    this.extensionClass = extensionClass;
  }

  @Override
  public void verify() {
    log.info("Verifying {}", sample.getClass());
    String extensionField = "_" + baseField;
    checkState(fields().containsAll(List.of(baseField, extensionField)) && fields().size() == 2);
    /* Make sure the sample is valid before we mess it up. */
    assertProblems(0);
    /* Make sure we are valid if no fields are set. */
    unsetFields();
    assertProblems(1);
    setField(baseField);
    assertProblems(0);
    unsetFields();
    setField(extensionField);
    assertProblems(0);
    checkState(field(extensionField).getType() == extensionClass);
  }
}
