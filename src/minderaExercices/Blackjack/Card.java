package minderaExercices.Blackjack;

public class Card{
	//for example this propertie belongs to the access so its getter
	private static Card[] fullDeck = new Card[52];
	private static int fullDeckCounter = 0;
	private static String[] cardsFamilies = {"Clubs", "Spades", "Hearts", "Diamonds"};
	private static String[] cardsSymbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	//obejct properties can only be reached trough object getters this means
	private String family;
	private String symbol;

	public Card(String family, String symbol) {
		this.family = family;
		this.symbol = symbol;
	}

	public static Card[] getFullDeck() {
		return fullDeck;
	}

	public static int getFullDeckCounter() {
		return fullDeckCounter;
	}

	public String getFamily() {
		return family;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getCardName() {
		String name = this.getSymbol();
		String familly = this.getFamily();
		return name + " of " + familly;
	}

	public static void setFullDeckCounter(int fullDeckCounter) {
		Card.fullDeckCounter = fullDeckCounter;
	}

	public static void generateArrayOfAllCards() {
		for (int i = 0; i < cardsFamilies.length; i++) {
			for (int j = 0; j < cardsSymbols.length; j++) {

				Card card = new Card(cardsFamilies[i], cardsSymbols[j]);

				fullDeck[fullDeckCounter] = card;

				fullDeckCounter++;
			}
		}
	}

	public static int decreaseFullDeckCounter() {
		return fullDeckCounter--;
	}

	public static void resetDeck(){
		if(fullDeckCounter == 0){
			setFullDeckCounter(52);
		}
	}

}
