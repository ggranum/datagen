package com.fetherbrik.datagen.core;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringChainGeneratorTest {

  @Test
  public void testCanGenerateStaticChain() {
    StringChainGenerator gen = new StringChainGenerator(List.of(
        Supplier.of("example"),
        Supplier.of("@"),
        Supplier.of("gmail.com")));
    assertThat(gen.next(), is("example@gmail.com"));
    assertThat(gen.next(), is("example@gmail.com"));
    assertThat(gen.next(), is("example@gmail.com"));
  }

  @Test
  public void testCanGenerateCountingChain() {
    StringChainGenerator gen = new StringChainGenerator(List.of(
        Supplier.of("count-"),
        StringSequenceGenerator.inRange(0, 2)));
    assertThat(gen.next(), is("count-0"));
    assertThat(gen.next(), is("count-1"));
    assertThat(gen.next(), is("count-2"));
    assertThat(gen.next(), is("count-0"));
  }

  @Test
  public void testCanGenerateCountingChainWithPadding() {
    StringChainGenerator gen = new StringChainGenerator(List.of(
        Supplier.of("count-"),
        StringSequenceGenerator.inRange(8, 11, 2, '0')));
    assertThat(gen.next(), is("count-08"));
    assertThat(gen.next(), is("count-09"));
    assertThat(gen.next(), is("count-10"));
    assertThat(gen.next(), is("count-11"));
    assertThat(gen.next(), is("count-08"));
  }

  @Test
  public void testPaddingChar() {
    StringChainGenerator gen = new StringChainGenerator(List.of(
        Supplier.of("count-"),
        StringSequenceGenerator.inRange(8, 11, 2, '=')));
    assertThat(gen.next(), is("count-=8"));
    assertThat(gen.next(), is("count-=9"));
    assertThat(gen.next(), is("count-10"));
    assertThat(gen.next(), is("count-11"));
    assertThat(gen.next(), is("count-=8"));
  }

}
