package com.example.tennisscorecomputer.service;

import com.example.tennisscorecomputer.model.TennisRally;
import com.example.tennisscorecomputer.vo.GameStatus;
import com.example.tennisscorecomputer.vo.Point;

/**
 * This service will check all the tennis game rules
 */
public class TennisRuleService {

    public static void runRules(TennisRally rally) {
        applyAdvantageRule(rally);
        checkIfGameIsAtDeuce(rally);
        checkIfGameIsWon(rally);
    }

    /**
     * This rule will check ,in the current rally, if the player without advantage wins the ball,
     * so they are both back at deuce
     * @param rally the rally in which the check is made
     */
    private static void applyAdvantageRule(TennisRally rally) {
        //This means that the player without advantage wins the ball, so they are both back at “deuce”
        if (rally.winner().isInAdvantage() && rally.looser().isInAdvantage()) {
            rally.winner().backAtDeuce();
            rally.looser().backAtDeuce();
        }
    }

    /**
     * Check if the game at deuce by first checking if the player who win the game has reached the score of 40
     * And then if that is the case, check if his score is equal to his opponent's score
     * @param rally the rally in which the check is made
     */
    private static void checkIfGameIsAtDeuce(TennisRally rally) {
        if (rally.winner().getPoint() == Point.FORTY
                && rally.winner().getPoint() == rally.looser().getPoint()) {
            rally.game().setGameStatus(GameStatus.DEUCE);
        }
    }

    /**
     * We have two conditions to check in order to determine if the game is won,
     *    First we need to check if the winner of the rally has reached a score beyond 40 and that the looser
     *       of the current rally has a score below 40.
     *    Second condition is to check if the player who won the rally has won after being in advantage over
     *       his opponent
     * @param rally the rally in which the check is made
     */
    private static void checkIfGameIsWon(TennisRally rally) {
        //Here the game is won without entering the advantage phase
        if (rally.winner().getPoint() == Point.WON_OR_ADVANTAGE && rally.looser().getScore() < 3) {
            rally.game().setGameStatus(GameStatus.WON);
        }
        //Here the game is won after finishing the advantage phase
        if (rally.winner().getPoint() == Point.WON_AFTER_ADVANTAGE && rally.looser().getPoint() == Point.FORTY) {
            rally.game().setGameStatus(GameStatus.WON);
        }
    }
}
