package ru.avorotov.Model;

/**
 * Класс Комментарий.
 */
public class Comment {
    /**
     * Текст Комментария.
     */
    private String text;

    /**
     * Конструктор.
     * @param text Текст Комментария.
     */
    public Comment(String text) {
        this.text = text;
    }

    /**
     * Получить текст Комментария.
     * @return Текст Комментария.
     */
    public String getText() {
        return text;
    }
}
