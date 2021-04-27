package com.geoffgranum.datagen.core;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Geoff M. Granum
 */
public class LongSequenceGenerator implements Generator<Long> {

    private static final long MINIMUM_UNIQUE_VALUES =
        Long.parseLong(System.getProperty("datagen.sequence_generator.minimum_unique_values", "10000"));

    private static final long DEFAULT_INITIAL_VALUE;

    static {
        String propertyValue = System.getProperty("datagen.sequence_generator.default_initial_value", null);
        if (propertyValue != null) {
            DEFAULT_INITIAL_VALUE = Long.parseLong(propertyValue);
        } else {
            DEFAULT_INITIAL_VALUE = 0;
        }
    }

    private static final LongSequenceGenerator GLOBAL_SEQUENCE = new LongSequenceGenerator(DEFAULT_INITIAL_VALUE);

    private final AtomicLong sequence;

    private long minInclusive;
    private long maxInclusive;

    public LongSequenceGenerator(long minInclusive) {
        this(minInclusive, Long.MAX_VALUE);
    }

    public LongSequenceGenerator(long minInclusive, long maxInclusive) {
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
        sequence = new AtomicLong(minInclusive);
    }

    public LongSequenceGenerator() {
        this(DEFAULT_INITIAL_VALUE, DEFAULT_INITIAL_VALUE + MINIMUM_UNIQUE_VALUES);
    }

    @Override
    public Long next() {
        long value;
        synchronized (sequence) {
            value = sequence.longValue();
            if (!sequence.compareAndSet(maxInclusive, minInclusive)) {
                sequence.incrementAndGet();
            }
        }
        return value;
    }

    public static LongSequenceGenerator globalSequence() {
        return GLOBAL_SEQUENCE;
    }
}
 
