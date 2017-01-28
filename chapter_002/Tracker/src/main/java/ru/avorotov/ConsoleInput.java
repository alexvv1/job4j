package ru.avorotov;

import java.util.Scanner;

/**
 * Ввод с консоли.
 */
public class ConsoleInput implements IInput {
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
        System.out.println(question);
        return scanner.nextLine();
    }
}
