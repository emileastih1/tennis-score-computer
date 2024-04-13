package com.example.tennisscorecomputer.service;

import com.example.tennisscorecomputer.vo.Point;
import com.example.tennisscorecomputer.model.TennisPlayer;

public class PrintService {
    public static void printScoreAfterRally(TennisPlayer playerOne, TennisPlayer playerTwo) {
        System.out.println("Player " + playerOne.getIdentifier() + " : " + Point.getDisplayLabelFromScore(playerOne.getScore())
                + " / Player " + playerTwo.getIdentifier() + " : " + Point.getDisplayLabelFromScore(playerTwo.getScore()));
    }

    public static void printGameWinner(TennisPlayer winner) {
        System.out.println("Player " + winner.getIdentifier() + " wins the game");
    }
}
