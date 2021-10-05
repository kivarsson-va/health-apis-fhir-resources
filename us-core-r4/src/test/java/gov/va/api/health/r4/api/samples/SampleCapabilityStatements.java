package gov.va.api.health.r4.api.samples;

import gov.va.api.health.r4.api.resources.CapabilityStatement;
import gov.va.api.health.r4.api.resources.CapabilityStatement.CapabilityResource;
import gov.va.api.health.r4.api.resources.CapabilityStatement.ConditionalDelete;
import gov.va.api.health.r4.api.resources.CapabilityStatement.ConditionalRead;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Document;
import gov.va.api.health.r4.api.resources.CapabilityStatement.DocumentMode;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Implementation;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Kind;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Messaging;
import gov.va.api.health.r4.api.resources.CapabilityStatement.MessagingEndpoint;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Operation;
import gov.va.api.health.r4.api.resources.CapabilityStatement.ReferencePolicy;
import gov.va.api.health.r4.api.resources.CapabilityStatement.ResourceInteraction;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Rest;
import gov.va.api.health.r4.api.resources.CapabilityStatement.RestInteraction;
import gov.va.api.health.r4.api.resources.CapabilityStatement.RestMode;
import gov.va.api.health.r4.api.resources.CapabilityStatement.SearchParam;
import gov.va.api.health.r4.api.resources.CapabilityStatement.SearchParamType;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Security;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Software;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Status;
import gov.va.api.health.r4.api.resources.CapabilityStatement.SupportedMessage;
import gov.va.api.health.r4.api.resources.CapabilityStatement.SupportedMessageMode;
import gov.va.api.health.r4.api.resources.CapabilityStatement.SystemRestfulInteraction;
import gov.va.api.health.r4.api.resources.CapabilityStatement.TypeRestfulInteraction;
import gov.va.api.health.r4.api.resources.CapabilityStatement.Versioning;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleCapabilityStatements {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public CapabilityStatement capability() {
    return CapabilityStatement.builder()
        .id("c1")
        .implicitRules("https://example.com")
        .language("en")
        .text(narrative())
        .contained(List.of(resource()))
        .extension(extension().asList())
        .modifierExtension(extension().asList())
        .url("http://example.com")
        .version("1")
        .name("conformin' norman")
        .title("urgent care capability")
        .status(Status.active)
        .experimental(true)
        .date("2000-01-01T00:00:00-00:00")
        .publisher("random house")
        .contact(contactDetail().asList())
        .description("words words")
        .useContext(usageContext().asList())
        .jurisdiction(codeableConcept().asList())
        .purpose("words words")
        .copyright("Alphonso, Lord of the Mangos")
        .kind(Kind.capability)
        .instantiates(List.of("http://example.com"))
        .imports(List.of("http://example.com"))
        .software(software())
        .implementation(implementation())
        .fhirVersion("R4")
        .format(List.of("R4"))
        .patchFormat(List.of("R4"))
        .rest(rest().asList())
        .messaging(messaging().asList())
        .document(document().asList())
        .build();
  }

  public CapabilityResource capabilityResource() {
    return CapabilityResource.builder()
        .type("CODE")
        .profile("http://example.com")
        .supportedProfile(List.of("http://example.com"))
        .documentation("words words")
        .interaction(resourceInteraction().asList())
        .versioning(Versioning.no_version)
        .readHistory(true)
        .updateCreate(false)
        .conditionalCreate(true)
        .conditionalRead(ConditionalRead.not_supported)
        .conditionalUpdate(false)
        .conditionalDelete(ConditionalDelete.not_supported)
        .referencePolicy(List.of(ReferencePolicy.enforced))
        .searchInclude(List.of("indlude dem"))
        .searchRevInclude(List.of("include dem too"))
        .searchParam(searchParam().asList())
        .operation(operation().asList())
        .build();
  }

  public Document document() {
    return Document.builder()
        .mode(DocumentMode.consumer)
        .documentation("words words")
        .profile("http://example.com")
        .build();
  }

  public MessagingEndpoint endpoint() {
    return MessagingEndpoint.builder().protocol(coding()).address("http://example.com").build();
  }

  public Implementation implementation() {
    return Implementation.builder()
        .description("words words")
        .url("http://example.com")
        .custodian(reference())
        .build();
  }

  public Messaging messaging() {
    return Messaging.builder()
        .endpoint(endpoint().asList())
        .reliableCache(0)
        .documentation("words words")
        .supportedMessage(supportedMessage().asList())
        .build();
  }

  public Operation operation() {
    return Operation.builder()
        .name("Jimmy")
        .definition("http://example.com")
        .documentation("words words")
        .build();
  }

  public ResourceInteraction resourceInteraction() {
    return ResourceInteraction.builder()
        .code(TypeRestfulInteraction.patch)
        .documentation("words words")
        .build();
  }

  public Rest rest() {
    return Rest.builder()
        .mode(RestMode.client)
        .documentation("words words")
        .security(security())
        .resource(capabilityResource().asList())
        .interaction(restInteraction().asList())
        .searchParam(searchParam())
        .operation(operation())
        .compartment("words words")
        .build();
  }

  public RestInteraction restInteraction() {
    return RestInteraction.builder()
        .code(SystemRestfulInteraction.batch)
        .documentation("words words")
        .build();
  }

  public SearchParam searchParam() {
    return SearchParam.builder()
        .name("Jimmy")
        .definition("http://example.com")
        .type(SearchParamType.composite)
        .documentation("words words")
        .build();
  }

  public Security security() {
    return Security.builder()
        .cors(true)
        .service(codeableConcept().asList())
        .description("words words")
        .build();
  }

  public Software software() {
    return Software.builder()
        .name("Jimmy")
        .version("1")
        .releaseDate("2000-01-01T00:00:00-00:00")
        .build();
  }

  public SupportedMessage supportedMessage() {
    return SupportedMessage.builder()
        .mode(SupportedMessageMode.receiver)
        .definition("http://example.com")
        .build();
  }
}
