package ru.avorotov;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Сортровка пользователей.
 */
public class SortUser {
    public Set<User> sort(List<User> users) {
        TreeSet<User> sortUsers = new TreeSet<>(users);
        return sortUsers;
    }

}
