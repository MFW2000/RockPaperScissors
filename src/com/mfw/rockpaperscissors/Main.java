package com.mfw.rockpaperscissors;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String[] RPS_CHOICES = {"rock", "paper", "scissors", "exit"};
    private static final String[] GAME_CHOICES = {"exit", ""};

    public static void main(String[] args) {
        String input = "";

        clearConsole(); // Clear first cmd line

        // Game loop
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("=== Rock Paper Scissors ===");
            System.out.println("Welcome to Rock Paper Scissors, let's begin.");
            System.out.println();

            System.out.print("Make a move! (rock/paper/scissors): ");
            input = readOptionString(RPS_CHOICES);

            try {
                RockPaperScissors.playRPS(input);
            } catch (RockPaperScissorsException e) {
                e.printStackTrace();
            }

            System.out.println();

            System.out.print("Press enter to play again or type 'exit' to quit: ");
            input = readOptionString(GAME_CHOICES);

            clearConsole();
        }
    }

    /**
     * Reads user input and checks if the input is in the given array of choices.
     * @param possibleChoices array of possible choices
     * @return the user input
     */
    private static String readOptionString(String[] possibleChoices) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        String result = "";

        while (!isValid) {
            result = scanner.nextLine();

            if (!Arrays.asList(possibleChoices).contains(result.toLowerCase())) {
                System.err.println("Invalid input!");
                System.out.print("Try again: ");
            } else {
                isValid = true;
            }
        }

        return result;
    }

    /**
     * Clears Java console
     */
    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
