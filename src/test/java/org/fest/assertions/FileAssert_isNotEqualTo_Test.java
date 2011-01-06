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

import static org.fest.assertions.FileStub.*;

import java.io.File;

import org.junit.BeforeClass;

/**
 * Tests for <code>{@link FileAssert#isNotEqualTo(java.io.File)}</code>.
 *
 * @author David DIDIER
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class FileAssert_isNotEqualTo_Test extends GenericAssert_isNotEqualTo_TestCase<FileAssert, File> {

  private static File notNullValue;
  private static File unequalValue;

  @BeforeClass
  public static void setUpOnce() {
    notNullValue = aFile();
    unequalValue = newFile("c:\\");
  }

  @Override protected FileAssert assertionsFor(File actual) {
    return new FileAssert(actual);
  }

  @Override protected File notNullValue() {
    return notNullValue;
  }

  @Override protected File unequalValue() {
    return unequalValue;
  }
}
