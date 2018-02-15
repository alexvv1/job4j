package ru.vorotov.tree;

import java.util.List;

/**
 * BinaryTree interface.
 * @param <E> Element type.
 */
public interface BinaryTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Add node.
     * @param value Value.
     * @return was added or not.
     */
    boolean addNode(E value);

    /**
     * Get List of all elements in the tree.
     * @return List of all elements in the tree.
     */
    List<E> getChildren();

    /**
     * Check if tree has this element.
     * @param value Value.
     * @return Check if tree has this element.
     */
    boolean contains(E value);
}