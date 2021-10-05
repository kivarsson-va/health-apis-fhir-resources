package gov.va.api.health.stu3.api.samples;

import gov.va.api.health.stu3.api.bundle.AbstractEntry;
import gov.va.api.health.stu3.api.datatypes.Address;
import gov.va.api.health.stu3.api.datatypes.Address.AddressType;
import gov.va.api.health.stu3.api.datatypes.Address.AddressUse;
import gov.va.api.health.stu3.api.datatypes.Annotation;
import gov.va.api.health.stu3.api.datatypes.Attachment;
import gov.va.api.health.stu3.api.datatypes.CodeableConcept;
import gov.va.api.health.stu3.api.datatypes.Coding;
import gov.va.api.health.stu3.api.datatypes.ContactPoint;
import gov.va.api.health.stu3.api.datatypes.ContactPoint.ContactPointSystem;
import gov.va.api.health.stu3.api.datatypes.ContactPoint.ContactPointUse;
import gov.va.api.health.stu3.api.datatypes.Duration;
import gov.va.api.health.stu3.api.datatypes.HumanName;
import gov.va.api.health.stu3.api.datatypes.HumanName.NameUse;
import gov.va.api.health.stu3.api.datatypes.Identifier;
import gov.va.api.health.stu3.api.datatypes.Identifier.IdentifierUse;
import gov.va.api.health.stu3.api.datatypes.Period;
import gov.va.api.health.stu3.api.datatypes.Quantity;
import gov.va.api.health.stu3.api.datatypes.Range;
import gov.va.api.health.stu3.api.datatypes.Ratio;
import gov.va.api.health.stu3.api.datatypes.SampledData;
import gov.va.api.health.stu3.api.datatypes.Signature;
import gov.va.api.health.stu3.api.datatypes.SimpleQuantity;
import gov.va.api.health.stu3.api.datatypes.SimpleResource;
import gov.va.api.health.stu3.api.datatypes.Timing;
import gov.va.api.health.stu3.api.datatypes.Timing.EventTiming;
import gov.va.api.health.stu3.api.datatypes.Timing.Repeat;
import gov.va.api.health.stu3.api.datatypes.Timing.UnitsOfTime;
import gov.va.api.health.stu3.api.elements.Extension;
import gov.va.api.health.stu3.api.elements.Meta;
import gov.va.api.health.stu3.api.elements.Narrative;
import gov.va.api.health.stu3.api.elements.Reference;
import gov.va.api.health.stu3.api.resources.OperationOutcome;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

@SuppressWarnings({"WeakerAccess", "unused"})
@NoArgsConstructor(staticName = "get")
public final class SampleDataTypes {
  public Address address() {
    return Address.builder()
        .id("1234")
        .extension(extension().asList())
        .use(AddressUse.home)
        .type(AddressType.both)
        .text("Hello")
        .line(List.of("hello", "goodbye"))
        .city("Hello City")
        .district("Hello District")
        .state("Hello State")
        .postalCode("12345")
        .country("Hello Country")
        .period(period())
        .build();
  }

  public Annotation annotation() {
    return Annotation.builder()
        .id("8888")
        .extension(extension().asList())
        .authorString("Test Author")
        .time("2015-04-15T04:00:00Z")
        .text("annotation test text")
        .build();
  }

  public Attachment attachment() {
    return Attachment.builder()
        .contentType("HelloType")
        .language("HelloLanguage")
        .data("SSBqdXN0IGF0ZSBhIHBlYW51dAo=")
        .url("http://HelloUrl.com")
        .size(1)
        .hash("SSBqdXN0IGF0ZSBhIHBlYW51dAo=")
        .title("HelloTitle")
        .creation("2000-01-01T00:00:00-00:00")
        .build();
  }

  public CodeableConcept codeableConcept() {
    return CodeableConcept.builder().coding(codingList()).text("code text test").build();
  }

