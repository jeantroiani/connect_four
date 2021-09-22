import exceptions.InvalidInputException;
import player.Player;
import validation.BoardGameValidation;

import java.util.List;

public abstract class BoardGame {
    char[][] board;
    int connectNumber = 4;
    int numberOfMoves = 0;

    public BoardGame(Integer height, Integer width) {
        this.board = new char[height][width];
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void incrementNumberOfMovesByOne() {
        this.numberOfMoves = numberOfMoves + 1;
    }

    public Boolean isBoardGameFull() {
        return (board[0].length * board.length) == getNumberOfMoves();
    }

    public char[][] getBoard() {
        return board;
    }

    abstract Boolean hasPlayerWon(Player player);

    public String getNameOfGame() {
        return "Connect 4";
    }

    public int getConnectNumber() {
        return connectNumber;
    }

    abstract List<String> getWinningConditions();

    public void placeCounter(char player, int position) throws InvalidInputException {
        BoardGameValidation.validateInput(position, board, player);
        boolean placed = false;
        for (int i = board.length - 1; i >= 0; i--) {
            if (!placed) {
                if (board[i][position] == '\u0000') {
                    board[i][position] = player;
                    placed = true;
                }
            }
        }
        incrementNumberOfMovesByOne();
    }
}
