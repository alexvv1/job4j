package ru.vorotov.genericpro.GenericStore;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Тестирование контейнера.
 */
public class StoreTest {

    /**
     * Пользоватеель №1.
     */
    private static final User USER_1 = new User("Id1");

    /**
     * Пользоватеель №2.
     */
    private static final User USER_2 = new User("Id2");

    /**
     * Пользоватеель №2.
     */
    private static final User USER_3 = new User("Id3");

    /**
     * Тестирование добавления элемента.
     */
    @Test
    public void addAndGetStoreTest() {
        //Arrange
        Store<User> userStore = new UserStore();
        //Act
        userStore.add(USER_1);
        userStore.add(USER_2);
        userStore.add(USER_3);
        //Assert
        assertThat(userStore.get(0), is(USER_1));
        assertThat(userStore.get(1), is(USER_2));
        assertThat(userStore.get(2), is(USER_3));
    }

    /**
     * Тестирование вставки элемента.
     */
    @Test
    public void replaceStoreTest() {
        //Arrange
        Store<User> userStore = new UserStore();
        userStore.add(USER_1);
        userStore.add(USER_2);
        userStore.add(USER_3);
        //Act
        userStore.replace(1, USER_1);
        //Assert
        assertThat(userStore.get(0), is(USER_1));
        assertThat(userStore.get(1), is(USER_1));
        assertThat(userStore.get(2), is(USER_3));
    }

    /**
     * Тестирование удаления элемента.
     */
    @Test
    public void deleteStoreTest() {
        //Arrange
        Store<User> userStore = new UserStore();
        userStore.add(USER_1);
        userStore.add(USER_2);
        userStore.add(USER_3);
        //Act
        userStore.delete(1);
        //Assert
        assertThat(userStore.get(0), is(USER_1));
        assertThat(userStore.get(1), is(USER_3));
    }

}
