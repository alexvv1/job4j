package ru.vorotov.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node.
 * @param <E> Element type.
 */
public class Node<E extends Comparable<E>> {
    /**
     * Children element.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Node value.
     */
    private final E value;

    /**
     * Node value.
     * @return Node value.
     */
    public E getValue() {
        return value;
    }

    /**
     * Ctor.
     * @param value value.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Add node.
     * @param child child element.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Leaves tree.
     * @return Leaves tree.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Equals value.
     * @param that Element that.
     * @return Equals.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }
}