package com.example.tennisscorecomputer.vo;

import java.util.Arrays;

public enum Point {
    LOVE(0),
    FIFTEEN(1),
    THIRTY(2),
    FORTY(3),
    WON_OR_ADVANTAGE(4),
    WON_AFTER_ADVANTAGE(5);

    private final int score;

    private Point(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    public static Point getLabelFromScore(int score){
        return Arrays.stream(Point.values())
                .filter(point -> point.getScore() == score)
                .findFirst()
                .orElse(null);
    }

    public static String getDisplayLabelFromScore(int score){
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            case 4 -> "A";
            default -> "";
        };

    }
}
