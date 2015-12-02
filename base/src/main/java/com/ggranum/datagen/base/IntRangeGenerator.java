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
 * @author Geoff M. Granum
 */
public class IntRangeGenerator implements Generator<Integer> {

  private final int min;
  private final int max;
  private int current;

  /**
   * @param min The lowest (and first) value that will ever be returned by a call to next()
   * @param max The largest value that will ever be returned by a call to next()
   */
  public IntRangeGenerator(int min, int max) {
    this.min = min;
    this.max = max;
    this.current = min;
  }

  @Override
  public Integer next() {
    int next = current;
    if(current == max) {
      current = min;
    } else {
      current++;
    }
    return next;
  }
}
 
