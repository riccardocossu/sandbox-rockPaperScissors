package net.riccardocossu.sandbox.rockPaperScissors.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveTest {

	@Test
	public void should_player_1_be_accepted() {
		new Move(player: 1)
	}
	
	@Test(expected=AssertionError.class)
	public void should_player_3_be_refused() {
		new Move(player: 3)
	}
	
	@Test(expected=AssertionError.class)
	public void should_player_0_be_refused() {
		new Move(player: 0)
	}

}
