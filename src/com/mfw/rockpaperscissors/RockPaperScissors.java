package com.mfw.rockpaperscissors;

import java.util.Random;

public class RockPaperScissors {
    public void start(String playerMove) {
        Random random = new Random();
        int opponentChoice = random.nextInt(3);
        String opponentMove = getOpponentMove(opponentChoice);
        playerMove = playerMove.toLowerCase();

        System.out.println("Your opponent chose: " + opponentMove);
        boolean isWinner = checkForWin(playerMove, opponentMove);

        // if (playerMove.equals())
    }

    private static String getOpponentMove(int opponentChoice) {
        String opponentMove = "";

        switch (opponentChoice) {
            case 0 -> opponentMove = "rock";
            case 1 -> opponentMove = "paper";
            case 2 -> opponentMove = "scissors";
        }

        return opponentMove;
    }

    private static boolean checkForWin(String playerMove, String opponentMove) {
        if (playerMove.equals("rock")) {
            return opponentMove.equals("scissors");
        } else if (playerMove.equals("paper")) {
            return opponentMove.equals("rock");
        } else {
            return opponentMove.equals("paper");
        }
    }
}
