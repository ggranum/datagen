package com.ggranum.datagen.base;

import java.math.BigInteger;

/**
 *
 * @author Geoff M. Granum
 */
public class BigIntSequenceGenerator implements Generator<BigInteger> {

  private final SequenceGenerator sequenceGenerator;

  public BigIntSequenceGenerator(boolean useGlobalSequence) {
    if(useGlobalSequence) {
      sequenceGenerator = SequenceGenerator.globalSequence();
    } else {
      sequenceGenerator = new SequenceGenerator();
    }
  }

  public BigIntSequenceGenerator() {
    this(false);
  }

  @Override
  public BigInteger next() {
    return new BigInteger(String.valueOf(sequenceGenerator.next()));
  }
}
 
