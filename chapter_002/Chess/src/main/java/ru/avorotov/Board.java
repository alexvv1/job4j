package ru.avorotov;

import ru.avorotov.pieces.Figure;

/**
 * Шахматная доска.
 */
public class Board {
    /**
     * Индекс фигуры на доске.
     */
    private int figureIndex = 0;

    /**
     * Размер доски.
     */
    private final int sizeBoard = 32;

    /**
     * Список фигур на поле.
     */
    private Figure[] figures = new Figure[sizeBoard];

    /**
     * Добавить фигуру на доску.
     * @param figure Фигура.
     */
    public void addFigure(Figure figure) {
        figures[figureIndex++] = figure;
    }

    /**
     * Ход фигуры.
     * @param source Исходное положение фигуры.
     * @param dist Конечное подожение фигуры.
     * @throws ImpossibleMoveException  Неверный путь.
     * @throws OccupiedWayException На пути фигуры есть другие фигуры.
     * @throws FigureNotFoundException Фигура не найдена.
     */
    public void move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int iFigure = findIndexFigure(source);
        if (iFigure == -1) {
            throw new FigureNotFoundException();
        }

        Figure figure = figures[iFigure];
        Cell[] wayFigure = figure.way(dist);

        for (Cell cell : wayFigure) {
            //Исключем из проверки исходную позицию фигуры
            if (cell.equals(source)) {
                continue;
            }
            if (findIndexFigure(cell) != -1) {
                throw new OccupiedWayException();
            }
        }

        figures[iFigure] = figures[iFigure].clone(dist);
    }

    /**
     * Получить фигуру по её расположению.
     *
     * @param position Позиция.
     * @return Фигура.
     * @throws FigureNotFoundException Фигура не найдена.
     */
    public Figure getFigure(Cell position) throws FigureNotFoundException {
        int iFigure = findIndexFigure(position);
        if (iFigure == -1) {
            throw new FigureNotFoundException();
        }

        Figure figure = figures[iFigure];
        return figure;
    }

    /**
     * Получить индекс фигуры на доске.
     * @param cell Позиция фигуры.
     * @return Индекс фигуры на доске.
     */
    private int findIndexFigure(Cell cell) {
        int iFigure = -1;
        //Поиск фигуры которая ноходится в ячейке source
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && cell.equals(figures[i].getPosition())) {
                iFigure = i;
                break;
            }
        }

        return iFigure;
    }
}
