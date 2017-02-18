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
    private final static Cell sourcePositionFigure = new Cell(1,3);
    private final static Cell distPositionFigure = new Cell(3,5);


    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * Ход фигуры. SuccessPath.
     * @throws Exception
     */
    @Test
    public void move_whenWayCleanThenSuccessPath() throws Exception {
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
     * @throws Exception
     */
    @Test()
    public void move_whenFigureNotFound() throws Exception {
        //Arrange
        Board board = new Board();
        board.addFigure(new Bishop(sourcePositionFigure));
        //Act
        //Assert
        expectedException.expect(Is.isA(FigureNotFoundException.class));
        board.move(new Cell(8,8), distPositionFigure);
    }

    /**
     * Ход фигуры. Неверный путь.
     * @throws Exception
     */
    @Test()
    public void move_impossibleMoveException() throws Exception {
        //Arrange
        Board board = new Board();
        board.addFigure(new Bishop(sourcePositionFigure));
        //Act
        //Assert
        expectedException.expect(Is.isA(ImpossibleMoveException.class));
        expectedException.expectMessage(Is.is("Неверный путь."));
        board.move(sourcePositionFigure, new Cell(1,7));
    }

    /**
     * Ход фигуры. На пути фигуры есть другие фигуры.
     * @throws Exception
     */
    @Test()
    public void move_OccupiedWayException() throws Exception {
        //Arrange
        Board board = new Board();
        board.addFigure(new Bishop(sourcePositionFigure));
        board.addFigure(new Pawn(new Cell(2,4)));
        //Act
        //Assert
        expectedException.expect(Is.isA(OccupiedWayException.class));
        board.move(sourcePositionFigure, distPositionFigure);
    }

}