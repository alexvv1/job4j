package ru.vorotov.map;

import java.time.LocalDate;
import java.util.Objects;

/**
 * UserHashCodeAndEquals.
 */
public class UserHashCodeAndEquals extends User {
    /**
     * Ctor.
     *
     * @param name     Name.
     * @param children Children.
     * @param birthday Birthday.
     */
    public UserHashCodeAndEquals(String name, int children, LocalDate birthday) {
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

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChildren(), getBirthday());
    }
}