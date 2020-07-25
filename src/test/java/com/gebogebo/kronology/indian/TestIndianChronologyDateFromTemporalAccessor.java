package com.gebogebo.kronology.indian;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.time.*;
import java.time.chrono.*;
import java.time.temporal.TemporalAccessor;
import java.util.stream.Stream;

/**
 * Tests the {@link IndianNationalChronology#date(TemporalAccessor) date} method of IndianNationalChronology.
 *
 * @author viraj
 * @since Shravan 1942 (Jul 2020)
 */
public class TestIndianChronologyDateFromTemporalAccessor {

    @Test
    public void testFromEra() {
        Stream.of(IsoEra.CE, ThaiBuddhistEra.BE, HijrahEra.AH).forEach(e -> {
            try {
                IndianNationalChronology.INSTANCE.date(e);
                fail("Expected DateTimeException to be thrown for: " + e.getClass());
            } catch (DateTimeException ex) {
                // expected
            }
        });
    }

    @Test
    public void testFromIndianDate() {
        ChronoLocalDate id1 = IndianNationalChronology.INSTANCE.date(1942,1, 1);
        ChronoLocalDate id2 = IndianNationalChronology.INSTANCE.date(id1);
        assertThat(id2, is(id1));
    }

    @Test
    public void testUnsupportedTemporal() {
        Stream.of(Instant.EPOCH,
                    Year.now(),
                    YearMonth.now(),
                    OffsetTime.now(),
                    DayOfWeek.of(1),
                    LocalTime.now(),
                    ZoneOffset.ofHours(2))
                .forEach(e -> {
                    try {
                        IndianNationalChronology.INSTANCE.date(e);
                        fail("Expected DateTimeException to be thrown for: " + e.getClass());
                    } catch (DateTimeException ex) {
                        // expected
                    }
        });
    }

    @Test
    public void testSupportedTemporal() {
        Stream.of(ZonedDateTime.now(),
                    HijrahDate.now(),
                    JapaneseDate.now(),
                    MinguoDate.now(),
                    OffsetDateTime.now(),
                    LocalDate.now(),
                    ThaiBuddhistDate.now())
                .forEach(IndianNationalChronology.INSTANCE::date);
    }
}
