package ru.vorotov.genericpro.GenericStore;

import ru.vorotov.genericpro.SimpleArray;

/**
 * Общая реализация контейнера.
 *
 * @param <T> Тип хранимых элементов.
 */
public abstract class AbstractStore<T extends BaseModel> implements Store<T> {

    /**
     * Внутренние хранилище элементов.
     */
    private SimpleArray<T> innerStore;

    /**
     * Конструктор.
     */
    AbstractStore() {
        this.innerStore = new SimpleArray<>();
    }

    /**
     * Добавить элемень в контейнер.
     *
     * @param model Добавляемый элемент.
     */
    @Override
    public void add(T model) {
        innerStore.add(model);
    }

    /**
     * Вставить элемент в заданную позицию.
     *
     * @param index Индекс в контейнеру, куда вставить элемент.
     * @param model Вставляемый элемент.
     */
    @Override
    public boolean replace(int index, T model) {
        try {
            innerStore.set(index, model);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Удалить элемент из контейнера.
     *
     * @param index Индекс удаляемого элемента.
     */
    @Override
    public boolean delete(int index) {
        try {
            innerStore.delete(index);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Возвращает элемен из контейнера по индексу.
     *
     * @param index Индекс элемента.
     * @return элемен из контейнера по индексу.
     */
    @Override
    public T get(int index) {
        return innerStore.get(index);
    }
}
