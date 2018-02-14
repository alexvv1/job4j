package ru.vorotov.tree;

import java.util.Optional;

/**
 * Tree interface.
 *
 * @param <E> Element type.
 */
public interface Tree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return Add or not.
     */
    boolean add(E parent, E child);

    /**
     * Find by value.
     *
     * @param value value
     * @return Node.
     */
    Optional<Node<E>> findBy(E value);
}
