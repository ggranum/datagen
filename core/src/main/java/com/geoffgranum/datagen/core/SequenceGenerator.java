package com.geoffgranum.datagen.core;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang.time.DateUtils;

/**
 * @author Geoff M. Granum
 */
public class SequenceGenerator implements Generator<Long> {

    private static final long MINIMUM_UNIQUE_VALUES =
        Long.parseLong(System.getProperty("datagen.sequence_generator.minimum_unique_values", "10000"));

    private static final long DEFAULT_INITIAL_VALUE;

    static {
        String propertyValue = System.getProperty("datagen.sequence_generator.default_initial_value", null);
        if(propertyValue != null) {
            DEFAULT_INITIAL_VALUE = Long.parseLong(propertyValue);
        } else {
            long secondOfDay = DateUtils.getFragmentInSeconds(new Date(), Calendar.DATE);
            DEFAULT_INITIAL_VALUE = secondOfDay * MINIMUM_UNIQUE_VALUES;
        }
    }

    private static final SequenceGenerator GLOBAL_SEQUENCE = new SequenceGenerator(DEFAULT_INITIAL_VALUE);

    private final AtomicLong sequence;

    public SequenceGenerator(Long initialValue) {
        sequence = new AtomicLong(initialValue);
    }

    public SequenceGenerator() {
        this(DEFAULT_INITIAL_VALUE);
    }

    @Override
    public Long next() {
        return sequence.incrementAndGet();
    }

    public static SequenceGenerator globalSequence() {
        return GLOBAL_SEQUENCE;
    }
}
 
