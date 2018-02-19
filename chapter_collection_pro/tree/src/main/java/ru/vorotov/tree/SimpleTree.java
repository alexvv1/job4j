package ru.vorotov.tree;

import java.util.*;

/**
 * SimpleTree.
 *
 * @param <E> Element type.
 */
public class SimpleTree<E extends Comparable<E>> implements Tree<E> {

    /**
     * Root.
     */
    private final Node root;

    /**
     * Ctor.
     *
     * @param root root element.
     */
    public SimpleTree(E root) {
        if (root == null) {
            throw new NullPointerException();
        }
        this.root = new Node<>(root);
    }

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean wasAdded = false;
        if (child != null && parent != null) {
            Node parentNode = getNodeByElement(parent, root);
            if (parentNode != null) {
                Node childNode = new Node(child);
                parentNode.add(childNode);
                wasAdded = true;
            }
        }
        return wasAdded;
    }

    /**
     * Get Node By Element.
     *
     * @param element Element.
     * @param parent  Parent.
     * @return Elemtn.
     */
    private Node getNodeByElement(E element, Node parent) {
        Node node = null;
        if (parent.getValue().equals(element)) {
            node = parent;
        } else {
            List<Node> children = parent.leaves();
            for (Node child : children) {
                node = getNodeByElement(element, child);
                if (node != null) {
                    break;
                }
            }
        }
        return node;
    }

    /**
     * Find by value.
     *
     * @param value value
     * @return Node.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Check if the tree is binary. The number of children in the tree <= 2.
     * @return Check if the tree is binary.
     */
    @Override
    public boolean isBinary() {
        return isBinary(root);
    }

    /**
     * Check if the tree is binary. The number of children in the tree <= 2.
     * @param node Root element.
     * @return Check if the tree is binary.
     */
    private boolean isBinary(Node node) {
        boolean isBinary = true;
        int size = node.leaves().size();
        if (size != 2 && size != 0) {
            isBinary = false;
        } else if (size == 2) {
            isBinary = isBinary((Node) node.leaves().get(0));
            if (isBinary) {
                isBinary = isBinary((Node) node.leaves().get(1));
            }
        }
        return isBinary;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Queue<Node<E>> data = new LinkedList<>();

            {
                data.offer(root);
            }

            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node res;


                Node<E> el = data.poll();
                res = el;

                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }

                return (E) res.getValue();
            }
        };
    }
}
