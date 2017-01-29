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
     *
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
     * @param range
     * @return Ответ на вопрос.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean valid = false;
        int key = -1;

        do {
            try {
                key = Integer.valueOf(this.ask(question));
                for (int value : range) {
                    if (value == key) {
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    throw new MenuOutException("Out of menu range.");
                }
            } catch (MenuOutException ex) {
                System.out.println("Введите, пожалуйста, корректный пункт меню. ");
            } catch (NumberFormatException e) {
                System.out.println("Введите, пожалуйста, корректный пункт меню. ");
            }
        } while (!valid);
        return key;
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
