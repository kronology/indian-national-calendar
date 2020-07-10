package com.gebogebo.kronology;

import com.gebogebo.kronology.indian.IndianNationalDate;
import org.junit.Test;
import static java.time.temporal.ChronoField.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

/**
 * Tests the {@code IndianNationalDate} class.
 *
 * @author viraj
 * @since Jul 2020
 */
public class TestIndianNationalDate {

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the epoch date of Iso chronology.
     */
    @Test
    public void testIsoEpochTime() {
        testIndianNationalDate(new int[] {0, 1, 1}, new int[] {-79, 10, 11});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the epoch date of Indian chronology.
     */
    @Test
    public void testIndianEpochTime() {
        testIndianNationalDate(new int[] {78, 3, 22}, new int[] {0, 1, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Indian non-leap year.
     */
    @Test
    public void testIndianNewYear() {
        testIndianNationalDate(new int[] {2019, 3, 22}, new int[] {1941, 1, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Iso non-leap year.
     */
    @Test
    public void testIsoNewYear() {
        testIndianNationalDate(new int[] {2019, 1, 1}, new int[] {1940, 10, 11});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Indian leap year.
     */
    @Test
    public void testIndianNewLeapYear() {
        testIndianNationalDate(new int[] {2020, 3, 21}, new int[] {1942, 1, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Iso leap year.
     */
    @Test
    public void testIsoNewLeapYear() {
        testIndianNationalDate(new int[] {2020, 1, 1}, new int[] {1941, 10, 11});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Indian leap year.
     */
    @Test
    public void testLastDayOfYearInLeapYear() {
        testIndianNationalDate(new int[] {2020, 3, 20}, new int[] {1941, 12, 30});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Iso leap year.
     */
    @Test
    public void testIsoLastDayOfYearInLeapYear() {
        testIndianNationalDate(new int[] {2020, 12, 31}, new int[] {1942, 10, 10});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Indian non-leap year.
     */
    @Test
    public void testLastDayOfYearInNonLeapYear() {
        testIndianNationalDate(new int[] {2019, 3, 20}, new int[] {1940, 12, 29});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Iso non-leap year.
     */
    @Test
    public void testIsoLastDayOfYearInNonLeapYear() {
        testIndianNationalDate(new int[] {2019, 12, 31}, new int[] {1941, 10, 10});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Indian month start in a non-leap year.
     */
    @Test
    public void testSakaMonthStartNonLeapYear() {
        testIndianNationalDate(new int[] {2018, 3, 22}, new int[] {1940, 1, 1});
        testIndianNationalDate(new int[] {2018, 4, 21}, new int[] {1940, 2, 1});
        testIndianNationalDate(new int[] {2018, 5, 22}, new int[] {1940, 3, 1});
        testIndianNationalDate(new int[] {2018, 6, 22}, new int[] {1940, 4, 1});
        testIndianNationalDate(new int[] {2018, 7, 23}, new int[] {1940, 5, 1});
        testIndianNationalDate(new int[] {2018, 8, 23}, new int[] {1940, 6, 1});
        testIndianNationalDate(new int[] {2018, 9, 23}, new int[] {1940, 7, 1});
        testIndianNationalDate(new int[] {2018, 10, 23}, new int[] {1940, 8, 1});
        testIndianNationalDate(new int[] {2018, 11, 22}, new int[] {1940, 9, 1});
        testIndianNationalDate(new int[] {2018, 12, 22}, new int[] {1940, 10, 1});
        testIndianNationalDate(new int[] {2018, 1, 21}, new int[] {1939, 11, 1});
        testIndianNationalDate(new int[] {2018, 2, 20}, new int[] {1939, 12, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Iso month start in a non-leap year.
     */
    @Test
    public void testIsoMonthStartNonLeapYear() {
        testIndianNationalDate(new int[] {2018, 1, 1}, new int[] {1939, 10, 11});
        testIndianNationalDate(new int[] {2018, 2, 1}, new int[] {1939, 11, 12});
        testIndianNationalDate(new int[] {2018, 3, 1}, new int[] {1939, 12, 10});
        testIndianNationalDate(new int[] {2018, 4, 1}, new int[] {1940, 1, 11});
        testIndianNationalDate(new int[] {2018, 5, 1}, new int[] {1940, 2, 11});
        testIndianNationalDate(new int[] {2018, 6, 1}, new int[] {1940, 3, 11});
        testIndianNationalDate(new int[] {2018, 7, 1}, new int[] {1940, 4, 10});
        testIndianNationalDate(new int[] {2018, 8, 1}, new int[] {1940, 5, 10});
        testIndianNationalDate(new int[] {2018, 9, 1}, new int[] {1940, 6, 10});
        testIndianNationalDate(new int[] {2018, 10, 1}, new int[] {1940, 7, 9});
        testIndianNationalDate(new int[] {2018, 11, 1}, new int[] {1940, 8, 10});
        testIndianNationalDate(new int[] {2018, 12, 1}, new int[] {1940, 9, 10});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Indian month start in a leap year.
     */
    @Test
    public void testSakaMonthStartLeapYear() {
        testIndianNationalDate(new int[] {2020, 3, 21}, new int[] {1942, 1, 1});
        testIndianNationalDate(new int[] {2020, 4, 21}, new int[] {1942, 2, 1});
        testIndianNationalDate(new int[] {2020, 5, 22}, new int[] {1942, 3, 1});
        testIndianNationalDate(new int[] {2020, 6, 22}, new int[] {1942, 4, 1});
        testIndianNationalDate(new int[] {2020, 7, 23}, new int[] {1942, 5, 1});
        testIndianNationalDate(new int[] {2020, 8, 23}, new int[] {1942, 6, 1});
        testIndianNationalDate(new int[] {2020, 9, 23}, new int[] {1942, 7, 1});
        testIndianNationalDate(new int[] {2020, 10, 23}, new int[] {1942, 8, 1});
        testIndianNationalDate(new int[] {2020, 11, 22}, new int[] {1942, 9, 1});
        testIndianNationalDate(new int[] {2020, 12, 22}, new int[] {1942, 10, 1});
        testIndianNationalDate(new int[] {2020, 1, 21}, new int[] {1941, 11, 1});
        testIndianNationalDate(new int[] {2020, 2, 20}, new int[] {1941, 12, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Iso month start in a leap year.
     */
    @Test
    public void testIsoMonthStartLeapYear() {
        testIndianNationalDate(new int[] {2020, 1, 1}, new int[] {1941, 10, 11});
        testIndianNationalDate(new int[] {2020, 2, 1}, new int[] {1941, 11, 12});
        testIndianNationalDate(new int[] {2020, 3, 1}, new int[] {1941, 12, 11});
        testIndianNationalDate(new int[] {2020, 4, 1}, new int[] {1942, 1, 12});
        testIndianNationalDate(new int[] {2020, 5, 1}, new int[] {1942, 2, 11});
        testIndianNationalDate(new int[] {2020, 6, 1}, new int[] {1942, 3, 11});
        testIndianNationalDate(new int[] {2020, 7, 1}, new int[] {1942, 4, 10});
        testIndianNationalDate(new int[] {2020, 8, 1}, new int[] {1942, 5, 10});
        testIndianNationalDate(new int[] {2020, 9, 1}, new int[] {1942, 6, 10});
        testIndianNationalDate(new int[] {2020, 10, 1}, new int[] {1942, 7, 9});
        testIndianNationalDate(new int[] {2020, 11, 1}, new int[] {1942, 8, 10});
        testIndianNationalDate(new int[] {2020, 12, 1}, new int[] {1942, 9, 10});
    }

    /**
     * A utility method to test conversion from isoDate to indianDate.
     *
     * @param isoDates     Iso date components in the order of year, month and day of month.
     * @param indianDates  Indian date components in the order of year, month and day of month.
     */
    private static void testIndianNationalDate(int[] isoDates, int[] indianDates) {
        LocalDate isoLocalDate = LocalDate.of(isoDates[0], isoDates[1], isoDates[2]);
        IndianNationalDate indianNationalDate = IndianNationalDate.of(isoLocalDate);
        assertThat("year doesn't match", indianNationalDate.get(YEAR), is(indianDates[0]));
        assertThat("month doesn't match", indianNationalDate.get(MONTH_OF_YEAR), is(indianDates[1]));
        assertThat("day doesn't match", indianNationalDate.get(DAY_OF_MONTH), is(indianDates[2]));
    }
}
