package ru.vorotov.list;

/**
 * SimpleStack.
 *
 * @param <T>Element type.
 */
public class SimpleStack<T> {
    /**
     * Inner container.
     */
    private SimpleLinkedContainer<T> innerContainer;

    /**
     * Ctor.
     */
    SimpleStack() {
        this.innerContainer = new SimpleLinkedContainer<>();
    }

    /**
     * Достать элемент из стека в стек.
     *
     * @return Элемент.
     */
    public T poll() {
        return innerContainer.removeFirst();
    }

    /**
     * Положить элемент в стек.
     *
     * @param value Элемент.
     */
    public void push(T value) {
        innerContainer.addFirst(value);
    }
}
