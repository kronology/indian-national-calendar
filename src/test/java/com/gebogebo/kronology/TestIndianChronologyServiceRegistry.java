package com.gebogebo.kronology;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.chrono.Chronology;

/**
 * Tests the Chronology's registration in META-INF.services.
 *
 * @author viraj
 * @since Jul 2020
 */
public class TestIndianChronologyServiceRegistry {

    @Test
    public void testCalendarRegistered() {
        assertThat(Chronology.of("indian"), notNullValue());
        assertThat(Chronology.of("Indian"), notNullValue());
    }
}