  public List<CodeableConcept> codeableConceptList() {
    return codeableConcept().asList();
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

  public List<Coding> codingList() {
    return coding().asList();
  }

  public ContactPoint contactPoint() {
    return ContactPoint.builder()
        .system(ContactPointSystem.other)
        .value("HelloValue")
        .use(ContactPointUse.home)
        .rank(1)
        .period(period())
        .build();
  }

  public List<ContactPoint> contactPointList() {
    return contactPoint().asList();
  }

  public CodeableConcept details() {
    return CodeableConcept.builder().coding(coding().asList()).text("HelloText").build();
  }

  public Duration duration() {
    return Duration.builder()
        .value(11.11)
        .unit("HelloUnit")
        .system("http://HelloSystem.com")
        .code("d")
        .build();
  }

  public Extension extension() {
    return Extension.builder().url("http://HelloUrl.com").valueInteger(1).build();
  }

  public List<Extension> extensionList() {
    return extension().asList();
  }

  public Extension extensionWithQuantity() {
    return Extension.builder()
        .url("http://HelloUrl.com")
        .valueQuantity(
            Quantity.builder()
                .code("Q")
                .comparator(">=")
                .id("Q1")
                .unit("things")
                .system("http://example.com")
                .value(1.0)
                .build())
        .build();
  }

  public Extension extensionWithRatio() {
    return Extension.builder()
        .url("http://HelloUrl.com")
        .valueRatio(
            Ratio.builder()
                .id("R1")
                .denominator(Quantity.builder().value(1.0).build())
                .numerator(Quantity.builder().value(2.0).build())
                .build())
        .build();
  }

  public HumanName humanName() {
    return HumanName.builder()
        .use(NameUse.anonymous)
        .text("HelloText")
        .given(List.of("HelloGiven"))
        .prefix(List.of("HelloPrefix"))
        .suffix(List.of("HelloSuffix"))
        .period(period())
        .build();
  }

  public Identifier identifier() {
    return Identifier.builder()
        .id("5678")
        .use(IdentifierUse.official)
        .use(IdentifierUse.official)
        .extension(extension().asList())
        .build();
  }

  public OperationOutcome.Issue issue() {
    return OperationOutcome.Issue.builder()
        .severity(OperationOutcome.Issue.IssueSeverity.error)
        .code("HelloCode")
        .details(details())
        .diagnostics("HelloDiagnostics")
        .location(List.of("HelloLocation"))
        .expression(List.of("HelloExpression"))
        .build();
  }

  public Meta meta() {
    return Meta.builder()
        .versionId("1111")
        .lastUpdated("2000-01-01T00:00:00-00:00")
        .profile(List.of("http://HelloProfile.com"))
        .security(coding().asList())
        .tag(coding().asList())
        .build();
  }

  public Narrative narrative() {
    return Narrative.builder()
        .status(Narrative.NarrativeStatus.additional)
        .div("<p>HelloDiv<p>")
        .build();
  }

  public Period period() {
    return Period.builder()
        .id("5678")
        .extension(Extension.builder().url("http://example.com").valueInteger(1).build().asList())
        .start("2000-01-01T00:00:00-00:00")
        .end("2001-01-01T00:00:00-00:00")
        .build();
  }

  public Quantity quantity() {
    return Quantity.builder().value(11.11).unit("HelloUnit").build();
  }

  public Range range() {
    return Range.builder().low(simpleQuantity()).high(simpleQuantity()).build();
  }

  public Ratio ratio() {
    return Ratio.builder().numerator(quantity()).denominator(quantity()).build();
  }

  public Reference reference() {
    return Reference.builder().reference("HelloReference").display("HelloDisplay").build();
  }

  public List<Reference> referenceList() {
    return reference().asList();
  }

  public Repeat repeat() {
    return Repeat.builder()
        .id("2222")
        .extension(extension().asList())
        .boundsQuantity(duration())
        .count(1)
        .duration(11.11)
        .durationMax(11.11)
        .durationUnits(UnitsOfTime.min)
        .frequency(1)
        .frequencyMax(1)
        .period(11.11)
        .periodMax(11.11)
        .periodUnits(UnitsOfTime.h)
        .when(EventTiming.AC)
        .build();
  }

  public AbstractEntry.Request request() {
    return AbstractEntry.Request.builder()
        .id("request1")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .method(AbstractEntry.HttpVerb.GET)
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

  public AbstractEntry.Response response() {
    return AbstractEntry.Response.builder()
        .id("request1")
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .status("single")
        .location("http://example.com")
        .etag("you're it")
        .lastModified("2005-01-21T07:57:00Z")
        .build();
  }

  public SampledData sampledData() {
    return SampledData.builder()
        .origin(simpleQuantity())
        .period(new BigDecimal("11.11"))
        .factor(new BigDecimal("11.11"))
        .lowerLimit(new BigDecimal("11.11"))
        .upperLimit(new BigDecimal("11.11"))
        .dimensions(1)
        .data("HelloText")
        .build();
  }

  public AbstractEntry.Search search() {
    return AbstractEntry.Search.builder()
        .id("s1")
        .mode(AbstractEntry.SearchMode.match)
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .rank(new BigDecimal(0.5))
        .build();
  }

  public Signature signature() {
    return Signature.builder()
        .id("1234")
        .type(SampleDataTypes.get().codingList())
        .when("2000-01-01T00:00:00-00:00")
        .whoReference(SampleDataTypes.get().reference())
        .contentType("contentTypeTest")
        .blob("aGVsbG8=")
        .build();
  }

  public SimpleQuantity simpleQuantity() {
    return SimpleQuantity.builder()
        .value(11.11)
        .unit("HelloUnit")
        .system("http://example.com")
        .build();
  }

  public List<SimpleResource> simpleResourceList() {
    return resource().asList();
  }

  public Timing timing() {
    List<String> events = new LinkedList<>();
    String event = "2015-04-15T04:00:00Z";
    events.add(event);
    return Timing.builder()
        .id("2222")
        .extension(extension().asList())
        .event(events)
        .repeat(repeat())
        .code(codeableConcept())
        .build();
  }
}
