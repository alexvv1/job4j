package ru.avorotov.newtracker;

import java.util.List;

/**
 * Ввод данных.
 */
public interface IInput {
    /**
     * Спросить.
     * @param question Вопрос
     * @return Ответ на вопрос.
     */
    String ask(String question);

    /**
     * Спросить.
     * @param question Вопрос.
     * @param range Ключи допустимых действий.
     * @return Ответ на вопрос.
     */
    int ask(String question, List<Integer> range);


    /**
     * Спросить.
     * @param question Вопрос
     * @return Ответ на вопрос в формате boolean.
     */
    boolean askBoolean(String question);
}
