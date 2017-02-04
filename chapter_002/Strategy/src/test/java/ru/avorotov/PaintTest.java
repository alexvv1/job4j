package ru.avorotov;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование класса Paint.
 */
public class PaintTest {

    /**
     * Тестирование отображения фигуры Треугольник.
     */
    @Test
    public void whenDrawTriangleThenSuccess() {
        //Arrange
        Paint paint = new Paint(new Triangle());
        //Act
        String actualShapeDraw = paint.draw();
        //Assert
        String lineTriangle1 = "    ^";
        String lineTriangle2 = "   ^ ^";
        String lineTriangle3 =  "  ^   ^";
        String lineTriangle4 =  " ^     ^";
        String lineTriangle5 =  "^ ^ ^ ^ ^";
        String expectedTriangle = new StringBuilder().append(lineTriangle1)
                .append(System.lineSeparator())
                .append(lineTriangle2)
                .append(System.lineSeparator())
                .append(lineTriangle3)
                .append(System.lineSeparator())
                .append(lineTriangle4)
                .append(System.lineSeparator())
                .append(lineTriangle5)
                .toString();
        Assert.assertEquals(expectedTriangle, actualShapeDraw);
    }

    /**
     * Тестирование отображения фигуры Квадрат.
     */
    @Test
    public void whendrawSquareThenSuccess() {
        //Arrange
        Paint paint = new Paint(new Square());
        //Act
        String actualShapeDraw = paint.draw();
        //Assert
        String lineSquare1 = "^^^^^";
        String lineSquare2 = "^   ^";
        String lineSquare3 = "^   ^";
        String lineSquare4 = "^   ^";
        String lineSquare5 = "^^^^^";
        String expectedSquare = new StringBuilder().append(lineSquare1)
                .append(System.lineSeparator())
                .append(lineSquare2)
                .append(System.lineSeparator())
                .append(lineSquare3)
                .append(System.lineSeparator())
                .append(lineSquare4)
                .append(System.lineSeparator())
                .append(lineSquare5)
                .toString();
        Assert.assertEquals(expectedSquare, actualShapeDraw);
    }
}