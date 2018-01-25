package ru.avorotov;

/**
 * Paint.
 */
public class Paint {

    /**
     * Фигура.
     */
    private Shape shape = null;

    /**
     * Конструктор.
     * @param shape Фигура которую некобходимо нарисовать.
     */
    Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Нарисовать.
     * @return Фигура в псевдографике.
     */
    String draw() {
        return shape.pic();
    }
}
