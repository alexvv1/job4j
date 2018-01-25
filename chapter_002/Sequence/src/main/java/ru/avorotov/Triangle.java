package ru.avorotov;

/**
 * Треугольник.
 */
public class Triangle implements Shape {
    /**
     * Возвращает фигуру в псевдографике.
     *
     * @return Фигура в псевдографике.
     */
    @Override
    public String pic() {
        String lineTriangle1 = "    ^";
        String lineTriangle2 = "   ^ ^";
        String lineTriangle3 = "  ^   ^";
        String lineTriangle4 = " ^     ^";
        String lineTriangle5 = "^ ^ ^ ^ ^";
        return lineTriangle1
                + System.lineSeparator()
                + lineTriangle2
                + System.lineSeparator()
                + lineTriangle3
                + System.lineSeparator()
                + lineTriangle4
                + System.lineSeparator()
                + lineTriangle5;
    }
}
