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
 
