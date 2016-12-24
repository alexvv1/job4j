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

    /**
     * Сортировка массива методом перестановки.
     * @param array Исходный массив
     */
    public void sortSelection(int[] array) {
        //Цикл по массиву
        for (int index = 0; index < array.length - 1; index++) {
            int minIndex = index;
            //находим индекс минимального элемента в хвосте списка
            for (int j = minIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //производим обмен минимального элемента со значением из текущей позиции
            int minValue = array[index];
            array[index] = array[minIndex];
            array[minIndex] = minValue;
        }
    }
}
