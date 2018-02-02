package ru.avorotov;

import java.util.Comparator;
import java.util.List;

/**
 * Класс для сравнения списка объектов.
 */
public class ListCompare implements Comparator<List<Integer>> {
    /**
     * Сравнение списков с int значениями.
     * Логика сравнения: Сравниваем поэлементно. Далее по размеру массива.
     * @param left  Первый объект для сравнения.
     * @param right Второй объект для сравнения.
     * @return -1 -> left < right; 0 -> left = right; 1 -> left > right.
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size() && result == 0) {
            result = Integer.compare(left.get(i), right.get(j));
            i++;
            j++;
        }
        return result == 0 ? Integer.compare(left.size(), right.size()) : result;
    }
}
