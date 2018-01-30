package ru.avorotov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;

public class SortUserTest {

    @Test
    public void sort() {
        //Arrange
        User user1 = new User("Name1", 14);
        User user2 = new User("Name2", 10);
        User user3 = new User("Name3", 16);
        User user4 = new User("Name4", 12);
        List<User> unsortedList = new ArrayList<>();
        unsortedList.add(user1);
        unsortedList.add(user2);
        unsortedList.add(user3);
        unsortedList.add(user4);
        //Act
        Set<User> sortedUsers = new SortUser().sort(unsortedList);
        //Assert
        //assertThat(sortedUsers, hasItems(hasItem(user1), hasItem(user4), hasItem(user1), hasItem(user3)));
        assertThat(sortedUsers, contains(user2, user4, user1, user3));

    }
}