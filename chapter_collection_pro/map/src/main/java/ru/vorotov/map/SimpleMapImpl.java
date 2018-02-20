package ru.vorotov.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


/**
 * Simple map implementation.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 */
public class SimpleMapImpl<K, V> implements SimpleMap<K, V>, Iterable<SimpleMapImpl.Entry> {

    /**
     * Default size of array.
     */
    private static final int DEFAULT_SIZE = 4;
    /**
     * entries.
     */
    private Entry<K, V>[] entries;

    /**
     * Ctor.
     */
    public SimpleMapImpl() {
        this(DEFAULT_SIZE);
    }

    /**
     * Ctor.
     *
     * @param size size..
     */
    public SimpleMapImpl(int size) {
        entries = new Entry[size];
    }

    /**
     * entries.
     * @return entries.
     */
    public Entry<K, V>[] getEntries() {
        return entries;
    }

    /**
     * Insert element.
     *
     * @param key   Key.
     * @param value Value.
     * @return true - insert.
     */
    @Override
    public boolean insert(K key, V value) {
        boolean wasAdded = false;
        int position = getPosition(key);
        Entry<K, V> oldEntry = entries[position];
        if (oldEntry == null) {
            entries[position] = new Entry<>(key, value);
            wasAdded = true;
        } else if (Objects.equals(key, oldEntry.getKey())) {
            oldEntry.value = value;
        } else {
            resizeArray();
            refillEntries();
            insert(key, value);
        }
        return wasAdded;
    }

    /**
     * Refill Entries.
     */
    private void refillEntries() {
        Entry<K, V>[] oldEntries = entries;
        entries = new Entry[entries.length];
        for (Entry<K, V> entry : oldEntries) {
            if (entry != null) {
                entries[getPosition(entry.getKey())] = entry;
            }
        }
    }

    /**
     * Resize array.
     */
    private void resizeArray() {
        entries = Arrays.copyOf(entries, entries.length * 2);
    }

    /**
     * Get position element.
     *
     * @param key Key.
     * @return position element.
     */
    private int getPosition(K key) {
        int position = 0;
        if (key != null) {
            position = key.hashCode() % entries.length;
        }
        return position;
    }


    /**
     * Get value by key.
     *
     * @param key Key Type.
     * @return Value.
     */
    @Override
    public V get(K key) {
        V value = null;
        Entry<K, V> entry = entries[getPosition(key)];
        if (entry != null) {
            value = entry.getValue();
        }
        return value;

    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key Removes the mapping for a key from this map if it is present.
     * @return boolean.
     */
    @Override
    public boolean delete(K key) {
        boolean wasDeleted = false;
        int position = getPosition(key);
        Entry<K, V> entry = entries[position];
        if (entry != null && Objects.equals(key, entry.getKey())) {
            entries[position] = null;
            wasDeleted = true;
        }
        return wasDeleted;

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Entry> iterator() {
        return new SimpleMapImplIterator();
    }

    /**
     * Entry.
     * @param <K> Key type.
     * @param <V> Value type.
     */
    public class Entry<K, V> {

        /**
         * Key.
         */
        private K key;

        /**
         * Value.
         */
        private V value;

        /**
         * Ctor.
         *
         * @param key   K.
         * @param value V.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Key.
         *
         * @return Key.
         */
        public K getKey() {
            return key;
        }

        /**
         * Value.
         *
         * @return Value.
         */
        public V getValue() {
            return value;
        }
    }

    /**
     * Iterator.
     */
    private class SimpleMapImplIterator implements Iterator<Entry> {
        /**
         * Next index.
         */
        private int nextIndex = 0;

        /**
         * Previous index.
         */
        private int prevIndex = -1;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            boolean has = false;
            int position = nextIndex;
            while (!has && position < entries.length) {
                if (entries[position] != null) {
                    has = true;
                } else {
                    position++;
                }
            }
            return has;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Entry<K, V> next() {
            Entry<K, V> nextEntry = null;
            for (int i = 0; i < entries.length; i++) {
                Entry<K, V> entry = entries[i];
                if (entry != null) {
                    nextEntry = entry;
                    prevIndex = nextIndex;
                    nextIndex = i + 1;
                    break;
                }
            }
            if (nextEntry == null) {
                throw new NoSuchElementException();
            }
            return nextEntry;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator.
         */
        @Override
        public void remove() {
            if (prevIndex == -1) {
                throw new IllegalStateException();
            } else {
                delete(entries[prevIndex].getKey());
                prevIndex = -1;
            }
        }
    }
}
