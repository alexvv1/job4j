package ru.avorotov;

/**
 * Квадрат.
 */
public class Square implements Shape {

    /**
     * Возвращает фигуру в псевдографике.
     *
     * @return Фигура в псевдографике.
     */
    @Override
    public String pic() {
        String lineSquare1 = "^^^^^";
        String lineSquare2 = "^   ^";
        String lineSquare3 = "^   ^";
        String lineSquare4 = "^   ^";
        String lineSquare5 = "^^^^^";
        String square = new StringBuilder().append(lineSquare1)
                .append(System.lineSeparator())
                .append(lineSquare2)
                .append(System.lineSeparator())
                .append(lineSquare3)
                .append(System.lineSeparator())
                .append(lineSquare4)
                .append(System.lineSeparator())
                .append(lineSquare5)
                .toString();
        return square;
    }
}
