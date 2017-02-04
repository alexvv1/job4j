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
        String triangle = new StringBuilder().append(lineTriangle1)
                .append(System.lineSeparator())
                .append(lineTriangle2)
                .append(System.lineSeparator())
                .append(lineTriangle3)
                .append(System.lineSeparator())
                .append(lineTriangle4)
                .append(System.lineSeparator())
                .append(lineTriangle5)
                .toString();
        return triangle;
    }
}
