package com.mfw.rockpaperscissors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsTest {
    RockPaperScissors rps;

    @BeforeEach
    void setRps() {
        rps = new RockPaperScissors();
    }

    @Test
    void testValidInputParameter() {
        assertThrowsExactly(RockPaperScissorsException.class, () -> rps.playRPS("UnvalidInput"));
    }

    @Test
    void testRPSGameLogic() throws RockPaperScissorsException {
        rps.playRPS("rock");

        if (rps.getOpponentMove().equals("paper")) {
            assertEquals(0, rps.getTotalWins());
        }
    }
}
