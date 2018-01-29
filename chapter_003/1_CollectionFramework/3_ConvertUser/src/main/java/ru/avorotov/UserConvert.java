package ru.avorotov;

import java.util.HashMap;
import java.util.List;

/**
 * User Convert.
 */
public class UserConvert {

    /**
     * Принимает в себя список пользователей
     * и конвертирует его в Map с ключом Integer id и соответствующим ему User.
     * @param list список пользователей.
     * @return Map с ключом Integer id и соответствующим ему User.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }

        return result;
    }
}
