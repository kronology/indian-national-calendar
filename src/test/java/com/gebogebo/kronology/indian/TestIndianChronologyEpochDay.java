package com.gebogebo.kronology.indian;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;

/**
 * Tests the {@link IndianNationalChronology#dateEpochDay(long)}.
 *
 * @author viraj
 * @since 1-5(Sravan)-1942
 */
public class TestIndianChronologyEpochDay {

    @Test
    public void testEpochDayStart() {
        verifyEpochDayWithIndianDate(0, new int[] {0, 1, 1});
    }

    @Test
    public void testEpochDayNegative() {
        verifyEpochDayWithIndianDate(-365, new int[] {-1, 1, 1});
        verifyEpochDayWithIndianDate(-1461, new int[] {-4, 1, 1});
    }

    @Test
    public void testEpochDayYearStart() {
        verifyEpochDayWithIndianDate(365, new int[] {1, 1, 1});
    }

    @Test
    public void testEpochDay() {
        verifyEpochDayWithIndianDate(709300, new int[] {1942, 1, 1});   // 2020-3-22
        verifyEpochDayWithIndianDate(690958, new int[] {1891, 10, 11}); // 1970-1-1
    }

    /**
     * Verifies the date created from the given epoch day against the given date components.
     *
     * @param epochDay              Indian epoch day (starts from 1-1-78)
     * @param indianDateComponents  date components to verify against
     */
    private static void verifyEpochDayWithIndianDate(long epochDay, int[] indianDateComponents) {
        ChronoLocalDate ld = IndianNationalChronology.INSTANCE.dateEpochDay(epochDay);
        Assert.assertThat(ld, instanceOf(IndianNationalDate.class));
        Assert.assertThat(ld.get(ChronoField.YEAR), CoreMatchers.is(indianDateComponents[0]));
        Assert.assertThat(ld.get(ChronoField.MONTH_OF_YEAR), CoreMatchers.is(indianDateComponents[1]));
        Assert.assertThat(ld.get(ChronoField.DAY_OF_MONTH), CoreMatchers.is(indianDateComponents[2]));
    }
}
