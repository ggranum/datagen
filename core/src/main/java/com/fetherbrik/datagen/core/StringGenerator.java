package com.fetherbrik.datagen.core;

/**
 * @author Geoff M. Granum
 */
public class StringGenerator implements Generator<String> {

  private Generator<String> content = Supplier.of("");

  public StringGenerator() {
  }

  public StringGenerator(String value) {
    content = Supplier.of(value);
  }

  public StringGenerator content(Generator<String> content) {
    this.content = content;
    return this;
  }

  public StringGenerator content(String value) {
    this.content = Supplier.of(value);
    return this;
  }

  @Override
  public String next() {
    return content.next();
  }


}
 
