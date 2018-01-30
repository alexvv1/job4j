package ru.avorotov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.Is.is;

/**
 * User Convert Test.
 */
public class UserConvertTest {

    /**
     * Тест конвертиртации список пользователей в Map с ключом Integer id и соответствующим ему User.
     */
    @Test
    public void convertUserListToMapTest() {
        //Arrange
        final int oneId = 1;
        User user1 = new User(oneId, "Philander Dajana", "New York");
        final int twoId = 2;
        User user2 = new User(twoId, "Anastazy Caradog", "Los Angeles");
        final int threeId = 3;
        User user3 = new User(threeId, "Aaron Erlingr", "Chicago");
        final int four = 4;
        User user4 = new User(four, "Lucas Nanda", "Houston");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        //Act
        HashMap<Integer, User> process = new UserConvert().process(users);
        //Assert
        final int size = 4;
        assertThat(process.size(), is(size));
        assertThat(process, allOf(hasEntry(oneId, user1),
                hasEntry(twoId, user2),
                hasEntry(threeId, user3),
                hasEntry(four, user4)));
    }
}