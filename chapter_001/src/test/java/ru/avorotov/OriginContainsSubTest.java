package ru.avorotov;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тест OriginContainsSubTest.
 *
 * @author avorotov
 * @version 1
 * @since 17.12.2016
 */
public class OriginContainsSubTest {

    /**
     * Когда строка Origin содержит подстроку Sub возвращет True.
     */
    @Test
    public void whenOriginContainsSubThenTrue() {
        //Строка
        final String origin = "gfhjdfghKJGKGgjhkgKJG";
        //Искомая подстрока
        final String sub = "hjd";
        boolean result = new OriginContainsSub().contains(origin, sub);
        Assert.assertTrue(result);
    }

    /**
     * Когда строка Origin не содержит подстроку Sub возвращет False.
     */
    @Test
    public void whenOriginNotContainsSubThenFalse() {
        //Строка
        final String origin = "gfhjdfghKJGKGgjhkgKJG";
        //Искомая подстрока
        final String sub = ",m.";
        boolean result = new OriginContainsSub().contains(origin, sub);
        Assert.assertFalse(result);
    }
}