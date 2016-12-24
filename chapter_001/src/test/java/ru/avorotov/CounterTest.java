package ru.avorotov;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование Вычисляет сумму четныx чисел от start до finish.
 */
public class CounterTest {
    /**
     * Тестирование add. Success path
     */
    @Test
    public void whenExecuteAddThenSuccessPath() {
        //Arrange
        final int startNumber = 0;
        final int endNumber = 10;
        //Act
        int summ = new Counter().add(startNumber, endNumber);
        final int expectedSumm = 30;
        //Assert
        Assert.assertEquals(expectedSumm, summ);
    }

    /**
     * Тестирование add. Exception
     */
    @Test(expected = Exception.class)
    public void whenAddStartNumberMoreEndNumberThenException() {
        //Arrange
        final int startNumber = 20;
        final int endNumber = 10;
        //Act
        int summ = new Counter().add(startNumber, endNumber);
        final int expectedSumm = 30;
        //Assert
        Assert.assertEquals(expectedSumm, summ);
    }
}