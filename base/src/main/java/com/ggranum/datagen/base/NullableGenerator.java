package com.ggranum.datagen.base;

import java.util.Random;
import javax.annotation.Nullable;

/**
 * Wrap another generator in a NullableGenerator in order to return null values based on chance.
 * <br/>
 * Set the chance as a percentage, with 0 being 'will never return null' and '100' being 'always return null'.<br/>
 * <br/><br/>
 * This class utilizes an instance of java.util.Random that is, by default, initialized with the value '1024L'. Thus,
 * for most use cases, uses of this Generator will provide repeatable results, <i>provided the generator instance
 * is not shared between tests</i>.<br/>
 * <br/>
 * To force 'true' random behavior, set the environment property 'datagen.no_repeatable_random' to true:
 * "-Ddatagen.no_repeatable_random=true" in your test runner arguments.
 *
 * @author Geoff M. Granum
 */
public class NullableGenerator<T> implements Generator<T> {

    private static final Boolean NON_REPEATABLE_RANDOM = Boolean.valueOf("datagen.no_repeatable_random");
    private final Random random = new Random(NON_REPEATABLE_RANDOM ? System.currentTimeMillis() : 1024L);
    private final Generator<T> wrappedGenerator;
    private int chanceOfNull = 10;

    /**
     * Create a new NullableGenerator with a 10% chance of returning a null value, and, correspondingly, a 90%
     * chance of returning the value<code>wrappedGenerator#next</code>.
     */
    public NullableGenerator(Generator<T> wrappedGenerator) {
        this.wrappedGenerator = wrappedGenerator;
    }

    /**
     * Change the chance of receiving a null value instead of the value from the wrapped generator.<br/>
     * Defaults to '10', meaning 10% chance of null.<br/>
     * The chance is
     *
     * @param percentChanceOfNull A percentage, with 0 being 'will never return null' and '100' being 'always return
     *                            null'.
     */
    public NullableGenerator<T> nullChance(int percentChanceOfNull) {
        this.chanceOfNull = percentChanceOfNull;
        return this;
    }

    @Nullable
    @Override
    public T next() {
        return nextIsNull() ? null : wrappedGenerator.next();
    }

    /**
     * If nextInt == 40 and chanceOfNull is 60, return true.
     * If nextInt == 60 and chanceOfNull is 60, return true.
     * If nextInt == 79 and chanceOfNull is 60, return false.
     */
    private boolean nextIsNull() {
        // 0 to 101, exclusive.
        return random.nextInt(101) <= chanceOfNull;
    }

    public static <U> NullableGenerator<U> randomNullFor(Generator<U> generator) {
        return new NullableGenerator<U>(generator);
    }

    public static <U> NullableGenerator<U> randomNullFor(Generator<U> generator, int percentChanceOfNull) {
        return new NullableGenerator<U>(generator).nullChance(percentChanceOfNull);
    }
}
 
