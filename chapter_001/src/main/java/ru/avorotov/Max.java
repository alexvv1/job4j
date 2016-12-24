package ru.avorotov;

/**
 * Определение максимального числа.
 * @author avorotov
 * @since 17.12.2016
 * @version 1
 */
public class Max {
    /**
     * Максимальное из двух чисел.
     * @param first Первое число
     * @param second Второе число
     * @return Максимальное из двух чисел
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Максимальное из трех чисел.
     * @param first Первое число
     * @param second Второе число.
     * @param third Третье число.
     * @return Максимальное из трех чисел
     */
    public int max(int first, int second, int third) {
        return  max(max(first, second), third);
    }
}
