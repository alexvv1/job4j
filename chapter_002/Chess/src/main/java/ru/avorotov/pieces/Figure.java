package ru.avorotov.pieces;

import ru.avorotov.Cell;
import ru.avorotov.ImpossibleMoveException;
import ru.avorotov.PositionException;

import java.util.Objects;

/**
 * Тип фигуры.
 */
enum FigureType { Bishop, King, Knight, Pawn, Queen, Rook }


/**
 * Фигура.
 */
public abstract class Figure {

    /**
     * Ячека в которой находится фигура на шахмотной доске.
     */
    private final Cell position;

    /**
     * Конструктор.
     * @param position Ячека в которой находится фигура на шахмотной доске.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Получить наименование фигуры.
     * @return Тип фигуры.
     */
    public abstract FigureType getFigureType();

    /**
     * Получить расположение фигуры на поле.
     * @return Расположение фигуры на поле.
     */
    public Cell getPosition() {
        return position;
    }

    /**
     * Путь фигуры.
     * @param dist Позиция куда должна быть передвинута фигура.
     * @return Путь фигуры. Массив ячеек.
     * @throws ImpossibleMoveException  Перемещение фигуры невозможно.
     * @throws PositionException Неверные координаты фигуры.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException, PositionException;

    /**
     * Копировать фигуру с новыми координатами.
     * @param cell Позиция на доске.
     * @return Фигура с новыми координатами.
     */
    public abstract Figure clone(Cell cell);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Figure)) {
            return false;
        }
        Figure figure = (Figure) o;
        if (getFigureType() != ((Figure) o).getFigureType()) {
            return false;
        }
        return Objects.equals(getPosition(), figure.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
