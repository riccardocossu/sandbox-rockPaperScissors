package net.riccardocossu.sandbox.rockPaperScissors.listeners;

import net.riccardocossu.sandbox.rockPaperScissors.events.GameMove;
import net.riccardocossu.sandbox.rockPaperScissors.events.GameMoveListener;
import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcome;
import net.riccardocossu.sandbox.rockPaperScissors.events.GameStart;
import net.riccardocossu.sandbox.rockPaperScissors.events.GameStartListener;
import static net.riccardocossu.sandbox.rockPaperScissors.model.Outcome.*
import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcomeListener;

public class SimpleGameMoveListener implements GameMoveListener {

	@Override
	public void moveMade(GameMove event) {
		println "Plyer ${event.move.player} -> ${event.move.move.value.toUpperCase()}!!!"
	}

	


}
