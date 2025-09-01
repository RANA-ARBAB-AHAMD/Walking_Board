package walking.game;

import walking.game.util.Direction;

public class WalkingBoard {

    private int[][] tiles;
    private int x;
    private int y;

    public static final int BASE_TILE_SCORE = 3;

    public WalkingBoard(int size) {
        this.tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }

    public WalkingBoard(int[][] tiles) {
        int size = tiles.length;
        this.tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tiles[i][j] = tiles[i][j] < BASE_TILE_SCORE ? BASE_TILE_SCORE : tiles[i][j];
            }
        }
    }

    public int[][] getTiles() {
        int size = tiles.length;
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(tiles[i], 0, copy[i], 0, size);
        }
        return copy;
    }

    public int getTile(int x, int y) {
        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Invalid position");
        }
        return tiles[x][y];
    }

    public int[] getPosition() {
        return new int[] { this.x, this.y };
    }

    public boolean isValidPosition(int x, int y) {
        int size = tiles.length;
        return x >= 0 && x < size && y >= 0 && y < tiles[x].length;
    }

    public static int getXStep(Direction direction) {
        return direction == Direction.UP ? -1 : direction == Direction.DOWN ? 1 : 0;
    }

    public static int getYStep(Direction direction) {
        return direction == Direction.LEFT ? -1 : direction == Direction.RIGHT ? 1 : 0;
    }

    public int moveAndSet(Direction TODOname, int value) {

        int newX = getXStep(TODOname) + this.x;
        int newY = getYStep(TODOname) + this.y;

        if (!isValidPosition(newX, newY)) {

            return 0;
        }

        int oldValue = getTile(newX, newY);

        tiles[newX][newY] = value;
        this.x = newX;
        this.y = newY;
        return oldValue;

    }

}
