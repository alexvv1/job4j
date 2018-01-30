package ru.avorotov;

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
     * @param question Вопрос
     * @param range Ключи допустимых действий.
     * @return Ответ на вопрос.
     */
    int ask(String question, int[] range);


    /**
     * Спросить.
     * @param question Вопрос
     * @return Ответ на вопрос в формате boolean.
     */
    boolean askBoolean(String question);
}
