package walking.game;

import walking.game.player.MadlyRotatingBuccaneer;
import walking.game.player.Player;;

public class WalkingBoardWithPlayers extends WalkingBoard {

    private Player[] players;
    private int round;
    private int playerCount;
    public static final int SCORE_EACH_STEP = 13;
    private static int[][] board;

    public WalkingBoardWithPlayers(int[][] board, int playerCount) {
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount) {
        super(size);
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount) {
        if (playerCount < 2) {
            throw new IllegalArgumentException();
        }
        players = new Player[playerCount];
        players[0] = new MadlyRotatingBuccaneer();
        for (int i = 1; i < playerCount; i++) {
            players[i] = new Player();
        }
    }

    public int[] walk(int... stepCounts) {
        int[] playerScores = new int[players.length];
        for (int steps : stepCounts) {
            for (int i = 0; i < players.length; i++) {
                Player currentParticipant = players[i];
                currentParticipant.turn();
                int score = 0;

                for (int j = 0; j < steps; j++) {
                    score += moveAndSet(currentParticipant.getDirection(), Math.min(SCORE_EACH_STEP, steps));

                }
                currentParticipant.addToScore(score); // adding score in player
                playerScores[i] += score;
            }
        }
        return playerScores;
    }

}