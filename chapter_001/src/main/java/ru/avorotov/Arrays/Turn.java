package ru.avorotov.Arrays;

/**
 * Очередь.
 *
 * @author avorotov
 * @version 1
 * @since 24.12.2016
 */
public class Turn {

    /**
     * Перевернуть массив.
     *
     * @param array Исходный массив
     */
    public void back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
