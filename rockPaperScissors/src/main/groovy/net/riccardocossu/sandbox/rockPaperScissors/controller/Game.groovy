package net.riccardocossu.sandbox.rockPaperScissors.controller;

import net.riccardocossu.sandbox.rockPaperScissors.model.Move
import net.riccardocossu.sandbox.rockPaperScissors.model.MoveValue
import net.riccardocossu.sandbox.rockPaperScissors.model.Outcome

public class Game {
	
	
	
	public Outcome playTurn(MoveValue p1Move, MoveValue p2Move) {
		assert p1Move != null
		assert p2Move != null
		if(p1Move == p2Move) {
			Outcome.DRAW
		} else {
			def winsAgainst = winsAgainst(p1Move)
			if(winsAgainst == p2Move) {
				Outcome.ONE_WINS
			} else {
				Outcome.TWO_WINS
			}
		}
	}
	
	private MoveValue winsAgainst(MoveValue v) {
		switch(v) {
			case MoveValue.ROCK: MoveValue.SCISSORS
			break
			case MoveValue.SCISSORS: MoveValue.PAPER
			break
			case MoveValue.PAPER: MoveValue.ROCK
			break
		}
	}
}
