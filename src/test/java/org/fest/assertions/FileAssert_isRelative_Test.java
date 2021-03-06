/*
 * Created on Dec 23, 2007
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
import static org.fest.assertions.FailureMessages.actualIsNull;

import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link FileAssert#isRelative()}</code>.
 *
 * @author David DIDIER
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class FileAssert_isRelative_Test extends FileAssert_TestCase {

  @Rule public ExpectedException thrown = none();

  @Test public void should_pass_if_actual_is_relative() {
    file.ensureIsRelative();
    new FileAssert(file).isRelative();
  }

  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    new FileAssert(null).isRelative();
  }

  @Test public void should_fail_and_display_description_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull("A Test"));
    new FileAssert(null).as("A Test")
                        .isRelative();
  }

  @Test public void should_fail_if_actual_is_not_relative() {
    file.ensureIsAbsolute();
    thrown.expectAssertionError("file:<c:\\f.txt> should be a relative path");
    new FileAssert(file).isRelative();
  }

  @Test public void should_fail_and_display_description_if_actual_is_not_relative() {
    file.ensureIsAbsolute();
    thrown.expectAssertionError("[A Test] file:<c:\\f.txt> should be a relative path");
    new FileAssert(file).as("A Test")
                        .isRelative();
  }

  @Test public void should_fail_with_custom_message_if_actual_is_not_relative() {
    file.ensureIsAbsolute();
    thrown.expectAssertionError("My custom message");
    new FileAssert(file).overridingErrorMessage("My custom message")
                        .isRelative();
  }

  @Test public void should_fail_with_custom_message_ignoring_description_if_actual_is_not_relative() {
    file.ensureIsAbsolute();
    thrown.expectAssertionError("My custom message");
    new FileAssert(file).as("A Test")
                        .overridingErrorMessage("My custom message")
                        .isRelative();
  }
}