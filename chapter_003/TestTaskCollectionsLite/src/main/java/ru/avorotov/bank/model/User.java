package ru.avorotov.bank.model;

import java.util.Objects;

/**
 * Пользователь.
 */
public class User {

    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Номер паспорта.
     */
    private String passport;

    /**
     * Конструктор.
     *
     * @param name     Имя пользователя.
     * @param passport Номер паспорта.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Имя пользователя.
     *
     * @return Имя пользователя.
     */
    public String getName() {
        return name;
    }

    /**
     * Номер паспорта.
     *
     * @return Номер паспорта.
     */
    public String getPassport() {
        return passport;
    }

    /**
     *  Indicates whether some other object is "equal to" this one.
     *
     * @param   obj   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(passport, user.passport)
                && Objects.equals(name, user.name);
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     *
     * @return {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    /**
     * Строковое представление объета.
     * @return Строковое представление объета.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", passport='" + passport + '\''
                + '}';
    }
}
