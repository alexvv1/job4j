package ru.avorotov;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.avorotov.pieces.Bishop;
import ru.avorotov.pieces.Figure;

/**
 * Тест Слон.
 */
public class BishopTest {

    /**
     * Rule expectedException.
     */
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * succesPath.
     *
     * @throws Exception exc.
     */
    @Test
    public void wayTestSuccesPath() throws Exception {
        //Arrange
        final int xCoordinateStart = 2;
        final int yCoordinateStart = 1;
        Figure bishop = new Bishop(new Cell(xCoordinateStart, yCoordinateStart));
        //Act
        final int xCoordinateEnd = 5;
        final int yCoordinateEnd = 4;
        Cell[] actualWay = bishop.way(new Cell(xCoordinateEnd, yCoordinateEnd));
        //Assert
        final int xCoordinateWay1 = 3;
        final int xCoordinateWay2 = 4;
        final int yCoordinateWay1 = 2;
        final int yCoordinateWay2 = 3;
        Cell[] expectedWay = new Cell[]{new Cell(xCoordinateStart, yCoordinateStart),
                new Cell(xCoordinateWay1, yCoordinateWay1),
                new Cell(xCoordinateWay2, yCoordinateWay2),
                new Cell(xCoordinateEnd, yCoordinateEnd)};

        Assert.assertThat(actualWay, Is.is(expectedWay));
    }

    /**
     * ImpossibleMoveException. Неверный путь.
     *
     * @throws Exception exc.
     */
    @Test
    public void wayTestImpossibleMoveException() throws Exception {
        //Arrange
        final int xCoordinateBishop = 2;
        final int Bishop = 1;
        Figure bishop = new Bishop(new Cell(xCoordinateBishop, Bishop));
        //Act
        //Assert
        expectedException.expect(Is.isA(ImpossibleMoveException.class));
        final int xCoordinateWay = 5;
        final int yCoordinateWay = 7;
        bishop.way(new Cell(xCoordinateWay, yCoordinateWay));
    }
}