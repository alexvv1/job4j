package ru.avorotov;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Сортровка пользователей.
 */
public class SortUser {
    /**
     * Отсортироть пользователей по возрасту в порядке возрастания.
     *
     * @param users Пользователи.
     * @return Set отсортированных пользователей.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Сортировка пользователей по Имени.
     *
     * @param users Список пользователей.
     * @return Список отсортированных пользователей.
     */
    public List<User> sortNameLength(List<User> users) {
        //noinspection Convert2Lambda
        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User leftUser, User rightUser) {
                return Integer.compare(leftUser.getName().length(), rightUser.getName().length());
            }
        };
        users.sort(userComparator);
        return users;
    }

    /**
     * Сортировка пользователей по Имени с помощью Lambda Expression.
     *
     * @param users Список пользователей.
     * @return Список отсортированных пользователей..
     */
    public List<User> sortNameLengthByLambda(List<User> users) {
        Comparator<User> userComparator = Comparator.comparingInt(leftUser -> leftUser.getName().length());
        users.sort(userComparator);
        return users;
    }

    /**
     * Сортировка пользователей по полям имени и возрасту.
     *
     * @param users Список пользователей.
     * @return Список отсортированных пользователей.
     */
    public List<User> sortByAllFields(List<User> users) {
        //noinspection Convert2Lambda
        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User leftUser, User rightUser) {
                int rsl = leftUser.getName().compareTo(rightUser.getName());
                return rsl != 0 ? rsl : leftUser.getAge().compareTo(rightUser.getAge());
            }
        };
        users.sort(userComparator);
        return users;
    }

    /**
     * Сортировка пользователей по полям имени и возрасту с помощью Lambda Expression.
     *
     * @param users Список пользователей.
     * @return Список отсортированных пользователей.
     */

    public List<User> sortByAllFieldsByLambda(List<User> users) {
        Comparator<User> userComparator = Comparator.comparing(User::getName).thenComparingInt(User::getAge);
        users.sort(userComparator);
        return users;
    }


}
