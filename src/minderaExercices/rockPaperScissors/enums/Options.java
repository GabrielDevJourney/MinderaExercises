package minderaExercices.rockPaperScissors.enums;

public enum Options {
	ROCK(1, "rock"),
	PAPER(2, "paper"),
	SCISSORS(3, "scissors");

	private int id;
	private String choice;

	private Options(int id, String choice) {
		this.id = id;
		this.choice = choice;
	}

	public int getId() {
		return id;
	}

	public String getChoice() {
		return choice;
	}

	//based on user chopice return what was his option
	public static Options optionChoosen(int choice) {
		for (Options option : Options.values()) {
			if (option.getId() == choice) {
				return option;
			}
		}
		return null;
	}

	//possible winning moves if false then opponentOption wins
	public boolean winningMoves(Options opponentOption) {
		return (this == ROCK && opponentOption == SCISSORS) ||
				(this == PAPER && opponentOption == ROCK) ||
				(this == SCISSORS && opponentOption == PAPER);
	}
}
