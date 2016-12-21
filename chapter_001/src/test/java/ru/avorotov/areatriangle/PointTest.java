package ru.avorotov.areatriangle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Точка на плоскости.
 * @author avorotov
 * @since 19.12.2016
 * @version 1
 */
public class PointTest {
    /**
     * Тестирование расстояния между точками с положительными координатаи.
     */
    @Test
    public void whenSetAnyPointPositivThenDistanceToSuccess() {
        //Arrange
        final double x1 = 3;
        final double y1 = 3;
        Point p1 = new Point(x1, y1); //Первая точка
        final double y2 = 0;
        final double x2 = 6;
        Point p2 = new Point(x2, y2); //Вторая точка
        //Act
        double distanceTo = p1.distanceTo(p2);
        //Assert
        final double expectedDistanceTo = 4.24;
        final double delta = 0.01;
        Assert.assertEquals(expectedDistanceTo, distanceTo, delta);
    }
        /**
        * Тестирование расстояния между точками с отрицательными координатам.
        */
        @Test
        public void whenSetAnyPointNegativeThenDistanceToSuccess() {
            //Arrange
            final double x1 = 3;
            final double y1 = -3;
            Point p1 = new Point(x1, y1); //Первая точка
            final double x2 = -6;
            final double y2 = 0;
            Point p2 = new Point(x2, y2); //Вторая точка
            //Act
            double distanceTo = p1.distanceTo(p2);
            //Assert
            final double expectedDistanceTo = 9.48;
            final double delta = 0.01;
            Assert.assertEquals(expectedDistanceTo, distanceTo, delta);
        }
}