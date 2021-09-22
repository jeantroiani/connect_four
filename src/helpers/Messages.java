package helpers;

import java.util.List;

public class Messages {

    public static Boolean isLastObject(List list, Object obj) {
        return list.indexOf(obj) == list.size() - 1;
    }

    public static Boolean isSecondToLastObject(List list, Object obj) {
        return list.indexOf(obj) == list.size() - 2;
    }

    public static String getUserIDAssigmentMessage(List<Character> playerList) {
        StringBuilder string = new StringBuilder();
        for (char player : playerList) {
            string.append("player ").append(playerList.indexOf(player) + 1).append(" is \"").append(player).append("\" ");
        }

        return string.toString();
    }

    public static String getNumberOfUsersAndID(List<Character> playerList) {
        StringBuilder string = new StringBuilder(playerList.size() + " players ");
        for (char player : playerList) {
            string.append(player);
            if (isSecondToLastObject(playerList, player)) {
                string.append(" and ");
            } else if (!isLastObject(playerList, player)) {
                string.append(", ");
            }

        }

        return string.toString();
    }

    public static String getWinningConditionMessage(Integer numberOfTokensConnected, List<String> conditions) {
        StringBuilder string = new StringBuilder();

        string.append("A player wins by connecting ");
        string.append(numberOfTokensConnected + " ");
        string.append("counters in a row - ");
        for (String condition : conditions) {

            string.append(condition);

            if (isSecondToLastObject(conditions, condition)) {
                string.append(" or ");
            }
            else if (!isLastObject(conditions, condition)) {
                string.append(", ");
            }

        }
        return string.toString();
    }
}
