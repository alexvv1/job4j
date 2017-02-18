package ru.avorotov.pieces;

import ru.avorotov.Cell;
import ru.avorotov.ImpossibleMoveException;

/**
 * Фигура "Конь".
 */
public class Knight extends Figure {
    /**
     * Конструктор.
     *
     * @param position Ячека в которой находится фигура на шахмотной доске.
     */
    public Knight(Cell position) {
        super(position);
    }

    /**
     * Получить наименование фигуры.
     */
    @Override
    public FigureType getFigureType() {
        return FigureType.Knight;
    }

    /**
     * Получить расположение фигуры на поле.
     *
     * @return Расположение фигуры на поле.
     */
    @Override
    public Cell getPosition() {
        return super.getPosition();
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Figure clone(Cell cell) {
        throw new UnsupportedOperationException();
    }
}
