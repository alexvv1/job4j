package ru.avorotov;

import java.util.Collection;
import java.util.Iterator;

/**
 * Тестирование производительности коллекций.
 */
public class PerfomanceCollection {

    /**
     * Считает время добавления элементов в коллекцию.
     *
     * @param collection Коллекция.
     * @param amount     Число вставляемых элементов.
     * @return Время вставки в мс.
     */
    public long add(final Collection<String> collection, final int amount) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < amount; i++) {
            final String stringAdd = "String Add: " + i;
            collection.add(stringAdd);
        }

        return System.currentTimeMillis() - startTime;
    }

    /**
     * Считает время удаления элементов из коллекции.
     *
     * @param collection Коллекция.
     * @param amount     Число удаляемых элементов.
     * @return Время удаления в мс.
     */
    public long delete(final Collection<String> collection, final int amount) {
        long startTime = System.currentTimeMillis();
        final Iterator<String> iterator = collection.iterator();
        for (int i = 0; i < amount; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        return System.currentTimeMillis() - startTime;
    }
}
