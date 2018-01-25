package ru.avorotov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Конвертация двумерного массива в ArrayList и наоборот.
 */
public class ConvertList {
    /**
     * Конвертация двумерного массива в ArrayList.
     * @param array Массив.
     * @return Результирующий ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> newList = new ArrayList<>();
        for (int[] innerArray : array) {
            for (int elem : innerArray) {
                newList.add(elem);
            }
        }
        return newList;
    }

    /**
     * Конвертация ArrayList в двумерный массив.
     * @param list Исходный ArrayList.
     * @param rows Количество строк в результирующем массиве.
     * @return Результирующий массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int lengthList = list.size();
        int column;
        if (lengthList % rows != 0) {
            column = lengthList / rows + 1;
        } else {
            column = lengthList / rows;
        }
        int[][] array = new int[rows][column];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
