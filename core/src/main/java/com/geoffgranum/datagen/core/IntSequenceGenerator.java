package com.geoffgranum.datagen.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Geoff M. Granum
 */
public class IntSequenceGenerator implements Generator<Integer> {

  private final int min;
  private final int max;
  private final AtomicInteger current;

  /**
   * @param min The lowest (and first) value that will ever be returned by a call to next()
   * @param max The largest value that will ever be returned by a call to next()
   */
  public IntSequenceGenerator(int min, int max) {
    this.min = min;
    this.max = max;
    this.current = new AtomicInteger(min);
  }

  @Override
  public Integer next() {
    synchronized (current){
      if(!current.compareAndSet(max, min)){
        current.incrementAndGet();
      }
      return current.get();
    }
  }
}
 
