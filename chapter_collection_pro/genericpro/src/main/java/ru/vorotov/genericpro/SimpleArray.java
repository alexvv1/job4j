package ru.vorotov.genericpro;

import java.util.*;

/**
 * Реализация контейнера на массивах.
 *
 * @param <T> Тип элементов контефнера.
 */
public class SimpleArray<T> implements MyList<T> {
    /**
     * Вместимость контейнера.
     */
    private static final int DEFAULT_CAPACITY = 2;
    /**
     * Текущий размер массива.
     */
    private int size = 0;
    /**
     * Внутренние хранилище контейнера.
     */
    private Object[] container = new Object[DEFAULT_CAPACITY];
    /**
     * Количество модификаций контейнера.
     */
    private int modCount;

    /**
     * Добавить элемент в контейнер.
     *
     * @param model Добавляемый элемент в контейнер.
     * @return Индекс вставленного элемента.
     */
    @Override
    public int add(T model) {
        extendArr();
        modCount++;
        int i = size++;
        container[i] = model;
        return i;
    }

    /**
     * Вставить элемент в заданную позицию.
     *
     * @param index Индекс в контейнеру, куда вставить элемент.
     * @param model Вставляемый элемент.
     */
    @Override
    public void set(int index, T model) {
        checkIndex(index);
        modCount++;
        extendArr();
        container[index] = model;
    }

    /**
     * Удалить элемент из контейнера.
     *
     * @param index Индекс удаляемого элемента.
     */
    @Override
    public void delete(int index) {
        checkIndex(index);
        modCount++;
        //Если не последний элемент
        if (index != this.size() - 1) {
            System.arraycopy(container, index + 1, container, index, this.size() - index - 1);
        }
        container[--size] = null;
    }

    /**
     * Возвращает элемен из контейнера по индексу.
     *
     * @param index Индекс элемента.
     * @return элемен из контейнера по индексу.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        T t = (T) container[index];
        return t;
    }

    /**
     * Размер контейнера.
     *
     * @return Размер контейнера.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Контейнер содержит элемент?
     *
     * @param element Элемент для поиска.
     * @return Результат поиска.
     */
    @Override
    public boolean contains(T element) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, container[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    /**
     * Проверить валиден ли индекс.
     *
     * @param index Проверяемый индекс.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Проверить размер массива, при необходимости расширить.
     */
    private void extendArr() {
        if (container.length == size) {
            container = Arrays.copyOf(container, this.size() * 2);
        }
    }

    /**
     * Итератор.
     */
    private class Itr implements Iterator<T> {

        /**
         * Количество модификаций.
         */
        private int expectedModCount = modCount;

        /**
         * Курсор.
         */
        private int cursor = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return SimpleArray.this.size() > cursor;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            checkModification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return (T) SimpleArray.this.container[cursor++];
        }

        /**
         * Были ли изменения в коллекции после создания итератора.
         */
        private void checkModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
