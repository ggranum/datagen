/*
 * Copyright 2013 Geoff M. Granum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ggranum.datagen.base;

import org.apache.commons.lang.StringUtils;

/**
 * @author Geoff M. Granum
 */
public class StringSequenceGenerator implements Generator<String> {

  private static final int DEFAULT_LEADING_ZEROS = Integer.parseInt(System.getProperty(
      "datagen.string_sequence_generator.default_leading_zeros", "3"));

  private static final StringSequenceGenerator GLOBAL_GENERATOR =
      new StringSequenceGenerator(DEFAULT_LEADING_ZEROS);

  private final SequenceGenerator sequenceGenerator;
  private int leadingZeros = 0;

  public StringSequenceGenerator(int leadingZeros) {
    this.leadingZeros = leadingZeros;
    sequenceGenerator = new SequenceGenerator();
  }

  /**
   * Create a String Sequence Generator that utilizes a global counter and left-pads to a length of three.
   */
  public StringSequenceGenerator() {
    this(3);
  }

  public StringSequenceGenerator zeroPad(int numberOfZeros) {
    leadingZeros = numberOfZeros;
    return this;
  }

  @Override
  public String next() {
    return pad(String.valueOf(sequenceGenerator.next()));
  }

  private String pad(String value) {
    if(leadingZeros > 0) {
      value = StringUtils.leftPad(value, leadingZeros, '0');
    }
    return value;
  }

  public static StringSequenceGenerator globalStringSequenceGenerator() {
    return GLOBAL_GENERATOR;
  }
}
 
