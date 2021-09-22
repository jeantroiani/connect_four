package validation;

import exceptions.InvalidInputException;

public class ConnectNValidation {
    static public void validateConnectNumber (Integer connectNumber) throws InvalidInputException {
        if (2 > connectNumber && connectNumber > 7) {
            throw new InvalidInputException("N should be bigger than 2 and smaller than 7");
        }
    }
}
