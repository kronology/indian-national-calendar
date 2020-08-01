package com.gebogebo.kronology.indian;

import org.junit.Test;
import static java.time.temporal.ChronoField.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.time.DateTimeException;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.stream.Stream;

/**
 * Tests the {@link IndianNationalChronology#range(ChronoField)} method.
 *
 * @author viraj
 * @since Shravan 1942 (Jul 2020)
 */
public class TestIndianChronologyRange {

    @Test
    public void testRangeDayOfMonth() {
        verifyRange(DAY_OF_MONTH, 1L, 30L, 31L);
    }

    @Test
    public void testRangeMonthOfYear() {
        verifyRange(MONTH_OF_YEAR, 1L, 12L, 12L);
    }

    @Test
    public void testRangeYear() {
        verifyRange(YEAR, -999999999L, 999999999L, 999999999L);
    }

    @Test
    public void testRangeYearOfEra() {
        verifyRange(YEAR_OF_ERA, 1L, 999999999L,1000000000L);
    }

    @Test
    public void testRangeEra() {
        verifyRange(ERA, 0L, 1L, 1L);
    }

    @Test
    public void testRangeEpochDay() {
        verifyRange(EPOCH_DAY, -365243219162L, 365241780471L, 365241780471L);
    }

    @Test
    public void testRangeDayOfYear() {
        verifyRange(DAY_OF_YEAR, 1L, 365L, 366L);
    }

    /**
     * Tests the unsupported {@code ChronoField} by IndianNationalChronology.
     */
    @Test
    public void testUnsupportedFields() {
        Stream.of(ALIGNED_DAY_OF_WEEK_IN_MONTH,
                ALIGNED_DAY_OF_WEEK_IN_YEAR,
                ALIGNED_WEEK_OF_MONTH,
                ALIGNED_WEEK_OF_YEAR,
                AMPM_OF_DAY,
                CLOCK_HOUR_OF_AMPM,
                CLOCK_HOUR_OF_DAY,
                DAY_OF_WEEK,
                HOUR_OF_AMPM,
                HOUR_OF_DAY,
                INSTANT_SECONDS,
                MICRO_OF_DAY,
                MICRO_OF_SECOND,
                MILLI_OF_DAY,
                MILLI_OF_SECOND,
                MINUTE_OF_DAY,
                MINUTE_OF_HOUR,
                NANO_OF_SECOND,
                NANO_OF_DAY,
                OFFSET_SECONDS,
                PROLEPTIC_MONTH,
                SECOND_OF_DAY,
                SECOND_OF_MINUTE).forEach(f -> {
            try {
                IndianNationalChronology.INSTANCE.range(f);
                fail("Expected exception for unsupported field: " + f);
            } catch(DateTimeException e) {
                // expected
            }
        });
    }

    /**
     * Verifies the value range in {@code IndianNationalChronology} for the given field.
     *
     * @param field        field for which the range is to be verified
     * @param minValue     minimum value that the field can have
     * @param maxSmallest  smallest maximum value that the field can have
     * @param maxLargest   largest maximum value that the field can have
     */
    private void verifyRange(ChronoField field, long minValue, long maxSmallest, long maxLargest) {
        ValueRange r = IndianNationalChronology.INSTANCE.range(field);
        assertThat(r.getMinimum(), is(minValue));
        assertThat(r.getMaximum(), is(maxLargest));
        assertThat(r.getSmallestMaximum(), is(maxSmallest));
    }
}
