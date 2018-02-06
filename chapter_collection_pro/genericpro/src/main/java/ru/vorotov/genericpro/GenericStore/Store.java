package ru.vorotov.genericpro.GenericStore;

/**
 * Интерфейс контейнера.
 *
 * @param <T> Тип хранимого элемента контейнера.
 */
public interface Store<T extends BaseModel> {
    /**
     * Добавить элемень в контейнер.
     * @param model Добавляемый элемент.
     */
    void add(T model);

    /**
     * Вставить элемент в заданную позицию.
     *
     * @param index Индекс в контейнеру, куда вставить элемент.
     * @param model Вставляемый элемент.
     * @return Результат вставки.
     */
    boolean replace(int index, T model);

    /**
     * Удалить элемент из контейнера.
     *
     * @param index Индекс удаляемого элемента.
     * @return Результат вставки.
     */
    boolean delete(int index);

    /**
     * Возвращает элемен из контейнера по индексу.
     *
     * @param index Индекс элемента.
     * @return элемен из контейнера по индексу.
     */
    T get(int index);

}
