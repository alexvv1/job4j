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

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    /**
     * succesPath
     */
    @Test
    public void wayTest_SuccesPath() throws Exception {
        //Arrange
        Figure bishop = new Bishop(new Cell(2, 1));
        //Act
        Cell[] actualWay = bishop.way(new Cell(5, 4));
        //Assert
        Cell[] expectedWay = new Cell[]{new Cell(2, 1), new Cell(3, 2), new Cell(4, 3), new Cell(5, 4)};

        Assert.assertThat(actualWay, Is.is(expectedWay));
    }

    /**
     * ImpossibleMoveException. Неверный путь.
     */
    @Test
    public void wayTest_ImpossibleMoveException() throws Exception {
        //Arrange
        Figure bishop = new Bishop(new Cell(2, 1));
        //Act
        //Assert
        expectedException.expect(Is.isA(ImpossibleMoveException.class));
        Cell[] actualWay = bishop.way(new Cell(5, 7));
    }
}