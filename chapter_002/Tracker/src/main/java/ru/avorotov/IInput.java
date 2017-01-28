package ru.avorotov;

/**
 * Ввод данных
 */
public interface IInput {
    /**
     * Спросить.
     * @param qestion Вопрос
     * @return Ответ на вопрос.
     */
    String ask(String qestion);
}
