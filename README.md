# Kata Tennis

Implementation of the kata from BforBank.

## Usage

To run the build with test coverage:

1. Run the following command:
    ```
    mvn clean verify
    ```

2. You will find the coverage report in: `target/site/jacoco/index.html`

You can run the Tennis class on your IDE or by console:

- **IDE:** You can run the TennisScoreComputerApplication class.
- **Console:** Run the following command:
    ```
    java -jar tennis-score-computer-1.0.0.jar
    ```

## Instructions

This Kata goal is to implement a simple tennis score computer.

The scoring system consist in one game, divided by points :

- Each player starts a game with 0 point.
- If the player wins the 1st ball, he will have 15 points. 2nd balls won: 30 points. 3rd ball won: 40 points.
- If a player has 40 points and wins the ball, he wins the game, however, there are special rules.
- If both players have 40 points the players are “deuce”.
- If the game is in deuce, the winner of the ball will have an advantage.
- If the player with advantage wins the ball, he wins the game.
- If the player without advantage wins the ball they are back at “deuce”.

You can find more details about the rules [here](http://en.wikipedia.org/wiki/Tennis#Scoring).

## Objective

The objective is to develop a Java method that will take a String as input containing the character ‘A’ or ‘B’. The character ‘A’ corresponding to “player A won the ball”, and ‘B’ corresponding to “player B won the ball”.
The Java method should print the score after each won ball (for example: “Player A : 15 / Player B : 30”) and print the winner of the game.

For example, the following input “ABABAA” should print:

- “Player A : 15 / Player B : 0”
- “Player A : 15 / Player B : 15”
- “Player A : 30 / Player B : 15”
- “Player A : 30 / Player B : 30”
- “Player A : 40 / Player B : 30”
- “Player A wins the game”
