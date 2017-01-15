package ru.avorotov.paint;

/**
 * Класс рисования фигур в псевдографике.
 *
 * @author avorotov
 * @version 1
 * @since 24.12.2016
 */
public class Paint {
    /**
     * Символ для рисования.
     */
    private String symbolPaint = "^";
    /**
     * Символ ппробела между символами рисования.
     */
    private String symbolSpace = " ";

    /**
     * Возвращает пирамиду в псевдографике.
     *
     * @param hight - высота пирамиды
     * @return Возвращает пирамиду в псевдографике.
     * @throws Exception Высота пирамиды <= 0
     */
    public String piramid(int hight) throws Exception {
        if (hight <= 0) {
            throw new Exception("can not paint a pyramid");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < hight + 1; i++) {
            for (int j = 0; j < hight - i; j++) {
                stringBuilder.append(symbolSpace);
            }
            stringBuilder.append(symbolPaint);
            for (int k = 1; k < i; k++) {
                stringBuilder.append(symbolSpace + symbolPaint);
            }
            if (i < hight) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }
}
