package ru.avorotov;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тесты Array.
 */
public class ArrayTest {

    /**
     * Тест IsSortAsc. Массив отсортирован по возрастанию.
     * Return true.
     */
    @Test
    public void whenArraySortedAscThenTrue() {
        final int[] array = new int[]{5, 6, 7, 8, 9, 10, 11};
        boolean isSortArrayAsc = new Array().isSortAsc(array);
        Assert.assertTrue(isSortArrayAsc);
    }

    /**
     * Тест IsSortAsc. Массив не отсортирован по возрастанию.
     * return false
     */
    @Test
    public void whenArrayNotSortedAscThenFalse() {
        final int[] array = new int[]{4, 7, 10, 12, 16, 3};
        boolean isSortArrayAsc = new Array().isSortAsc(array);
        Assert.assertFalse(isSortArrayAsc);
    }

    /**
     * Тест IsSortAsc. Массив отсортирован по убыванию.
     * Return true.
     */
    @Test
    public void whenArraySortedDescThenTrue() {
        final int[] array = new int[]{9, 8, 7, 6, 5, 4};
        boolean isSortArrayAsc = new Array().isSortDesc(array);
        Assert.assertTrue(isSortArrayAsc);
    }

    /**
     * Тест IsSortAsc. Массив не отсортирован по убыванию.
     * Return false.
     */
    @Test
    public void whenArrayNotSortedDescThenFalse() {
        final int[] array = new int[]{4, 7, 10, 12, 16, 3};
        boolean isSortArrayAsc = new Array().isSortDesc(array);
        Assert.assertFalse(isSortArrayAsc);
    }

    /**
     * Тест countNumberMaxEqualSequence.
     * Max последовательность в начале.
     */
    @Test
    public void whenMaxSequenceStartThenSuccessPath() {
        final int[] array = new int[]{4, 4, 4, 4, 5, 5, 5, 3, 3};
        int count = new Array().countNumberMaxEqualSequence(array);
        final int targerCount = 4;
        Assert.assertEquals(targerCount, count);
    }

    /**
     * Тест countNumberMaxEqualSequence.
     * Max последовательность в середине.
     */
    @Test
    public void whenMaxSequenceMiddleThenSuccessPath() {
        final int[] array = new int[]{3, 3, 4, 4, 4, 4, 5, 5, 5};
        int count = new Array().countNumberMaxEqualSequence(array);
        final int targerCount = 4;
        Assert.assertEquals(targerCount, count);
    }

    /**
     * Тест countNumberMaxEqualSequence.
     * Max последовательность в конце.
     */
    @Test
    public void whenMaxSequenceEndThenSuccessPath() {
        final int[] array = new int[]{3, 3, 5, 5, 5, 4, 4, 4, 4};
        int count = new Array().countNumberMaxEqualSequence(array);
        final int targerCount = 4;
        Assert.assertEquals(targerCount, count);
    }
}