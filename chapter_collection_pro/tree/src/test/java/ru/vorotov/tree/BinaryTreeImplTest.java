package ru.vorotov.tree;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * BinaryTreeImplTest.
 */
public class BinaryTreeImplTest {
    /**
     * Rule Expected Exception.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     *
     */
    @Test
    public void whenAddRootThenReturnTrue() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        //Act
        boolean result = tree.addNode(0);
        //Assert
        assertThat(result, is(true));
    }

    /**
     *
     */
    @Test
    public void whenAddRootThenContains() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        tree.addNode(0);
        //Act
        boolean result = tree.contains(0);
        //Assert
        assertThat(result, is(true));
    }

    /**
     *
     */
    @Test
    public void whenAddNullThenReturnFalse() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        //Act
        boolean result = tree.addNode(null);
        //Assert
        assertThat(result, is(false));
    }

    /**
     *
     */
    @Test
    public void whenAddNullThenDoesNotContainIt() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        tree.addNode(null);
        //Act
        boolean result = tree.contains(null);
        //Assert
        assertThat(result, is(false));
    }

    /**
     *
     */
    @Test
    public void whenAddSecondElementThenReturnTrue() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        tree.addNode(0);
        //Act
        boolean result = tree.addNode(1);
        //Assert
        assertThat(result, is(true));
    }

    /**
     *
     */
    @Test
    public void whenAddSecondElementThenContainsIt() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        tree.addNode(0);
        tree.addNode(1);
        //Act
        boolean result = tree.contains(1);
        //Assert
        assertThat(result, is(true));
    }

    /**
     *
     */
    @Test
    public void whenEmptyTreeThenReturnEmptyList() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        List<Integer> list = Collections.emptyList();
        //Act
        List<Integer> result = tree.getChildren();
        //Assert
        assertThat(result, is(list));
    }

    /**
     *
     */
    @Test
    public void whenAddOnlyRootThenListHasOnlyRoot() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        List<Integer> list = new ArrayList<>(Collections.singletonList(0));
        tree.addNode(0);
        //Act
        List<Integer> result = tree.getChildren();
        //Assert
        assertThat(result, is(list));
    }

    /**
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void whenAddEightElementsThenListSizeIsEight() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        for (int i = 0; i < 8; i++) {
            tree.addNode(i);
        }
        //Act
        List<Integer> result = tree.getChildren();
        //Assert
        assertThat(result.size(), is(8));
    }

    /**
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void whenAddEightElementsThenListHasTheseElements() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(
                0, 1, 2, 3, 4, 5, 6, 7));
        for (int i = 0; i < 8; i++) {
            tree.addNode(i);
        }
        //Act
        List<Integer> result = tree.getChildren();
        //Assert
        assertThat(result, is(list));
    }

    /**
     *
     */
    @Test
    public void whenSetHasElementThenIteratorHasNext() {
        //Arrange
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        tree.addNode(1);
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
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void hasNextNextSequentialInvocation() {
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        for (int i = 0; i < 8; i++) {
            tree.addNode(i);
        }

        Iterator<Integer> it = tree.iterator();

        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(0));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(5));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(6));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(7));
    }

    /**
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        for (int i = 0; i < 8; i++) {
            tree.addNode(i);
        }

        Iterator<Integer> it = tree.iterator();

        assertThat(it.next(), Matchers.is(0));
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.next(), Matchers.is(5));
        assertThat(it.next(), Matchers.is(6));
        assertThat(it.next(), Matchers.is(7));
    }
}