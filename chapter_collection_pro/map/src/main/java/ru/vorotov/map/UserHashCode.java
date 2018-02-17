package ru.vorotov.map;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 */
public class UserHashCode extends User {

    /**
     * Ctor.
     *
     * @param name     Name.
     * @param children Children.
     * @param birthday Birthday.
     */
    public UserHashCode(String name, int children, LocalDate birthday) {
        super(name, children, birthday);
    }

    /**
     * HashCode.
     * @return HashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChildren(), getBirthday());
    }
}
