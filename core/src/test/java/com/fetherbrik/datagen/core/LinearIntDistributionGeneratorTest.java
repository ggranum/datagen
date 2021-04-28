package com.fetherbrik.datagen.core;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class LinearIntDistributionGeneratorTest {

  @Test
  public void testLinearIntegerDistribution() {
    LinearDistributionGenerator<Integer> gen = LinearDistributionGenerator.fromLine(0, 10, -1, 10).resetRandom();
    Map<Integer, Integer> values = new HashMap<>();
    for (int i = 0; i < 10000; i++) {
      Integer v = gen.next();
      Integer count = values.get(v);
      count = count == null ? 1 : count + 1;
      values.put(v, count);
    }

    int x = 1;
    do {
      System.out.printf("Count at x='%s' is %s\n", x, values.get(x));
      assertThat(values.get(x), notNullValue());
      assertThat(values.get(x), Matchers.lessThan(values.get(x - 1)));
    } while (++x < 10);
  }


  @Test
  public void testLinearIntegerDistributionPositiveSlope() {
    LinearDistributionGenerator<Integer> gen = LinearDistributionGenerator.fromLine(0, 18, 1, 0).resetRandom();
    Map<Integer, Integer> values = new HashMap<>();
    for (int i = 0; i < 10000; i++) {
      Integer v = gen.next();
      Integer count = values.get(v);
      count = count == null ? 1 : count + 1;
      values.put(v, count);
    }
    int x = 2;
    do {
      System.out.printf("Count at x='%s' is %s\n", x, values.get(x));
      assertThat(values.get(x), notNullValue());
      assertThat(values.get(x), Matchers.greaterThan(values.get(x - 1)));
    } while (++x <= 18);
  }

  @Test
  public void testOtherThings() {
    LinearDistributionGenerator<String> gen = new LinearDistributionGenerator<>(List.of(
        "1", "1", "1", "1", "1", "1",
        "2", "2", "2", "2", "2", "2",
        "3",
        "5", "5", "5",
        "7", "7", "7",
        "9"
    ));
    for (int i = 0; i < 500; i++) {
      System.out.print(gen.next());
      System.out.print(",");
    }
  }
}
