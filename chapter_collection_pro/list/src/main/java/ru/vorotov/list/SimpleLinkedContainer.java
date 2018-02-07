package ru.vorotov.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Контейнер на базе связанного списка.
 *
 * @param <E> Тип хранимого значения.
 */
public class SimpleLinkedContainer<E> implements SimpleContainer<E> {


    /**
     * Размер контейнера.
     */
    private int size = 0;

    /**
     * Ссылка на первый элемент.
     */
    private Node<E> first;

    /**
     * Ссылка на последний элемент.
     */
    private Node<E> last;

    /**
     * Количество модификаций.
     */
    private int modCount;

    /**
     * Добавить элемент в контейнер.
     *
     * @param value Добавляемый элемент в контейнер.
     */
    @Override
    public void add(E value) {
        Node<E> tmp = last;
        Node<E> newNode = new Node<>(tmp, null, value);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * Возвращает элемен из контейнера по индексу.
     *
     * @param index Индекс элемента.
     * @return элемен из контейнера по индексу.
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> node;
        int i1 = size / 2;
        if (index < i1) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            node = x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            node = x;
        }
        return node.item;
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
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
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
     * Нода - элемент связанного списка.
     * @param <E> Тип значения.
     */
    private static class Node<E> {
        /**
         * Значение.
         */
        private E item;
        /**
         * Ссылка на следующий элемент.
         */
        private Node<E> next;
        /**
         * Ссылка на предыдущий элемент.
         */
        private Node<E> prev;

        /**
         * Конструктор.
         * @param prev Ссылка на предыдущий элемент.
         * @param next Ссылка на следующий элемент.
         * @param element Значение.
         */
        Node(Node<E> prev, Node<E> next, E element) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Итератор.
     */
    private class Itr implements Iterator<E> {

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
            checkModification();
            return cursor != size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            checkModification();
            return get(cursor++);
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
