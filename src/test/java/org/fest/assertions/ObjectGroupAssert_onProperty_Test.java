/*
 * Created on May 26, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions;

import static java.util.Collections.emptyList;
import static org.fest.assertions.ExpectedException.none;
import static org.fest.assertions.FailureMessages.actualIsNull;
import static org.fest.assertions.Title.*;
import static org.junit.Assert.assertEquals;

import java.util.*;

import org.fest.util.IntrospectionError;
import org.junit.*;

/**
 * Base class for testing implementations of <code>{@link ObjectGroupAssert#onProperty(String)}</code>.
 * @param <S> used to simulate "self types." For more information please read &quot;<a
 * href="http://passion.forco.de/content/emulating-self-types-using-java-generics-simplify-fluent-api-implementation"
 * target="_blank">Emulating 'self types' using Java Generics to simplify fluent API implementation</a>.&quot;
 * @param <A> The type supported by the implementation of the {@code ObjectGroupAssert} to test.
 *
 * @author Joel Costigliola
 * @author Alex Ruiz
 */
public abstract class ObjectGroupAssert_onProperty_Test<S extends ObjectGroupAssert<S, A>, A> {

  @Rule public ExpectedException thrown = none();

  private List<Person> persons;

  @Before public void setUp() {
    persons = new ArrayList<Person>(populateData());
  }

  private static Collection<Person> populateData() {
    /*
     *  Person properties :
     *  - Long id;
     *  - Name name;
     *  - Person father;
     *  - int age;
     *  - long socialSecurityNumber;
     *  - boolean male;
     *  - char favoriteAlphabetLetter;
     *  - byte favoriteByte;
     *  - short yearOfBirth;
     *  - float height;
     *  - double weight;
     *  - String homeTown;
     */
    List<Person> persons = new ArrayList<Person>();
    Person pier = new Person(1L, "Pier", 25, 6L, true, 'P', 1, 1974, 1.90f, 80.1, "Paris");
    pier.setFather(new Person(11L, "PierFather", 55, 6L, true, 'P', 1, 1974, 1.90f, 80.1, "Paris"));
    persons.add(pier);
    Person paula = new Person(2L, "Paula", 32, 67L, false, 'O', 2, 1975, 1.80f, 90.2, "Madrid");
    paula.setFather(new Person(22L, "PaulaFather", 62, 67L, false, 'O', 2, 1975, 1.80f, 90.2, "Madrid"));
    paula.setTitle(Miss);
    persons.add(paula);
    Person jack = new Person(3L, "Jack", 16, 678L, false, 'J', 4, 1976, 1.70f, 100.3, "London");
    jack.setFather(new Person(33L, "JackFather", 46, 678L, false, 'J', 4, 1976, 1.70f, 100.3, "London"));
    persons.add(jack);
    Person otherJack = new Person(4L, "Jack", 44, 6789L, true, 'K', 8, 1977, 1.60f, 110.4, "Roma");
    otherJack.setFather(new Person(44L, "OtherJackFather", 74, 678L, false, 'J', 4, 1976, 1.70f, 100.3, "Roma"));
    persons.add(otherJack);
    return persons;
  }

  @Test public final void should_pass_on_non_primitive_type_property() {
    assertionsFor(persons).onProperty("id").contains(1L, 2L, 4L);
    assertionsFor(persons).onProperty("homeTown").contains("Paris", "Roma", "London", "Madrid");
  }

  @Test public final void should_pass_on_enum_type_property() {
    assertionsFor(persons).onProperty("title").contains(Mr, Miss);
  }

  @Test public final void should_pass_on_primitive_type_int_property() {
    assertionsFor(persons).onProperty("age").containsOnly(25, 16, 44, 32);
  }

  @Test public final void should_pass_on_primitive_type_long_property() {
    assertionsFor(persons).onProperty("socialSecurityNumber").containsOnly(6L, 67L, 678L, 6789L);
  }

  @Test public final void should_pass_on_primitive_type_short_property() {
    assertionsFor(persons).onProperty("yearOfBirth").containsOnly((short)1974, (short)1975, (short)1976, (short)1977);
  }

  @Test public final void should_pass_on_primitive_type_float_property() {
    assertionsFor(persons).onProperty("height").containsOnly(1.90f, 1.80f, 1.70f, 1.60f);
  }

  @Test public final void should_pass_on_primitive_type_double_property() {
    assertionsFor(persons).onProperty("weight").containsOnly(80.1, 90.2, 100.3, 110.4);
  }

  @Test public final void should_pass_on_primitive_type_boolean_property() {
    assertionsFor(persons).onProperty("male").containsOnly(true, false, false, true);
  }

  @Test public final void should_pass_on_primitive_type_byte_property() {
    assertionsFor(persons).onProperty("favoriteByte").containsOnly((byte)1, (byte)2, (byte)4, (byte)8);
  }

  @Test public final void should_pass_on_primitive_type_char_property() {
    ObjectGroupAssert<S, A> assertions = assertionsFor(persons);
    assertions.onProperty("favoriteAlphabetLetter").contains('P', 'K');
    assertions.onProperty("favoriteAlphabetLetter").containsOnly('O', 'J', 'P', 'K');
  }

