/*
 * Created on Jan 10, 2007
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

import static java.math.BigDecimal.ZERO;
import static org.fest.assertions.BigDecimals.*;
import static org.fest.assertions.ExpectedException.none;
import static org.fest.assertions.FailureMessages.actualIsNull;

import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link BigDecimalAssert#isGreaterThanOrEqualTo(java.math.BigDecimal)}</code>.
 *
 * @author David DIDIER
 * @author Ted M. Young
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class BigDecimalAssert_isGreaterThanOrEqualTo_Test implements Assert_isGreaterThanOrEqualTo_TestCase {

  @Rule public ExpectedException thrown = none();

  @Test public void should_pass_if_actual_is_greater_than_expected() {
    new BigDecimalAssert(eight()).isGreaterThanOrEqualTo(ZERO);
  }

  @Test public void should_pass_if_actual_is_equal_to_expected() {
    new BigDecimalAssert(seven()).isGreaterThanOrEqualTo(seven());
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    new BigDecimalAssert(null).isGreaterThanOrEqualTo(eight());
  }

  @Test public void should_fail_and_display_description_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull("A Test"));
    new BigDecimalAssert(null).as("A Test")
                              .isGreaterThanOrEqualTo(eight());
  }

  @Test public void should_fail_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("actual value:<0> should be greater than or equal to:<8.0>");
    new BigDecimalAssert(ZERO).isGreaterThanOrEqualTo(eight());
  }

  @Test public void should_fail_and_display_description_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("[A Test] actual value:<0> should be greater than or equal to:<8.0>");
    new BigDecimalAssert(ZERO).as("A Test")
                              .isGreaterThanOrEqualTo(eight());
  }

  @Test public void should_fail_with_custom_message_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("My custom message");
    new BigDecimalAssert(ZERO).overridingErrorMessage("My custom message")
                              .isGreaterThanOrEqualTo(eight());
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_is_less_than_expected() {
    thrown.expectAssertionError("My custom message");
    new BigDecimalAssert(ZERO).as("A Test")
                              .overridingErrorMessage("My custom message")
                              .isGreaterThanOrEqualTo(eight());
  }
}
