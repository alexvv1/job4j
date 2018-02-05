package ru.vorotov.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Converter Iterator Of Iterators.
 */
public class ConverterIteratorOfIterators {

    /**
     * Получить все элементы вложенного итератора.
     * @param it Итератор итератора.
     * @return Получить все элементы вложенного итератора.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * Внутренний итератор.
             */
            private Iterator<Integer> innerIter = null;
            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (innerIter == null && it.hasNext()) {
                    innerIter = it.next();
                }
                if (innerIter == null) {
                    return false;
                }

                if (innerIter.hasNext()) {
                    hasNext = true;
                }

                if (!innerIter.hasNext()) {
                    innerIter = null;
                }

                return hasNext;
            }
            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public Integer next() {
                Integer item = getElem();
                if (item == null) {
                    throw new NoSuchElementException();
                }
                return item;
            }

            /**
             * Получить элемент итератора.
             * @return Получить элемент итератора.
             */
            private Integer getElem() {
                Integer item = null;
                if (innerIter == null && it.hasNext()) {
                    innerIter = it.next();
                }
                if (innerIter == null) {
                    throw new NoSuchElementException();
                }

                if (innerIter.hasNext()) {
                    item = innerIter.next();
                }

                if (!innerIter.hasNext()) {
                    innerIter = null;
                }
                return item;
            }
        };
    }
}
