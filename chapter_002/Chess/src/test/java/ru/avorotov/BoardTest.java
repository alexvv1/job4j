package ru.avorotov;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.avorotov.pieces.Bishop;
import ru.avorotov.pieces.Figure;
import ru.avorotov.pieces.Pawn;

/**
 * Тест Шахмотная доска.
 */
public class BoardTest {
    /**
     * Начальная позиция фигуры.
     */
    private final Cell sourcePositionFigure = new Cell(1, 3);
    /**
     * Конечная позиция фигуры.
     */
    private final Cell distPositionFigure = new Cell(3, 5);

    /**
     * Rule expectedException.
     */
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * Ход фигуры. SuccessPath.
     * @throws Exception exc.
     */
    @Test
    public void moveWhenWayCleanThenSuccessPath() throws Exception {
        //Arrange
        Board board = new Board();
        board.addFigure(new Bishop(sourcePositionFigure));
        //Act
        board.move(sourcePositionFigure, distPositionFigure);
        //Assert
        Figure expectFigure = new Bishop(distPositionFigure);
        Figure actualFigure = board.getFigure(distPositionFigure);
        Assert.assertThat(actualFigure, Is.is(expectFigure));
    }

    /**
     * Ход фигуры. Фигура на заданной ячейке не найденв.
     * @throws Exception exc.
     */
    @Test()
    public void moveWhenFigureNotFound() throws Exception {
        //Arrange
        Board board = new Board();
        board.addFigure(new Bishop(sourcePositionFigure));
        //Act
        //Assert
        expectedException.expect(Is.isA(FigureNotFoundException.class));
        final int xCoordinate = 8;
        final int yCoordinate = 8;
        board.move(new Cell(xCoordinate, yCoordinate), distPositionFigure);
    }

    /**
     * Ход фигуры. Неверный путь.
     * @throws Exception exc.
     */
    @Test()
    public void moveImpossibleMoveException() throws Exception {
        //Arrange
        Board board = new Board();
        board.addFigure(new Bishop(sourcePositionFigure));
        //Act
        //Assert
        expectedException.expect(Is.isA(ImpossibleMoveException.class));
        expectedException.expectMessage(Is.is("Неверный путь."));
        final int xCoordinate = 1;
        final int yCoordinate = 7;
        board.move(sourcePositionFigure, new Cell(xCoordinate, yCoordinate));
    }

    /**
     * Ход фигуры. На пути фигуры есть другие фигуры.
     * @throws Exception exc.
     */
    @Test()
    public void moveOccupiedWayException() throws Exception {
        //Arrange
        Board board = new Board();
        board.addFigure(new Bishop(sourcePositionFigure));
        final int xCoordinate = 2;
        final int yCoordinate = 4;
        board.addFigure(new Pawn(new Cell(xCoordinate, yCoordinate)));
        //Act
        //Assert
        expectedException.expect(Is.isA(OccupiedWayException.class));
        board.move(sourcePositionFigure, distPositionFigure);
    }

}