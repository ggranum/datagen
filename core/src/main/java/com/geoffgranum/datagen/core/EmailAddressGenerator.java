package com.geoffgranum.datagen.core;

import java.util.List;

/**
 * @author Geoff M. Granum
 */
public class EmailAddressGenerator implements Generator<String> {

  private final List<Generator<String>> parts;

  public EmailAddressGenerator() {
    this.parts = List.of(Supplier.of("email_"),
        StringSequenceGenerator.globalStringSequenceGenerator(),
        Supplier.of("@example.com"));
  }

  /**
   * Construct an email address from a chain of generators that will all be concatenated together.
   */
  @SafeVarargs public EmailAddressGenerator(Generator<String>... parts) {
    this.parts = List.of(parts);
  }


  @Override
  public String next() {
    StringBuilder b = new StringBuilder();
    for (Generator<String> part : parts) {
      b.append(part.next());
    }
    return b.toString();
  }
}
 
