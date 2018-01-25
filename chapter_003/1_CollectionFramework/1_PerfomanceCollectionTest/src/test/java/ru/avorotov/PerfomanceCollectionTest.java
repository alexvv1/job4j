package ru.avorotov;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Тестрование производительности коллекций.
 */
public class PerfomanceCollectionTest {
    /**
     * Количество вставляемых элеметов.
     */
    public static final int AMOUNT_ADD = 3000000;
    /**
     * Количество удаляемых элементов.
     */
    public static final int AMOUNT_DELETE = 2500000;

    /**
     * Тестирование производительности ArrayList.
     */
    @Ignore
    @Test
    public void whenArrayList() {
        //Arrange
        System.out.println("PerfomanceCollectionTest.whenArrayList: Start");
        final PerfomanceCollection perfomanceCollection = new PerfomanceCollection();
        //Act
        final ArrayList<String> stringArrayList = new ArrayList<>();
        final long addTime = perfomanceCollection.add(stringArrayList, AMOUNT_ADD);
        System.out.println(String.format("Add %s elements. Time is %s ms.", AMOUNT_ADD, addTime));
        assertThat(AMOUNT_ADD, is(stringArrayList.size()));

        final long deleteTime = perfomanceCollection.delete(stringArrayList, AMOUNT_DELETE);
        //Assert
        System.out.println(String.format("Delete %s elements. Time is %s ms.", AMOUNT_DELETE, deleteTime));
        assertThat(AMOUNT_ADD - AMOUNT_DELETE, is(stringArrayList.size()));
        System.out.println("PerfomanceCollectionTest.whenArrayList: whenArrayList End");
    }

    /**
     * Тестирование производительности LinkedList.
     */
    @Test
    public void whenLinkedList() {
        //Arrange
        System.out.println("PerfomanceCollectionTest.whenLinkedList: Start");
        final PerfomanceCollection perfomanceCollection = new PerfomanceCollection();
        //Act
        final LinkedList<String> stringLinkedList = new LinkedList<>();
        final long addTime = perfomanceCollection.add(stringLinkedList, AMOUNT_ADD);
        System.out.println(String.format("Add %s elements. Time is %s ms.", AMOUNT_ADD, addTime));
        assertThat(AMOUNT_ADD, is(stringLinkedList.size()));

        final long deleteTime = perfomanceCollection.delete(stringLinkedList, AMOUNT_DELETE);
        //Assert
        System.out.println(String.format("Delete %s elements. Time is %s ms.", AMOUNT_DELETE, deleteTime));
        assertThat(AMOUNT_ADD - AMOUNT_DELETE, is(stringLinkedList.size()));
        System.out.println("PerfomanceCollectionTest.whenlinkedList: whenLinkedList End");
    }

    /**
     * Тестирование производительности TreeSet.
     */
    @Test
    public void whenTreeSet() {
        //Arrange
        System.out.println("PerfomanceCollectionTest.whenTreeSet: Start");
        final PerfomanceCollection perfomanceCollection = new PerfomanceCollection();
        //Act
        final TreeSet<String> stringTreeSet = new TreeSet<>();
        final long addTime = perfomanceCollection.add(stringTreeSet, AMOUNT_ADD);
        System.out.println(String.format("Add %s elements. Time is %s ms.", AMOUNT_ADD, addTime));
        assertThat(AMOUNT_ADD, is(stringTreeSet.size()));

        final long deleteTime = perfomanceCollection.delete(stringTreeSet, AMOUNT_DELETE);
        //Assert
        System.out.println(String.format("Delete %s elements. Time is %s ms.", AMOUNT_DELETE, deleteTime));
        assertThat(AMOUNT_ADD - AMOUNT_DELETE, is(stringTreeSet.size()));
        System.out.println("PerfomanceCollectionTest.whenTreeSet: whenTreeSet End");
    }
}