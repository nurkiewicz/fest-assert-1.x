/*
 * Created on Feb 14, 2008
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
 * Copyright @2008-2011 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.ArrayFactory.longArray;
import static org.fest.assertions.ExpectedException.none;
import static org.fest.assertions.FailureMessages.actualIsNull;

import org.junit.*;

/**
 * Tests for <code>{@link LongArrayAssert#contains(long...)}</code>.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class LongArrayAssert_contains_Test implements GroupAssert_contains_TestCase {

  @Rule public ExpectedException thrown = none();

  private static long[] array;

  @BeforeClass public static void setUpOnce() {
    array = longArray(6, 8);
  }

  @Test public void should_pass_if_actual_contains_given_value() {
    new LongArrayAssert(array).contains(6);
  }

  @Test public void should_pass_if_actual_contains_given_values() {
    new LongArrayAssert(array).contains(6, 8);
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    new LongArrayAssert(null).contains(6, 8);
  }

  @Test public void should_fail_and_display_description_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull("A Test"));
    new LongArrayAssert(null).as("A Test")
                             .contains(6, 8);
  }

  @Test public void should_throw_error_if_expected_is_null() {
    thrown.expectNullPointerException("The given array should not be null");
    new LongArrayAssert(array).contains(null);
  }

  @Test public void should_throw_error_and_display_description_if_expected_is_null() {
    thrown.expectNullPointerException("[A Test] The given array should not be null");
    new LongArrayAssert(array).as("A Test")
                              .contains(null);
  }

  @Test public void should_fail_if_actual_does_not_contain_given_values() {
    thrown.expectAssertionError("<[6, 8]> does not contain element(s):<[10]>");
    new LongArrayAssert(array).contains(10);
  }

  @Test public void should_fail_and_display_description_if_actual_does_not_contain_given_values() {
    thrown.expectAssertionError("[A Test] <[6, 8]> does not contain element(s):<[10]>");
    new LongArrayAssert(array).as("A Test")
                              .contains(10);
  }

  @Test public void should_fail_with_custom_message_if_actual_does_not_contain_given_values() {
    thrown.expectAssertionError("My custom message");
    new LongArrayAssert(array).overridingErrorMessage("My custom message")
                              .contains(10);
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_does_not_contain_given_values() {
    thrown.expectAssertionError("My custom message");
    new LongArrayAssert(array).as("A Test")
                              .overridingErrorMessage("My custom message")
                              .contains(10);
  }
}