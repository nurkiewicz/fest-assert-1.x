/*
 * Created on Jan 10, 2007
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2007-2011 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.ExpectedException.none;
import static org.fest.assertions.FailureMessages.actualIsNull;

import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link StringAssert#endsWith(String)}</code>.
 *
 * @author Yvonne Wang
 * @author David DIDIER
 * @author Alex Ruiz
 */
public class StringAssert_endsWith_Test {

  @Rule public ExpectedException thrown = none();

  @Test public void should_pass_if_actual_ends_with_given_String() {
    new StringAssert("Luke").endsWith("uke");
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    new StringAssert(null).endsWith("Leia");
  }

  @Test public void should_fail_and_display_description_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull("A Test"));
    new StringAssert(null).as("A Test")
                          .endsWith("Leia");
  }

  @Test public void should_fail_if_actual_does_not_end_with_given_String() {
    thrown.expectAssertionError("<'Luke'> should end with:<'Luk'>");
    new StringAssert("Luke").endsWith("Luk");
  }

  @Test public void should_fail_and_display_description_if_actual_does_not_end_with_given_String() {
    thrown.expectAssertionError("[A Test] <'Luke'> should end with:<'Luk'>");
    new StringAssert("Luke").as("A Test")
                            .endsWith("Luk");
  }

  @Test public void should_fail_with_custom_message_if_actual_does_not_end_with_given_String() {
    thrown.expectAssertionError("My custom message");
    new StringAssert("Luke").overridingErrorMessage("My custom message")
                            .endsWith("Luk");
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_does_not_end_with_given_String() {
    thrown.expectAssertionError("My custom message");
    new StringAssert("Luke").as("A Test")
                            .overridingErrorMessage("My custom message")
                            .endsWith("Luk");
  }
}
