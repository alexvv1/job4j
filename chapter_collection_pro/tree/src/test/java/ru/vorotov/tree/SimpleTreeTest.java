package ru.vorotov.tree;

import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * SimpleTreeTest.
 */
public class SimpleTreeTest {

    /**
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }


    /**
     *
     */
    @Test
    public void whenSetHasElementThenIteratorHasNext() {
        //Arrange
        Tree<Integer> tree = new SimpleTree<>(1);
        Iterator<Integer> iterator = tree.iterator();
        //Act
        boolean result = iterator.hasNext();
        //Assert
        assertThat(result, Is.is(true));
    }

    /**
     *
     */
    @Test
    public void whenSetHasOneElementThenIteratorHasNotNextAfterCallNext() {
        //Arrange
        Tree<Integer> tree = new SimpleTree<>(1);
        //Act
        Iterator<Integer> iterator = tree.iterator();
        iterator.next();
        boolean result = iterator.hasNext();
        //Assert
        assertThat(result, Is.is(false));
    }

    /**
     *
     */
    @Test
    public void whenSetHasNoElementThenIteratorThrowExceptionAfterCallNext() {
        //Arrange
        Tree<Integer> tree = new SimpleTree<>(1);
        Iterator<Integer> iterator = tree.iterator();
        iterator.next();
        //Act
        //Assert
        thrown.expect(NoSuchElementException.class);
        iterator.next();
    }

    /**
     * Rule Expected Exception.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
}