package gov.va.api.health.dstu2.api.samples;

import gov.va.api.health.dstu2.api.resources.Conformance;
import gov.va.api.health.dstu2.api.resources.Conformance.AcceptUnknown;
import gov.va.api.health.dstu2.api.resources.Conformance.Contact;
import gov.va.api.health.dstu2.api.resources.Conformance.DeleteCode;
import gov.va.api.health.dstu2.api.resources.Conformance.Document;
import gov.va.api.health.dstu2.api.resources.Conformance.DocumentMode;
import gov.va.api.health.dstu2.api.resources.Conformance.Kind;
import gov.va.api.health.dstu2.api.resources.Conformance.Messaging;
import gov.va.api.health.dstu2.api.resources.Conformance.MessagingEndpoint;
import gov.va.api.health.dstu2.api.resources.Conformance.MessagingEvent;
import gov.va.api.health.dstu2.api.resources.Conformance.MessagingEventCategory;
import gov.va.api.health.dstu2.api.resources.Conformance.MessagingEventMode;
import gov.va.api.health.dstu2.api.resources.Conformance.ResourceInteraction;
import gov.va.api.health.dstu2.api.resources.Conformance.ResourceInteractionCode;
import gov.va.api.health.dstu2.api.resources.Conformance.Rest;
import gov.va.api.health.dstu2.api.resources.Conformance.RestInteraction;
import gov.va.api.health.dstu2.api.resources.Conformance.RestInteractionCode;
import gov.va.api.health.dstu2.api.resources.Conformance.RestMode;
import gov.va.api.health.dstu2.api.resources.Conformance.RestOperation;
import gov.va.api.health.dstu2.api.resources.Conformance.RestResource;
import gov.va.api.health.dstu2.api.resources.Conformance.RestResourceVersion;
import gov.va.api.health.dstu2.api.resources.Conformance.RestTransactionMode;
import gov.va.api.health.dstu2.api.resources.Conformance.SearchParam;
import gov.va.api.health.dstu2.api.resources.Conformance.SearchParamModifier;
import gov.va.api.health.dstu2.api.resources.Conformance.SearchParamType;
import gov.va.api.health.dstu2.api.resources.Conformance.SecurityCertificate;
import gov.va.api.health.dstu2.api.resources.Conformance.Status;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@SuppressWarnings({"unused", "WeakerAccess"})
@NoArgsConstructor(staticName = "get")
public class SampleConformance {
  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public Conformance conformance() {
    return Conformance.builder()
        .id("c1")
        .implicitRules("https://example.com")
        .language("en")
        .text(narrative())
        .contained(simpleResourceList())
        .extension(extensionList())
        .modifierExtension(extensionList())
        .url("http://example.com")
        .version("1")
        .name("conformin' norman")
        .status(Status.active)
        .experimental(true)
        .publisher("random house")
        .contact(contactList())
        .date("2005-01-21T07:57:00.000Z")
        .description("words words")
        .requirements("to be")
        .copyright("Alphonso, Lord of the Mangos")
        .kind(Kind.capability)
        .software(software())
        .implementation(implementation())
        .fhirVersion("argonaut")
        .acceptUnknown(AcceptUnknown.no)
        .format(List.of("json"))
        .profile(referenceList())
        .rest(restList())
        .messaging(messagingList())
        .document(documentList())
        .build();
  }

  public Conformance.Contact contact() {
    return Conformance.Contact.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .name("Jimmy")
        .telecom(contactPointList())
        .build();
  }

  public List<Contact> contactList() {
    return contact().asList();
  }

