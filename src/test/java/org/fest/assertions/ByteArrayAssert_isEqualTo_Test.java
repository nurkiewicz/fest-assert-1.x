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

import static org.fest.assertions.ArrayFactory.byteArray;

import org.junit.BeforeClass;

/**
 * Tests for <code>{@link ByteArrayAssert#isEqualTo(byte[])}</code>.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class ByteArrayAssert_isEqualTo_Test extends GenericAssert_isEqualTo_TestCase<ByteArrayAssert, byte[]> {

  private static byte[] notNullValue;
  private static byte[] unequalValue;

  @BeforeClass public static void setUpOnce() {
    notNullValue = byteArray(6, 8);
    unequalValue = byteArray(8);
  }

  @Override protected ByteArrayAssert assertionsFor(byte[] actual) {
    return new ByteArrayAssert(actual);
  }

  @Override protected byte[] notNullValue() {
    return notNullValue;
  }

  @Override protected byte[] notEqualValue() {
    return unequalValue;
  }
}
