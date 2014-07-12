package net.riccardocossu.sandbox.rockPaperScissors.listeners;

import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcome;
import static net.riccardocossu.sandbox.rockPaperScissors.model.Outcome.*
import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcomeListener;

public class SimpleConsoleOutcomeListener implements GameOutcomeListener {

	@Override
	public void processOutcome(GameOutcome event) {
		switch(event.outcome) {
			case ONE_WINS: println "player 1 wins!"
			break
			case TWO_WINS: println "player 2 wins!"
			break
			case DRAW: println "it's a draw!"
			break
		}

	}

}
