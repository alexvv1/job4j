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
        double ab = this.a.distanceTo(this.b);
        double bc = this.b.distanceTo(this.c);
        double ca = this.c.distanceTo(this.a);
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
        double ab = this.a.distanceTo(this.b);
        double bc = this.b.distanceTo(this.c);
        double ca = this.c.distanceTo(this.a);
        if ((ab + bc > ca) && (bc + ca > ab) && (ab + ca > bc)) {
            return true;
        }
        return false;
    }
}
