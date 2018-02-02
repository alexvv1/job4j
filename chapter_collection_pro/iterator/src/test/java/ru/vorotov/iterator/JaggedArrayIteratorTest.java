package ru.vorotov.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест иткратора двухмерного массива с различным количеством строк и столбцов.
 */
public class JaggedArrayIteratorTest {
    /**
     * Первый элемент массива.
     */
    private static final int ARRAY_INDEX_1 = 1;
    /**
     * Второй элемент массива.
     */
    private static final int ARRAY_INDEX_2 = 3;
    /**
     * Третий элемент массива.
     */
    private static final int ARRAY_INDEX_3 = 4;
    /**
     * Четвертый элемент массива.
     */
    private static final int ARRAY_INDEX_4 = 7;
    /**
     * Итератор.
     */
    private Iterator<Integer> it;

    /**
     * Инициализация массива.
     */
    @Before
    public void setUp() {
        final int[][] array = {{1}, {3, 4}, {7}};
        it = new ArrayIterator(array);
    }

    /**
     * tests That Next Method Doesnt Depends On Prior Has Next Invocation.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(ARRAY_INDEX_1));
        assertThat(it.next(), is(ARRAY_INDEX_2));
        assertThat(it.next(), is(ARRAY_INDEX_3));
        assertThat(it.next(), is(ARRAY_INDEX_4));
    }

    /**
     * Test sequential Has Next Invocation Doesnt Affect Retrieval Order.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_1));
        assertThat(it.next(), is(ARRAY_INDEX_2));
        assertThat(it.next(), is(ARRAY_INDEX_3));
        assertThat(it.next(), is(ARRAY_INDEX_4));
    }

    /**
     * Test has Next Next Sequential Invocation.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(ARRAY_INDEX_4));
        assertThat(it.hasNext(), is(false));
    }
}
