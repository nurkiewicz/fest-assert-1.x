/*
 * Created on Jun 18, 2007
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
 * Copyright @2007-2011 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.ExpectedException.none;
import static org.fest.assertions.FailureMessages.equal;

import org.junit.*;

/**
 * Tests for <code>{@link ByteAssert#isNotEqualTo(byte)}</code>.
 *
 * @author Yvonne Wang
 * @author David DIDIER
 * @author Alex Ruiz
 */
public class ByteAssert_isNotEqualTo_Test implements Assert_isNotEqualTo_TestCase {

  @Rule public ExpectedException thrown = none();

  private static Byte actual;

  private ByteAssert assertObject;

  @BeforeClass public static void setUpOnce() {
    actual = 6;
  }

  @Before public void setUp() {
    assertObject = new ByteAssert(actual);
  }

  @Test public void should_pass_if_actual_and_expected_are_not_equal() {
    assertObject.isNotEqualTo((byte)8);
  }

  @Test public void should_fail_if_actual_and_expected_are_equal() {
    thrown.expectAssertionError(equal(actual, actual));
    assertObject.isNotEqualTo(actual);
  }

  @Test public void should_fail_and_display_description_if_actual_and_expected_are_equal() {
    thrown.expectAssertionError(equal("A Test", actual, actual));
    assertObject.as("A Test")
                .isNotEqualTo(actual);
  }

  @Test public void should_fail_with_custom_message_if_actual_and_expected_are_equal() {
    thrown.expectAssertionError("My custom message");
    assertObject.overridingErrorMessage("My custom message")
                .isNotEqualTo(actual);
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_and_expected_are_equal() {
    thrown.expectAssertionError("My custom message");
    assertObject.as("A Test")
                .overridingErrorMessage("My custom message")
                .isNotEqualTo(actual);
  }
}
