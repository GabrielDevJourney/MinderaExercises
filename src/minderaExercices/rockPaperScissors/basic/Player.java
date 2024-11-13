package minderaExercices.rockPaperScissors.basic;

public class Player {
	private String name;
	private int playerScore;
	private String currentChoice;
	private String playerType;

	public Player(String name, int playerScore,String playerType) {
		this.name = name;
		this.playerScore = playerScore;
		this.playerType = playerType;
	}

	public String getCurrentChoice() {
		return currentChoice;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public String getName() {
		return name;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setCurrentChoice(String currentChoice) {
		this.currentChoice = currentChoice;
	}

	public int addWinning(){
		return this.playerScore ++;
	}
}
