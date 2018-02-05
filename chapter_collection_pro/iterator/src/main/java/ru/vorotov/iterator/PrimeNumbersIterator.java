package ru.vorotov.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор. Простые числа.
 * Простым является натуральное число больше 1, которое делится без остатка только на 1 и на себя.
 */
public class PrimeNumbersIterator implements Iterator<Integer> {
    /**
     * Внутренний массив.
     */
    private final int[] array;
    /**
     * Курсор.
     */
    private int cursor;

    /**
     * Конструктор.
     *
     * @param array Ряд чисел.
     */
    PrimeNumbersIterator(int[] array) {
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
        return getIndexPrimeNumber(this.array, cursor) != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() {
        Integer index = getIndexPrimeNumber(this.array, cursor);

        if (index == null) {
            throw new NoSuchElementException();
        }
        cursor = index + 1;
        return array[index];
    }

    /**
     * Возвращает индекс в массиве простого числа.
     *
     * @param array      Входящий массив чисел.
     * @param startIndex Стартовый массив.
     * @return Индекс в массиве простого числа.
     */
    private Integer getIndexPrimeNumber(int[] array, int startIndex) {
        if (array.length == 0) {
            return null;
        }
        int i = startIndex;
        Integer index = null;
        for (; i < array.length; i++) {
            final int current = array[i];
            if (isPrimeNumber(current)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Определяет простое число или нет.
     * Простым является натуральное число больше 1, которое делится без остатка только на 1 и на себя.
     *
     * @param num Входящее число.
     * @return true - если входящие число простое.
     */
    private boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
