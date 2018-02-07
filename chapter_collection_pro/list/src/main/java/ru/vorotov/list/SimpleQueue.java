package ru.vorotov.list;

/**
 * SimpleQueue.
 *
 * @param <T> Element type.
 */
public class SimpleQueue<T> {
    /**
     * Inner container.
     */
    private SimpleLinkedContainer<T> innerContainer;

    /**
     * Ctor.
     */
    public SimpleQueue() {
        this.innerContainer = new SimpleLinkedContainer<>();
    }

    /**
     * Удалить из начала очереди.
     *
     * @return Удаленный элемент.
     */
    public T poll() {
        return innerContainer.removeFirst();
    }

    /**
     * Вставить элемент в конец очереди.
     *
     * @param value Вставляемый элемент.
     */
    public void push(T value) {
        innerContainer.add(value);
    }

}
