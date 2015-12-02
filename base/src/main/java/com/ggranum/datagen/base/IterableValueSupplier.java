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

import java.util.Iterator;

/**
 * Provide a single value from an Iterable source per each call of {@link #next}.
 * Upon reaching the last value the iterator will reset.
 *
 * @author Geoff M. Granum
 */
public class IterableValueSupplier<T> implements Generator<T> {

  private final Iterable<T> value;
  private Iterator<T> iterator;

  public IterableValueSupplier(Iterable<T> value) {
    this.value = value;
  }

  @Override
  public T next() {
    if(iterator == null || !iterator.hasNext()) {
      iterator = value.iterator();
      if(!iterator.hasNext()) {
        throw new RuntimeException("Provided iterable is empty.");
      }
    }
    return iterator.next();
  }

  public static <U> Generator<U> oneOf(Iterable<U> values) {
    return new IterableValueSupplier<>(values);
  }
}
 
