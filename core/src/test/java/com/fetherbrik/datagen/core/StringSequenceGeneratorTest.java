package com.fetherbrik.datagen.core;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringSequenceGeneratorTest {

  @Test
  public void testSequenceStartsWithMin() {
    StringSequenceGenerator range = StringSequenceGenerator.inRange(0, 2);
    assertThat(range.next(), is("0"));
  }
}
