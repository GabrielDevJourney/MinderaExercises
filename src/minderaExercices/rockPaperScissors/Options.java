package minderaExercices.rockPaperScissors;

public enum Options {
	ROCK(1, "rock"),
	PAPER(2, "paper"),
	SCISSORS(3, "scissors");

	private int id;
	private String name;

	Options(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
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
