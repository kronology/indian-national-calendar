package com.gebogebo.kronology.indian;

import static java.lang.String.format;

import java.time.DateTimeException;
import java.time.chrono.AbstractChronology;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Era;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ValueRange;
import java.util.List;

/**
 * The Indian National calendar system.
 *
 * <p>
 * This chronology defines the rules of the Indian calendar system.
 * This calendar system is primarily used in India.
 * Dates are aligned such that {@code 1869-05-24 (Saka)} is {@code 1947-08-15 (ISO)}.
 * <p>
 * The fields are defined as follows:
 * <ul>
 * <li>era - There are two eras, the current 'Saka Era' (SE) and the previous era (BEFORE_SE).
 * <li>year-of-era - The year-of-era for the current era increases uniformly from the epoch at year one.
 *  For the previous era the year increases from one as time goes backwards.
 *  The value for the current era is equal to the ISO proleptic-year minus 78.
 * <li>proleptic-year - The proleptic year is the same as the year-of-era for the
 *  current era. For the previous era, years have zero, then negative values.
 *  The value is equal to the ISO proleptic-year minus 78.
 * <li>month-of-year - The Indian month-of-year starts in the middle of ISO month and the months have either 30 or 31
 *  days.
 * <li>day-of-month - The Indian day-of-month starts on 20th, 21st, 22nd or 23rd day of Iso month. The first 6 months
 *  have 31 days in a leap year and the last 6 months have 30 days in a leap and a non-leap year. The first month
 *  (Chaitra) has 31 days in a leap year.
 * <li>day-of-year - The Indian day-of-year starts on 21st March in a non-leap year. In a leap year, the first day of
 *  year starts on 22nd March.
 * <li>leap-year - The Indian leap-year pattern exactly matches ISO, such that the two calendars
 *  are never out of step.
 * </ul>
 *
 * @implSpec
 * This class is immutable and thread-safe.
 * All the methods accept and return non-null values.
 *
 * @author viraj
 * @since Jul 2020
 */
public class IndianNationalChronology extends AbstractChronology {
    /* pkg pvt */ static final int YEARS_BEHIND_ISO_YEAR = 78;

    public static final IndianNationalChronology INSTANCE = new IndianNationalChronology();

    public String getId() {
        return "Indian";
    }

    public String getCalendarType() {
        return "indian";
    }

    @Override
    public ChronoLocalDate date(int prolepticYear, int month, int dayOfMonth) {
        return new IndianNationalDate(prolepticYear, month, dayOfMonth);
    }

    @Override
    public ChronoLocalDate dateYearDay(int prolepticYear, int dayOfYear) {
        //TODO: implement this
        throw new UnsupportedOperationException("This operation will be implemented soon");
    }

    @Override
    public ChronoLocalDate dateEpochDay(long epochDay) {
        //TODO: implement this
        throw new UnsupportedOperationException("This operation will be implemented soon");
    }

    @Override
    public ChronoLocalDate date(TemporalAccessor temporal) {
        //TODO: implement this
        throw new UnsupportedOperationException("This operation will be implemented soon");
    }

    @Override
    public boolean isLeapYear(long prolepticYear) {
        return IsoChronology.INSTANCE.isLeapYear(prolepticYear + YEARS_BEHIND_ISO_YEAR);
    }

    @Override
    public int prolepticYear(Era era, int yearOfEra) {
        if(era == IndianEra.SE) {
            return yearOfEra;
        } else if(era == IndianEra.BEFORE_SE) {
            return 1 - yearOfEra;
        }
        throw new DateTimeException(format("Invalid Era %s for IndianNationalChronology", era));
    }

    @Override
    public Era eraOf(int eraValue) {
        return IndianEra.of(eraValue);
    }

    @Override
    public List<Era> eras() {
        return List.of(IndianEra.values());
    }

    @Override
    public ValueRange range(ChronoField field) {
        //TODO: implement this
        throw new UnsupportedOperationException("This operation will be implemented soon");
    }
}
