package net.riccardocossu.sandbox.rockPaperScissors.model;

public enum MoveValue {

	ROCK("rock"),PAPER("paper"),SCISSORS("scissors")
	
	private final String value


	private MoveValue(String value) {
		this.value = value
	}	

	public String getValue() {
		return value
	}
	
}
