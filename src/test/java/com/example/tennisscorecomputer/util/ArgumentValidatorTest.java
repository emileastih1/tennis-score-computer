package com.example.tennisscorecomputer.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArgumentValidatorTest {

    @Test
    @DisplayName("Given a valid identifier, when isValidIdentifier is called, then it should return true")
    public void testIsValidIdentifier_Valid() {
        assertTrue(ArgumentValidator.isValidPlayersIdentifiers('A', 'B'));
        assertTrue(ArgumentValidator.isValidPlayersIdentifiers('B', 'X'));
        assertTrue(ArgumentValidator.isValidPlayersIdentifiers('Z', 'A'));
    }

    @Test
    @DisplayName("Given an invalid identifier, when isValidIdentifier is called, then it should return false")
    public void testIsValidIdentifier_Invalid() {
        assertFalse(ArgumentValidator.isValidPlayersIdentifiers('1', 'A'));
        assertFalse(ArgumentValidator.isValidPlayersIdentifiers('A','*'));
        assertFalse(ArgumentValidator.isValidPlayersIdentifiers('A', ' '));
        assertFalse(ArgumentValidator.isValidPlayersIdentifiers('A', '\n'));
    }

    @Test
    @DisplayName("Given a valid input string that only contains valid identifiers, then it should return true")
    public void testIsValidInput_Valid() {
        assertTrue(ArgumentValidator.isValidInput("AAAAA", 'A', 'B'));
        assertTrue(ArgumentValidator.isValidInput("BBB", 'A', 'B'));
        assertTrue(ArgumentValidator.isValidInput("ABABAB", 'A', 'B'));
        assertTrue(ArgumentValidator.isValidInput("BABAB", 'A', 'B'));
    }

    @Test
    @DisplayName("Given an invalid input string that only contains invalid identifiers, then it should return false")
    public void testIsValidInput_Invalid() {
        assertFalse(ArgumentValidator.isValidInput("AAAAA", 'X', 'Y'));
        assertFalse(ArgumentValidator.isValidInput("BBB", 'X', 'Y'));
        assertFalse(ArgumentValidator.isValidInput("ABABAB", 'X', 'Y'));
        assertFalse(ArgumentValidator.isValidInput("BABAB", 'X', 'Y'));
        assertFalse(ArgumentValidator.isValidInput("AAAAAX", 'A', 'B'));
        assertFalse(ArgumentValidator.isValidInput("XBBB", 'A', 'B'));
        assertFalse(ArgumentValidator.isValidInput("", 'A', 'B'));
        assertFalse(ArgumentValidator.isValidInput(" ", 'A', 'B'));
        assertFalse(ArgumentValidator.isValidInput(null, 'A', 'B'));
    }
}