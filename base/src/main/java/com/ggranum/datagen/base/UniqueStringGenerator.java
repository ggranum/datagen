package com.ggranum.datagen.base;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Provides a probably-unique value.
 * Not even vaguely efficient.
 *
 * @author Geoff M. Granum
 */
public class UniqueStringGenerator implements Generator<String> {

  @Override
  public String next() {
    UUID uuid = UUID.randomUUID();
    ByteBuffer buffer = ByteBuffer.allocate(16);
    buffer.putLong(uuid.getMostSignificantBits());
    buffer.putLong(uuid.getLeastSignificantBits());

    byte[] bytes = buffer.array();
    bytes[0] = bytes[0] > 0 ? bytes[0] : (byte)(-1 * bytes[0]);
    return new BigInteger(bytes).toString(Character.MAX_RADIX);
  }
}
 
