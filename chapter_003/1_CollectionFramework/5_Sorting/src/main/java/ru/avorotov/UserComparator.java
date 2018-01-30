package ru.avorotov;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User leftUser, User rightUser) {
        final int compareAge = leftUser.getAge().compareTo(rightUser.getAge());
        return compareAge;
    }
}
