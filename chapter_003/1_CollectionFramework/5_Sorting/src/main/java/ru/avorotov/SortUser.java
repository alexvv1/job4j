package ru.avorotov;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Сортровка пользователей.
 */
public class SortUser {
    /**
     * Отсортироть пользователей по возрасту в порядке возрастания.
     * @param users Пользователи.
     * @return Set отсортированных пользователей.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

}
