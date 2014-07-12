package net.riccardocossu.sandbox.rockPaperScissors.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*

import javax.sound.midi.ControllerEventListener;

import net.riccardocossu.sandbox.rockPaperScissors.events.GameEvent;
import net.riccardocossu.sandbox.rockPaperScissors.events.GameMoveListener;
import net.riccardocossu.sandbox.rockPaperScissors.model.Move;
import net.riccardocossu.sandbox.rockPaperScissors.model.MoveValue;
import net.riccardocossu.sandbox.rockPaperScissors.model.Outcome

import org.junit.Before;
import org.junit.Test;

public class GameControllerTest {
	GameController controller
	
	@Before
	public void setup() {
		controller = new GameController()
		controller.newGame()
	}

	@Test
	public void new_game_should_reset_turn_and_p1move() {
		controller.turn = 1
		controller.p1Move = mock(Move.class)
		controller.newGame()
		assertEquals(0,controller.turn)
		assertNull(controller.p1Move)
	}
	
	@Test
	public void placing_a_move_should_increase_turn() {
		Outcome o = controller.doMove(new Move(move: MoveValue.ROCK,player: 1))
		assertEquals(1, controller.turn)
		assertNotNull(controller.p1Move)
		assertNull(o)
	}
	
	@Test
	public void placing_two_moves_should_give_outcome() {
		controller.doMove(new Move(move: MoveValue.ROCK,player: 1))
		Outcome o = controller.doMove(new Move(move: MoveValue.ROCK,player: 2))
		assertNotNull(o)
	}
	
	@Test
	public void placing_two_moves_should_alert_listener_twice() {
		def gl = mock(GameMoveListener.class)
		controller.addGameMoveListener(gl)
		controller.doMove(new Move(move: MoveValue.ROCK,player: 1))
		Outcome o = controller.doMove(new Move(move: MoveValue.ROCK,player: 2))
		assertNotNull(o)
		verify(gl,times(2)).moveMade(any(GameEvent.class))
	}

}
