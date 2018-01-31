package ru.avorotov;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для Класса сравнения списка объектов.
 */
public class ListCompareTest {
    /**
     * Сравниваемы списки равны.
     */
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        final List<Integer> left = Arrays.asList(1, 2, 3);
        final List<Integer> right = Arrays.asList(1, 2, 3);
        int rst = compare.compare(
                left,
                right
        );
        assertThat(rst, is(0));
    }

    /**
     * Список left < списка right.
     */
    @Test
    public void whenLeftLessRightThenMinus() {
        ListCompare compare = new ListCompare();
        final List<Integer> right = Arrays.asList(1, 2, 3);
        final List<Integer> left = Collections.singletonList(1);
        int rst = compare.compare(
                left,
                right
        );
        assertThat(rst, is(-1));
    }

    /**
     * Список left > списка right.
     */
    @Test
    public void whenLeftGreatRightThenPlus() {
        ListCompare compare = new ListCompare();
        final List<Integer> left = Arrays.asList(1, 2);
        final List<Integer> right = Arrays.asList(1, 1);
        int rst = compare.compare(
                left,
                right
        );
        assertThat(rst, is(1));
    }
}

