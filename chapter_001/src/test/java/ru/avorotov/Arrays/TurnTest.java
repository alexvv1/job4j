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

    /**
     * Тестирование Сортировка массива методом перестановки. Sucess path.
     */
    @Test
    public void sortSelection() {
        //Assert
        final int[] array = {5, 3, 8, 5, 2, 6};
        //Act
        new Turn().sortSelection(array);
        //Assert
        final int[] expectedArray = {2, 3, 5, 5, 6, 8};
        Assert.assertArrayEquals(expectedArray, array);
    }
    /**
     * Тестирование Сортировка массива методом пузырька. Sucсess path.
     */
    @Test
    public void whenBubbleSortSuccessPathThenSortArray() {
        //Assert
        final int[] array = {5, 3, 8, 5, 2, 6};
        //Act
        new Turn().bubbleSort(array);
        //Assert
        final int[] expectedArray = {2, 3, 5, 5, 6, 8};
        Assert.assertArrayEquals(expectedArray, array);
    }

    /**
     * Тестирование Транспонирование матрицы. Sucсess path.
     */
    @Test
    public void whenRotateSuccessPathThenRotate() {
        //Assert
        final int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //Act
        final int[][] rotateArray = new Turn().rotate(array);
        //Assert
        final int[][] expectedArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assert.assertArrayEquals(expectedArray, rotateArray);
    }

    /**
     * Тестирование Удаляет дубликаты.
     */
    @Test
    public void whenDublicateSuccessPathThenReturnClearedArray() {
        //Arrange
        final String[] array = {"22", "33", "44", "55", "22", "44"};
        //Act
        final String[] removeDuplicateArray = new Turn().removeDuplicate(array);
        //Assert
        final String[] expectedArray = {"22", "33", "44", "55"};
        Assert.assertArrayEquals(expectedArray, removeDuplicateArray);
    }
}