package gov.va.api.health.r4.api.swaggerexamples;

import gov.va.api.health.r4.api.bundle.AbstractBundle;
import gov.va.api.health.r4.api.bundle.AbstractEntry;
import gov.va.api.health.r4.api.bundle.BundleLink;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.resources.Questionnaire;
import java.util.List;

public class SwaggerQuestionnaire {
  /**
   * An example Questionnaire.
   *
   * @return an example Questionnaire.
   */
  public static Questionnaire questionnaire() {
    return Questionnaire.builder()
        .id("3141")
        .url("http://hl7.org/fhir/Questionnaire/3141")
        .version("3.14")
        .name("Cancer Quality Forum Questionnaire 2012")
        .title("Cancer Quality Forum Questionnaire 2012")
        .derivedFrom(List.of("Patient"))
        .status(Questionnaire.PublicationStatus.draft)
        .experimental(true)
        .subjectType(List.of("Patient"))
        .date("2012-01")
        .approvalDate("2012-01")
        .lastReviewDate("2012-01")
        .item(
            List.of(
                Questionnaire.Item.builder()
                    .id("1")
                    .linkId("1")
                    .definition("definition")
                    .code(
                        Coding.builder()
                            .system("http://example.org/system/code/sections")
                            .code("COMORBIDITY")
                            .build()
                            .asList())
                    .prefix("prefix")
                    .text("text")
                    .type(Questionnaire.QuestionnaireItemType.group)
                    .enableBehavior(Questionnaire.EnableWhenBehavior.all)
                    .required(true)
                    .repeats(false)
                    .readOnly(false)
                    .maxLength(2000)
                    .answerValueSet("answers")
                    .answerOption(
                        Questionnaire.AnswerOption.builder()
                            .valueString("x")
                            .initialSelected(false)
                            .build()
                            .asList())
                    .initial(Questionnaire.Initial.builder().valueString("x").build().asList())
                    .item(
                        List.of(
                            Questionnaire.Item.builder()
                                .linkId("1.1")
                                .code(
                                    Coding.builder()
                                        .system("http://example.org/system/code/QUESTIONS")
                                        .code("COMCAR00")
                                        .display("Angina Pectoris")
                                        .build()
                                        .asList())
                                .prefix("1")
                                .type(Questionnaire.QuestionnaireItemType.choice)
                                .answerValueSet("http://hl7.org/fhir/ValueSet/yesnodontknow")
                                .build(),
                            Questionnaire.Item.builder()
                                .linkId("1.2")
                                .code(
                                    Coding.builder()
                                        .system("http://snomed.info/sct")
                                        .code("22298006")
                                        .display("Myocardial infarction (disorder)")
                                        .build()
                                        .asList())
                                .prefix("1")
                                .type(Questionnaire.QuestionnaireItemType.choice)
                                .answerValueSet("http://hl7.org/fhir/ValueSet/yesnodontknow")
                                .build()))
                    .build(),
                Questionnaire.Item.builder()
                    .id("2")
                    .linkId("2")
                    .definition("definition")
                    .code(
                        Coding.builder()
                            .system("http://example.org/system/code/sections")
                            .code("HISTOPATHOLOGY")
                            .build()
                            .asList())
                    .prefix("prefix")
                    .text("text")
                    .type(Questionnaire.QuestionnaireItemType.group)
                    .enableBehavior(Questionnaire.EnableWhenBehavior.all)
                    .required(true)
                    .repeats(false)
                    .readOnly(false)
                    .maxLength(2000)
                    .answerValueSet("answers")
                    .item(
                        Questionnaire.Item.builder()
                            .linkId("2.1")
                            .code(
                                Coding.builder()
                                    .system("http://example.org/system/code/sections")
                                    .code("ABDOMINAL")
                                    .build()
                                    .asList())
                            .type(Questionnaire.QuestionnaireItemType.group)
                            .item(
                                Questionnaire.Item.builder()
                                    .linkId("2.1.2")
                                    .code(
                                        Coding.builder()
                                            .system("http://example.org/system/code/questions")
                                            .code("STADPT")
                                            .display("pT category")
                                            .build()
                                            .asList())
                                    .type(Questionnaire.QuestionnaireItemType.choice)
                                    .build()
                                    .asList())
                            .build()
                            .asList())
                    .build()))
        .build();
  }

  /**
   * An example Questionnaire.Bundle.
   *
   * @return an example Questionnaire.Bundle.
   */
  public static Questionnaire.Bundle questionnaireBundle() {
    return Questionnaire.Bundle.builder()
        .type(AbstractBundle.BundleType.searchset)
        .total(1)
        .link(
            List.of(
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.self)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/v0/Questionnaire?_id=3141&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.first)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/v0/Questionnaire?_id=3141&page=1&_count=15")
                    .build(),
                BundleLink.builder()
                    .relation(BundleLink.LinkRelation.last)
                    .url(
                        "https://sandbox-api.va.gov/services/fhir/v0/r4/v0/Questionnaire?_id=3141&page=1&_count=15")
                    .build()))
        .entry(
            Questionnaire.Entry.builder()
                .fullUrl("https://sandbox-api.va.gov/services/fhir/v0/r4/v0/Questionnaire/3141")
                .resource(questionnaire())
                .search(AbstractEntry.Search.builder().mode(AbstractEntry.SearchMode.match).build())
                .build()
                .asList())
        .build();
  }
}
