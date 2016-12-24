package ru.avorotov;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование Определение максимального числа.
 *
 * @author avorotov
 * @version 1
 * @since 17.12.2016
 */
public class MaxTest {
    /**
     * Тестирование Максимальное из двух чисел и первое больше второго.
     */
    @Test
    public void whenMaxTwoNumberThenReturnMaxFirstNumber() {
        //Arange
        final int first = 15;
        final int second = 10;
        //Act
        int maxNumber = new Max().max(first, second);
        //Assert
        Assert.assertEquals(first, maxNumber);
    }

    /**
     * Тестирование Максимальное из двух чисел и второе больше первого.
     */
    @Test
    public void whenMaxTwoNumberThenReturnMaxSecondNumber() {
        //Arange
        final int first = 10;
        final int second = 15;
        //Act
        int maxNumber = new Max().max(first, second);
        //Assert
        Assert.assertEquals(second, maxNumber);
    }

    /**
     * Тестирование Максимальное из трех чисел и максимальное первое.
     */
    @Test
    public void whenMaxThirdNumberThenReturnMaxFirstNumber() {
        //Arange
        final int first = 20;
        final int second = 15;
        final int third = 10;
        //Act
        int maxNumber = new Max().max(first, second, third);
        //Assert
        Assert.assertEquals(first, maxNumber);
    }

    /**
     * Тестирование Максимальное из трех чисел и максимальное второе.
     */
    @Test
    public void whenMaxThirdNumberThenReturnMaxSecondNumber() {
        //Arange
        final int first = 20;
        final int second = 25;
        final int third = 10;
        //Act
        int maxNumber = new Max().max(first, second, third);
        //Assert
        Assert.assertEquals(second, maxNumber);
    }

    /**
     * Тестирование Максимальное из трех чисел и максимальное второе.
     */
    @Test
    public void whenMaxThirdNumberThenReturnMaxThirdNumber() {
        //Arange
        final int first = 20;
        final int second = 25;
        final int third = 37;
        //Act
        int maxNumber = new Max().max(first, second, third);
        //Assert
        Assert.assertEquals(third, maxNumber);
    }
}