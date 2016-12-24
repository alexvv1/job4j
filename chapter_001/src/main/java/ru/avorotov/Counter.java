package ru.avorotov;

/**
 * Подсчет суммы в диапозоне.
 *
 * @author avorotov
 * @version 1
 * @since 17.12.2016
 */
public class Counter {
    /**
     * Вычисляет сумму четныx чисел от start до finish.
     * @param start Начальное число
     * @param finish Конечное число
     * @return Сумму четныx чисел
     */
    int add(int start, int finish) {
        if (start > finish) {
            throw new ArithmeticException();
        }
        int summ = 0;
        int currentNumber = start;
        while (currentNumber <= finish) {
            if (currentNumber % 2 == 0) {
                summ += currentNumber;
            }
            currentNumber++;
        }
        return summ;
    }




}
