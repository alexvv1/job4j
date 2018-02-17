package ru.vorotov.map;

import java.time.LocalDate;
import java.util.Objects;

/**
 * User override Equals.
 */
@SuppressWarnings("checkstyle:equalshashcode")
public class UserEquals extends User {
    /**
     * Ctor.
     *
     * @param name     Name.
     * @param children Children.
     * @param birthday Birthday.
     */
    public UserEquals(String name, int children, LocalDate birthday) {
        super(name, children, birthday);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return getChildren() == user.getChildren()
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getBirthday(), user.getBirthday());
    }

}
