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

/**
 * Supply a constant, known value for every call to {@link #next()}
 *
 * @author Geoff M. Granum
 */
public class DefinedValueSupplier<T> implements Generator<T> {

  private final T value;

  public DefinedValueSupplier(T value) {
    this.value = value;
  }

  @Override
  public T next() {
    return value;
  }

  /**
   * Supply a constant value for every call to {@link #next()}
   *
   * @param value The value that will be returned on every call to {@link #next()}
   *
   * @return A {@link Generator} that will always return the passed argument.
   */
  public static <U> Generator<U> theValue(U value) {
    return new DefinedValueSupplier<>(value);
  }
}
 
