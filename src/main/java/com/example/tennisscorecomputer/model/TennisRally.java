package com.example.tennisscorecomputer.model;

public record TennisRally(TennisGame game, TennisPlayer winner, TennisPlayer looser, int rallyNumber) {
    public TennisRally {
        if (game == null) {
            throw new IllegalArgumentException("Game instance cannot be null");
        }
        if (winner == null) {
            throw new IllegalArgumentException("Each game rally must have a winner!");
        }
        if (looser == null) {
            throw new IllegalArgumentException("Each game rally must have a loose!");
        }
        if (winner == looser) {
            throw new IllegalArgumentException("The winner and the looser of the rally cannot be the same player!");
        }
    }
}
