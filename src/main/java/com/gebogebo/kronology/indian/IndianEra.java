package com.gebogebo.kronology.indian;

import java.time.DateTimeException;
import java.time.chrono.Era;

/**
 * An era in the Indian calendar system.
 * <p>
 * The Indian calendar system has two eras.
 * The current era, for years from 1 onwards, is known as the 'Saka' era.
 * All previous years, zero or earlier in the proleptic count or one and greater
 * in the year-of-era count, are part of the 'Before Saka' era.
 *
 * <table class="striped" style="text-align:left">
 * <caption style="display:none">Indian years and eras</caption>
 * <thead>
 * <tr>
 * <th scope="col">year-of-era</th>
 * <th scope="col">era</th>
 * <th scope="col">proleptic-year</th>
 * <th scope="col">ISO proleptic-year</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td>2</td><td>SE</td><th scope="row">2</th><td>79</td>
 * </tr>
 * <tr>
 * <td>1</td><td>SE</td><th scope="row">1</th><td>78</td>
 * </tr>
 * <tr>
 * <td>1</td><td>BEFORE_SE</td><th scope="row">0</th><td>77</td>
 * </tr>
 * <tr>
 * <td>2</td><td>BEFORE_SE</td><th scope="row">-1</th><td>76</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>
 * <b>Do not use {@code ordinal()} to obtain the numeric representation of {@code IndianEra}.
 * Use {@code getValue()} instead.</b>
 *
 * @implSpec
 * This is an immutable and thread-safe enum.
 *
 * @author viraj
 * @since Jul 2020
 */
public enum IndianEra implements Era {
    BEFORE_SE,
    SE;

    public static IndianEra of(int isoEra) {
        switch (isoEra) {
            case 0:
                return BEFORE_SE;
            case 1:
                return SE;
            default:
                throw new DateTimeException("Invalid Indian era: " + isoEra);
        }
    }

    @Override
    public int getValue() {
        return ordinal();
    }
}
