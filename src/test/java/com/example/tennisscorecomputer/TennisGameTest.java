package com.example.tennisscorecomputer;

import com.example.tennisscorecomputer.model.TennisGame;
import com.example.tennisscorecomputer.model.TennisPlayer;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.example.tennisscorecomputer.util.Constants.GAME_ALREADY_ENDED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TennisGameTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Nested
    @DisplayName("Given valid parameters")
    class validParameters{
        @Test
        @DisplayName("When the game ends, Then print the expected result")
        void testStartGame_With_Valid_Parameters() {
            //Given
            String input = "ABABAA";
            TennisPlayer playerOne = new TennisPlayer('A');
            TennisPlayer playerTwo = new TennisPlayer('B');

            TennisGame tennisGame = new TennisGame(playerOne, playerTwo);

            //When
            tennisGame.startGame(input);

            //Then
            String expectedOutput =
                    "Player A : 15 / Player B : 0" + System.lineSeparator() +
                            "Player A : 15 / Player B : 15" + System.lineSeparator() +
                            "Player A : 30 / Player B : 15" + System.lineSeparator() +
                            "Player A : 30 / Player B : 30" + System.lineSeparator() +
                            "Player A : 40 / Player B : 30" + System.lineSeparator() +
                            "Player A wins the game" + System.lineSeparator();

            assertEquals(expectedOutput, outputStreamCaptor.toString());
        }

        @Test
        @DisplayName("When the input contains more rallies then what is needed to win the game, " +
                "Then throw and IllegalArgumentException")
        void testStartGame_With_Exceeded_Number_Of_Rounds() {
            // Given
            String input = "ABABAABAAB";
            TennisPlayer playerOne = new TennisPlayer('A');
            TennisPlayer playerTwo = new TennisPlayer('B');

            TennisGame tennisGame = new TennisGame(playerOne, playerTwo);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> tennisGame.startGame(input));
            assertEquals(String.format(GAME_ALREADY_ENDED, 6), exception.getMessage());

        }

        @Test
        @DisplayName("And that player A should win, When we face a deuce situation, then we should handle it correctly and provide valid result")
        void testStartGame_Deuce_Player_A_Wins() {
            //Given
            String input = "AAABBBABAA";
            TennisPlayer playerOne = new TennisPlayer('A');
            TennisPlayer playerTwo = new TennisPlayer('B');

            TennisGame tennisGame = new TennisGame(playerOne, playerTwo);

            //When
            tennisGame.startGame(input);

            //Then
            String expectedOutput =
                    "Player A : 15 / Player B : 0" + System.lineSeparator() +
                            "Player A : 30 / Player B : 0" + System.lineSeparator() +
                            "Player A : 40 / Player B : 0" + System.lineSeparator() +
                            "Player A : 40 / Player B : 15" + System.lineSeparator() +
                            "Player A : 40 / Player B : 30" + System.lineSeparator() +
                            "Player A : 40 / Player B : 40" + System.lineSeparator() +
                            "Player A : A / Player B : 40" + System.lineSeparator() +
                            "Player A : 40 / Player B : 40" + System.lineSeparator() +
                            "Player A : A / Player B : 40" + System.lineSeparator() +
                            "Player A wins the game" + System.lineSeparator();

            assertEquals(expectedOutput, outputStreamCaptor.toString());
        }

        @Test
        @DisplayName("And that player B should win,When we face a deuce situation, then we should handle it correctly and provide valid result")
        void testStartGame_Deuce_Player_B_Wins() {
            //Given
            String input = "AAABBBABBB";
            TennisPlayer playerOne = new TennisPlayer('A');
            TennisPlayer playerTwo = new TennisPlayer('B');

            TennisGame tennisGame = new TennisGame(playerOne, playerTwo);

            //When
            tennisGame.startGame(input);

            //Then
            String expectedOutput =
                    "Player A : 15 / Player B : 0" + System.lineSeparator() +
                            "Player A : 30 / Player B : 0" + System.lineSeparator() +
                            "Player A : 40 / Player B : 0" + System.lineSeparator() +
                            "Player A : 40 / Player B : 15" + System.lineSeparator() +
                            "Player A : 40 / Player B : 30" + System.lineSeparator() +
                            "Player A : 40 / Player B : 40" + System.lineSeparator() +
                            "Player A : A / Player B : 40" + System.lineSeparator() +
                            "Player A : 40 / Player B : 40" + System.lineSeparator() +
                            "Player A : 40 / Player B : A" + System.lineSeparator() +
                            "Player B wins the game" + System.lineSeparator();

            assertEquals(expectedOutput, outputStreamCaptor.toString());
        }
    }



}
