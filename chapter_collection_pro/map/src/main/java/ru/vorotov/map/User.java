package ru.vorotov.map;

import java.util.Calendar;

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
    private Calendar birthday;

    /**
     * Ctor.
     * @param name Name.
     * @param children Children.
     * @param birthday Birthday.
     */
    public User(String name, int children, Calendar birthday) {
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
    public Calendar getBirthday() {
        return birthday;
    }
}
