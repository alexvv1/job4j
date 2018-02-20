package ru.vorotov.map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;


/**
 *
 */
public class SimpleMapImplTest {
    /**
     * Rule Expected Exception.
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    /**
     *
     */
    @Test
    public void whenAddEntryThenMapContainsIt() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        map.insert("0", "value0");

        String result = map.get("0");

        assertThat(result, is("value0"));
    }

    /**
     *
     */
    @Test
    public void whenAddEntryWithOldKeyThenMapContainsNewValue() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        map.insert("0", "value0");
        map.insert("0", "newValue");

        String result = map.get("0");

        assertThat(result, is("newValue"));
    }

    /**
     *
     */
    @Test
    public void whenAddEntryInNotNullBucketThenAddToExtendedMap() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>(2);
        map.insert("0", "value0");
        map.insert("1", "value1");
        map.insert("2", "value2");

        String result = map.get("2");

        assertThat(result, is("value2"));
    }

    /**
     *
     */
    @Test
    public void whenRemoveEntryThenMapDoesNotContainIt() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        map.insert("0", "value0");

        map.delete("0");
        String result = map.get("0");

        assertThat(result, is(nullValue()));
    }

    /**
     *
     */
    @Test
    public void whenRemoveEntryThenMapContainsOtherEntries() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>(2);
        map.insert("0", "value0");
        map.insert("1", "value1");

        map.delete("0");
        String result = map.get("1");

        assertThat(result, is("value1"));
    }

    /**
     *
     */
    @Test
    public void whenAddNullKeyThenContainsIt() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>(2);
        map.insert(null, "value");

        String result = map.get(null);

        assertThat(result, is("value"));
    }

    /**
     *
     */
    @Test
    public void whenMapHasntryThenIteratorHasNext() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        map.insert("0", "value0");
        Iterator<SimpleMapImpl.Entry> iterator = map.iterator();

        boolean result = iterator.hasNext();

        assertThat(result, is(true));
    }

    /**
     *
     */
    @Test
    public void whenMapHasNoEntryThenIteratorHasNotNext() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        Iterator<SimpleMapImpl.Entry> iterator = map.iterator();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     *
     */
    @Test
    public void whenMapHasOneEntryThenIteratorHasNotNextAfterCallNext() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        map.insert("0", "value0");
        Iterator<SimpleMapImpl.Entry> iterator = map.iterator();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     *
     */
    @Test
    public void whenMapHasNoEntryThenIteratorThrowExceptionAfterCallNext() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        Iterator<SimpleMapImpl.Entry> iterator = map.iterator();
        thrown.expect(NoSuchElementException.class);
        iterator.next();
    }

    /**
     *
     */
    @Test
    public void whenRemoveBeforeGetNextThenThrowException() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        map.insert("0", "value0");
        Iterator<SimpleMapImpl.Entry> iterator = map.iterator();

        thrown.expect(IllegalStateException.class);
        iterator.remove();
    }

    /**
     *
     */
    @Test
    public void whenRemoveAfterGetNextThenMapDoNotContainsEntry() {
        SimpleMapImpl<String, String> map = new SimpleMapImpl<>();
        map.insert("0", "value0");
        Iterator<SimpleMapImpl.Entry> iterator = map.iterator();

        iterator.next();
        iterator.remove();
        String result = map.get("0");

        assertThat(result, is(nullValue()));
    }
}