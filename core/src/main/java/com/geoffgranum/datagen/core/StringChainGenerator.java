package com.geoffgranum.datagen.core;

import java.util.List;

public class StringChainGenerator extends ChainGenerator<String> {

  public StringChainGenerator(List<Generator<String>> chain) {
    super(chain);
  }

  @Override public String next() {
    StringBuilder b = new StringBuilder();
    for (Generator<String> gen : chain()) {
      b.append(gen.next());
    }
    return b.toString();
  }
}
