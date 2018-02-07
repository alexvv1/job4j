package ru.vorotov.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test SimpleQueue.
 */
public class SimpleQueueTest {

    /**
     * Rule Expected Exception.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * push And Poll Queue Test.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void pushAndPollQueue() {
        SimpleQueue<Integer> sq = new SimpleQueue<>();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        //Assert
        assertThat(sq.poll(), is(1));
        assertThat(sq.poll(), is(2));
        assertThat(sq.poll(), is(3));
    }

    /**
     * poll Queue Exception Test.
     */
    @Test
    public void pollQueueException() {
        SimpleQueue<Integer> sq = new SimpleQueue<>();
        sq.push(1);
        assertThat(sq.poll(), is(1));
        //Assert
        thrown.expect(NoSuchElementException.class);
        sq.poll();
    }
}