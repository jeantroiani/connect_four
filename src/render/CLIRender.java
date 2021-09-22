package render;

public class CLIRender implements IRender {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage() {
        System.out.println();
    }

    private String parseString(char value) {
        boolean isEmpty = value == '\u0000';
        String val = isEmpty ? "  " : value + " ";
        return "| " + val;
    }

    private StringBuilder getRowsNumber(char[][] board) {
        StringBuilder numbers = new StringBuilder(" ");

        for (int i = 0; i < board[0].length; i++) {
            numbers.append(" ").append(i + 1).append("  ");
        }
        return numbers;
    }

    @Override
    public void printBoard(char[][] board) {

        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(parseString(aChar));
            }
            System.out.println("|");
        }
        System.out.println(getRowsNumber(board));
    }

}
