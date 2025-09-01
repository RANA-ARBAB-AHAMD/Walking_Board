package walking.game;

import walking.game.util.Direction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WalkingBoardTest {
    @ParameterizedTest
    @CsvSource({
            "0,0,3", "0,1,3", "0,2,3", "1,0,3", "1,1,3", "1,2,3", "2,0,3", "2,1,3", "2,2,3"
    })
    public void testSimpleInit(int x, int y, int expected) {
        int size = 2;
        WalkingBoard newbd = new WalkingBoard(size);

        assertEquals(3, newbd.getTile(0, 0));

        assertEquals(3, newbd.getTile(1, 1));
    }

    @ParameterizedTest()
    @CsvSource({ "0, 0, 3", "0,1, 3", "0,2, 3", "1,0, 4", "1,1, 5", "1,2, 6", "2,0,7", "2,1,8", "2,2, 9" })
    void testCustomInit(int x, int y, int value) {
        int[][] tiles = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        WalkingBoard board = new WalkingBoard(tiles);

        assertEquals(value, board.getTile(x, y));

    }

    @Test
    void testMoves() {

        WalkingBoard Board2 = new WalkingBoard(3);

        assertEquals(0, Board2.moveAndSet(Direction.UP, 8));

        assertArrayEquals(new int[] { 0, 0 }, Board2.getPosition());

        assertEquals(3, Board2.getTile(0, 0));
        assertEquals(3, Board2.getTile(1, 1));

        assertEquals(3, Board2.moveAndSet(Direction.RIGHT, 5));

        assertArrayEquals(new int[] { 0, 1 }, Board2.getPosition());

        assertEquals(5, Board2.getTile(0, 1));

        assertEquals(3, Board2.moveAndSet(Direction.DOWN, 4));

        assertArrayEquals(new int[] { 1, 1 }, Board2.getPosition());

        assertEquals(4, Board2.getTile(1, 1));

        assertEquals(3, Board2.moveAndSet(Direction.LEFT, 4));
        assertArrayEquals(new int[] { 1, 0 }, Board2.getPosition());
        assertEquals(4, Board2.getTile(1, 0));

        assertEquals(3, Board2.moveAndSet(Direction.UP, 12));
        assertArrayEquals(new int[] { 0, 0 }, Board2.getPosition());
        assertEquals(12, Board2.getTile(0, 0));

        assertEquals(5, Board2.moveAndSet(Direction.RIGHT, 9));
        assertArrayEquals(new int[] {0,1 }, Board2.getPosition());
        assertEquals(9, Board2.getTile(0, 1));

    }

}