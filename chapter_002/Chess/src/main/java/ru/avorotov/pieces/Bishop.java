package ru.avorotov.pieces;

import ru.avorotov.Cell;
import ru.avorotov.ImpossibleMoveException;
import ru.avorotov.PositionException;

/**
 * Слон.
 */
public class Bishop extends Figure {
    /**
     * Конструктор.
     *
     * @param position Ячека в которой находится фигура на шахмотной доске.
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * Получить наименование фигуры.
     */
    @Override
    public FigureType getFigureType() {
        return FigureType.Bishop;
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        //Координаты неотрицательны
        if (dist.getxCoordinate() < 0 || dist.getyCoordinate() < 0) {
            throw new ImpossibleMoveException("Координаты должны быть неотрицательны.", new PositionException());
        }

        int sizeX = Math.abs(dist.getxCoordinate() - getPosition().getxCoordinate());
        int sizeY = Math.abs(dist.getyCoordinate() - getPosition().getyCoordinate());
        //Координаты по x и y должны быть равны.
        // т.к. слон ходит только по диагонали.
        if (sizeX != sizeY) {
            throw new ImpossibleMoveException("Неверный путь.");
        }
        //Расстояние которое проходит фигура
        int size = sizeX + 1;
        //Путь фигуры
        Cell[] cellsWay = new Cell[size];
        int posX = getPosition().getxCoordinate();
        int posY = getPosition().getyCoordinate();
        for (int i = 0; i < size; i++) {
            cellsWay[i] = new Cell(posX, posY);
            posX++;
            posY++;
        }

        return cellsWay;
    }

    @Override
    public Figure clone(Cell cell) {
        Figure newFigure = new Bishop(cell);
        return newFigure;
    }
}
