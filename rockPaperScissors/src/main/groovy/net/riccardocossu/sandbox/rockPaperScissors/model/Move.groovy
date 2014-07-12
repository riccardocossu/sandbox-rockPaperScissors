package net.riccardocossu.sandbox.rockPaperScissors.model;

public class Move {
	
	short player
	
	MoveValue move

	public short getPlayer() {
		return player;
	}
	public void setPlayer(short player) {
		assert (player >=1 && player <=2) : "player must be between 1 and 2"
		this.player = player;
	}
		
	
	

}
