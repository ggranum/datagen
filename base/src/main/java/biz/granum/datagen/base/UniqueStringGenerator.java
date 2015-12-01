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
package biz.granum.datagen.base;

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
 
