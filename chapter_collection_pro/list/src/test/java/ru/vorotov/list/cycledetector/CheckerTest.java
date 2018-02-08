package ru.vorotov.list.cycledetector;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * CheckerTest.
 */
public class CheckerTest {
    /**
     * CycleDetector.
     */
    private CycleDetector detector = new CycleDetector();

    /**
     * null Is Not Cyclic.
     */
    @Test
    public void nullIsNotCyclic() {
        //Arrange
        Node firstNode = null;
        //Act
        boolean hasCycle = detector.hasCycle(firstNode);
        //Assert
        assertThat(hasCycle, is(false));
    }

    /**
     *
     */
    @Test
    public void oneElementListShouldHaveNoCycle() {
        //Assert
        Node<Integer> firstNode = new Node<>(1);
        //Act
        boolean hasCycle = detector.hasCycle(firstNode);
        //Assert
        assertThat(hasCycle, is(false));
    }

    /**
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void shouldFindNoCycles() {
        //Arrange
        Node list = createList(3);
        //Act
        boolean hasCycle = detector.hasCycle(list);
        assertThat(hasCycle, is(false));
    }

    /**
     *
     */
    @Test
    public void shouldFindCyclesInOneLoopedNode() {
        //Arrange
        Node head = new Node<>(1);
        head.setNext(head);
        //Act
        boolean hasCycle = detector.hasCycle(head);
        //Assert
        assertThat(hasCycle, is(true));
    }

    /**
     *
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void shouldFindCycleInMultiElementList() {
        //Arrange
        Node head = createList(10);
        Node node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(head);
        //Act
        boolean hasCycle = detector.hasCycle(head);
        //Assert
        assertThat(hasCycle, is(true));
    }

    /**
     * Create List.
     * @param size Size list.
     * @return List node.
     */
    private Node createList(int size) {
        Node head = new Node<>(1);
        Node node = head;
        for (int i = 2; i <= size; ++i) {
            node.setNext(new Node<>(i));
            node = node.getNext();
        }
        return head;
    }
}