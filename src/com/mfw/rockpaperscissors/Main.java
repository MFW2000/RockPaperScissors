package com.mfw.rockpaperscissors;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String[] gameChoices = {"r", "p", "s"};
    private static final String[] menuChoices = {"exit", ""};

    public static void main(String[] args) {
        Random random = new Random();
        String[] results = {"You win!", "You lose!", "It's a draw!"};
        String input = "";

        System.out.println("Welcome to Rock Paper Scissors.");

        while (!input.equalsIgnoreCase("exit")) {
            System.out.print("Rock, Paper, Scissors? - r, p, s: ");
            readString(gameChoices);

            int outcome = random.nextInt(results.length);
            System.out.println(results[outcome]);
            System.out.println();

            System.out.print("Leave empty to play again or type 'exit' to quit: ");
            input = readString(menuChoices);
        }
    }

    private static String readString(String[] possibleChoices) {
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
}
