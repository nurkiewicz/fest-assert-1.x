/*
 * Created on Oct 10, 2007
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

import org.fest.util.Objects;

import static org.fest.util.Strings.isEmpty;
import static org.fest.util.Strings.quote;
import static org.fest.util.ToString.toStringOf;

/**
 * Creates instances of JUnit's <code>ComparisonFailure</code>.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public final class ComparisonFailureFactory {

  private static final String EMPTY_MESSAGE = "";

  private static ConstructorInvoker constructorInvoker = new ConstructorInvoker();

  static void constructorInvoker(ConstructorInvoker newConstructorInvoker) {
    constructorInvoker = newConstructorInvoker;
  }

  /**
   * Creates a new instance of JUnit's <code>ComparisonFailure</code> only if JUnit 4+ is in the classpath.
   * @param message the identifying message or {@code null}.
   * @param expected the expected value.
   * @param actual the actual value.
   * @return the created <code>ComparisonFailure</code>, or {@code null} if JUnit 4+ is not in the classpath.
   */
  public static AssertionError comparisonFailure(String message, Object expected, Object actual) {
    try {
      final String expectedStr = asString(expected);
      final String actualStr = asString(actual);
      if(Objects.areEqual(expectedStr, actualStr))
        return newComparisonFailure(clean(message), expectedStr + asVerboseString(expected), actualStr + asVerboseString(actual));
      else
        return newComparisonFailure(clean(message), expectedStr, actualStr);
    } catch (Exception e) {
      return null;
    }
  }

  private static String clean(String message) {
    return message == null ? "" : message;
  }

  private static AssertionError newComparisonFailure(String message, String expected, String actual) throws Exception {
    String className = "org.junit.ComparisonFailure";
    Class<?>[] parameterTypes = new Class<?>[] { String.class, String.class, String.class };
    Object[] parameterValues = new Object[] { format(message), expected, actual };
    Object o = constructorInvoker.newInstance(className, parameterTypes, parameterValues);
    if (o instanceof AssertionError) return (AssertionError)o;
    return null;
  }

  private static String asString(Object o) {
    if (o instanceof String) return quote((String)o);
    if (o == null) return null;
    return toStringOf(o);
  }

  private static String asVerboseString(Object obj) {
    return " (" + obj.getClass().getSimpleName() + "@" + Integer.toHexString(obj.hashCode()) + ")";
  }

  private static String format(String message) {
    if (isEmpty(message)) return EMPTY_MESSAGE;
    return String.format("[%s]", message);
  }

  private ComparisonFailureFactory() {}
}
