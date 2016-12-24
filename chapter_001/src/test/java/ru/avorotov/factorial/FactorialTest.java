package ru.avorotov.factorial;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SSS on 24.12.2016.
 */
public class FactorialTest {

    /**
     * Тест вычисления факториала числа.
     */
    @Test
    public void whenCalcFactorialExecuteThenSuccessPath() {
        //Arrange
        final long number = 15;
        //Act
        final long factorial = new Factorial().calcFactorial(number);
        final long expectedFactorial = 1_307_674_368_000L;
        Assert.assertEquals(expectedFactorial, factorial);
    }
}