package com.geoffgranum.datagen.core;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;

public abstract class ChainGenerator<T> implements Generator<T> {

  private final List<Generator<T>> chain;

  public ChainGenerator(List<Generator<T>> chain) {
    this.chain = chain;
  }

  public ChainGenerator(Generator<T>... chain) {
    this.chain = Arrays.asList(chain);
  }

  List<Generator<T>> chain() {
    return ImmutableList.copyOf(chain);
  }

}
