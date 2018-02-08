package ru.vorotov.set;

/**
 * Simple Set.
 * @param <T> Element type.
 */
public interface SimpleSet<T> extends Iterable<T> {

    /**
     * Add element to set.
     * @param element Element.
     * @return was added or not.
     */
    boolean add(T element);

    /**
     * Get size of the set.
     * @return size.
     */
    int size();

    /**
     * Set contains object?
     * @param element Object.
     * @return boolean.
     */
    boolean contains(T element);
}