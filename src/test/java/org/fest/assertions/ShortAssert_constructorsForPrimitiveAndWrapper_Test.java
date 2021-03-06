/*
 * Created on Apr 12, 2010
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

/**
 * Tests for <code>{@link ShortAssert#ShortAssert(short)}</code> and
 * <code>{@link ShortAssert#ShortAssert(Short)}</code>.
 *
 * @author Ansgar Konermann
 * @author Alex Ruiz
 */
public class ShortAssert_constructorsForPrimitiveAndWrapper_Test extends
    GenericAssert_constructorsForPrimitiveAndWrapper_TestCase<ShortAssert, Short> {

  @Override protected Class<ShortAssert> assertionType() {
    return ShortAssert.class;
  }

  @Override protected Class<?> primitiveType() {
    return short.class;
  }

  @Override protected Class<Short> primitiveWrapperType() {
    return Short.class;
  }
}
