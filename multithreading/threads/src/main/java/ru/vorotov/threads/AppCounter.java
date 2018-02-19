package ru.vorotov.threads;

/**
 * AppCounter.
 */
public class AppCounter {
    /**
     * COUNTER STRING.
     */
    private static final String COUNTER_STRING = "Данный раздел посвящен языку программирования Java и всем сопутствующим технологиям.";

    /**
     * Runner.
     */
    public void run() {
        Counter counter = new Counter(COUNTER_STRING);
        Thread threadCounterSpace = new Thread(() -> System.out.println("Result Count Space = " + counter.countSpace()));
        Thread threadCounterWord = new Thread(() -> System.out.println("Result Count Word = " + counter.countWord()));
        threadCounterSpace.start();
        threadCounterWord.start();
    }
}