package ru.vorotov.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * User test.
 */
public class UserTest {
    /**
     * Equals and HashCode не переопределены. Оба user добавлены в Map.
     * По умолчанию Hashcode для разные инстансов возвращает всегда разные значения.
     * Значит объекты будут добавлены в коллекцию как разные.
     */
    @Test
    public void whenNotOverrideEqualsAndHashCode() {
        User user1 = new User("Name", 1, Calendar.getInstance());
        User user2 = new User("Name", 1, Calendar.getInstance());
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(user1, new Object());
        testMap.put(user2, new Object());

        printMap(testMap);
    }

    /**
     * HashCode переопределен. Оба user добавлены в Map.
     * т.к. добавляемые объекты равны то и HashCode равны.
     * Далее идет сравнение методом Equals.
     * По-умолчнию метод Equals возвращает false для разных инстанцов оъектов
     *
     * Следовательно объекты будут добавлены в коллекцию как разные.
     */
    @Test
    public void whenOverrideHashCode() {
        User user1 = new UserHashCode("Name", 1, Calendar.getInstance());
        User user2 = new UserHashCode("Name", 1, Calendar.getInstance());
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(user1, new Object());
        testMap.put(user2, new Object());

        printMap(testMap);
    }


    /**
     * Print map.
     * @param map Map for printing.
     */
    private void printMap(Map<?, ?> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key:" + entry.getKey() + "; Value:" + entry.getValue());
        }
    }
}