package com.fetherbrik.datagen.core;

import java.util.ArrayList;
import java.util.List;

public class ListGenerator<T> implements Generator<List<T>> {

  private Generator<T> type;
  private Generator<Integer> count;

  public ListGenerator(Generator<T> of) {
    this(of, Supplier.of(10));
  }

  public ListGenerator(Generator<T> type, Generator<Integer> count) {
    this.type = type;
    this.count = count;
  }

  public static <T> ListGenerator<T> of(Generator<T> type) {
    return new ListGenerator<>(type);
  }

  @Override public List<T> next() {
    int size = count.next();
    List<T> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add(type.next());
    }
    return list;
  }
}
