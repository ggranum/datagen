package com.fetherbrik.datagen.core;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringGeneratorTest {
  @Test
  public void testCanGenerateSixCharacterString() {
    StringGenerator gen = new StringGenerator(6, 6);
    assertThat(gen.next().length(), is(6));
    assertThat(gen.next().length(), is(6));
    assertThat(gen.next().length(), is(6));
  }

  @Test
  public void testCanGenerateZeroTo4CharacterString() {
    StringGenerator gen = new StringGenerator(0, 4).resetRandom();
    // Random is pseudo random, this test should pass consistently, provided the JVM's are using the same
    // generator in the background. Part of the purpose of this test is to verify that.

    assertThat(gen.next().length(), is(2));
    assertThat(gen.next().length(), is(2));
    assertThat(gen.next().length(), is(2));
    assertThat(gen.next().length(), is(3));
    assertThat(gen.next().length(), is(2));
    assertThat(gen.next().length(), is(3));
    assertThat(gen.next().length(), is(1));
    assertThat(gen.next().length(), is(0));
    assertThat(gen.next().length(), is(1));
  }
}
