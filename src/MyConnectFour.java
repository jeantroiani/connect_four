import exceptions.InvalidInputException;
import render.CLIRender;
import player.*;
import helpers.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyConnectFour {

    private final List<Player> players;
    BoardGame boardGame;
    CLIRender cliRender;
    //todo: ask user about this parameters
    Integer HEIGHT_OF_BOARD = 6;
    Integer WIDTH_OF_BOARD = 7;
    Integer CONNECT_N = 4;
    char PLAYER_ONE_ID = 'R';
    char PLAYER_TWO_ID = 'Y';
    char PLAYER_THREE_ID = 'G';

    public MyConnectFour() {
        players = new ArrayList<>();
        try {
            boardGame = new ConnectN(HEIGHT_OF_BOARD, WIDTH_OF_BOARD, CONNECT_N);
        } catch (InvalidInputException exception) {
            // log error
            // ask user for a valid number
        }
        cliRender = new CLIRender();
        playGame();
    }

    private void playGame() {
        HumanPlayer playerOne = new HumanPlayer(PLAYER_ONE_ID, WIDTH_OF_BOARD);
        NPC computerOne = new NPC(PLAYER_TWO_ID, WIDTH_OF_BOARD, boardGame.getBoard());
        NPC computerTwo = new NPC(PLAYER_THREE_ID, WIDTH_OF_BOARD, boardGame.getBoard());
        players.addAll(new ArrayList<>(Arrays.asList(playerOne, computerOne, computerTwo)));

        List<Character> playersId = players.stream().map(Player::getId).collect(Collectors.toList());
        cliRender.printMessage("Welcome to " + boardGame.getNameOfGame());
        cliRender.printMessage(Messages.getNumberOfUsersAndID(playersId));
        cliRender.printMessage(Messages.getUserIDAssigmentMessage(playersId));
        cliRender.printMessage("To play the game type in the number of the column you want to drop you counter in");
        cliRender.printMessage(Messages.getWinningConditionMessage(boardGame.getConnectNumber(), boardGame.getWinningConditions()));
        cliRender.printMessage();
        cliRender.printBoard(boardGame.getBoard());

        String winner = null;
        Boolean isBoardGameFull = boardGame.isBoardGameFull();

        while (winner == null && !isBoardGameFull) {
            for (Player player : players) {
                if (winner == null) {
                    cliRender.printMessage(player.getId() + " type where do you want to place your token on the board");

                    Integer userInput = null;

                    while (userInput == null && !isBoardGameFull) {
                        try {
                            userInput = player.getPlayerInput();
                            boardGame.placeCounter(player.getId(), userInput - 1);
                            isBoardGameFull = boardGame.isBoardGameFull();
                        } catch (InvalidInputException exception) {
                            cliRender.printMessage(exception.getMessage());
                            userInput = null;
                        } catch (NumberFormatException exception) {
                            cliRender.printMessage("Error parsing input, try a number between 0 " + WIDTH_OF_BOARD);
                            userInput = null;
                        }
                    }

                    Boolean playerWon = boardGame.hasPlayerWon(player);

                    cliRender.printBoard(boardGame.getBoard());
                    if (playerWon) {
                        winner = Character.toString(player.getId());
                    }
                }
            }
        }
        if (winner != null) {
            cliRender.printMessage(winner + " has won!!!");
        } else {
            cliRender.printMessage("No winner");
        }
    }
}
