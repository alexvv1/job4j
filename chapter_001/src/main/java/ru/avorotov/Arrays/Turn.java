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

    /**
     * Сортировка массива методом Пузырька.
     * @param array Сортируемый массив
     */
    public void bubbleSort(int[] array) {
        //Внешний цикл каждый раз сокращает фрагмент массива
        for (int i = array.length - 1; i > 0; i--) {
            //внутренний цикл каждый раз ставит в конец фрагмента максимальный элемент
            for (int j = 0; j < i; j++) {
                    //Сравниваем элементы, если они имеют неправильный порядок(первый больше второго),
                    // то меняем местами
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

}
