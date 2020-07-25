package com.gebogebo.kronology.indian;

import org.junit.Test;
import static com.gebogebo.kronology.indian.IndianEra.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.time.DateTimeException;
import java.time.chrono.Chronology;
import java.util.stream.IntStream;

/**
 * Tests the {@link IndianEra} class.
 *
 * @author viraj
 * @since (Aashad 1942) Jul 2020
 */
public class TestIndianEra {

    @Test
    public void testErasList() {
        Chronology indian = Chronology.of("indian");
        assertThat(indian.eras().size(), is(2));
        assertThat(indian.eras().get(0), is(BEFORE_SE));
        assertThat(indian.eras().get(1), is(SE));
    }

    @Test
    public void testErasOrdinal() {
        assertThat(BEFORE_SE.ordinal(), is(0));
        assertThat(SE.ordinal(), is(1));
    }

    @Test
    public void testInvalidEra() {
        IntStream.of(-10, -1, 2, 100).forEach(era -> {
            try {
                of(era);
                fail("Expected DateTimeException");
            } catch(DateTimeException e) {
                // expected
            }
        });
    }
}
