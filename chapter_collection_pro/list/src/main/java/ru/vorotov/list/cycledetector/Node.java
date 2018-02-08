package ru.vorotov.list.cycledetector;

/**
 * Node.
 *
 * @param <T> Item type.
 */
class Node<T> {
    /**
     * Value.
     */
    private T value;
    /**
     * Next node.
     */
    private Node next;

    /**
     * Constructor.
     *
     * @param value value.
     */
    Node(T value) {
        this.value = value;
    }

    /**
     * Get Value.
     *
     * @return Value.
     */
    public T getValue() {
        return value;
    }

    /**
     * Set value.
     *
     * @param value value.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Get next node.
     *
     * @return Next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set next node.
     *
     * @param next next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
