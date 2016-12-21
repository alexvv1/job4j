package ru.avorotov.areatriangle;

/**
 * Треугольник. С вершинами в точках A,B,C.
 *
 * @author avorotov
 * @version 1
 * @since 19.12.2016
 */
public class Triangle {
    /**
     * Вершина A.
     */
    private Point a;
    /**
     * Вершина B.
     */
    private Point b;
    /**
     * Вершина С.
     */
    private Point c;

    /**
     * Конструктор.
     *
     * @param a Вершина A
     * @param b Вершина B
     * @param c Вершина C
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
/*
    *//**
     * Вершина A
     *//*
    public Point getA() {
        return a;
    }

    *//**
     * Вершина B
     *//*
    public Point getB() {
        return b;
    }

    *//**
     * Вершина C
     *//*
    public Point getC() {
        return c;
    }*/

    /**
     * Площадь треугольника.
     *
     * @return Площадь треугольника.
     * @throws Exception Когда треугольника не может быть постоен
     */
    public double area() throws Exception {
        if (!existTriangle()) {
            throw new Exception("Not exist triangle");
        }
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ca = c.distanceTo(a);
        double p = (ab + bc + ca) / 2; //Полупериметр
        double area = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
        return area;
    }
    /**
     * Возможно ли построить треугольник.
     *
     * @return Возможно ли построить треугольник.
     */
    private boolean existTriangle() {
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ca = c.distanceTo(a);
        if ((ab + bc > ca) && (bc + ca > ab) && (ab + ca > bc)) {
            return true;
        }
        return false;
    }
}
