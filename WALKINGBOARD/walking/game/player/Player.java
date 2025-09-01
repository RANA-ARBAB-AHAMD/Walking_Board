package walking.game.player;

import walking.game.util.Direction;

public class Player {

    private int score;

    public int getScore() {
        return score;
    }

    protected Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public Player() {
        this.score = 0;

    }

    public void addToScore(int score) {
        this.score = this.score + score;
    }

    public void turn() {

        if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        } else if (direction == Direction.LEFT) {
            direction = Direction.UP;
        } else if (direction == Direction.RIGHT) {

            direction = Direction.DOWN;
        }
    }

}