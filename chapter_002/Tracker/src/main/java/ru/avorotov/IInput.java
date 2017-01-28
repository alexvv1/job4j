package ru.avorotov;

/**
 * Ввод данных.
 */
public interface IInput {
    /**
     * Спросить.
     * @param qestion Вопрос
     * @return Ответ на вопрос.
     */
    String ask(String qestion);

    /**
     * Спросить.
     * @param qestion Вопрос
     * @return Ответ на вопрос в формате boolean.
     */
    boolean askBoolean(String qestion);
}
