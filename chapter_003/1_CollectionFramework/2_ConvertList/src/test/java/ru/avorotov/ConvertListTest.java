package ru.avorotov;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Тест Конвертация двумерного массива в ArrayList и наоборот.
 */
public class ConvertListTest {

    /**
     * Тест Конвертация двумерного массива в ArrayList.
     */
    @Test
    public void convertArrayToListTest() {
        //Arrange
        final ConvertList convertList = new ConvertList();
        final int[][] testArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        //Act
        final List<Integer> resultList = convertList.toList(testArray);
        //Assert
        final List<Integer> expectedList = Arrays.asList(7, 4, 1, 8, 5, 2, 9, 6, 3);
        assertThat(expectedList, is(resultList));
    }

    /**
     * Тест Конвертация ArrayList в двумерный массив.
     */
    @Test
    public void convertListToArrayTest() {
        //Arrange
        final ConvertList convertList = new ConvertList();
        final List<Integer> testList = Arrays.asList(7, 4, 1, 8, 5, 2, 9, 6, 3, 7, 4, 0, 4, 3);
        final int rows = 4;
        //Act
        final int[][] testArray = convertList.toArray(testList, rows);
        //Assert
        final int[][] expectedArray = {{7, 4, 1, 8}, {5, 2, 9, 6}, {3, 7, 4, 0}, {4, 3, 0, 0}};
        assertThat(expectedArray, is(testArray));
    }
}