package ru.vorotov.set;

import ru.vorotov.list.SimpleContainer;
import ru.vorotov.list.SimpleLinkedContainer;

import java.util.Iterator;

/**
 * LinkedSimpleSet.
 * @param <T> Element type.
 */
public class LinkedSimpleSet<T> implements SimpleSet<T> {

    /**
     * Inner container.
     */
    private SimpleContainer<T> container = new SimpleLinkedContainer<>();

    /**
     * Add element to set.
     *
     * @param element Element.
     * @return was added or not.
     */
    @Override
    public boolean add(T element) {
        boolean wasAdded = false;
        if (!contains(element)) {
            container.add(element);
            wasAdded = true;
        }
        return wasAdded;
    }

    /**
     * Get size of the set.
     *
     * @return size.
     */
    @Override
    public int size() {
        return container.size();
    }

    /**
     * Set contains object?.
     *
     * @param element Object.
     * @return boolean.
     */
    @Override
    public boolean contains(T element) {
        return container.contains(element);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}