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
import static org.fest.util.Collections.list;

import java.util.List;

import org.junit.*;

/**
 * Tests for <code>{@link ObjectGroupAssert#hasSize(int)}</code>.
 *
 * @author Yvonne Wang
 */
public final class ObjectGroupAssert_hasSize_Test implements Assert_hasSize_TestCase {

  @Rule public ExpectedException thrown = none();

  private List<?> actual;
  private TestObjectGroupAssert assertions;

  @Before public void setUp() {
    actual = list("Gandalf", "Frodo", "Sam");
    assertions = new TestObjectGroupAssert(actual);
  }

  @Test public final void should_pass_if_actual_has_expected_size() {
    assertions.hasSize(3);
  }

  @Test public final void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    new TestObjectGroupAssert(null).hasSize(0);
  }

  @Test public final void should_fail_and_display_description_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull("A Test"));
    new TestObjectGroupAssert(null).as("A Test")
                                   .hasSize(0);
  }

  @Test public final void should_fail_if_actual_does_not_have_expected_size() {
    String message = "expected size:<2> but was:<3> for <['Gandalf', 'Frodo', 'Sam']>";
    thrown.expectAssertionError(message);
    assertions.hasSize(2);
  }

  @Test public final void should_fail_and_display_description_if_actual_does_not_have_expected_size() {
    String message = "[A Test] expected size:<2> but was:<3> for <['Gandalf', 'Frodo', 'Sam']>";
    thrown.expectAssertionError(message);
    assertions.as("A Test")
              .hasSize(2);
  }

  @Test public final void should_fail_with_custom_message_if_actual_does_not_have_expected_size() {
    thrown.expectAssertionError("My custom message");
    assertions.overridingErrorMessage("My custom message")
              .hasSize(2);
  }

  @Test public final void should_fail_with_custom_message_ignoring_description_if_actual_does_not_have_expected_size() {
    thrown.expectAssertionError("My custom message");
    assertions.as("A Test")
              .overridingErrorMessage("My custom message")
              .hasSize(2);
  }
}
