package ru.vorotov.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * HashSimpleSet.
 * @param <E> Element type.
 */
public class HashSimpleSet<E> implements SimpleSet<E> {
    /**
     * Count of bucket.
     */
    private static final int AMOUNT_BUCKETS = 10;
    /**
     * Buckets.
     */
    private SimpleSet[] buckets = new SimpleSet[AMOUNT_BUCKETS];

    /**
     * Constructor.
     */
    public HashSimpleSet() {
        for (int i = 0; i < AMOUNT_BUCKETS; i++) {
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
        return buckets[getBucket(element)].add(element);
    }

    /**
     * Get bucket by hashcode.
     *
     * @param o Object.
     * @return int.
     */
    private int getBucket(Object o) {
        return o.hashCode() % AMOUNT_BUCKETS;
    }


    /**
     * Get size of the set.
     *
     * @return size.
     */
    @Override
    public int size() {
        int size = 0;
        for (SimpleSet set : buckets) {
            size += set.size();
        }
        return size;

    }

    /**
     * Set contains object?
     *
     * @param element Object.
     * @return boolean.
     */
    @Override
    public boolean contains(E element) {
        return buckets[getBucket(element)].contains(element);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new HashSetIterator();
    }

    /**
     * Iterator of HashSimpleSet.
     */
    private class HashSetIterator implements Iterator<E> {

        /**
         * Index of current bucket.
         */
        private int bucketIndex = 0;

        /**
         * Current iterator.
         */
        private Iterator<E> currentIterator = null;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (currentIterator == null) {
                currentIterator = buckets[0].iterator();
            }
            boolean has;
            do {
                has = currentIterator.hasNext();
                if (!has) {
                    changeIterator();
                }
            } while (!has && bucketIndex < AMOUNT_BUCKETS - 1);
            return has;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (currentIterator == null) {
                currentIterator = buckets[0].iterator();
            }
            E element = null;

            do {
                if (currentIterator.hasNext()) {
                    element = currentIterator.next();
                } else {
                    changeIterator();
                }
            } while (element == null && bucketIndex < AMOUNT_BUCKETS - 1);

            if (element == null) {
                throw new NoSuchElementException();
            }
            return element;
        }

        /**
         * Change current iterator to the next iterator.
         */
        private void changeIterator() {
            if (bucketIndex < AMOUNT_BUCKETS - 1) {
                currentIterator = buckets[++bucketIndex].iterator();
            }
        }
    }
}
