package gov.va.api.health.stu3.api.samples;

import static java.util.Collections.singletonList;

import gov.va.api.health.stu3.api.bundle.AbstractEntry.HttpVerb;
import gov.va.api.health.stu3.api.bundle.AbstractEntry.Request;
import gov.va.api.health.stu3.api.bundle.AbstractEntry.Response;
import gov.va.api.health.stu3.api.bundle.AbstractEntry.Search;
import gov.va.api.health.stu3.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.stu3.api.datatypes.CodeableConcept;
import gov.va.api.health.stu3.api.datatypes.Coding;
import gov.va.api.health.stu3.api.datatypes.Identifier;
import gov.va.api.health.stu3.api.datatypes.Identifier.IdentifierUse;
import gov.va.api.health.stu3.api.datatypes.Period;
import gov.va.api.health.stu3.api.datatypes.Signature;
import gov.va.api.health.stu3.api.datatypes.SimpleResource;
import gov.va.api.health.stu3.api.elements.Extension;
import gov.va.api.health.stu3.api.elements.Meta;
import gov.va.api.health.stu3.api.elements.Narrative;
import gov.va.api.health.stu3.api.elements.Narrative.NarrativeStatus;
import gov.va.api.health.stu3.api.elements.Reference;
import gov.va.api.health.stu3.api.resources.OperationOutcome.Issue;
import gov.va.api.health.stu3.api.resources.OperationOutcome.Issue.IssueSeverity;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "get")
public class SampleDataTypes {
  public CodeableConcept codeableConcept() {
    return CodeableConcept.builder().coding(singletonList(coding())).text("code text test").build();
  }

  public Coding coding() {
    return Coding.builder()
        .system("http://HelloSystem.com")
        .version("Hello Version")
        .code("Hello Code")
        .display("Hello Display")
        .userSelected(true)
        .build();
  }

  public Extension extension() {
    return Extension.builder().url("http://HelloUrl.com").valueCoding(coding()).build();
  }

  public Identifier identifier() {
    return Identifier.builder()
        .id("5678")
        .use(IdentifierUse.official)
        .use(Identifier.IdentifierUse.official)
        .extension(singletonList(extension()))
        .build();
  }

  public Issue issue() {
    return Issue.builder()
        .severity(IssueSeverity.error)
        .code("HelloCode")
        .details(codeableConcept())
        .diagnostics("HelloDiagnostics")
        .location(singletonList("HelloLocation"))
        .expression(singletonList("HelloExpression"))
        .build();
  }

  public Meta meta() {
    return Meta.builder()
        .versionId("1111")
        .lastUpdated("2000-01-01T00:00:00-00:00")
        .profile(singletonList("http://HelloProfile.com"))
        .security(singletonList(coding()))
        .tag(singletonList(coding()))
        .build();
  }

  public Narrative narrative() {
    return Narrative.builder().status(NarrativeStatus.additional).div("<p>HelloDiv<p>").build();
  }

  public Period period() {
    return Period.builder()
        .id("5678")
        .extension(
            singletonList(Extension.builder().url("http://example.com").valueInteger(1).build()))
        .start("2000-01-01T00:00:00-00:00")
        .end("2001-01-01T00:00:00-00:00")
        .build();
  }

  public Reference reference() {
    return Reference.builder().reference("HelloReference").display("HelloDisplay").build();
  }

  public Request request() {
    return Request.builder()
        .id("request1")
        .extension(singletonList(extension()))
        .modifierExtension(singletonList(extension()))
        .method(HttpVerb.GET)
        .url("http://example.com")
        .ifNoneMatch("ok")
        .ifModifiedSince("also ok")
        .ifMatch("really ok")
        .ifNoneExist("meh, ok.")
        .build();
  }

  public SimpleResource resource() {
    return SimpleResource.builder()
        .id("1111")
        .meta(meta())
        .implicitRules("http://HelloRules.com")
        .language("Hello Language")
        .build();
  }

  public Response response() {
    return Response.builder()
        .id("response1")
        .extension(singletonList(extension()))
        .modifierExtension(singletonList(extension()))
        .status("single")
        .location("http://example.com")
        .etag("you're it")
        .lastModified("2005-01-21T07:57:00Z")
        .build();
  }

  public Search search() {
    return Search.builder()
        .id("search1")
        .mode(SearchMode.match)
        .extension(singletonList(extension()))
        .modifierExtension(singletonList(extension()))
        .rank(BigDecimal.valueOf(0))
        .build();
  }

  public Signature signature() {
    return Signature.builder()
        .type(singletonList(coding()))
        .when("now")
        .whoReference(reference())
        .onBehalfOfReference(reference())
        .contentType("YO")
        .blob("00000")
        .build();
  }
}
