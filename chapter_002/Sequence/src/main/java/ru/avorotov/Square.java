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
        return lineSquare1
                + System.lineSeparator()
                + lineSquare2
                + System.lineSeparator()
                + lineSquare3
                + System.lineSeparator()
                + lineSquare4
                + System.lineSeparator()
                + lineSquare5;
    }
}
