package com.geoffgranum.datagen.core;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongSequenceGeneratorTest {

  @Test
  public void testSequenceStartsWithMinValue() {
    LongSequenceGenerator gen = new LongSequenceGenerator(0, 5);
    assertThat(gen.next(), is(0L));
  }

  @Test
  public void testSequenceStartsHonorsMaxValue() {
    LongSequenceGenerator gen = new LongSequenceGenerator(0, 5);
    assertThat(gen.next(), is(0L));
    assertThat(gen.next(), is(1L));
    assertThat(gen.next(), is(2L));
    assertThat(gen.next(), is(3L));
    assertThat(gen.next(), is(4L));
    assertThat(gen.next(), is(5L));
    assertThat(gen.next(), is(0L));
  }
}
