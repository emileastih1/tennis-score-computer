package com.example.tennisscorecomputer;

import com.example.tennisscorecomputer.model.TennisGame;
import com.example.tennisscorecomputer.model.TennisPlayer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.example.tennisscorecomputer.util.ArgumentValidator.isValidInput;
import static com.example.tennisscorecomputer.util.ArgumentValidator.isValidPlayersIdentifiers;
import static com.example.tennisscorecomputer.util.Constants.*;

@SpringBootApplication
public class TennisScoreComputerApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(TennisScoreComputerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Prompt for player identifiers
        System.out.print(ENTER_THE_IDENTIFIER_FOR_PLAYER_ONE_SINGLE_CHARACTER);
        char playerOneIdentifier = scanner.next().charAt(0);
        System.out.print(ENTER_THE_IDENTIFIER_FOR_PLAYER_TWO_SINGLE_CHARACTER);
        char playerTwoIdentifier = scanner.next().charAt(0);

        // Validate player identifiers
        if (!isValidPlayersIdentifiers(playerOneIdentifier, playerTwoIdentifier)) {
            System.out.println(INVALID_PLAYER_IDENTIFIER_PLEASE_ENTER_A_SINGLE_CHARACTER);
            return;
        }

        // Prompt for input string
        System.out.print(ENTER_THE_INPUT_STRING_WITH_ONLY_THE_PROVIDED_IDENTIFIERS);
        String input = scanner.next();

        // Validate input string
        if (!isValidInput(input, playerOneIdentifier, playerTwoIdentifier)) {
            System.out.println(INVALID_INPUT_STRING_IT_SHOULD_CONTAIN_ONLY_THE_PROVIDED_IDENTIFIERS);
            return;
        }

        scanner.close();

        TennisPlayer playerOne = new TennisPlayer(playerOneIdentifier);
        TennisPlayer playerTwo = new TennisPlayer(playerTwoIdentifier);

        TennisGame tennisGame = new TennisGame(playerOne, playerTwo);
        tennisGame.startGame(input);

    }
}
