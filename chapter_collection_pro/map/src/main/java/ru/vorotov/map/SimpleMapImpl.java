package ru.vorotov.map;

import java.util.Iterator;

/**
 * Simple mapimplementation.
 */
public class SimpleMapImpl<K,V> implements SimpleMap<K,V>, Iterable<SimpleMapImpl.Entry>{
    /**
     * Insert element.
     *
     * @param key   Key.
     * @param value Value.
     * @return true - insert.
     */
    @Override
    public boolean insert(Object key, Object value) {
        return false;
    }

    /**
     * Get value by key.
     *
     * @param key Key Type.
     * @return Value.
     */
    @Override
    public Object get(Object key) {
        return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key Removes the mapping for a key from this map if it is present.
     * @return boolean.
     */
    @Override
    public boolean delete(Object key) {
        return false;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Entry> iterator() {
        return null;
    }

    public class Entry<K,V> {

    }
}
