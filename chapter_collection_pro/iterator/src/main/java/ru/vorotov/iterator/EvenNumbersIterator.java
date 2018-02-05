package ru.vorotov.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор. Возвращает четные числа.
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    /**
     * Массив.
     */
    private final int[] array;
    /**
     * Курсор.
     */
    private int cursor;

    /**
     * Конструктор.
     *
     * @param array Входящий массив.
     */
    EvenNumbersIterator(int[] array) {
        this.array = array;
    }

    /**
     * Возвращает индекс в массиве четного числа.
     *
     * @param array      Входящий массив чисел.
     * @param startIndex Стартовый массив.
     * @return Индекс в массиве четного числа.
     */
    private Integer getIndexEvenNumber(int[] array, int startIndex) {
        if (array.length == 0) {
            return null;
        }
        int i = startIndex;
        Integer index = null;
        for (; i < array.length; i++) {
            final int current = array[i];
            if ((current % 2) == 0) {
                index = i;
                break;
            }
        }
        return index;
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
        return getIndexEvenNumber(this.array, cursor) != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() {
        Integer index = getIndexEvenNumber(this.array, cursor);

        if (index == null) {
            throw new NoSuchElementException();
        }
        cursor = index + 1;
        return array[index];
    }
}
