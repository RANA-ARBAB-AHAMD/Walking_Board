package walking.game.player;

public class MadlyRotatingBuccaneer extends Player {
    private int turnCount;

    public MadlyRotatingBuccaneer() {
        super();
        turnCount = 0;
    }

    public void turn() {
        for (int i = 1; i <= turnCount; i++) {
            super.turn();
        }
        turnCount++;
    }
}
