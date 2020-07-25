package com.gebogebo.kronology.indian;

import org.junit.Assert;
import org.junit.Test;
import static java.time.temporal.ChronoField.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DateTimeException;
import java.time.chrono.ChronoLocalDate;
import java.util.stream.IntStream;

/**
 * Test the behavior of {@link IndianNationalChronology#dateYearDay(int, int)}.
 *
 * @author viraj
 * @since Aashadh 1942 (Jul 2020)
 */
public class TestIndianChronologyDateYearDay {

    @Test
    public void testInvalidValues() {
        IntStream.of(-1, -12, 367, 1000).forEach(i -> {
            try {
                IndianNationalChronology.INSTANCE.dateYearDay(1942, i);
                Assert.fail("Expected an error for invalid value");
            } catch (DateTimeException e) {
                // expected
            }
        });
    }

    @Test
    public void testYearStartNonLeap() {
        verifyIndianDateFromDayOfYear(1941, 1, new int[] {1, 1});
        verifyIndianDateFromDayOfYear(-141, 1, new int[] {1, 1});
    }

    @Test
    public void testYearStartLeap() {
        verifyIndianDateFromDayOfYear(1942, 1, new int[] {1, 1});
        verifyIndianDateFromDayOfYear(-942, 1, new int[] {1, 1});
    }

    @Test
    public void testMonthStartNonLeap() {
        verifyIndianDateFromDayOfYear(1941, 1, new int[] {1, 1}); // chaitra
        verifyIndianDateFromDayOfYear(1941, 31, new int[] {2, 1}); // vaishak
        verifyIndianDateFromDayOfYear(1941, 62, new int[] {3, 1}); // jyestha
        verifyIndianDateFromDayOfYear(1941, 93, new int[] {4, 1}); // ashadh
        verifyIndianDateFromDayOfYear(1941, 124, new int[] {5, 1}); // shravan
        verifyIndianDateFromDayOfYear(1941, 155, new int[] {6, 1}); // bhardra
        verifyIndianDateFromDayOfYear(1941, 186, new int[] {7, 1}); // ashwin
        verifyIndianDateFromDayOfYear(1941, 216, new int[] {8, 1}); // kartika
        verifyIndianDateFromDayOfYear(1941, 246, new int[] {9, 1}); // agrahayan
        verifyIndianDateFromDayOfYear(1941, 276, new int[] {10, 1}); // paush
        verifyIndianDateFromDayOfYear(1941, 306, new int[] {11, 1}); // magh
        verifyIndianDateFromDayOfYear(1941, 336, new int[] {12, 1}); // phalgun
        verifyIndianDateFromDayOfYear(1941, 365, new int[] {12, 30}); // phalgun-end
    }

    @Test
    public void testMonthStartLeap() {
        verifyIndianDateFromDayOfYear(1942, 1, new int[] {1, 1}); // chaitra
        verifyIndianDateFromDayOfYear(1942, 32, new int[] {2, 1}); // vaishak
        verifyIndianDateFromDayOfYear(1942, 63, new int[] {3, 1}); // jyestha
        verifyIndianDateFromDayOfYear(1942, 94, new int[] {4, 1}); // ashadh
        verifyIndianDateFromDayOfYear(1942, 125, new int[] {5, 1}); // shravan
        verifyIndianDateFromDayOfYear(1942, 156, new int[] {6, 1}); // bhardra
        verifyIndianDateFromDayOfYear(1942, 187, new int[] {7, 1}); // ashwin
        verifyIndianDateFromDayOfYear(1942, 217, new int[] {8, 1}); // kartika
        verifyIndianDateFromDayOfYear(1942, 247, new int[] {9, 1}); // agrahayan
        verifyIndianDateFromDayOfYear(1942, 277, new int[] {10, 1}); // paush
        verifyIndianDateFromDayOfYear(1942, 307, new int[] {11, 1}); // magh
        verifyIndianDateFromDayOfYear(1942, 337, new int[] {12, 1}); // phalgun
        verifyIndianDateFromDayOfYear(1942, 366, new int[] {12, 30}); // phalgun-end
    }

    /**
     * Verifies the ChronoLocalDate instance that is created with the from
     * {@code IndianNationalChronology} using given parameters. Verification is done against the
     * passed in {@code dateComponents}.
     *
     * @param prolepticYear   proleptic year of Indian chronology
     * @param dayOfYear       day of year of Indian chronology
     * @param dateComponents  date components which will be used to validate the {@link IndianNationalDate} instance
     */
    private static void verifyIndianDateFromDayOfYear(int prolepticYear, int dayOfYear, int[] dateComponents) {
        ChronoLocalDate id = IndianNationalChronology.INSTANCE.dateYearDay(prolepticYear, dayOfYear);
        assertThat(id.get(YEAR), is(prolepticYear));
        assertThat(id.get(MONTH_OF_YEAR), is(dateComponents[0]));
        assertThat(id.get(DAY_OF_MONTH), is(dateComponents[1]));
    }
}
