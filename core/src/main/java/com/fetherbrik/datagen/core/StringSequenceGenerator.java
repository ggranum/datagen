package com.fetherbrik.datagen.core;


import org.apache.commons.lang3.StringUtils;

/**
 * @author Geoff M. Granum
 */
public class StringSequenceGenerator implements Generator<String> {

  private final LongSequenceGenerator sequenceGenerator;
  private int leftPadTo;
  private char padChar;
  private int radix;

  public StringSequenceGenerator(long min, long max, int leftPadTo, char padChar) {
    sequenceGenerator = new LongSequenceGenerator(min, max);
    this.leftPadTo = leftPadTo;
    this.padChar = padChar;
  }

  /**
   * Create a String Sequence Generator that utilizes a global counter and left-zero-pads to a length of three.
   */
  public StringSequenceGenerator() {
    this(0, 999, 3, '0');
  }

  public static StringSequenceGenerator inRange(int minInclusive, int maxInclusive) {
    return new StringSequenceGenerator(minInclusive, maxInclusive, 0, '0');
  }

  public static StringSequenceGenerator inRange(int minInclusive, int maxInclusive, int leftPad, char padChar) {
    return new StringSequenceGenerator(minInclusive, maxInclusive, leftPad, padChar);
  }

  public static StringSequenceGenerator alphaNumericInRange(int minInclusive, int maxInclusive) {
    return alphaNumericInRange(minInclusive, maxInclusive, 0, '0');
  }

  public static StringSequenceGenerator alphaNumericInRange(int minInclusive,
                                                            int maxInclusive,
                                                            int leftPad,
                                                            char padChar) {
    return new StringSequenceGenerator(minInclusive, maxInclusive, leftPad, padChar).radix(Character.MAX_RADIX);
  }

  /**
   * The radix, as in base 10, base 16, base 36 etc.
   * Defaults to base 10.
   * Uses Long.toString(String, int), which means a Character.MAX_RADIX is the largest allowed value.
   */
  public StringSequenceGenerator radix(int radix) {
    if (radix > Character.MAX_RADIX) {
      throw new IllegalArgumentException(String.format("Radix value of '%s' exceeds the maximum Radix of '%s' ",
          radix,
          Character.MAX_RADIX));
    }
    this.radix = radix;

    return this;
  }

  public StringSequenceGenerator pad(int leftPadTo, char padChar) {
    this.leftPadTo = leftPadTo;
    this.padChar = padChar;
    return this;
  }

  @Override
  public String next() {
    return pad(Long.toString(sequenceGenerator.next(), radix));
  }

  private String pad(String value) {
    if (leftPadTo > 0) {
      value = StringUtils.leftPad(value, leftPadTo, padChar);
    }
    return value;
  }
}
 
