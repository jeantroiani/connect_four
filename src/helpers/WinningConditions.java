package helpers;

public class WinningConditions {
    public static Boolean checkHorizontal(Integer numberToWin, char[][] board, char playerId) {
        boolean hasWon = false;
        int count = 0;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == playerId) {
                    count = count + 1;
                    if (count >= numberToWin) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return hasWon;
    }

    public static Boolean checkVertical(Integer numberToWin, char[][] board, char playerId) {
        boolean hasWon = false;
        int count = 0;

        for (int i = 0; i < board[0].length; i++) {
            for (char[] chars : board) {
                if (chars[i] == playerId) {
                    count = count + 1;
                    if (count >= numberToWin) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }

        }
        return hasWon;

    }

    public static Boolean checkDiagonalLeftToRight(Integer numberToWin, char[][] board, char playerId) {
        boolean hasWon = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == playerId) {
                    int count = 0;
                    for (int x = i, y = j; x < board.length && y < board[0].length; x++, y++) {
                        if (board[x][y] == playerId) {
                            count = count + 1;
                            if (count >= numberToWin) {
                                hasWon = true;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
        }
        return hasWon;
    }

    public static Boolean checkDiagonalRightToLeft(Integer numberToWin, char[][] board, char playerId) {
        boolean hasWon = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == playerId) {
                    int count = 0;
                    for (int x = i, y = j; x >= 0 && y < board[0].length; x--, y++) {
                        if (board[x][y] == playerId) {
                            count = count + 1;
                            if (count >= numberToWin) {
                                hasWon = true;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
        }
        return hasWon;
    }
}
