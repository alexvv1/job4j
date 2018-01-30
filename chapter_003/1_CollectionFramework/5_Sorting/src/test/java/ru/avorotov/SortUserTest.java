package ru.avorotov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * Тест сортировки пользователей.
 */
public class SortUserTest {

    /**
     * Тестирование пользователя по возрасту в порядке возрастания.
     */
    @Test
    public void sortUserTest() {
        //Arrange
        final int ageUser1 = 14;
        User user1 = new User("Name1", ageUser1);
        final int ageUser2 = 10;
        User user2 = new User("Name2", ageUser2);
        final int ageUser3 = 16;
        User user3 = new User("Name3", ageUser3);
        final int ageUser4 = 12;
        User user4 = new User("Name4", ageUser4);
        List<User> unsortedList = new ArrayList<>();
        unsortedList.add(user1);
        unsortedList.add(user2);
        unsortedList.add(user3);
        unsortedList.add(user4);
        //Act
        Set<User> sortedUsers = new SortUser().sort(unsortedList);
        //Assert
        assertThat(sortedUsers, contains(user2, user4, user1, user3));

    }
}