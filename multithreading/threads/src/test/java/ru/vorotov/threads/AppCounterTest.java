package ru.vorotov.threads;

import org.junit.Test;

/**
 * AppCounterTest.
 */
public class AppCounterTest {
    /**
     * Count words and space. Multithreading.
     */
    @Test
    public void counterTest() {
       new AppCounter().run();
        /*
         Count Space = 1
         Count Space = 1
         Count Space = 2
         Count Space = 3
         Count Space = 4
         Count Space = 5
         Count Space = 6
         Count Word = 1
         Count Space = 7
         Count Word = 2
         Count Space = 8
         Count Word = 3
         Count Word = 4
         Count Word = 5
         Count Word = 6
         Count Space = 9
         Count Word = 7
         Result Count Space = 9
         Count Word = 8
         Count Word = 9
         Count Word = 10
         Result Count Word = 10
         */
    }
}