package player;

import helpers.NPCMove;

import java.util.Random;

public class NPC extends Player {
    Integer boardSize;
    Random random;
    char[][] board;

    public NPC(char id, Integer boardSize, char[][] board) {
        super(id);
        this.boardSize = boardSize;
        random = new Random();
        this.board = board;
    }

    @Override
    public Integer getPlayerInput() {
        // todo: improve the logic to check for best vertical and or diagonal
        return NPCMove.getBestColumnWithValidMove(random, board, id);
    }
}
