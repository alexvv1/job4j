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
    private char symbolPaint = '^';
    /**
     * Символ ппробела между символами рисования.
     */
    private char symbolSpace = ' ';

    /**
     * Возвращает пирамиду в псевдографике.
     *
     * @param hight - высота пирамиды
     * @return Возвращает пирамиду в псевдографике.
     * @exception Exception Высота пирамиды <= 0
     */
    public String piramid(int hight) throws Exception {
        if (hight <= 0) {
            throw new Exception("can not paint a pyramid");
        }
        final int width = 2 * hight - 1; //Ширина пирамиды
        StringBuilder piramid = new StringBuilder("");
        for (int iHight = 1; iHight <= hight; iHight++) { //Рисуем пирамиду построчно
            final int widthJ = 2 * iHight - 1; //Ширина пирамиды в текущей строке
            String linePiramid = getLinePiramid(widthJ, width); //Построить текущую строку пирамиды
            piramid.append(linePiramid);
            if (iHight != hight) { //Добавить после строки перевод на следующую строки, кроме последней
                piramid.append(System.lineSeparator());
            }
        }
        return piramid.toString();
    }

    /**
     * Возвращает строку пирамиды.
     *
     * @param widthJ       Ширина текущей строки
     * @param piramidWidth Ширина пирамиды
     * @return Возвращает строку пирамиды
     */
    private String getLinePiramid(int widthJ, int piramidWidth) {
        StringBuilder linePiramid = new StringBuilder();
        for (int jWidth = 1; jWidth <= widthJ; jWidth++) { //рисуем строку пирамиды посимвольно
            if (jWidth % 2 != 0) { //В нечетные символ рисования, в четные пробелы

                linePiramid.append(symbolPaint);
            } else {
                linePiramid.append(symbolSpace);
            }
        }
        //Добавить к строке недостоющие пробелы
        String linePiramidWithSpace = getPiramidLineWithSpace(linePiramid.toString(), piramidWidth);
        return linePiramidWithSpace;
    }

    /**
     * Возвращает строку с недостающими пробелами с каждой строны.
     *
     * @param linePiramid  Строка пирамиды
     * @param piramidWidth Ширина пирамиды
     * @return Возвращает строку с недостающими пробелами с каждой строны
     */
    private String getPiramidLineWithSpace(String linePiramid, int piramidWidth) {
        int countSpace = piramidWidth - linePiramid.length(); //Число пробелов в строке
        StringBuilder linePiramidWithSpace = new StringBuilder(); //Строка пирамиды с недостающими пробелами с каждой строны
        //Формируем недостующие пробелы с обеих сторон
        StringBuilder halfSpace = new StringBuilder();
        int halfCountSpace = countSpace / 2;
        for (int iSpace = 1; iSpace <= halfCountSpace; iSpace++) {
            halfSpace.append(symbolSpace);
        }
        linePiramidWithSpace.append(halfSpace).append(linePiramid).append(halfSpace);
        return linePiramidWithSpace.toString();
    }
}
