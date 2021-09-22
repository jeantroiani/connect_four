package validation;

import exceptions.InvalidInputException;

public class BoardGameValidation {
    static public void validateInput(Integer position, char[][] board, char player) throws InvalidInputException {

        // out of boundaries
        if (position < 0 || position >= board[0].length) {
            throw new InvalidInputException("Invalid move outside of board from player " + player + " on position " + (position + 1));
        }

        // column is full
        if (board[0][position] != '\u0000') {
            throw new InvalidInputException("Invalid move on a full row from player " + player + " on position " + (position + 1));
        }

    }
}
