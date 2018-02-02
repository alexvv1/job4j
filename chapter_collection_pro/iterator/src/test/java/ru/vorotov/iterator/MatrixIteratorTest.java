package ru.vorotov.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест итератора двухмерного массива с одинаковым количеством строк и столбцов.
 */
public class MatrixIteratorTest {
    /**
     * Первый элемент массива.
     */
    private static final int ARRAY_INDEX_1 = 1;
    /**
     * Второй элемент массива.
     */
    private static final int ARRAY_INDEX_2 = 2;
    /**
     * Третий элемент массива.
     */
    private static final int ARRAY_INDEX_3 = 3;
    /**
     * Четвертый элемент массива.
     */
    private static final int ARRAY_INDEX_4 = 4;
    /**
     * Пятый элемент массива.
     */
    private static final int ARRAY_INDEX_5 = 5;
    /**
     * Шестой элемент массива.
     */
    private static final int ARRAY_INDEX_6 = 6;
    /**
     * Итератор.
     */
    private Iterator<Integer> it;

    /**
     * Инициализация массива.
     */
    @Before
    public void setUp() {
        final int[][] array = {{1, 2, 3}, {4, 5, 6}};
        it = new ArrayIterator(array);
    }

    /**
     * Test has Next Next Sequential Invocation.
     */
    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_6));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Tests That Next Method Doesnt Depends On Prior Has Next Invocation.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(ARRAY_INDEX_1));
        assertThat(it.next(), is(ARRAY_INDEX_2));
        assertThat(it.next(), is(ARRAY_INDEX_3));
        assertThat(it.next(), is(ARRAY_INDEX_4));
        assertThat(it.next(), is(ARRAY_INDEX_5));
        assertThat(it.next(), is(ARRAY_INDEX_6));
    }

    /**
     * Test sequential Has Next Invocation Doesnt Affect Retrieval Order.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_1));
        assertThat(it.next(), is(ARRAY_INDEX_2));
        assertThat(it.next(), is(ARRAY_INDEX_3));
        assertThat(it.next(), is(ARRAY_INDEX_4));
        assertThat(it.next(), is(ARRAY_INDEX_5));
        assertThat(it.next(), is(ARRAY_INDEX_6));
    }
}
