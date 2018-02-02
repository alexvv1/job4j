package ru.vorotov.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двумерно двухмерного массива int[][].
 */
public class ArrayIterator implements Iterator<Integer> {
    /**
     * Двухмерный массив.
     */
    private final int[][] array;
    /**
     * Текущая строка массива.
     */
    private int row;
    /**
     * Текущий столбец массива.
     */
    private int column;

    /**
     * Конструктор.
     * @param array Двухмерный массив по которому необходимо итерироваться.
     */
    public ArrayIterator(int[][] array) {
        this.array = array;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return this.row < array.length && this.column < array[this.row].length;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = array[this.row][this.column++];
        if (this.column == array[this.row].length && this.row < array.length) {
            this.row++;
            this.column = 0;
        }
        return result;
    }
}
