package ru.avorotov;

import java.util.Objects;

/**
 * Клетка на шазмотной доске.
 */
public class Cell {

    /**
     * Координата x ячейки на шахмотной доске.
     */
    private final int xCoordinate;
    /**
     * Координата y ячейки на шахмотной доске.
     */
    private final int yCoordinate;

    /**
     * Конструктор.
     *
     * @param xCoordinate Координата x ячейки на шахмотной доске.
     * @param yCoordinate Координата y ячейки на шахмотной доске.
     * @throws PositionException Неверные координаты фигуры.
     */
    public Cell(int xCoordinate, int yCoordinate) throws PositionException {
        if (xCoordinate < 0 || yCoordinate < 0) {
            throw new PositionException();
        }
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Получить координату X.
     * @return Получить координату X.
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
         * Получить координату Y.
         * @return Получить координату Y.
         */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("x =  %d, y = %d", xCoordinate, yCoordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) o;
        return getxCoordinate() == cell.getxCoordinate()
                && getyCoordinate() == cell.getyCoordinate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getxCoordinate(), getyCoordinate());
    }
}
