package net.riccardocossu.sandbox.rockPaperScissors.controller;

import net.riccardocossu.sandbox.rockPaperScissors.events.GameMove
import net.riccardocossu.sandbox.rockPaperScissors.events.GameMoveListener
import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcome
import net.riccardocossu.sandbox.rockPaperScissors.events.GameOutcomeListener
import net.riccardocossu.sandbox.rockPaperScissors.events.GameStart
import net.riccardocossu.sandbox.rockPaperScissors.events.GameStartListener;
import net.riccardocossu.sandbox.rockPaperScissors.model.Move
import net.riccardocossu.sandbox.rockPaperScissors.model.Outcome
import net.riccardocossu.sandbox.rockPaperScissors.rules.GameRules;

public class GameController {

	private Move p1Move
	private int turn = 0

	private List<GameStartListener> gameStartListeners = []
	private List<GameMoveListener> gameMoveListeners = []
	private List<GameOutcomeListener> gameOutcomeListeners = []
	GameRules rules = new GameRules()

	void addGameStartListener(GameStartListener listener) {
		gameStartListeners.add(listener)
	}

	void addGameMoveListener(GameMoveListener listener) {
		gameMoveListeners.add(listener)
	}

	void addgameOutcomeListener(GameOutcomeListener listener) {
		gameOutcomeListeners.add(listener)
	}

	public void newGame() {
		p1Move = null
		turn = 0
		def e = new GameStart()
		for(g in gameStartListeners) {
			g.gameStarted(e)
		}
	}

	public Outcome doMove(Move move) {
		Outcome res = null
		assert (move.player == 1 || (move.player == 2 && p1Move)) : "player 1 must play before player 2"
		def e = new GameMove(move:move)
		for(g in gameMoveListeners) {
			g.moveMade(e)
		}
		if(move.player == 1) {
			if(!p1Move) {
				turn++
			}
			p1Move = move
		} else {
			res = rules.playTurn(p1Move, move)
			p1Move = null
		}
		if(res) {
			def eo = new GameOutcome(res)
			for(g in gameOutcomeListeners) {
				g.processOutcome(eo)
			}
		}
		res
	}
}
