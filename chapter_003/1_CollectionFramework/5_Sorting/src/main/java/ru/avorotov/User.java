package ru.avorotov;

import java.util.Objects;

/**
 * User.
 */
public class User implements Comparable<User> {

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public Integer getAge() {
        return age;
    }

    private String name;

    private Integer age;

    @Override
    public int compareTo(User user) {
        final int compareAge = this.age.compareTo(user.age);
        return compareAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
