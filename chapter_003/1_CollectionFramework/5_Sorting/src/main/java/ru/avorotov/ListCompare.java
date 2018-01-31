package ru.avorotov;

import java.util.Comparator;
import java.util.List;

/**
 * Класс для сравнения списка объектов.
 */
public class ListCompare implements Comparator<List<Integer>> {
    /**
     * Сравнение списков с int значениями.
     * @param left  Первый объект для сравнения.
     * @param right Второй объект для сравнения.
     * @return -1 -> left < right; 0 -> left = right; 1 -> left > right.
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int res = Integer.compare(left.size(), right.size());
        if (res != 0) {
            return res;
        }
        for (int i = 0; i < left.size(); i++) {
            res = left.get(i).compareTo(right.get(i));
            if (res != 0) {
                break;
            }
        }
        return res;
    }
}
