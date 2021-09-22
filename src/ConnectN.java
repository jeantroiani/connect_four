import exceptions.InvalidInputException;
import player.Player;
import validation.ConnectNValidation;
import helpers.WinningConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectN extends BoardGame {
    int connectNumber;
    List<String> winningConditionsList = new ArrayList<>();

    public ConnectN(Integer height, Integer width, Integer connectNumber) throws InvalidInputException {
        super(height, width);
        ConnectNValidation.validateConnectNumber(connectNumber);
        this.connectNumber = connectNumber;
        this.winningConditionsList.addAll(new ArrayList<>(Arrays.asList("vertically", "horizontally", "diagonally")));
    }

    @Override
    public String getNameOfGame() {
        return "Connect N";
    }

    @Override
    public int getConnectNumber() {
        return connectNumber;
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
