package com.gebogebo.kronology.indian;

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
        testTranslation(new int[] {0, 1, 1}, new int[] {-79, 10, 11});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the epoch date of Indian chronology.
     */
    @Test
    public void testIndianEpochTime() {
        testTranslation(new int[] {78, 3, 22}, new int[] {0, 1, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Indian non-leap year.
     */
    @Test
    public void testIndianNewYear() {
        testTranslation(new int[] {2019, 3, 22}, new int[] {1941, 1, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Iso non-leap year.
     */
    @Test
    public void testIsoNewYear() {
        testTranslation(new int[] {2019, 1, 1}, new int[] {1940, 10, 11});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Indian leap year.
     */
    @Test
    public void testIndianNewLeapYear() {
        testTranslation(new int[] {2020, 3, 21}, new int[] {1942, 1, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the first day of an Iso leap year.
     */
    @Test
    public void testIsoNewLeapYear() {
        testTranslation(new int[] {2020, 1, 1}, new int[] {1941, 10, 11});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Indian leap year.
     */
    @Test
    public void testLastDayOfYearInLeapYear() {
        testTranslation(new int[] {2020, 3, 20}, new int[] {1941, 12, 30});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Iso leap year.
     */
    @Test
    public void testIsoLastDayOfYearInLeapYear() {
        testTranslation(new int[] {2020, 12, 31}, new int[] {1942, 10, 10});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Indian non-leap year.
     */
    @Test
    public void testLastDayOfYearInNonLeapYear() {
        testTranslation(new int[] {2019, 3, 20}, new int[] {1940, 12, 29});
    }

    /**
     * Test the Iso to Indian date conversion for the date corresponding to the last day of an Iso non-leap year.
     */
    @Test
    public void testIsoLastDayOfYearInNonLeapYear() {
        testTranslation(new int[] {2019, 12, 31}, new int[] {1941, 10, 10});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Indian month start in a non-leap year.
     */
    @Test
    public void testSakaMonthStartNonLeapYear() {
        testTranslation(new int[] {2018, 3, 22}, new int[] {1940, 1, 1});
        testTranslation(new int[] {2018, 4, 21}, new int[] {1940, 2, 1});
        testTranslation(new int[] {2018, 5, 22}, new int[] {1940, 3, 1});
        testTranslation(new int[] {2018, 6, 22}, new int[] {1940, 4, 1});
        testTranslation(new int[] {2018, 7, 23}, new int[] {1940, 5, 1});
        testTranslation(new int[] {2018, 8, 23}, new int[] {1940, 6, 1});
        testTranslation(new int[] {2018, 9, 23}, new int[] {1940, 7, 1});
        testTranslation(new int[] {2018, 10, 23}, new int[] {1940, 8, 1});
        testTranslation(new int[] {2018, 11, 22}, new int[] {1940, 9, 1});
        testTranslation(new int[] {2018, 12, 22}, new int[] {1940, 10, 1});
        testTranslation(new int[] {2018, 1, 21}, new int[] {1939, 11, 1});
        testTranslation(new int[] {2018, 2, 20}, new int[] {1939, 12, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Iso month start in a non-leap year.
     */
    @Test
    public void testIsoMonthStartNonLeapYear() {
        testTranslation(new int[] {2018, 1, 1}, new int[] {1939, 10, 11});
        testTranslation(new int[] {2018, 2, 1}, new int[] {1939, 11, 12});
        testTranslation(new int[] {2018, 3, 1}, new int[] {1939, 12, 10});
        testTranslation(new int[] {2018, 4, 1}, new int[] {1940, 1, 11});
        testTranslation(new int[] {2018, 5, 1}, new int[] {1940, 2, 11});
        testTranslation(new int[] {2018, 6, 1}, new int[] {1940, 3, 11});
        testTranslation(new int[] {2018, 7, 1}, new int[] {1940, 4, 10});
        testTranslation(new int[] {2018, 8, 1}, new int[] {1940, 5, 10});
        testTranslation(new int[] {2018, 9, 1}, new int[] {1940, 6, 10});
        testTranslation(new int[] {2018, 10, 1}, new int[] {1940, 7, 9});
        testTranslation(new int[] {2018, 11, 1}, new int[] {1940, 8, 10});
        testTranslation(new int[] {2018, 12, 1}, new int[] {1940, 9, 10});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Indian month start in a leap year.
     */
    @Test
    public void testSakaMonthStartLeapYear() {
        testTranslation(new int[] {2020, 3, 21}, new int[] {1942, 1, 1});
        testTranslation(new int[] {2020, 4, 21}, new int[] {1942, 2, 1});
        testTranslation(new int[] {2020, 5, 22}, new int[] {1942, 3, 1});
        testTranslation(new int[] {2020, 6, 22}, new int[] {1942, 4, 1});
        testTranslation(new int[] {2020, 7, 23}, new int[] {1942, 5, 1});
        testTranslation(new int[] {2020, 8, 23}, new int[] {1942, 6, 1});
        testTranslation(new int[] {2020, 9, 23}, new int[] {1942, 7, 1});
        testTranslation(new int[] {2020, 10, 23}, new int[] {1942, 8, 1});
        testTranslation(new int[] {2020, 11, 22}, new int[] {1942, 9, 1});
        testTranslation(new int[] {2020, 12, 22}, new int[] {1942, 10, 1});
        testTranslation(new int[] {2020, 1, 21}, new int[] {1941, 11, 1});
        testTranslation(new int[] {2020, 2, 20}, new int[] {1941, 12, 1});
    }

    /**
     * Test the Iso to Indian date conversion for the dates corresponding to Iso month start in a leap year.
     */
    @Test
    public void testIsoMonthStartLeapYear() {
        testTranslation(new int[] {2020, 1, 1}, new int[] {1941, 10, 11});
        testTranslation(new int[] {2020, 2, 1}, new int[] {1941, 11, 12});
        testTranslation(new int[] {2020, 3, 1}, new int[] {1941, 12, 11});
        testTranslation(new int[] {2020, 4, 1}, new int[] {1942, 1, 12});
        testTranslation(new int[] {2020, 5, 1}, new int[] {1942, 2, 11});
        testTranslation(new int[] {2020, 6, 1}, new int[] {1942, 3, 11});
        testTranslation(new int[] {2020, 7, 1}, new int[] {1942, 4, 10});
        testTranslation(new int[] {2020, 8, 1}, new int[] {1942, 5, 10});
        testTranslation(new int[] {2020, 9, 1}, new int[] {1942, 6, 10});
        testTranslation(new int[] {2020, 10, 1}, new int[] {1942, 7, 9});
        testTranslation(new int[] {2020, 11, 1}, new int[] {1942, 8, 10});
        testTranslation(new int[] {2020, 12, 1}, new int[] {1942, 9, 10});
    }

    /**
     * A utility method to test conversion between isoDate and indianDate.
     *
     * @param isoDates     Iso date components in the order of year, month and day of month.
     * @param indianDates  Indian date components in the order of year, month and day of month.
     */
    private static void testTranslation(int[] isoDates, int[] indianDates) {
        compareIndianDateFromLocalDateComponents(isoDates, indianDates);
        compareIsoDateFromIndianDateComponents(isoDates, indianDates);
    }

    /**
     * Tests the Indian date's components (year, month and day of month) by instantiating an Indian date from a local
     * date.
     */
    private static void compareIndianDateFromLocalDateComponents(int[] isoDates, int[] indianDates) {
        LocalDate isoLocalDate = LocalDate.of(isoDates[0], isoDates[1], isoDates[2]);
        // create an Indian date from Iso date and verify expectations
        IndianNationalDate indianDate = IndianNationalDate.of(isoLocalDate);
        assertThat("fromIsoDate(): year doesn't match", indianDate.get(YEAR), is(indianDates[0]));
        assertThat("fromIsoDate(): month doesn't match", indianDate.get(MONTH_OF_YEAR), is(indianDates[1]));
        assertThat("fromIsoDate(): day doesn't match", indianDate.get(DAY_OF_MONTH), is(indianDates[2]));
    }

    /**
     * Tests the Iso date's components (year, month and day of month) by instantiating an Iso date from Indian date
     * components.
     */
    private static void compareIsoDateFromIndianDateComponents(int[] isoDates, int[] indianDates) {
        // create Iso date from Indian date and verify expectations
        LocalDate d = IndianNationalDate.toLocalDate(indianDates[0], indianDates[1], indianDates[2]);
        assertThat("fromIndianDate(): year doesn't match", d.getYear(), is(isoDates[0]));
        assertThat("fromIndianDate(): month doesn't match", d.getMonthValue(), is(isoDates[1]));
        assertThat("fromIndianDate(): day of month doesn't match", d.getDayOfMonth(), is(isoDates[2]));
    }
}
