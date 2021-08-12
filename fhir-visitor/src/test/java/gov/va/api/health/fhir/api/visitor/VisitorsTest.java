package gov.va.api.health.fhir.api.visitor;

import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.fhir.api.IsReference;
import gov.va.api.health.fhir.api.IsResource;
import gov.va.api.health.r4.api.swaggerexamples.SwaggerCondition;
import gov.va.api.health.r4.api.swaggerexamples.SwaggerDiagnosticReport;
import gov.va.api.health.r4.api.swaggerexamples.SwaggerPatient;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class VisitorsTest {

  @Test
  void combineInvokesAreVisitors() {
    var v1 = new TrackingVisitor();
    var v2 = new TrackingVisitor();
    var v3 = new TrackingVisitor();
    var bundle = SwaggerDiagnosticReport.diagnosticReportBundle();
    Inspector.builder().visitor(Visitors.combine(v1, v2, v3)).root(bundle).build().inspect();
    assertThat(v1.visitedLocations).isNotEmpty();
    assertThat(v2.visitedLocations).containsExactlyElementsOf(v1.visitedLocations);
    assertThat(v3.visitedLocations).containsExactlyElementsOf(v1.visitedLocations);
  }

  @Test
  void referenceVisitorSeesOnlyReferences() {
    List<IsReference> refs = new ArrayList<>();
    var bundle = SwaggerDiagnosticReport.diagnosticReportBundle();
    Inspector.builder()
        .visitor(Visitors.referenceVisitor((loc, ref) -> refs.add(ref)))
        .root(bundle)
        .build()
        .inspect();
    var dr = bundle.entry().get(0).resource();
    assertThat(refs)
        .containsExactlyInAnyOrder(dr.subject(), dr.result().get(0), dr.result().get(1));
  }

  @Test
  void resourceVisitorSeesOnlyResources() {
    List<IsResource> refs = new ArrayList<>();
    var bundle0 = SwaggerDiagnosticReport.diagnosticReportBundle();
    var bundle1 = SwaggerCondition.conditionBundle();
    var resource0 = SwaggerPatient.patient();
    var stuff = List.of(bundle0, resource0, bundle1);
    Inspector.builder()
        .visitor(Visitors.resourceVisitor((loc, ref) -> refs.add(ref)))
        .root(stuff)
        .build()
        .inspect();
    assertThat(refs)
        .containsExactlyInAnyOrder(
            bundle0, // bundles are resources, too
            bundle0.entry().get(0).resource(),
            bundle1,
            bundle1.entry().get(0).resource(),
            resource0);
  }

  private static class TrackingVisitor implements Visitor {
    List<InspectionLocation> visitedLocations = new ArrayList<>();

    @Override
    public void visit(InspectionLocation location) {
      visitedLocations.add(location);
    }
  }
}
