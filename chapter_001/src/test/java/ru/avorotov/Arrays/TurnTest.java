package ru.avorotov.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование Очередь.
 */
public class TurnTest {
    /**
     * Тестирование Перевернуть массив.
     */
    @Test
    public void whenBackSuccessPathThenBackArray() {
        //Arrange
        final int[] array = {5, 3, 8, 5, 2, 6};
        //Act
        new Turn().back(array);
        //Assert
        final int[] expectedArray = {6, 2, 5, 8, 3, 5};
        Assert.assertArrayEquals(expectedArray, array);

    }
}