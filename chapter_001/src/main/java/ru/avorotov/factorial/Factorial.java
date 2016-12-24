package ru.avorotov.factorial;

/**
 * Вычисляет факториал числа.
 *
 * @author avorotov
 * @version 1
 * @since 17.12.2016
 */
public class Factorial {

    /**
     * Вычисляет факториал числа.
     * @param number Число для которого вычисляется факториал
     * @return Факториал
     */
    public long calcFactorial(long number) {
        long factorial = 1;
        for (int i = 2; i <= number; ++i) {
            factorial *= i;
        }
        return factorial;
    }
}
