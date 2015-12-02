package com.ggranum.datagen.base;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Provides a value that is unique to the current execution, where execution means invocation of the JVM and creation
 * of thread.
 *
 * @author Geoff M. Granum
 */
public class ExecutionIdGenerator implements Generator<String> {

  /* It's a special case, make it easy to use without requiring pointless new instances. */
  public static final ExecutionIdGenerator EXECUTION_ID = new ExecutionIdGenerator();

  private static final ThreadLocal<String> executionId = new ThreadLocal<>();

  @Override
  public String next() {
    if(executionId.get() == null) {
      UUID uuid = UUID.randomUUID();
      ByteBuffer buffer = ByteBuffer.allocate(16);
      buffer.putLong(uuid.getMostSignificantBits());
      buffer.putLong(uuid.getLeastSignificantBits());

      byte[] bytes = buffer.array();
      bytes[0] = bytes[0] > 0 ? bytes[0] : (byte)(-1 * bytes[0]);
      String id = new BigInteger(bytes).toString(Character.MAX_RADIX);
      executionId.set(id);
    }
    return executionId.get();
  }
}
 
