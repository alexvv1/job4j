package ru.avorotov;

import java.time.LocalDateTime;

/**
 * Класс заявка.
 */
public class Claim {
    /**
     * Конструктор.
     * @param name Наименование заявки.
     * @param description Описание заявки.
     */
    public Claim(String name, String description) {
        this.name = name;
        this.description = description;
        createDate = LocalDateTime.now();
    }

    /**

     * Идентификатор.
     */
    private String id;
    /**
     * Имя.
     */
    private String name;
    /**
     * Описание.
     */
    private String description;
    /**
     * Дата создания.
     */
    private LocalDateTime createDate;
    /**
     * Список комментариев.
     */
    private Comment[] comments;

    /**
     * Возвращает Дата создания.
     *
     * @return Дата создания.
     */
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    /**
     * Возвращает Описание.
     *
     * @return Описание.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Установить описание.
     *
     * @param description описание.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Возвращает Имя.
     *
     * @return Имя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Установить Имя.
     *
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает список Комментариев.
     *
     * @return список Комментариев.
     */
    public Comment[] getComments() {
        return this.comments;
    }

    /**
     * Установить список Комментариев.
     *
     * @param comments Комментарии.
     */
    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    /**
     * Возвращает Идентификатор.
     *
     * @return Идентификатор.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Установить Идентификатор.
     *
     * @param id Идентификатор.
     */
    public void setId(String id) {
        this.id = id;
    }
}
