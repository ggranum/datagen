package com.ggranum.datagen.base;

/**
 * @author Geoff M. Granum
 */
public class EmailAddressGenerator implements Generator<String> {

  private Generator<String> emailAddress = new StringGenerator()
      .prefix("email_")
      .content(StringSequenceGenerator.globalStringSequenceGenerator())
      .postfix("@example.com");

  @Override
  public String next() {
    return emailAddress.next();
  }
}
 
