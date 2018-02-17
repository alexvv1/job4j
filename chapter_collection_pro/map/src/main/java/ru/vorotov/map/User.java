package ru.vorotov.map;

import java.time.LocalDate;

/**
 * User.
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Children.
     */
    private int children;
    /**
     * Birthday.
     */
    private LocalDate birthday;

    /**
     * Ctor.
     * @param name Name.
     * @param children Children.
     * @param birthday Birthday.
     */
    public User(String name, int children, LocalDate birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Name.
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Children.
     * @return Children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Birthday.
     * @return Birthday.
     */
    public LocalDate getBirthday() {
        return birthday;
    }
}
