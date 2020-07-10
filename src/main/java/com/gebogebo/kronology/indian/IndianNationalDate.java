package com.gebogebo.kronology.indian;

import static com.gebogebo.kronology.indian.IndianNationalChronology.YEARS_BEHIND_ISO_YEAR;
import static java.time.temporal.ChronoField.YEAR;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A date in the Saka calendar system.
 * <p>
 * This date operates using the {@linkplain IndianNationalChronology Indian calendar}.
 * This calendar system is primarily used in India and is also known as Indian National Calendar or Indian Civil Calendar.
 * Dates are aligned such that {@code 1869-05-24 (Saka)} is {@code 1947-08-15 (ISO)}.
 *
 * <p>
 * This is a <a href="{@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>
 * class; use of identity-sensitive operations (including reference equality
 * ({@code ==}), identity hash code, or synchronization) on instances of
 * {@code IndianNationalDate} may have unpredictable results and should be avoided.
 * The {@code equals} method should be used for comparisons.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 * All the methods accept and return non-null values.
 *
 * @author viraj
 * @since Jul 2020
 */
public final class IndianNationalDate implements ChronoLocalDate, Serializable {

    /**
     * Serialization version.
     */
    private static final long serialVersionUID = -8252231876281470680L;

    /**
     * Internal data objects to represent Indian months using {@code IndianMonth} instances.
     */
    private static final List<IndianMonth> leapMonths = new ArrayList<>(12);
    private static final List<IndianMonth> months = new ArrayList<>(12);
    static {
        leapMonths.add(new IndianMonth(1, 81, 111, 0));
        leapMonths.add(new IndianMonth(2, 112, 142,0));
        leapMonths.add(new IndianMonth(3, 143, 173,0));
        leapMonths.add(new IndianMonth(4, 174, 204,0));
        leapMonths.add(new IndianMonth(5, 205, 235,0));
        leapMonths.add(new IndianMonth(6, 236, 266, 0));
        leapMonths.add(new IndianMonth(7, 267, 296, 0));
        leapMonths.add(new IndianMonth(8, 297, 326, 0));
        leapMonths.add(new IndianMonth(9, 327, 356, 0));
        leapMonths.add(new IndianMonth(10, 357, 366, 0));
        leapMonths.add(new IndianMonth(10, 1, 20, -1));
        leapMonths.add(new IndianMonth(11, 21, 50, -1));
        leapMonths.add(new IndianMonth(12, 51, 80, -1));

        months.add(new IndianMonth(1, 81, 110, 0));
        months.add(new IndianMonth(2, 111, 141,0));
        months.add(new IndianMonth(3, 142, 172,0));
        months.add(new IndianMonth(4, 173, 203,0));
        months.add(new IndianMonth(5, 204, 234,0));
        months.add(new IndianMonth(6, 235, 265, 0));
        months.add(new IndianMonth(7, 266, 295, 0));
        months.add(new IndianMonth(8, 296, 325, 0));
        months.add(new IndianMonth(9, 326, 355, 0));
        months.add(new IndianMonth(10, 356, 365, 0));
        months.add(new IndianMonth(10, 1, 20, -1));
        months.add(new IndianMonth(11, 21, 50, -1));
        months.add(new IndianMonth(12, 51, 80, -1));
    }

    private final IndianEra era;
    private final int year;
    private final int month;
    private final int dayOfMonth;

    /**
     * Obtains the current {@code IndianNationalDate} from the {@code LocalDate} instance.
     *
     * @param localDate  the localDate to use
     * @return the {@code IndianNationalDate} instance corresponding to the given {@code LocalDate}.
     * @throws DateTimeException If the given {@code LocalDate} can't be mapped to a {@code IndianNationalDate}.
     */
    public static IndianNationalDate of(LocalDate localDate) {
        int dayOfYear = localDate.get(ChronoField.DAY_OF_YEAR);
        return (localDate.isLeapYear() ? leapMonths : months)
                .stream()
                .filter(m -> m.isThisMonth(dayOfYear))
                .findFirst()
                .map(m -> new IndianNationalDate(localDate.get(YEAR) + m.yearDelta - YEARS_BEHIND_ISO_YEAR,
                        m.indianMonth,
                        m.getIndianDayOfMonth(dayOfYear)))
                .orElseThrow(() -> new DateTimeException(String.format("Can't convert %s to Indian date.", localDate.toString())));
    }

