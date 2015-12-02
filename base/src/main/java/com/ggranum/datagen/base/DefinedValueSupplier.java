package com.ggranum.datagen.base;

/**
 * Supply a constant, known value for every call to {@link #next()}
 *
 * @author Geoff M. Granum
 */
public class DefinedValueSupplier<T> implements Generator<T> {

  private final T value;

  public DefinedValueSupplier(T value) {
    this.value = value;
  }

  @Override
  public T next() {
    return value;
  }

  /**
   * Supply a constant value for every call to {@link #next()}
   *
   * @param value The value that will be returned on every call to {@link #next()}
   *
   * @return A {@link Generator} that will always return the passed argument.
   */
  public static <U> Generator<U> theValue(U value) {
    return new DefinedValueSupplier<>(value);
  }
}
 
