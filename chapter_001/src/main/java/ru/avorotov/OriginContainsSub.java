package ru.avorotov;

/**
 * Проверяюет, что строка sub является подстрокой origin.
 *
 * @author avorotov
 * @version 1
 * @since 15.01.2017
 */
public class OriginContainsSub {

    /**
     * Проверяюет, что строка sub является подстрокой origin.
     *
     * @param origin Подстрока строка
     * @param sub Искомая строка
     * @return Строка sub является подстрокой origin
     */
    boolean contains(String origin, String sub) {
        char[] originChars = origin.toCharArray();
        char[] subChars = sub.toCharArray();
        boolean originContainsSub = false;
        //Цикл по подстроке origin
        for (int i = 0; i < originChars.length; i++) {
            //Ищем первое совпадение текущего символа origin и первого символа sub
            if (originChars[i] == subChars[0]) {
                //Необходимо найти чтобы все символы sub совподали с символами origin
                //начиная с симаола с индексом originCharI
                for (int j = 0; j < subChars.length; j++) {
                    if (originChars[i + j] != subChars[j]) {
                        break;
                    }
                    originContainsSub = j == subChars.length - 1;
                }
            }
            if (originContainsSub) {
                break;
            }
        }
        return originContainsSub;
    }
}
