package gov.va.api.health.r4.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation indicates fields that are required to be compliant with the UsCore specification.
 * (https://hl7.org/fhir/us/core/STU4)
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER})
public @interface UsCore {
  /** Indicate there has been a change in cardinality. */
  String cardinality() default "";
  /** Indicate there has been a change or specialization. */
  String note() default "";
}
