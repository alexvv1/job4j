package ru.avorotov.paint;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование рисования в псевдографике.
 */
public class PaintTest {
    /**
     * Тестирование Возвращает пирамиду в псевдографике.
     *
     * @throws Exception Когда h <= 0
     */
    @Test
    public void whenPiramidSucessPathThenPaintPiramid() throws Exception {
        //Arrange
        final int h = 5;
        //Act
        String piramid = new Paint().piramid(h);
        String piramidLine1 = "    ^    ";
        String piramidLine2 = "   ^ ^   ";
        String piramidLine3 = "  ^ ^ ^  ";
        String piramidLine4 = " ^ ^ ^ ^ ";
        String piramidLine5 = "^ ^ ^ ^ ^";
        String expectedPiramid = new StringBuilder().append(piramidLine1)
                .append(System.lineSeparator())
                .append(piramidLine2)
                .append(System.lineSeparator())
                .append(piramidLine3)
                .append(System.lineSeparator())
                .append(piramidLine4)
                .append(System.lineSeparator())
                .append(piramidLine5)
                .toString();
        //Assert
        Assert.assertEquals(expectedPiramid, piramid);
    }

    /**
     * Тестирование Возвращает пирамиду в псевдографике. h < 0. Exception.
     *
     * @throws Exception Когда h < 0
     */
    @Test(expected = Exception.class)
    public void whenPiramidAndHightLessZeroThenException() throws Exception {
        //Arrange
        final int h = -3;
        //Act
        String piramid = new Paint().piramid(h);
    }

    /**
     * Тестирование Возвращает пирамиду в псевдографике. h == 0. Exception.
     *
     * @throws Exception Когда h == 0
     */
    @Test(expected = Exception.class)
    public void whenPiramidAndHightZeroThenException() throws Exception {
        //Arrange
        final int h = 0;
        //Act
        String piramid = new Paint().piramid(h);
    }
}