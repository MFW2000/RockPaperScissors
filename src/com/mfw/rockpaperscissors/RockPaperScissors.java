package com.mfw.rockpaperscissors;

import java.util.Random;

public class RockPaperScissors {
    private int totalWins;
    private int winStreak;

    public RockPaperScissors() {
        totalWins = 0;
        winStreak = 0;
    }

    /**
     * Play a game of rock paper scissor
     * @param playerMove chosen move
     */
    public void playRPS(String playerMove) throws RockPaperScissorsException {
        playerMove = playerMove.toLowerCase();

        if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
            throw new RockPaperScissorsException("Invalid input! Only 'rock', 'paper' and 'scissor' is valid input");
        }

        Random random = new Random();
        int opponentChoice = random.nextInt(3);
        String opponentMove = getOpponentMove(opponentChoice);

        System.out.println("Your opponent chose: " + opponentMove);
        System.out.println();

        if (playerMove.equals(opponentMove)) {
            System.out.println("It's a draw!");
        } else if (isWinner(playerMove, opponentMove)) {
            System.out.println("You win!");
            totalWins++;
            winStreak++;
        } else {
            System.out.println("You lose!");

            if (totalWins > 0) {
                System.out.println("Win streak reset!");
            }

            winStreak = 0;
        }
    }

    /**
     * Get the move of the opponent
     * @param opponentChoice randomized choice of the opponent
     * @return opponent move
     */
    private static String getOpponentMove(int opponentChoice) {
        String opponentMove = "";

        switch (opponentChoice) {
            case 0 -> opponentMove = "rock";
            case 1 -> opponentMove = "paper";
            case 2 -> opponentMove = "scissors";
        }

        return opponentMove;
    }

    /**
     * Check if the player has won or not
     * @param playerMove the player move
     * @param opponentMove the opponent move
     * @return true if the player has won
     */
    private static boolean isWinner(String playerMove, String opponentMove) {
        if (playerMove.equals("rock")) {
            return opponentMove.equals("scissors");
        } else if (playerMove.equals("paper")) {
            return opponentMove.equals("rock");
        } else {
            return opponentMove.equals("paper");
        }
    }

    @Override
    public String toString() {
        return ("Total wins: " + totalWins + ". Win streak: " + winStreak);
    }
}
