package com.ggranum.datagen.base;

/**
 * @author Geoff M. Granum
 */
public class StringGenerator implements Generator<String> {

  private Generator<String> prefix = DefinedValueSupplier.theValue("");
  private Generator<String> content = DefinedValueSupplier.theValue("");
  private Generator<String> postfix = DefinedValueSupplier.theValue("");
  private int chanceOfNull = 0;

    public StringGenerator() {
    }

    public StringGenerator prefix(String prefix) {
    this.prefix = DefinedValueSupplier.theValue(prefix);
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
    return shouldReturnNull() ? null : prefix.next() + content.next() + postfix.next();
  }

  private boolean shouldReturnNull() {
    return Math.random() * 100 < chanceOfNull;
  }

  public StringGenerator postfix(String value) {
    this.postfix = DefinedValueSupplier.theValue(value);
    return this;
  }

  public StringGenerator content(String value) {
    this.content = DefinedValueSupplier.theValue(value);
    return this;
  }

  public StringGenerator nullChance(int chanceOfNull) {
    this.chanceOfNull = chanceOfNull;
    return this;
    }
}
 
