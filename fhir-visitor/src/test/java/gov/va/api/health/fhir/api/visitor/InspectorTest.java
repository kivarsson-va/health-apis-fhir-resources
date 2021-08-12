package gov.va.api.health.fhir.api.visitor;

import static gov.va.api.health.fhir.api.visitor.InspectionLocation.NOT_INDEXED;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.r4.api.elements.Reference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class InspectorTest {

  InspectionLocation find(List<InspectionLocation> visitedPaths, String name) {
    return visitedPaths.stream()
        .filter(l -> name.equals(l.toString()))
        .findFirst()
        .orElseThrow(() -> new AssertionError("Path not found: " + name));
  }

  @Test
  void inspectTraversesObjectAndAvoidsRestrictedScalarTypes() {
    List<InspectionLocation> visitedPaths = new ArrayList<>();

    Fugazi root = new Fugazi();
    Inspector.builder()
        .root(root)
        .visitor(visitedPaths::add)
        .doNotIntrospect(Set.of(NoFugazi.class))
        .build()
        .inspect();

    var rootNode = find(visitedPaths, "~");
    assertThat(rootNode.isIndexed()).isFalse();
    assertThat(rootNode.index()).isEqualTo(NOT_INDEXED);
    assertThat(rootNode.isRoot()).isTrue();
    assertThat(rootNode.value()).isEqualTo(root);
    assertThat(rootNode.field()).isNull();

    var leafNode = find(visitedPaths, "~.yesObject.okByMe");
    assertThat(leafNode.isIndexed()).isFalse();
    assertThat(leafNode.index()).isEqualTo(NOT_INDEXED);
    assertThat(leafNode.isRoot()).isFalse();
    assertThat(leafNode.value()).isEqualTo(root.yesObject.okByMe);

    var listNode = find(visitedPaths, "~.yesObjectLists[1]");
    assertThat(listNode.isIndexed()).isTrue();
    assertThat(listNode.index()).isEqualTo(1);
    assertThat(listNode.isRoot()).isFalse();
    assertThat(listNode.value()).isEqualTo(root.yesObjectLists.get(1));

    var mapNode = find(visitedPaths, "~.yesObjectMap[0]");
    assertThat(mapNode.isIndexed()).isTrue();
    assertThat(mapNode.index()).isEqualTo(0);
    assertThat(mapNode.isRoot()).isFalse();
    assertThat(mapNode.value()).isEqualTo(root.yesObjectMap.get("zero"));

    assertThat(visitedPaths.stream().map(InspectionLocation::toString))
        .containsExactlyInAnyOrder(
            "~",
            "~.yesObject",
            "~.yesObject.okByMe",
            "~.yesObjectLists",
            "~.yesObjectLists[0]",
            "~.yesObjectLists[0].okByMe",
            "~.yesObjectLists[1]",
            "~.yesObjectLists[1].okByMe",
            "~.yesObjectMap",
            "~.yesObjectMap[0]",
            "~.yesObjectMap[0].okByMe",
            "~.yesObjectMap[1]",
            "~.yesObjectMap[1].okByMe",
            "~.yesObjectMap[2]",
            "~.yesObjectMap[2].okByMe",
            "~.mixedObjectList",
            "~.mixedObjectList[0]",
            "~.mixedObjectList[0].okByMe",
            "~.mixedObjectList[2]",
            "~.mixedObjectList[2].okByMe",
            "~.mixedObjectMap",
            "~.mixedObjectMap[0]",
            "~.mixedObjectMap[0].okByMe",
            "~.mixedObjectMap[2]",
            "~.mixedObjectMap[2].okByMe");
  }

  @SuppressWarnings("unused")
  private static class Fugazi {
    String noString = "noString";
    Short noShort = 1;
    Integer noInteger = 2;
    Long noLong = 3L;
    BigInteger noBigInteger = BigInteger.ONE;
    Float noFloat = 5F;
    Double noDouble = 6D;
    BigDecimal noBigDecimal = BigDecimal.TEN;
    byte noByteP = 9;
    char noCharP = 'c';
    short noShortP = 11;
    int noIntegerP = 12;
    long noLongP = 13;
    float noFloatP = 14F;
    double noDoubleP = 15D;
    Date noDate = new Date();
    Calendar noCalendar = Calendar.getInstance();
    Instant noInstant = Instant.now();
    LocalDate noLocalDate = LocalDate.now();
    ChronoUnit noEnum = ChronoUnit.CENTURIES;
    YesFugazi nullObject = null;
    NoFugazi noObject = new NoFugazi();
    List<NoFugazi> noObjectList = List.of(new NoFugazi(), new NoFugazi());
    Map<String, NoFugazi> noObjectMap = map(new NoFugazi(), new NoFugazi(), new NoFugazi());

    YesFugazi yesObject = new YesFugazi();
    List<YesFugazi> yesObjectLists = List.of(new YesFugazi(), new YesFugazi());
    Map<String, YesFugazi> yesObjectMap = map(new YesFugazi(), new YesFugazi(), new YesFugazi());

    List<Object> mixedObjectList = List.of(new YesFugazi(), new NoFugazi(), new YesFugazi());
    Map<String, Object> mixedObjectMap = map(new YesFugazi(), new NoFugazi(), new YesFugazi());

    private static <T> Map<String, T> map(T zero, T one, T two) {
      var m = new LinkedHashMap<String, T>();
      m.put("zero", zero);
      m.put("one", one);
      m.put("two", two);
      return m;
    }
  }

  @SuppressWarnings("unused")
  private static class NoFugazi {
    Reference notAllowedHere = Reference.builder().reference("/never/gonna/get/it").build();
  }

  private static class YesFugazi {
    Reference okByMe = Reference.builder().reference("/ok/by/me").build();
  }

  @SuppressWarnings("unused")
  private static class YesYesFugazi {
    Reference okByMe = Reference.builder().reference("/ok/by/me").build();
    YesFugazi alsoOk = new YesFugazi();
  }
}