    /**
     * Creates an instance with given proleptic year, month and day.
     *
     * @param prolepticYear  the indian proleptic-year
     * @param month  the Indian month-of-year, from 1 to 12
     * @param dayOfMonth  the Indian day-of-month, from 1 to 31
     */
    /* pkg pvt */ IndianNationalDate(int prolepticYear, int month, int dayOfMonth) {
        this.era = IndianEra.of(prolepticYear <= 0 ? 0 : 1);
        this.year = prolepticYear;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    /**
     * Gets the chronology of this date, which is the Indian calendar system.
     * <p>
     * The {@code Chronology} represents the calendar system in use.
     * The era and other fields in {@link ChronoField} are defined by the chronology.
     *
     * @return the Indian chronology
     */
    @Override
    public IndianNationalChronology getChronology() {
        return IndianNationalChronology.INSTANCE;
    }

    /**
     * Returns the length of the month represented by this date.
     * <p>
     * This returns the length of the month in days.
     *
     * @return the length of the month in days
     */
    @Override
    public int lengthOfMonth() {
        if(month >= 2 && month <= 6) {
            return 31;
        }
        if(month >= 7 && month <= 12) {
            return 30;
        }
        if(month == 1) {
            return isLeapYear() ? 31 : 30;
        }
        throw new DateTimeException("IndianNationalDate instance created with an invalid month: " + month);
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        //TODO: implement this
        throw new UnsupportedOperationException("This operation will be implemented soon");
    }

    @Override
    public ChronoPeriod until(ChronoLocalDate endDateExclusive) {
        //TODO: implement this
        throw new UnsupportedOperationException("This operation will be implemented soon");
    }

    @Override
    public long getLong(TemporalField field) {
        if(!(field instanceof ChronoField) || !isSupported(field)) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + field);
        }
        ChronoField f = (ChronoField) field;
        switch (f) {
            case DAY_OF_MONTH:
                return dayOfMonth;
            case MONTH_OF_YEAR:
                return month;
            case DAY_OF_YEAR:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + field);
            case YEAR:
                return year;
            case YEAR_OF_ERA:
                return year >= 1 ? year : 1 - year;
            case ERA:
                return era.ordinal();
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + field);
    }

    @Override
    public ValueRange range(TemporalField field) {
        if (!(field instanceof ChronoField)) {
            return field.rangeRefinedBy(this);
        }
        if(!isSupported(field)) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + field);
        }
        ChronoField f = (ChronoField) field;
        switch (f) {
            case DAY_OF_MONTH:
                return ValueRange.of(1, lengthOfMonth());
            case MONTH_OF_YEAR:
                return ValueRange.of(1, 12);
            case DAY_OF_YEAR:
                return ValueRange.of(1, lengthOfYear());
            case YEAR_OF_ERA:
                return (year <= 0 ? ValueRange.of(1, Year.MAX_VALUE + 1) : ValueRange.of(1, Year.MAX_VALUE));
            default:
                return f.range();
        }
    }

    @Override
    public boolean isSupported(TemporalField field) {
        return field == ChronoField.DAY_OF_MONTH ||
            field == ChronoField.MONTH_OF_YEAR ||
            field == YEAR ||
            field == ChronoField.YEAR_OF_ERA ||
            field == ChronoField.ERA ||
            field == ChronoField.EPOCH_DAY;
    }

    @Override
    public boolean isSupported(TemporalUnit unit) {
        return unit == ChronoUnit.MONTHS ||
            unit == ChronoUnit.ERAS ||
            unit == ChronoUnit.YEARS ||
            unit == ChronoUnit.DAYS;
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, dayOfMonth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndianNationalDate indianNationalDate = (IndianNationalDate) o;
        return year == indianNationalDate.year &&
                month == indianNationalDate.month &&
                dayOfMonth == indianNationalDate.dayOfMonth &&
                era == indianNationalDate.era;
    }

    @Override
    public int hashCode() {
        return Objects.hash(era, year, month, dayOfMonth);
    }

    /**
     * An internal representation of a month in Saka chronology.
     * <p>
     * Use this class to translate Iso date into corresponding Saka date.
     *
     * @implSpec
     * This class is immutable and thread-safe.
     */
    private static class IndianMonth {
        private final ValueRange isoDayOfYearRange;
        private final int indianMonth;
        private final int yearDelta;

        private IndianMonth(int indianMonth, int minIsoDayOfYear, int maxIsoDayOfYear, int yearDelta) {
            this.indianMonth = indianMonth;
            this.isoDayOfYearRange = ValueRange.of(minIsoDayOfYear, maxIsoDayOfYear);
            this.yearDelta = yearDelta;
        }

        private boolean isThisMonth(int isoDayOfYear) {
            return isoDayOfYearRange.isValidIntValue(isoDayOfYear);
        }

        private int getIndianDayOfMonth(int isoDayOfYear) {
            if(!isThisMonth(isoDayOfYear)) {
                throw new DateTimeException("");
            }
            int result = isoDayOfYear - (int)isoDayOfYearRange.getMinimum() + 1;
            if((int)isoDayOfYearRange.getMinimum() == 1) {
                // we add 10 days to accommodate the 10th month (Pausha) that starts on Dec 22.
                result += 10;
            }
            return result;
        }
    }
}
