package ru.vorotov.list;

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
 * Тест Контейнер на базе связанного списка.
 */
public class SimpleLinkedContainerTest {
    /**
     * Нулевой элемент контейнера.
     */
    private static final String ELEMENT_ARRAY_0 = "Str0";

    /**
     * Первый элемент контейнера.
     */
    private static final String ELEMENT_ARRAY_1 = "Str1";

    /**
     * Второй элемент контейнера.
     */
    private static final String ELEMENT_ARRAY_2 = "Str2";

    /**
     * Третий элемент контейнера.
     */
    private static final String ELEMENT_ARRAY_3 = "Str3";


    /**
     * Тестовый контейнер.
     */
    private SimpleLinkedContainer<String> simpleLinkedContainer;
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
        simpleLinkedContainer = new SimpleLinkedContainer<>();
        simpleLinkedContainer.add(ELEMENT_ARRAY_0);
        simpleLinkedContainer.add(ELEMENT_ARRAY_1);
        simpleLinkedContainer.add(ELEMENT_ARRAY_2);
        simpleLinkedContainer.add(ELEMENT_ARRAY_3);
    }

    /**
     * add Elements Test Success.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void addElementsTestSuccess() {
        //Arrange
        //Act
        //Assert
        assertThat(simpleLinkedContainer.get(0), is(ELEMENT_ARRAY_0));
        assertThat(simpleLinkedContainer.get(1), is(ELEMENT_ARRAY_1));
        assertThat(simpleLinkedContainer.get(2), is(ELEMENT_ARRAY_2));
        assertThat(simpleLinkedContainer.get(3), is(ELEMENT_ARRAY_3));
    }


    /**
     * get Element Success.
     */
    @Test
    public void getElemSuccess() {
        //Arrange
        //Act
        String actualElem0 = simpleLinkedContainer.get(0);
        String actualElem2 = simpleLinkedContainer.get(2);
        //Assert
        assertThat(actualElem0, is(ELEMENT_ARRAY_0));
        assertThat(actualElem2, is(ELEMENT_ARRAY_2));
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
        simpleLinkedContainer.get(simpleLinkedContainer.size());
    }

    //Iterator test

    /**
     * concurrentModificationException Test.
     */
    @Test
    public void concurrentModificationExceptionTest() {
        //Arrange
        Iterator<String> iterator = simpleLinkedContainer.iterator();
        //Act
        simpleLinkedContainer.add("StrAny");
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
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        //Arrange
        Iterator<String> iterator = simpleLinkedContainer.iterator();
        //Act
        //Assert
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_0));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_1));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_2));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_3));
    }

    /**
     * Test should Return False If No Any Even Numbers.
     */
    @Test
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        //Arrange
        Iterator<String> iterator = simpleLinkedContainer.iterator();
        iterator.next();
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
    public void allNumbersAreEven() {
        //Arrange
        Iterator<String> iterator = simpleLinkedContainer.iterator();
        //Assert
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_0));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_1));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_2));
        assertThat(iterator.hasNext(), Matchers.is(true));
        assertThat(iterator.next(), Matchers.is(ELEMENT_ARRAY_3));
    }

}