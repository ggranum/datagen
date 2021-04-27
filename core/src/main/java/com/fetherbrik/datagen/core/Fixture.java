package com.fetherbrik.datagen.core;

/**
 * @author Geoff M. Granum
 */
public interface Fixture<T> extends Generator<T> {

  public T nextPersisted();

  public T persist(T generated);
}
