package com.fetherbrik.datagen.core;

import java.util.Random;

/**
 * It's rather expensive.
 *
 * @author Geoff M. Granum
 */
public class StringGenerator implements Generator<String> {

  private static final Random DEFAULT_RANDOM = new Random(Integer.parseInt(
      System.getProperty("com.fetherbrik.datagen.default_random_initializer", "0")));
  private static final String DEFAULT_CHARS = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private String[] allowedCharacters;
  private int minLength;
  private int maxLength;
  private Random random = DEFAULT_RANDOM;

  public StringGenerator() {
    this(0, 10);
  }

  public StringGenerator(int length) {
    this(length, length);
  }

  public StringGenerator(int minLength, int maxLength) {
    this(DEFAULT_CHARS, minLength, maxLength);
  }

  public StringGenerator(String allowedChars, int minLength, int maxLength) {
    this.allowedCharacters = allowedChars.split("");
    this.minLength = minLength;
    this.maxLength = maxLength;
  }

  @Override
  public String next() {
    int count = maxLength;
    if (minLength < maxLength) {
      count = random.nextInt(maxLength - minLength) + minLength;
    }
    return next(count);
  }

  public String next(int length) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < length; i++) {
      b.append(nextChar());
    }
    return b.toString();
  }

  private String nextChar() {
    return allowedCharacters[random.nextInt(allowedCharacters.length)];
  }

  public StringGenerator resetRandom() {
    random = new Random(Integer.parseInt(System.getProperty("com.fetherbrik.datagen.default_random_initializer", "0")));
    return this;
  }
}
 
