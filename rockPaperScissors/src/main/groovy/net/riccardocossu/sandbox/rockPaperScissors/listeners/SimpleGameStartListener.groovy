package net.riccardocossu.sandbox.rockPaperScissors.listeners;

import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcome;
import net.riccardocossu.sandbox.rockPaperScissors.events.GameStart;
import net.riccardocossu.sandbox.rockPaperScissors.events.GameStartListener;
import static net.riccardocossu.sandbox.rockPaperScissors.model.Outcome.*
import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcomeListener;

public class SimpleGameStartListener implements GameStartListener {

	@Override
	public void gameStarted(GameStart event) {
		println "Starting a new game, are you ready?"
		
	}


}
