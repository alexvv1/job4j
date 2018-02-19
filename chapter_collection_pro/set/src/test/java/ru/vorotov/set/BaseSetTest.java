package ru.vorotov.set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BaseSetTest.
 */
public abstract class BaseSetTest {
    /**
     *
     */
    private SimpleSet simpleSet;

    /**
     * Constructor.
     * @param simpleSet Test Set.
     * @param <E> Type set.
     */
    <E> BaseSetTest(SimpleSet<E> simpleSet) {
        this.simpleSet = simpleSet;
    }

    /**
     * Rule Expected Exception.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     *
     */
    @Test
    public void whenAddToSetThenContainsIt() {
        //Arrange
        SimpleSet set = simpleSet;
        set.add("0");
        //Act
        boolean result = set.contains("0");
        //Assert
        assertThat(result, is(true));
    }

    /**
     *
     */
    @Test
    public void whenAddValueThatAlreadyIsInSetThenDoNotAddIt() {
        //Arrange
        SimpleSet set = simpleSet;
        //Act
        set.add("0");
        set.add("0");
        //Assert
        int size = set.size();
        assertThat(size, is(1));
        assertThat(set.contains("0"), is(true));
    }

    /**
     *
     */
    @Test
    public void whenAddTwoValuesThanSetSizeIsTwo() {
        //Arrange
        SimpleSet<String> set = simpleSet;
        //Act
        set.add("0");
        set.add("1");
        //Assert
        assertThat(set.size(), is(2));
        assertThat(set.contains("0"), is(true));
        assertThat(set.contains("1"), is(true));
    }

    /**
     *
     */
    @Test
    public void whenSetHasElementThenIteratorHasNext() {
        //Arrange
        SimpleSet<String> set = simpleSet;
        set.add("0");
        Iterator<String> iterator = set.iterator();
        //Act
        boolean result = iterator.hasNext();
        //Assert
        assertThat(result, is(true));
    }

    /**
     *
     */
    @Test
    public void whenSetHasNoElementThenIteratorHasNotNext() {
        //Arrange
        SimpleSet<String> set = simpleSet;
        Iterator<String> iterator = set.iterator();
        //Act
        boolean result = iterator.hasNext();
        //Assert
        assertThat(result, is(false));
    }

    /**
     *
     */
    @Test
    public void whenSetHasOneElementThenIteratorHasNotNextAfterCallNext() {
        //Arrange
        SimpleSet<String> set = simpleSet;
        //Act
        set.add("0");
        Iterator<String> iterator = set.iterator();
        iterator.next();
        boolean result = iterator.hasNext();
        //Assert
        assertThat(result, is(false));
    }

    /**
     *
     */
    @Test
    public void whenSetHasNoElementThenIteratorThrowExceptionAfterCallNext() {
        //Arrange
        SimpleSet<String> set = simpleSet;
        Iterator<String> iterator = set.iterator();
        //Act
        //Assert
        thrown.expect(NoSuchElementException.class);
        iterator.next();
    }
}