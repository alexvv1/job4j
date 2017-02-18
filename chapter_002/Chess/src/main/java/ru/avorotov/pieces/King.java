package ru.avorotov.pieces;

import ru.avorotov.Cell;
import ru.avorotov.ImpossibleMoveException;
import ru.avorotov.PositionException;

/**
 * Фигура "Король".
 */
public class King extends Figure {
    /**
     * Конструктор.
     *
     * @param position Ячека в которой находится фигура на шахмотной доске.
     */
    public King(Cell position) {
        super(position);
    }

    /**
     * Получить наименование фигуры.
     */
    @Override
    public FigureType getFigureType() {
        return FigureType.King;
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

    /**
     * @param dist
     * @return
     * @throws ImpossibleMoveException
     * @throws PositionException
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException, PositionException {
        return new Cell[0];
    }

    @Override
    public Figure clone(Cell cell) {
        return null;
    }
}
