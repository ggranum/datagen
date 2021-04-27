package com.fetherbrik.datagen.core;

/**
 * @author Geoff M. Granum
 */
public class IntSequenceGenerator implements Generator<Integer> {

  private LongSequenceGenerator sequence;

  public IntSequenceGenerator() {
    this(0, Integer.MAX_VALUE);
  }

  /**
   * @param min The lowest (and first) value that will ever be returned by a call to next()
   * @param max The largest value that will ever be returned by a call to next()
   */
  public IntSequenceGenerator(int min, int max) {
    this.sequence = new LongSequenceGenerator(min, max);
  }

  public static IntSequenceGenerator inRange(int minInclusive, int maxInclusive) {
    return new IntSequenceGenerator(minInclusive, maxInclusive);
  }

  @Override
  public Integer next() {
    return sequence.next().intValue();
  }
}
 
