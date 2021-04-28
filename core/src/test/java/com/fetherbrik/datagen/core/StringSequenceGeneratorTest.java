package com.fetherbrik.datagen.core;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringSequenceGeneratorTest {

  @Test
  public void testSequenceStartsWithMinAndRollsOverAtMax() {
    StringSequenceGenerator range = StringSequenceGenerator.inRange(0, 2);
    assertThat(range.next(), is("0"));
    assertThat(range.next(), is("1"));
    assertThat(range.next(), is("2"));
    assertThat(range.next(), is("0"));
  }

  @Test
  public void testSequenceStartsWithMinAndRollsOverAtMaxForHex() {
    StringSequenceGenerator range = StringSequenceGenerator.alphaNumericInRange(0, 40);
    assertThat(range.next(), is("0"));
    assertThat(range.next(), is("1"));
    assertThat(range.next(), is("2"));
    assertThat(range.next(), is("3"));
    assertThat(range.next(), is("4"));
    assertThat(range.next(), is("5"));
    assertThat(range.next(), is("6"));
    assertThat(range.next(), is("7"));
    assertThat(range.next(), is("8"));
    assertThat(range.next(), is("9"));
    assertThat(range.next(), is("a"));
    assertThat(range.next(), is("b"));
    assertThat(range.next(), is("c"));
    assertThat(range.next(), is("d"));
    assertThat(range.next(), is("e"));
    assertThat(range.next(), is("f"));
    assertThat(range.next(), is("g"));
    assertThat(range.next(), is("h"));
    assertThat(range.next(), is("i"));
    assertThat(range.next(), is("j"));
    assertThat(range.next(), is("k"));
    assertThat(range.next(), is("l"));
    assertThat(range.next(), is("m"));
    assertThat(range.next(), is("n"));
    assertThat(range.next(), is("o"));
    assertThat(range.next(), is("p"));
    assertThat(range.next(), is("q"));
    assertThat(range.next(), is("r"));
    assertThat(range.next(), is("s"));
    assertThat(range.next(), is("t"));
    assertThat(range.next(), is("u"));
    assertThat(range.next(), is("v"));
    assertThat(range.next(), is("w"));
    assertThat(range.next(), is("x"));
    assertThat(range.next(), is("y"));
    assertThat(range.next(), is("z"));
    assertThat(range.next(), is("10"));
    assertThat(range.next(), is("11"));
    assertThat(range.next(), is("12"));
    assertThat(range.next(), is("13"));
    assertThat(range.next(), is("14"));
    assertThat(range.next(), is("0"));
  }
}
