package ru.avorotov;

import java.time.LocalDateTime;

/**
 * Класс заявка.
 */
public class Claim {
    /**
     * Идентификатор.
     */
    private int id;
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
     * Возвращает Дата создания.
     *
     * @param createDate Дата создания.
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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
    public int getId() {
        return this.id;
    }

    /**
     * Установить Идентификатор.
     *
     * @param id Идентификатор.
     */
    public void setId(int id) {
        this.id = id;
    }
}
