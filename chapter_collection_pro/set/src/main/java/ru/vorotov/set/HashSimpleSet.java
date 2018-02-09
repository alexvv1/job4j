package ru.vorotov.set;

import ru.vorotov.genericpro.SimpleArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSimpleSet<E> implements SimpleSet<E> {

    private static final int COUNT_BUCKETS = 10;

    private SimpleSet[] buckets;

    public HashSimpleSet() {
        buckets = new SimpleSet[COUNT_BUCKETS];

        for (int i = 0; i < COUNT_BUCKETS; i++) {
            buckets[i] = new ArraySimpleSet();
        }




    }

    /**
     * Add element to set.
     *
     * @param element Element.
     * @return was added or not.
     */
    @Override
    public boolean add(E element) {
        return false;
    }

    /**
     * Get size of the set.
     *
     * @return size.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Set contains object?
     *
     * @param element Object.
     * @return boolean.
     */
    @Override
    public boolean contains(E element) {
        return false;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }


    private static class Bucket{

    }
}
