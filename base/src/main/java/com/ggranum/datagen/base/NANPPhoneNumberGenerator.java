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

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

/**
 * @author Geoff M. Granum
 */
public class NANPPhoneNumberGenerator implements Generator<String> {

  private final Boolean withCountryCode;
  private final Generator<Integer> areaCode;
  private final Generator<Integer> exchangeCode;
  private final Generator<Integer> subscriberNumber;
  private final Generator<String> separator;

  public NANPPhoneNumberGenerator() {
    this(false,
         new IntRangeGenerator(200, 999),
         new IntRangeGenerator(200, 999),
         new IntRangeGenerator(0, 9999),
         new IterableValueSupplier<>(Lists.newArrayList(
             "-", ".", " "
         ))
    );
  }

  public NANPPhoneNumberGenerator(
      Boolean withCountryCode,
      Generator<Integer> areaCode,
      Generator<Integer> exchangeCode,
      Generator<Integer> subscriberNumber,
      Generator<String> separator) {
    this.withCountryCode = withCountryCode;
    this.areaCode = areaCode;
    this.exchangeCode = exchangeCode;
    this.subscriberNumber = subscriberNumber;
    this.separator = separator;
  }

  @Override
  public String next() {
    String sep = separator.next();
    String phn =
        areaCode.next() +
        sep +
        exchangeCode.next() +
        sep +
        StringUtils.leftPad(String.valueOf(subscriberNumber.next()), 4, '0');
    return withCountryCode ? "1" + sep + phn : phn;
  }
}
 
