package ru.avorotov;

/**
 * Класс для работы с массивами.
 */
public class Array {

    /**
     * Определяет отсортирован ли массив по возростанию.
     *
     * @param array Целочисленный массив
     * @return true - массив отсортирован по возростанию
     */
    public boolean isSortAsc(int[] array) {
        boolean isSort = true;
        //Если нарушено порядок следования элементов,
        //то прервать цикл, массив не отсортирован
        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i - 1] > array[i]) {
                isSort = false;
                break;
            }
        }
        return isSort;
    }

    /**
     * Определяет отсортирован ли массив по убыванию.
     *
     * @param array Целочисленный массив
     * @return true - массив отсортирован по убыванию
     */
    public boolean isSortDesc(int[] array) {
        boolean isSort = true;
        //Если нарушено порядок следования элементов,
        //то прервать цикл, массив не отсортирован
        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i - 1] < array[i]) {
                isSort = false;
                break;
            }
        }
        return isSort;
    }

    /**
     * Количество чисел в max одинаковой последовательности.
     *
     * @param array Массив int
     * @return Количество чисел в max одинаковой последовательности.
     */
    public int countNumberMaxEqualSequence(int[] array) {
        int countMax = 0;
        int tempCountMax = 1;
        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i - 1] != array[i]) {
                tempCountMax = 1;
            } else {
                tempCountMax++;
            }
            countMax = tempCountMax > countMax ? tempCountMax : countMax;
        }
        return countMax;
    }
}
