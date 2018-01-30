package ru.avorotov;

import java.util.Objects;

/**
 * User.
 */
public class User implements Comparable<User> {

    /**
     * Конструктор.
     * @param name Имя пользователя.
     * @param age Возраст пользователя.
     */
    @SuppressWarnings("WeakerAccess")
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Имя пользователя.
     * @return Имя пользователя.
     */
    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    /**
     * Возраст пользователя.
     * @return Возраст пользователя.
     */
    @SuppressWarnings("unused")
    public Integer getAge() {
        return age;
    }

    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Возраст пользователя.
     */
    private Integer age;

    /**
     * Сравнение текущего пользователя с переданным в параметрах.
     * @param user Сравниваемый пользователь.
     * @return -1 = this > user; +1 = user < this.
     */
    @Override
    public int compareTo(User user) {
        return this.age.compareTo(user.age);
    }

    /**
     * Сравнение текущего User и переданного по имени и возрасту.
     * @param o User
     * @return true - если объекты равны.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(age, user.age);
    }

    /**
     * HashCode.
     * @return HashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**
     * To String.
     * @return To String.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age + '}';
    }
}
