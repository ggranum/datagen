package com.geoffgranum.datagen.core;


import org.apache.commons.lang3.StringUtils;

/**
 * @author Geoff M. Granum
 */
public class StringSequenceGenerator implements Generator<String> {

  private final LongSequenceGenerator sequenceGenerator;
  private int leftPadTo;
  private char padChar;

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

  public StringSequenceGenerator pad(int leftPadTo, char padChar) {
    this.leftPadTo = leftPadTo;
    this.padChar = padChar;
    return this;
  }

  @Override
  public String next() {
    return pad(String.valueOf(sequenceGenerator.next()));
  }

  private String pad(String value) {
    if (leftPadTo > 0) {
      value = StringUtils.leftPad(value, leftPadTo, padChar);
    }
    return value;
  }
}
 
