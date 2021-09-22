package player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {
    Integer boardSize;
    BufferedReader bufferedReader;

    public HumanPlayer(char id, Integer boardSize) {
        super(id);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.boardSize = boardSize;

    }

    @Override
    public Integer getPlayerInput() throws NumberFormatException {
        Integer move = null;
        try {
            move = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            //todo: log error.
        }
        return move;
    }

}
