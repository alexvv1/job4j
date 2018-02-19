package ru.vorotov.threads;

import java.util.StringTokenizer;

/**
 * Counter.
 */
public class Counter {
    /**
     * String.
     */
    private String str;
    /**
     * Count Space.
     */
    private int countSpace = 0;
    /**
     * Count word.
     */
    private int countWord = 0;

    /**
     * Ctor.
     * @param str String.
     */
    public Counter(String str) {
        this.str = str;
    }

    /**
     * Count space.
     * @return Count space.
     */
    public int countSpace() {
        for (char charItem : str.toCharArray()) {
            if (charItem == ' ') {
                countSpace++;
                System.out.println("Count Space = " + countSpace);
            }
        }
        return countSpace;
    }

    /**
     * Count word.
     * @return Count word.
     */
    public int countWord() {
        StringTokenizer ins = new StringTokenizer(str);
        while (ins.hasMoreTokens()) {
            countWord++;
            System.out.println("Count Word = " + countWord);
            ins.nextToken();
        }
        return countWord;
    }
}
