package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NPCMove {

    static public List<Integer> getValidColumns(char[][] board) {
        List<Integer> rowsAvailable = new ArrayList<>();

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == '\u0000') {
                rowsAvailable.add(i + 1);
            }
        }

        return rowsAvailable;
    }

    static public Integer getRandomColumnWithValidMove(Random random, char[][] board) {
        List<Integer> rowsAvailable = getValidColumns(board);

        int move = random
                .nextInt(rowsAvailable.size());

        return rowsAvailable
                .get(move);
    }

    static public List<Integer> getColumnWithPlayerIdValueOnTop(char[][] board, char playerId) {
        List<Integer> rowsAvailable = new ArrayList<>();

        // Look for column with value to stack
        for (int i = 0; i < board[0].length; i++) {
            int counter = 0;
            for (int j = board.length - 1; j > 0; j--) {
                if (board[j][i] == playerId) {
                    counter++;
                } else if (board[j][i] == '\u0000' && counter > 0) {
                } else {
                    counter = 0;
                }
            }
            if (counter > 0) {
                rowsAvailable.add(i + 1);
            }
        }
        return rowsAvailable;
    }

    static public Integer getBestColumnWithValidMove(Random random, char[][] board, char playerId) {
        List<Integer> rowsAvailable = new ArrayList<>();

        // Look for column with value to stack
        rowsAvailable.addAll(getColumnWithPlayerIdValueOnTop(board, playerId));

        if (rowsAvailable.size() < 1) {
            return getRandomColumnWithValidMove(random, board);
        }

        List<Integer> validColumns = getValidColumns(board);
        List<Integer> filteredValidColumns = rowsAvailable
                .stream()
                .filter(integer -> validColumns.contains(integer))
                .collect(Collectors.toList());

        if (filteredValidColumns.size() < 1) {
            return getRandomColumnWithValidMove(random, board);
        }

        int move = random
                .nextInt(filteredValidColumns.size());

        return filteredValidColumns
                .get(move);
    }
}
