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

    /**
     * Пользователь №1.
     */
    private final User user1 = new User("Сергей", 25);

    /**
     * Пользователь №2.
     */
    private final User user2 = new User("Иван", 30);

    /**
     * Пользователь №3.
     */
    private final User user3 = new User("Сергей", 20);

    /**
     * Пользователь №4.
     */
    private final User user4 = new User("Иван", 25);

    /**
     * Тест Сортировки пользователей по Имени.
     */
    @Test
    public void sortNameLengthTest() {
        //Arrange
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        //Act
        new SortUser().sortNameLength(users);
        //Assert
        assertThat(users, contains(user2, user4, user1, user3));
    }

    /**
     * Тест Сортировки пользователей по Имени с помощью Lambda Expression..
     */
    @Test
    public void sortNameLengthByLambdaTest() {
        //Arrange
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        //Act
        new SortUser().sortNameLengthByLambda(users);
        //Assert
        assertThat(users, contains(user2, user4, user1, user3));
    }

    /**
     * Тест Сортировки пользователей по полям имени и возрасту.
     */
    @Test
    public void sortByAllFieldsTest() {
        //Arrange
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        //Act
        new SortUser().sortByAllFields(users);
        //Assert
        assertThat(users, contains(user4, user2, user3, user1));
    }

    /**
     * Тест Сортировки пользователей по полям имени и возрасту с помощью Lambda Expression.
     */
    @Test
    public void sortByAllFieldsByLambda() {
        //Arrange
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        //Act
        new SortUser().sortByAllFieldsByLambda(users);
        //Assert
        assertThat(users, contains(user4, user2, user3, user1));    }
}