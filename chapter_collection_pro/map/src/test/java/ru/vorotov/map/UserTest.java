package ru.vorotov.map;

import org.junit.Test;

import java.time.LocalDate;
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
    @SuppressWarnings("checkstyle:magicnumber")
    public void whenNotOverrideEqualsAndHashCode() {
        User user1 = new User("Name", 1, LocalDate.of(1996, 12, 15));
        User user2 = new User("Name", 1, LocalDate.of(1996, 12, 15));
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(user1, new Object());
        testMap.put(user2, new Object());

        printMap(testMap);

        /**
         *
         * Key:ru.vorotov.map.User@50134894; Value:java.lang.Object@1376c05c
         * Key:ru.vorotov.map.User@2957fcb0; Value:java.lang.Object@51521cc1
         */
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
    @SuppressWarnings("checkstyle:magicnumber")
    public void whenOverrideHashCode() {
        User user1 = new UserHashCode("Name", 1, LocalDate.of(1996, 12, 15));
        User user2 = new UserHashCode("Name", 1, LocalDate.of(1996, 12, 15));
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(user1, new Object());
        testMap.put(user2, new Object());

        printMap(testMap);

        /**
         * Key:ru.vorotov.map.UserHashCode@8ae2c778; Value:java.lang.Object@50134894
         * Key:ru.vorotov.map.UserHashCode@8ae2c778; Value:java.lang.Object@2957fcb0
         */
    }

    /**
     * HashCode и Equals переопределены. В Map добавлен только првый user.
     * Т.к. по hashcode и equals вставляемые user равны.
     */
    @Test
    @SuppressWarnings("checkstyle:magicnumber")
    public void whenOverrideEqualsAndHashCode() {
        User user1 = new UserHashCodeAndEquals("Name", 1, LocalDate.of(1996, 12, 12));
        System.out.println("User 1 hashcode:" + Integer.toHexString(user1.hashCode()));
        User user2 = new UserHashCodeAndEquals("Name", 1, LocalDate.of(1996, 12, 12));
        System.out.println("User 2 hashcode:" + Integer.toHexString(user2.hashCode()));
        System.out.println("User 1 equals user 2:" + user1.equals(user2));
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(user1, new Object());
        testMap.put(user2, new Object());

        printMap(testMap);

        /**
         * User 1 hashcode:8ae2c775
         * User 2 hashcode:8ae2c775
         * User 1 equals user 2:true
         * Key:ru.vorotov.map.UserHashCodeAndEquals@8ae2c775; Value:java.lang.Object@50134894
         */
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