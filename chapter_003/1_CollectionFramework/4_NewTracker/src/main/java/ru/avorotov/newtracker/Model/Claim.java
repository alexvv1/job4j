package ru.avorotov.newtracker.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    private List<Comment> comments;

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
     * Возвращает Имя.
     *
     * @return Имя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает список Комментариев.
     *
     * @return список Комментариев.
     */
    public List<Comment> getComments() {
        return this.comments;
    }

    /**
     * Установить список Комментариев.
     *
     * @param comments Комментарии.
     */
    public void setComments(List<Comment> comments) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Claim claim = (Claim) o;
        return Objects.equals(id, claim.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
