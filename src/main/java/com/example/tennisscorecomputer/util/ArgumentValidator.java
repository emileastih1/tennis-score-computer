package com.example.tennisscorecomputer.util;

public class ArgumentValidator {

    public static boolean isValidPlayersIdentifiers(char playerOneIdentifier, char playerTwoIdentifier) {
        if(!isValidIdentifier(playerOneIdentifier) || !isValidIdentifier(playerTwoIdentifier)){
            return false;
        }
        //This condition will verify that the two players are different
        return playerOneIdentifier != playerTwoIdentifier;
    }

    /**
     * Method to validate player identifiers
     *
     * @param identifier identifier for the player e.g: A , referring to player A
     * @return true if the identifier is valid
     */
    private static boolean isValidIdentifier(char identifier) {
        return Character.isLetter(identifier);
    }

    /**
     * Method to validate input string
     *
     * @param input               input string of the players' wins
     * @param playerOneIdentifier identifier for the player e.g: A , referring to player A
     * @param playerTwoIdentifier identifier for the player e.g: B , referring to player B
     * @return true if the input is not null nor empty and only contains the provided identifiers
     */
    public static boolean isValidInput(String input, char playerOneIdentifier, char playerTwoIdentifier) {
        return input != null && !input.isEmpty() &&
                input.chars().allMatch(c -> c == playerOneIdentifier || c == playerTwoIdentifier);
    }
}
