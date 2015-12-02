package com.ggranum.datagen.base;

import java.util.Iterator;

/**
 * Provide a single value from an Iterable source per each call of {@link #next}.
 * Upon reaching the last value the iterator will reset.
 *
 * @author Geoff M. Granum
 */
public class IterableValueSupplier<T> implements Generator<T> {

  private final Iterable<T> value;
  private Iterator<T> iterator;

  public IterableValueSupplier(Iterable<T> value) {
    this.value = value;
  }

  @Override
  public T next() {
    if(iterator == null || !iterator.hasNext()) {
      iterator = value.iterator();
      if(!iterator.hasNext()) {
        throw new RuntimeException("Provided iterable is empty.");
      }
    }
    return iterator.next();
  }

  public static <U> Generator<U> oneOf(Iterable<U> values) {
    return new IterableValueSupplier<>(values);
  }
}
 
