package com.geoffgranum.datagen.core;

/**
 * @author Geoff M. Granum
 */
public class EmailAddressGenerator implements Generator<String> {

  private final Generator<String> localPart;
  private final Generator<String> domain;

  public EmailAddressGenerator() {
    this.localPart = Supplier.of("email_");
    this.domain = Supplier.of("example.com");
  }


  public EmailAddressGenerator(Generator<String> localPart, Generator<String> domain) {
    this.localPart = localPart;
    this.domain = domain;
  }


  @Override
  public String next() {
    return localPart.next() + '@' + domain.next();
  }
}
 
