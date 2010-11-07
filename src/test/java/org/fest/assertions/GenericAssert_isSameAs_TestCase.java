/*
 * Created on Apr 27, 2010
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
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions;

import static org.fest.assertions.Formatter.format;
import static org.fest.test.ExpectedFailure.expectAssertionError;
import static org.fest.util.Strings.concat;

import org.fest.test.CodeToTest;
import org.junit.*;

/**
 * Base class for testing <code>{@link GenericAssert#isSameAs(Object)}</code>.
 * @param <T> The type supported by the implementation of the {@code GenericAssert} to test.
 *
 * @author Ansgar Konermann
 * @author Alex Ruiz
 */
public abstract class GenericAssert_isSameAs_TestCase<T> extends GenericAssert_TestCase<T> {

  private T actual;
  private GenericAssert<T> assertions;
  private T notSameValue;

  @Before
  public void setUp() {
    actual = notNullValue();
    assertions = assertionsFor(actual);
    notSameValue = notSameValue();
  }

  protected abstract T notSameValue();

  @Test
  public final void should_pass_if_actual_and_expected_are_same() {
    assertions.isSameAs(actual);
  }

  @Test
  public final void should_fail_if_actual_and_expected_are_not_same() {
    String msg = concat("expected same instance but found:<", format(actual), "> and:<", format(notSameValue), ">");
    expectAssertionError(msg).on(new CodeToTest() {
      public void run() {
        assertions.isSameAs(notSameValue);
      }
    });
  }

  @Test
  public final void should_fail_and_display_description_of_assertion_if_actual_and_expected_are_not_same() {
    String msg = concat("[A Test] expected same instance but found:<", format(actual), "> and:<", format(notSameValue), ">");
    expectAssertionError(msg).on(new CodeToTest() {
      public void run() {
        assertions.as("A Test")
                  .isSameAs(notSameValue);
      }
    });
  }

  @Test
  public final void should_fail_with_custom_message_if_actual_and_expected_are_not_same() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        assertions.overridingErrorMessage("My custom message")
                  .isSameAs(notSameValue);
      }
    });
  }

  @Test
  public final void should_fail_with_custom_message_ignoring_description_of_assertion_if_actual_and_expected_are_not_same() {
    expectAssertionError("My custom message").on(new CodeToTest() {
      public void run() {
        assertions.as("A Test")
                  .overridingErrorMessage("My custom message")
                  .isSameAs(notSameValue);
      }
    });
  }
}
