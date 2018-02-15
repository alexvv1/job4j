package ru.vorotov.tree;

import java.util.*;

/**
 * BinaryTree implementation.
 * @param <E> Element type.
 */
public class BinaryTreeImpl<E extends Comparable<E>> implements BinaryTree<E> {
    /**
     * Root node.
     */
    private Node root;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addNode(E value) {
        if (value == null) {
            return false;
        }

        root = addRecursive(root, value);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> getChildren() {
        List<E> list;
        if (root == null) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                list.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return list;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E value) {
        boolean contains = false;
        if (value != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.value.equals(value)) {
                    contains = true;
                    break;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return contains;
    }

    /**
     * Add node.
     * @param current current node.
     * @param value Value.
     * @return Node.
     */
    private Node addRecursive(Node current, E value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {

            private Queue<Node> data = new LinkedList<>();

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

                Node el = data.poll();
                res = el;

                if (el.left != null) {
                    data.offer(el.left);
                }
                if (el.right != null) {
                    data.offer(el.right);
                }

                return res.value;
            }
        };
    }

    /**
     * Node.
     */
    private class Node {

        /**
         * Data.
         */
        private E value;

        /**
         * Link to the left child.
         */
        private Node left;

        /**
         * Link to the right child.
         */
        private Node right;

        /**
         * Constructor.
         *
         * @param value E.
         */
        private Node(E value) {
            this.value = value;
        }
    }
}