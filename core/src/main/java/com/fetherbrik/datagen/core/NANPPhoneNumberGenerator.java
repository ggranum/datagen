package com.fetherbrik.datagen.core;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @todo: Handle '01' vs '1' for international prefix.
 * @author Geoff M. Granum
 */
public class NANPPhoneNumberGenerator implements Generator<String> {

  private final boolean withCountryCode;
  private final Generator<Integer> areaCode;
  private final Generator<Integer> exchangeCode;
  private final Generator<Integer> subscriberNumber;
  private final Generator<String> separator;

  /**
   * Generates generally valid phone numbers of the form
   * 200-200-0000
   * 200.200.0000
   * 200 200 0000
   * through
   * 999-999-9999
   * See North American Numbering Plan (NANP) specification for details.
   */
  public NANPPhoneNumberGenerator() {
    this(false,
         new IntSequenceGenerator(200, 999),
         new IntSequenceGenerator(200, 999),
         new IntSequenceGenerator(0, 9999),
         new IterableValueSupplier<>(Lists.newArrayList(
             "-", ".", " "
         ))
    );
  }

  public NANPPhoneNumberGenerator(
      boolean withCountryCode,
      Generator<Integer> areaCode,
      Generator<Integer> exchangeCode,
      Generator<Integer> subscriberNumber,
      Generator<String> separator) {
    this.withCountryCode = withCountryCode;
    this.areaCode = areaCode;
    this.exchangeCode = exchangeCode;
    this.subscriberNumber = subscriberNumber;
    this.separator = separator;
  }

  @Override
  public String next() {
    String sep = separator.next();
    String phn =
        areaCode.next() +
        sep +
        exchangeCode.next() +
        sep +
        StringUtils.leftPad(String.valueOf(subscriberNumber.next()), 4, '0');
    return withCountryCode ? "1" + sep + phn : phn;
  }
}
 
