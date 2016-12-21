package ru.avorotov.areatriangle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Треугольник.
 * @author avorotov
 * @since 19.12.2016
 * @version 1
 */
public class TriangleTest {
    /**
     * Площадь треугольника.
     * @throws Exception Невозможно построить треугольник -> Exception.
     */
    @Test
    public void whenExistTriangleThenReturnArea() throws Exception {
        //Arrange
        //Вершина A
        final double ax = 3;
        final double ay = 6;
        final Point a = new Point(ax, ay);
        //Вершина B
        final double bx = -5;
        final double by = -2;
        final Point b = new Point(bx, by);
        //Вершина C
        final double cx = 5;
        final double cy = -5;
        final Point c = new Point(cx, cy);
        //Act
        final double expectedArea = 52;
        final double delta = 0.01;
        final double area = new Triangle(a, b, c).area();
        //Asert
        Assert.assertEquals(expectedArea, area, delta);
    }
    /**
     * Невозможно построить треугольник -> Exception.
     * @throws Exception Невозможно построить треугольник -> Exception.
     */
    @Test(expected = Exception.class)
    public void whenNotExistTriangleThenException() throws Exception {
        //Arrange
         //Вершина A
         final double ax = 1;
         final double ay = 1;
         final Point a = new Point(ax, ay);
         //Вершина B
         final double bx = 3;
         final double by = 3;
         final Point b = new Point(bx, by);
         //Вершина C
         final double cx = 6;
         final double cy = 6;
         final Point c = new Point(cx, cy);
         //Act
         new Triangle(a, b, c).area();
         //Asert
    }
}