package com.gebogebo.kronology.indian;

import org.junit.Test;
import static com.gebogebo.kronology.indian.IndianNationalDate.of;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static java.time.temporal.ChronoUnit.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

/**
 * Tests the {@link ChronoLocalDate#until} and {@link ChronoLocalDate#until(Temporal, TemporalUnit)}of
 * {@link IndianNationalDate}.
 *
 * @author viraj
 * @since Aashad 1942 (Jul 2020)
 */
public class TestIndianNationalDateUntil {

    @Test
    public void testUnitSameDay() {
        compareUntilValues(now(), now());
    }

    @Test
    public void testUnitNegative() {
        compareUntilValues(now(), now().minus(100, DAYS)) ;
    }

    @Test
    public void testUnitPositive() {
        compareUntilValues(now(), now().plus(100, DAYS)) ;
    }

    @Test
    public void testExtremes() {
        LocalDate ld1 = of(1970, 1, 1);
        LocalDate ld2 = of(-1970, 1, 1);
        compareUntilValues(ld1, ld2);
    }

    @Test
    public void testFebEndLeapYear() {
        // covers Feb end as well as Indian new year (March 21/22)
        LocalDate ld1 = of(2020, 2, 1);
        LocalDate ld2 = of(2020, 4, 1);
        compareUntilValues(ld1, ld2);
    }

    @Test
    public void testFebEndNonLeapYear() {
        // covers Feb end as well as Indian new year (March 21/22)
        LocalDate ld1 = of(2019, 2, 1);
        LocalDate ld2 = of(2019, 4, 1);
        compareUntilValues(ld1, ld2);
    }

    @Test
    public void testNegativeProplecticYear() {
        LocalDate ld1 = LocalDate.of(-100, 1, 1);
        LocalDate ld2 = LocalDate.of(-100, 8, 12);
        compareUntilValues(ld1, ld2);
    }

    /**
     * Tests the output of {@code until} for {@link LocalDate} and {@link IndianNationalDate}.
     *
     * <p>
     *     Since the days of month are aligned (starts at 12:00 am), a period between two dates be it in Iso or Indian
     *     is same and that is why we test the output of the method {@link IndianNationalDate#until} by comparing it to
     *     the output the same method in {@link LocalDate}.
     *
     *     This method also tests the other flavor of this method where the output is returned as {@code long}.
     *
     * @param ld1 the starting date of the period
     * @param ld2 the ending date (exclusive) of the period
     */
    private void compareUntilValues(LocalDate ld1, LocalDate ld2) {
        IndianNationalDate id1 = of(ld1);
        IndianNationalDate id2 = of(ld2);
        assertThat(id1.until(id2), is(ld1.until(ld2)));
        assertThat(id2.until(id1), is(ld2.until(ld1))); // test reverse

        assertThat(id1.until(id2, YEARS), is(ld1.until(ld2, YEARS)));
        assertThat(id1.until(id2, MONTHS), is(ld1.until(ld2, MONTHS)));
        assertThat(id1.until(id2, DAYS), is(ld1.until(ld2, DAYS)));
    }
}