  private Document document() {
    return Conformance.Document.builder()
        .id("doc1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .mode(DocumentMode.consumer)
        .documentation("so many words")
        .profile(reference())
        .build();
  }

  private List<Document> documentList() {
    return document().asList();
  }

  public Conformance.Implementation implementation() {
    return Conformance.Implementation.builder()
        .id("implementation1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .description("cool beans")
        .url("http://example.com")
        .build();
  }

  public Messaging messaging() {
    return Conformance.Messaging.builder()
        .id("doc1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .endpoint(messagingEndpointList())
        .reliableCache(2)
        .documentation("finally done")
        .event(messagingEventList())
        .build();
  }

  public MessagingEndpoint messagingEndpoint() {
    return Conformance.MessagingEndpoint.builder()
        .id("end1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .protocol(coding())
        .address("http://example.com")
        .build();
  }

  public List<MessagingEndpoint> messagingEndpointList() {
    return messagingEndpoint().asList();
  }

  public MessagingEvent messagingEvent() {
    return Conformance.MessagingEvent.builder()
        .id("doc1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .code(coding())
        .category(MessagingEventCategory.Consequence)
        .mode(MessagingEventMode.sender)
        .focus("blur")
        .request(reference())
        .response(reference())
        .documentation("so many words")
        .build();
  }

  public List<MessagingEvent> messagingEventList() {
    return messagingEvent().asList();
  }

  public List<Messaging> messagingList() {
    return messaging().asList();
  }

  public Conformance.ResourceInteraction resourceInteraction() {
    return Conformance.ResourceInteraction.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .code(ResourceInteractionCode.create)
        .documentation("so long")
        .build();
  }

  private List<ResourceInteraction> resourceInteractionList() {
    return resourceInteraction().asList();
  }

  public Conformance.Rest rest() {
    return Conformance.Rest.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .mode(RestMode.server)
        .documentation("words words")
        .security(restSecurity())
        .resource(restResourceList())
        .interaction(restInteractionList())
        .transactionMode(RestTransactionMode.not_supported)
        .searchParam(searchParamList())
        .operation(restOperationList())
        .compartment(List.of("compartments!"))
        .build();
  }

  public Conformance.RestInteraction restInteraction() {
    return Conformance.RestInteraction.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .code(RestInteractionCode.search_system)
        .documentation("omg so long")
        .build();
  }

  private List<RestInteraction> restInteractionList() {
    return restInteraction().asList();
  }

  private List<Rest> restList() {
    return rest().asList();
  }

  private RestOperation restOperation() {
    return Conformance.RestOperation.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .name("STUFF")
        .definition(reference())
        .build();
  }

  private List<RestOperation> restOperationList() {
    return restOperation().asList();
  }

  private RestResource restResource() {
    return Conformance.RestResource.builder()
        .id("restresource1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .type("Thing")
        .profile(reference())
        .interaction(resourceInteractionList())
        .versioning(RestResourceVersion.no_version)
        .readHistory(true)
        .updateCreate(true)
        .conditionalCreate(true)
        .conditionalUpdate(true)
        .conditionalDelete(DeleteCode.not_supported)
        .searchInclude(List.of("ok"))
        .searchRevInclude(List.of("meh"))
        .searchParam(searchParamList())
        .build();
  }

  public List<RestResource> restResourceList() {
    return restResource().asList();
  }

  public Conformance.RestSecurity restSecurity() {
    return Conformance.RestSecurity.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .cors(true)
        .service(codeableConceptList())
        .description("wordy words")
        .certificate(restSecurityCertificateList())
        .build();
  }

  public Conformance.SecurityCertificate restSecurityCertificate() {
    return Conformance.SecurityCertificate.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .type("stuff")
        .blob("TH38L089")
        .build();
  }

  private List<SecurityCertificate> restSecurityCertificateList() {
    return restSecurityCertificate().asList();
  }

  public Conformance.SearchParam searchParam() {
    return Conformance.SearchParam.builder()
        .id("contact1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .name("thing")
        .definition("http://example.com")
        .type(SearchParamType.string)
        .documentation("this resource is yuge")
        .target(List.of("json"))
        .modifier(List.of(SearchParamModifier.not_in))
        .chain(List.of("cha-cha-chain-of-fools"))
        .build();
  }

  private List<SearchParam> searchParamList() {
    return searchParam().asList();
  }

  public Conformance.Software software() {
    return Conformance.Software.builder()
        .id("s1")
        .extension(extensionList())
        .modifierExtension(extensionList())
        .name("Virus.exe")
        .version("2.3")
        .releaseDate("2005-01-21T07:57:00.000Z")
        .build();
  }
}
