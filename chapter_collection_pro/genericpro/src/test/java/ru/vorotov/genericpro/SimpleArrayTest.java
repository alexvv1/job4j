package ru.vorotov.genericpro;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Тест Реализация контейнера на массивах.
 */
public class SimpleArrayTest {

    /**
     * Нулевой элемент контейнера.
     */
    private static final int ELEMENT_ARRAY_0 = 1;

    /**
     * Первый элемент контейнера.
     */
    private static final int ELEMENT_ARRAY_1 = 2;

    /**
     * Второй элемент контейнера.
     */
    private static final int ELEMENT_ARRAY_2 = 5;

    /**
     * Тестовый контейнер.
     */
    private SimpleArray<Integer> simpleArray;
    /**
     * Rule Expected Exception.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Инициализация массива.
     */
    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>();
        simpleArray.add(ELEMENT_ARRAY_0);
        simpleArray.add(ELEMENT_ARRAY_1);
        simpleArray.add(ELEMENT_ARRAY_2);
    }

    /**
     * add Elements Test Success.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void addElementsTestSuccess() {
        //Arrange
        //Act
        int index1 = simpleArray.add(4);
        int index2 = simpleArray.add(6);
        //Assert
        assertThat(simpleArray.get(index1), is(4));
        assertThat(simpleArray.get(index2), is(6));
    }

    /**
     * get Element Success.
     */
    @Test
    public void getElemSuccess() {
        //Arrange
        //Act
        Integer actualElem1 = simpleArray.get(0);
        Integer actualElem3 = simpleArray.get(2);
        //Assert
        assertThat(actualElem1, is(ELEMENT_ARRAY_0));
        assertThat(actualElem3, is(ELEMENT_ARRAY_2));
    }

    /**
     * get Elem Index Out Of Bounds Exception.
     */
    @Test
    public void getElemIndexOutOfBoundsException() {
        //Arrange
        //Act
        //Assert
        thrown.expect(IndexOutOfBoundsException.class);
        simpleArray.get(simpleArray.size());
    }

    /**
     * delete Last Index Element.
     */
    @Test
    public void deleteLastIndexElement() {
        //Arrange
        //Act
        int indexLastElem = simpleArray.size() - 1;
        simpleArray.delete(indexLastElem);
        //Assert
        assertThat(indexLastElem, is(simpleArray.size()));
        assertThat(ELEMENT_ARRAY_0, is(simpleArray.get(0)));
        assertThat(ELEMENT_ARRAY_1, is(simpleArray.get(1)));
    }

    /**
     * delete Not Last Index Element.
     */
    @Test
    public void deleteNotLastIndexElement() {
        //Arrange
        final int expectSize = simpleArray.size() - 1;
        //Act
        int indexElem = 1;
        simpleArray.delete(indexElem);
        //Assert
        assertThat(expectSize, is(simpleArray.size()));
        assertThat(ELEMENT_ARRAY_0, is(simpleArray.get(0)));
        assertThat(ELEMENT_ARRAY_2, is(simpleArray.get(1)));
    }

    /**
     * delete Elem Index Out Of Bounds Exception.
     */
    @Test
    public void deleteElemIndexOutOfBoundsException() {
        //Arrange
        //Act
        //Assert
        thrown.expect(IndexOutOfBoundsException.class);
        simpleArray.delete(simpleArray.size());
    }

    /**
     * size Test.
     */
    @Test
    public void sizeTest() {
        //Arrange
        //Act
        //Assert
        final int expectedSize = 3;
        assertThat(simpleArray.size(), is(expectedSize));
    }

    /**
     * set Element Test.
     */
    @Test
    public void setElementTest() {
        //Arrange
        int expectedSize = simpleArray.size();
        //Act
        final int newElem = 135;
        simpleArray.set(1, newElem);
        //Assert
        assertThat(expectedSize, is(simpleArray.size()));
        assertThat(ELEMENT_ARRAY_0, is(simpleArray.get(0)));
        assertThat(newElem, is(simpleArray.get(1)));
        assertThat(ELEMENT_ARRAY_2, is(simpleArray.get(2)));
    }

    /**
     * set Element Index Out Of Bounds Exception.
     */
    @Test
    public void setElemIndexOutOfBoundsException() {
        //Arrange
        //Act
        //Assert
        thrown.expect(IndexOutOfBoundsException.class);
        final int model = 35654;
        simpleArray.set(simpleArray.size(), model);
    }

    //Iterator test
    /**
     * concurrentModificationException Test.
     */
    @Test
    public void concurrentModificationExceptionTest() {
        //Arrange
        Iterator<Integer> iterator = simpleArray.iterator();
        //Act
        simpleArray.add(1);
        //Assert
        thrown.expect(ConcurrentModificationException.class);
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    /**
     * Test sequential Has Next Invocation Doesnt Affect Retrieval Order.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        //Arrange
        Iterator<Integer> iterator = simpleArray.iterator();
        //Act
        //Assert
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_0));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_1));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_2));
    }

    /**
     * Test should Return False If No Any Even Numbers.
     */
    @Test
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        //Arrange
        Iterator<Integer> iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        //Assert
        assertThat(iterator.hasNext(), Matchers.is(false));
    }

    /**
     * Test all Numbers Are Even.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void allNumbersAreEven() {
        //Arrange
        Iterator<Integer> iterator = simpleArray.iterator();
        //Assert
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_0));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_1));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_2));
    }

}