/*
 * Created on Jun 9, 2007
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
 * Copyright @2007-2010 the original author or authors.
 */
package org.fest.assertions;

import static java.awt.Color.BLUE;

import static org.fest.assertions.Images.fivePixelBlueImage;
import static org.fest.assertions.Images.image;

import java.awt.image.BufferedImage;

import org.junit.BeforeClass;

/**
 * Tests for <code>{@link org.fest.assertions.ImageAssert#isIn(BufferedImage ... values)} }</code> and
 * <code>{@link org.fest.assertions.ImageAssert#isIn(java.util.Collection)}</code>.
 *
 * @author Joel Costigliola
 */
public class ImageAssert_isIn_isNotIn_Test extends GenericAssert_isIn_isNotIn_TestCase<BufferedImage>  {

  private static BufferedImage notNullValue;
  private static BufferedImage unequalValue;

  @BeforeClass
  public static void setUpOnce() {
    notNullValue = fivePixelBlueImage();
    unequalValue = image(3, 5, BLUE);
  }


  @Override protected ImageAssert assertionsFor(BufferedImage actual) {
    return new ImageAssert(actual);
  }

  @Override protected BufferedImage notNullValue() {
    return notNullValue;
  }

  @Override
  public void setUpValuesContainingActual() {
    initValuesContainingActual(notNullValue(), unequalValue);
  }


}
