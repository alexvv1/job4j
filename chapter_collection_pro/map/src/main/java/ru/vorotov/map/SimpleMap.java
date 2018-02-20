package ru.vorotov.map;

/**
 * Simple map intarface.
 * @param <K> Key type.
 * @param <V> Value type.
 */
public interface SimpleMap<K,V> {
    /**
     * Insert element.
     * @param key Key.
     * @param value Value.
     * @return true - insert.
     */
    boolean insert(K key, V value);

    /**
     * Get value by key.
     * @param key Key Type.
     * @return Value.
     */
    V get(K key);

    /**
     * Removes the mapping for a key from this map if it is present.
     * @param key Removes the mapping for a key from this map if it is present.
     * @return boolean.
     */
    boolean delete(K key);
}
