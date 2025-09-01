package walking.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WalkingBoardWithPlayersTest {

    @Test
    void testWalk1() {
        WalkingBoardWithPlayers Board = new WalkingBoardWithPlayers(new int[2][2], 3);
        int[] scores = Board.walk(5, 4, 2, 19, 21);

        assertEquals(5, scores[0]);
        assertEquals(13, scores[1]);
        assertEquals(0, scores[2]);

        assertEquals(13, Board.getTile(0, 0));
        assertEquals(5, Board.getTile(0, 1));
        assertEquals(13, Board.getTile(1, 1));

        assertEquals(13, Board.getTile(1, 0));
        assertEquals(13, Board.getTile(1, 1));

    }

    @Test
    void testWalk2() {

        int[][] arr = { { 1, 2, 3, 4 },
                { 4, 5, 6, 7 },
                { 8, 9, 4, 5 } };

        WalkingBoardWithPlayers Board2 = new WalkingBoardWithPlayers(arr, 2);
        int[][] arr1 = Board2.getTiles();
        int[][] expected = { { 3, 3, 3 },
                { 3, 4, 5 } };
        assertArrayEquals(expected[0], arr1[0]);

    }
}