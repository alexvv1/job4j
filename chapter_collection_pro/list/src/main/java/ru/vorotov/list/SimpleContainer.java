package ru.vorotov.list;

/**
 * Интерфейс контейнера.
 * @param <T> Тип хранимого элемента.
 */
public interface SimpleContainer<T> extends Iterable<T> {

    /**
     * Добавить элемент в контейнер.
     *
     * @param value Добавляемый элемент в контейнер.
     */
    void add(T value);

    /**
     * Возвращает элемен из контейнера по индексу.
     *
     * @param index Индекс элемента.
     * @return элемен из контейнера по индексу.
     */
    T get(int index);

    /**
     * Размер контейнера.
     *
     * @return Размер контейнера.
     */
    int size();

    /**
     * Контейнер содержит элемент?
     * @param element Элемент для поиска.
     * @return Результат поиска.
     */
    boolean contains(T element);
}
