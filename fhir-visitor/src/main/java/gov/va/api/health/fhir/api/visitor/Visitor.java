package gov.va.api.health.fhir.api.visitor;

@FunctionalInterface
public interface Visitor {
  void visit(InspectionLocation location);
}
