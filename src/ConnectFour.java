import player.Player;
import helpers.WinningConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectFour extends BoardGame {
    List<String> winningConditionsList = new ArrayList<>();

    public ConnectFour(Integer height, Integer width) {
        super(height, width);
        this.winningConditionsList.addAll(new ArrayList<>(Arrays.asList("vertically", "horizontally", "diagonally")));

    }

    public List<String> getWinningConditions() {
        return this.winningConditionsList;
    }

    public Boolean hasPlayerWon(Player player) {
        char playerId = player.getId();

        if (WinningConditions.checkHorizontal(connectNumber, board, playerId)) {
            return true;
        }

        if (WinningConditions.checkVertical(connectNumber, board, playerId)) {
            return true;
        }

        if (WinningConditions.checkDiagonalLeftToRight(connectNumber, board, playerId)) {
            return true;
        }

        return WinningConditions.checkDiagonalRightToLeft(connectNumber, board, playerId);
    }

}
