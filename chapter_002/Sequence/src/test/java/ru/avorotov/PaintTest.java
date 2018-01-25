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
        String expectedTriangle = lineTriangle1
                + System.lineSeparator()
                + lineTriangle2
                + System.lineSeparator()
                + lineTriangle3
                + System.lineSeparator()
                + lineTriangle4
                + System.lineSeparator()
                + lineTriangle5;
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
        String expectedSquare = lineSquare1
                + System.lineSeparator()
                + lineSquare2
                + System.lineSeparator()
                + lineSquare3
                + System.lineSeparator()
                + lineSquare4
                + System.lineSeparator()
                + lineSquare5;
        Assert.assertEquals(expectedSquare, actualShapeDraw);
    }
}