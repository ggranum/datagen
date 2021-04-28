package com.fetherbrik.datagen.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A perfectly cromulent way to generate a linear distribution of the values you
 * provide to the constructor, but a horribly memory inefficient way to generate
 * numbers, when using the 'fromLine' method.
 * Avoid generating large maximum values or ranges, particularly with large slopes.
 */
public class LinearDistributionGenerator<T> implements Generator<T> {
  private static final Random DEFAULT_RANDOM = new Random(Integer.parseInt(
      System.getProperty("com.fetherbrik.datagen.default_random_initializer", "0")));
  private List<T> values;
  private Random random = DEFAULT_RANDOM;


  public LinearDistributionGenerator(List<T> values) {
    this.values = values;
  }

  /**
   * Incredibly memory intense. Do take care with large ranges and/or large slopes.
   * Generates a distribution of integer values, whose histogram will fit under the line described by
   * slope and offset, within the bounds of 'min' and 'max'.
   * <p>
   * Literally generates a List of values to pass into the primary constructor.
   */
  public static LinearDistributionGenerator<Integer> fromLine(int min, int max, int slope, int offset) {
    List<Integer> ints = new ArrayList<>((max - min) * Math.abs(slope) / 2);
    for (int x = min; x <= max; x++) {
      int v = slope * x + offset;
      for (int i = 0; i < v; i++) {
        ints.add(x);
      }
    }
    return new LinearDistributionGenerator<>(ints);
  }

  @Override
  public T next() {
    int x = random.nextInt(values.size());
    return values.get(x);
  }


  public LinearDistributionGenerator<T> resetRandom() {
    random = new Random(Integer.parseInt(System.getProperty("com.fetherbrik.datagen.default_random_initializer", "0")));
    return this;
  }
}
