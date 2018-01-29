package ru.avorotov;

import java.util.Objects;

/**
 * Пользователь.
 */
public class User {
    /**
     * Конструктор.
     *
     * @param id   Идентификатор.
     * @param name Имя.
     * @param city Город.
     */
    @SuppressWarnings("WeakerAccess")
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Идентификатор.
     *
     * @return Идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Имя.
     *
     * @return Имя.
     */
    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    /**
     * Город.
     *
     * @return Город.
     */
    @SuppressWarnings("unused")
    public String getCity() {
        return city;
    }

    /**
     * Идентификатор.
     */
    private int id;
    /**
     * Имя.
     */
    private String name;
    /**
     * Город.
     */
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
