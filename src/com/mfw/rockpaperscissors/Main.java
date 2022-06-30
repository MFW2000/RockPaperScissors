package com.mfw.rockpaperscissors;

import com.mfw.javalibrary.*;

public class Main {
    private static final String[] RPS_CHOICES = {"rock", "paper", "scissors", "exit"};
    private static final String[] GAME_CHOICES = {"exit", ""};

    public static void main(String[] args) {
        RockPaperScissors rps = new RockPaperScissors();
        String input = "";

        Console.clearConsole(); // Clear first cmd line

        // Game loop
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("=== Rock Paper Scissors ===");
            System.out.println("Welcome to Rock Paper Scissors, let's begin.");
            System.out.println();

            System.out.print("Make a move! (rock/paper/scissors): ");
            input = IO.readString(RPS_CHOICES);

            try {
                rps.playRPS(input);
            } catch (RockPaperScissorsException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println(rps);
            System.out.print("Press enter to play again or type 'exit' to quit: ");
            input = IO.readString(GAME_CHOICES);

            Console.clearConsole();
        }
    }
}
