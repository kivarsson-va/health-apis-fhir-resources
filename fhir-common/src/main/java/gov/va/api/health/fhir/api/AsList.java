package gov.va.api.health.fhir.api;

import java.util.List;

public interface AsList<T extends AsList<T>> {

  @SuppressWarnings("unchecked")
  default List<T> asList() {
    return List.of((T) this);
  }
}
