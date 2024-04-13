package com.example.tennisscorecomputer.model;

import com.example.tennisscorecomputer.vo.Point;

public class TennisPlayer {
    private final char identifier;
    private int score;
    private boolean isPlayerInAdvantage;

    public TennisPlayer(char identifier) {
        this.identifier = identifier;
        this.score = Point.LOVE.getScore();
        this.isPlayerInAdvantage = false;
    }

    public void winRally() {
        this.score += 1;
        if (this.score == 4) {
            this.isPlayerInAdvantage = true;
        }
    }

    public void backAtDeuce() {
        this.score -= 1;
        this.isPlayerInAdvantage = false;
    }

    public Point getPoint() {
        return Point.getLabelFromScore(score);
    }

    public char getIdentifier() {
        return identifier;
    }

    public int getScore() {
        return score;
    }

    public boolean isInAdvantage() {
        return isPlayerInAdvantage;
    }

}
