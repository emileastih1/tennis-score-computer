package com.example.tennisscorecomputer.model;

import com.example.tennisscorecomputer.vo.GameStatus;
import com.example.tennisscorecomputer.service.PrintService;
import com.example.tennisscorecomputer.service.TennisRuleService;

import java.util.HashMap;

import static com.example.tennisscorecomputer.util.Constants.GAME_ALREADY_ENDED;
import static com.example.tennisscorecomputer.util.Constants.INPUT_STRING_CANNOT_BE_EMPTY;

public class TennisGame {
    private final TennisPlayer playerOne;
    private final TennisPlayer playerTwo;
    private GameStatus gameStatus;
    private final HashMap<Character, TennisPlayer> playerIdentifierMapping = new HashMap<>();

    public TennisGame(TennisPlayer playerOne, TennisPlayer playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerIdentifierMapping.put(playerOne.getIdentifier(), playerOne);
        this.playerIdentifierMapping.put(playerTwo.getIdentifier(), playerTwo);
        this.gameStatus = GameStatus.ONGOING;
    }

    private boolean isGameTied() {
        return playerOne.getScore() == playerTwo.getScore();
    }

    public void startGame(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_STRING_CANNOT_BE_EMPTY);
        }

        for (int rallyNumber = 0; rallyNumber < input.toCharArray().length; rallyNumber++) {
            playRally(input.charAt(rallyNumber), rallyNumber);

            //If the game has ended, and there is more rounds to process then throw an exception
            if (this.gameStatus == GameStatus.WON && rallyNumber != input.toCharArray().length - 1) {
                throw new IllegalArgumentException(String.format(GAME_ALREADY_ENDED, (rallyNumber + 1)));

            }
        }
    }

    /**
     * This method represents a single round in the game, in which we have a winner and a looser of the point
     *
     * @param playerWon identifier that represents the player who won the ball
     */
    private void playRally(char playerWon, int rallyNumber) {
        TennisPlayer playerWonRally = this.playerIdentifierMapping.get(playerWon);
        playerWonRally.winRally();

        TennisPlayer playerLostRally = (playerWonRally == this.playerOne) ? this.playerTwo : this.playerOne;

        TennisRally rally = new TennisRally(this, playerWonRally, playerLostRally, rallyNumber);
        TennisRuleService.runRules(rally);
        //Terminate the game if we have a winner
        if (this.gameStatus == GameStatus.WON) {
            PrintService.printGameWinner(rally.winner());
            return;
        }
        PrintService.printScoreAfterRally(this.playerOne, this.playerTwo);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
