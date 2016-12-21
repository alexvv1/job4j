package ru.avorotov.areatriangle;

/**
 * Точка на плоскости.
 *
 * @author avorotov
 * @version 1
 * @since 19.12.2016
 */
public class Point {
    /**
     * Координата x.
     */
    private double x;

    /**
     * Координата x.
     *
     * @return Координата x
     */
    public double getX() {
        return x;
    }

    /**
     * Координата y.
     *
     * @return Координата y.
     */
    private double getY() {
        return y;
    }

    /**
     * Координата y.
     */
    private double y;

    /**
     * Конструктор. Создает точку по координатам.
     *
     * @param x Координата x
     * @param y Координата y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние между текущей точкой и переданной в параметр.
     *
     * @param point Точка на плоскости
     * @return Расстояние между точками
     */
    public double distanceTo(Point point) {
        double distanceTo = Math.sqrt(Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2));
        return distanceTo;
    }
}