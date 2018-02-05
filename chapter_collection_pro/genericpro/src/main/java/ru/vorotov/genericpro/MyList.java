package ru.vorotov.genericpro;

/**
 * Интерфейс контейнера.
 *
 * @param <T> Тип хранимого значения.
 */
public interface MyList<T> extends Iterable<T> {

    /**
     * Добавить элемент в контейнер.
     *
     * @param model Добавляемый элемент в контейнер.
     * @return Индекс вставленного элемента.
     */
    int add(T model);

    /**
     * Вставить элемент в заданную позицию.
     *
     * @param index Индекс в контейнеру, куда вставить элемент.
     * @param model Вставляемый элемент.
     */
    void set(int index, T model);

    /**
     * Удалить элемент из контейнера.
     *
     * @param index Индекс удаляемого элемента.
     */
    void delete(int index);

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
}
