package org.fest.assertions;

import org.junit.ComparisonFailure;
import org.junit.Test;

import static org.fest.util.Strings.concat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Tomasz Nurkiewicz
 * @since 16.01.11, 16:00
 */
public class ComparisonFailureFactory_comparisonFailure_sameToString_Test {

  @Test
  public void should_return_normal_toString_when_different_objects() throws Exception {
    //given
    final Person expected = new Person("Alice", 27);
    final Person actual = new Person("Bob", 28);

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertEquals("[message] expected:<Person[name=[Alice]]> but was:<Person[name=[Bob]]>", failure.getMessage());
  }

  @Test
  public void should_return_verbose_message_when_different_objects_but_toString_same() throws Exception {
    //given
    final Person expected = new Person("Alice", 27);
    final Person actual = new Person("Alice", 28);

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertTrue(failure.getMessage().contains("Person@"));
  }

  @Test
  public void should_return_normal_message_when_to_different_simple_objects() throws Exception {
    //given
    final Object expected = 42;
    final Object actual = 43;

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertEquals("[message] expected:<4[2]> but was:<4[3]>", failure.getMessage());
  }

  @Test
  public void should_return_verbose_message_when_to_different_simple_objects_with_same_toString() throws Exception {
    //given
    final Object expected = 42f;
    final Object actual = 42d;

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertTrue(failure.getMessage().matches("\\[message\\] expected:<42.0 \\(\\[Float@.*\\)> but was:<42.0 \\(\\[Double@.*\\)>"));
  }

  @Test
  public void should_return_message_when_expected_null_but_actual_not_null() throws Exception {
    //given
    final Object expected = null;
    final Object actual = 42;

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertEquals("[message] expected:<null> but was:<42>", failure.getMessage());
  }

  @Test
  public void should_return_message_when_expected_not_null_but_actual_null() throws Exception {
    //given
    final Object expected = 42;
    final Object actual = null;

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertEquals("[message] expected:<42> but was:<null>", failure.getMessage());
  }

  @Test
  public void should_return_verbose_message_when_enum_type_value_name_same_but_different_enum() throws Exception {
    //given
    final Object expected = TypeA.YES;
    final Object actual = TypeB.YES;

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertTrue(failure.getMessage().matches("\\[message\\] expected:<YES \\(Type\\[A@.*\\)> but was:<YES \\(Type\\[B@.*\\)>"));
  }

  @Test
  public void should_return_simple_message_when_enum_type_value_names_different_in_same_enum() throws Exception {
    //given
    final Object expected = TypeA.YES;
    final Object actual = TypeA.NO;

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertEquals("[message] expected:<[YES]> but was:<[NO]>", failure.getMessage());
  }

  @Test
  public void should_return_simple_message_when_enum_type_value_names_different_in_different_enum() throws Exception {
    //given
    final Object expected = TypeA.YES;
    final Object actual = TypeA.NO;

    //when
    final ComparisonFailure failure = (ComparisonFailure) ComparisonFailureFactory.comparisonFailure("message", expected, actual);

    //then
    assertEquals("[message] expected:<[YES]> but was:<[NO]>", failure.getMessage());
  }

  private static class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return concat("Person[name=", name, "]");
    }
  }

  private static enum TypeA {YES, NO}
  private static enum TypeB {YES, NO}
}
