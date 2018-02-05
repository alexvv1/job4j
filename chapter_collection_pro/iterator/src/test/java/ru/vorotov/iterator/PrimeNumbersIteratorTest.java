package ru.vorotov.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест Итератор. Простые числа.
 */
public class PrimeNumbersIteratorTest {
    /**
     * Итератор.
     */
    private Iterator<Integer> it;

    /**
     * Инициализация массива.
     */
    @Before
    @SuppressWarnings("checkstyle:magicnumber")
    public void setUp() {
        it = new PrimeNumbersIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
    }

    /**
     * Test should Return Prime Numbers Only.
     */
    @Test(expected = NoSuchElementException.class)
    @SuppressWarnings("checkstyle:magicnumber")
    public void shouldReturnPrimeNumbersOnly() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Test should Return Prime Numbers Only.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }

    /**
     * Test should Return False Cause There Is No Any Prime Number.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumber() {
        it = new PrimeNumbersIterator(new int[]{4, 6});
        assertThat("should return false, cause there is no any prime number", it.hasNext(), is(false));
    }
}