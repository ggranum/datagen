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

import java.math.BigInteger;

/**
 * @author Geoff M. Granum
 */
public class BigIntSequenceGenerator implements Generator<BigInteger> {

  private final SequenceGenerator sequenceGenerator;

  public BigIntSequenceGenerator(boolean useGlobalSequence) {
    if(useGlobalSequence) {
      sequenceGenerator = SequenceGenerator.globalSequence();
    } else {
      sequenceGenerator = new SequenceGenerator();
    }
  }

  public BigIntSequenceGenerator() {
    this(false);
  }

  @Override
  public BigInteger next() {
    return new BigInteger(String.valueOf(sequenceGenerator.next()));
  }
}
 
