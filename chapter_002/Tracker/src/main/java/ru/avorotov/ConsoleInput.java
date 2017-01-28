package ru.avorotov;

import java.util.Scanner;

/**
 * Ввод с консоли.
 */
public class ConsoleInput implements IInput {
    /**
     * Константа, для ответа "да".
     */
    private static final String YES = "да";

    /**
     * Parser из потока.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Спросить.
     * @param question Вопрос
     * @return Ответ на вопрос.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Спросить.
     *
     * @param question Вопрос
     * @return Ответ на вопрос в формате boolean.
     */
    @Override
    public boolean askBoolean(String question) {
        System.out.print(question);
        return YES.equals(scanner.nextLine());
    }
}