  @Test public final void should_pass_on_non_primitive_type_nested_property() {
    ObjectGroupAssert<S, A> assertions = assertionsFor(persons);
    assertions.onProperty("name.firstName").contains("Pier", "Paula", "Jack");
    assertions.onProperty("father.name.firstName")
              .containsOnly("PierFather", "PaulaFather", "JackFather", "OtherJackFather");
  }

  @Test public final void should_pass_on_enum_type_nested_property() {
    assertionsFor(persons).onProperty("father.title").containsOnly(Mr, Mr, Mr, Mr);
  }

  @Test public final void should_pass_on_primitive_type_nested_property() {
    assertionsFor(persons).onProperty("father.age").containsOnly(55, 46, 74, 62);
  }

  @Test public final void should_fail_on_non_primitive_type_property() {
    String message = "<['Paris', 'Madrid', 'London', 'Roma']> does not contain element(s):<['Rome', 'Londres']>";
    thrown.expectAssertionError(message);
    assertionsFor(persons).onProperty("homeTown").contains("Paris", "Rome", "Londres", "Madrid");
  }

  @Test public final void should_fail_on_non_primitive_type_nested_property() {
    String message = "<['Pier', 'Paula', 'Jack', 'Jack']> does not contain element(s):<['TOTO']>";
    thrown.expectAssertionError(message);
    assertionsFor(persons).onProperty("name.firstName").contains("Jack", "Pier", "TOTO", "Paula");
  }

  @Test public final void should_fail_on_enum_type_property() {
    String message = "<[Mr, Miss, Mr, Mr]> does not contain element(s):<[Ms]>";
    thrown.expectAssertionError(message);
    assertionsFor(persons).onProperty("title").contains(Mr, Ms);
  }

  @Test public final void should_fail_on_enum_type_nested_property() {
    String message = "<[Mr, Mr, Mr, Mr]> does not contain element(s):<[Miss]>";
    thrown.expectAssertionError(message);
    assertionsFor(persons).onProperty("father.title").contains(Miss);
  }

  @Test public final void should_fail_on_primitive_type_property() {
    String message = "<[25, 32, 16, 44]> does not contain element(s):<[777]>";
    thrown.expectAssertionError(message);
    assertionsFor(persons).onProperty("age").contains(777);
  }

  @Test public final void should_fail_on_primitive_type_nested_property() {
    String message = "<[55, 62, 46, 74]> does not contain element(s):<[888]>";
    thrown.expectAssertionError(message);
    assertionsFor(persons).onProperty("father.age").contains(888);
  }

  @Test public final void should_fail_because_of_unknown_property() {
    try {
      // expected failure: Person.name does not have a 'nickname' property
      assertionsFor(persons).onProperty("name.nickname").containsOnly("PaulaFather", "JackFather", "OtherJackFather");
    } catch (IntrospectionError e) {
      assertEquals("No getter for property 'nickname' in org.fest.assertions.Name", e.getMessage());
    }
  }

  @Test public final void should_fail_because_of_non_public_getter() {
    thrown.expectIntrospectionError("No public getter for property 'country' in org.fest.assertions.Person");
    assertionsFor(persons).onProperty("country").containsOnly("Spain");
  }

  @Test public final void should_fail_because_of_no_getter() {
    thrown.expectIntrospectionError("No getter for property 'favoriteSport' in org.fest.assertions.Person");
    assertionsFor(persons).onProperty("favoriteSport").containsOnly("soccer");
  }

  @Test public final void should_pass_even_if_actual_contains_null_elements() {
    persons.add(null);
    assertionsFor(persons).onProperty("father.name.firstName")
                          .containsOnly("PierFather", "PaulaFather", "JackFather", "OtherJackFather");
  }

  @Test public final void should_pass_with_null_nested_property_in_actual_elements() {
    persons.iterator().next().setFather(null);
    assertionsFor(persons).onProperty("father.name.firstName")
                          .containsOnly("PaulaFather", "JackFather", "OtherJackFather");
  }

  @Test public final void should_pass_with_null_property_in_actual_elements() {
    nullifyIdsEqualTo(1);
    assertionsFor(persons).onProperty("id").contains(2L, 3L, 4L);
    assertionsFor(persons).onProperty("id").containsOnly(2L, 3L, 4L, null);
    nullifyAllIds();
    assertionsFor(persons).onProperty("id").containsOnly(null, null, null, null);
  }

  private void nullifyIdsEqualTo(long id) {
    for (Person person : persons) if (person.getId() == id) person.setId(null);
  }

  private void nullifyAllIds() {
    for (Person person : persons) person.setId(null);
  }

  @Test public final void should_pass_if_actual_is_empty() {
    assertionsFor(emptyList()).onProperty("id").isEmpty();
  }

  @Test public final void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    assertionsFor(null).onProperty("homeTown").contains("Paris", "Roma", "London", "Madrid");
  }

  @Test public void should_pass_on_property_defined_at_object_class_level() {
    assertionsFor(persons).onProperty("class").containsOnly(Person.class);
  }

  protected abstract ObjectGroupAssert<S, A> assertionsFor(Collection<?> data);
}

