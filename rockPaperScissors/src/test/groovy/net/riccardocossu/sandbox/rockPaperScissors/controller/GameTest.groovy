package net.riccardocossu.sandbox.rockPaperScissors.controller;

import static org.junit.Assert.*;
import static net.riccardocossu.sandbox.rockPaperScissors.model.Outcome.*
import static net.riccardocossu.sandbox.rockPaperScissors.model.MoveValue.*

import org.junit.Test;

public class GameTest {
	
	Game game = new Game()

	@Test
	public void should_rock_by_p1_beat_scissors() {
		assertEquals(ONE_WINS,game.playTurn(ROCK, SCISSORS))
	}
	
	@Test
	public void should_rock_by_p2_beat_scissors() {
		assertEquals(TWO_WINS,game.playTurn(SCISSORS,ROCK))
	}
	
	@Test
	public void should_rock_by_both_ne_a_draw() {
		assertEquals(DRAW,game.playTurn(ROCK,ROCK))
	}
	
	@Test
	public void should_scissors_by_both_ne_a_draw() {
		assertEquals(DRAW,game.playTurn(SCISSORS,SCISSORS))
	}
	
	@Test
	public void should_paper_by_both_ne_a_draw() {
		assertEquals(DRAW,game.playTurn(PAPER,PAPER))
	}
	
	@Test
	public void should_paper_by_p1_beat_rock() {
		assertEquals(ONE_WINS,game.playTurn(PAPER, ROCK))
	}
	
	@Test
	public void should_scissors_by_p1_beat_paper() {
		assertEquals(ONE_WINS,game.playTurn(SCISSORS, PAPER))
	}

}
