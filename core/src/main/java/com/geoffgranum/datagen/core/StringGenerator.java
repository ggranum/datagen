package com.geoffgranum.datagen.core;

/**
 * @author Geoff M. Granum
 */
public class StringGenerator implements Generator<String> {

  private Generator<String> prefix = Supplier.of("");
  private Generator<String> content = Supplier.of("");
  private Generator<String> postfix = Supplier.of("");

  public StringGenerator() {
  }

  public StringGenerator prefix(String prefix) {
    this.prefix = Supplier.of(prefix);
    return this;
  }

  public StringGenerator prefix(Generator<String> prefix) {
    this.prefix = prefix;
    return this;
  }

  public StringGenerator postfix(Generator<String> postfix) {
    this.postfix = postfix;
    return this;
  }

  public StringGenerator content(Generator<String> content) {
    this.content = content;
    return this;
  }

  @Override
  public String next() {
    return prefix.next() + content.next() + postfix.next();
  }

  public StringGenerator postfix(String value) {
    this.postfix = Supplier.of(value);
    return this;
  }

  public StringGenerator content(String value) {
    this.content = Supplier.of(value);
    return this;
  }

}
 
