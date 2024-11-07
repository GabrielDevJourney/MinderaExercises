package minderaExercices.Blackjack;

public class Card {
	//for example this propertie belongs to the access so its getter
	private static Card[] fullDeck = new Card[52];
	private static int fullDeckCounter = 0;
	private static String[] cardsFamilies = {"Clubs", "Spades", "Hearts", "Diamonds"};
	private static String[] cardsSymbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	//obejct properties can only be reached trough object getters this means
	private int valueOfCard;
	private String family;
	private String symbol;

	public Card(int valueOfCard, String family, String symbol) {
		this.valueOfCard = valueOfCard;
		this.family = family;
		this.symbol = symbol;
	}

	public static Card[] getFullDeck() {
		return fullDeck;
	}

	public static int getFullDeckCounter() {
		return fullDeckCounter;
	}

	public static void generateArrayOfAllCards() {
		for (int i = 0; i < cardsFamilies.length; i++) {
			for (int j = 0; j < cardsSymbols.length; j++) {
				int value;
				if (cardsSymbols[j].equals("A")) {
					value = 1;
				} else if (cardsSymbols[j].equals("K") || cardsSymbols[j].equals("Q") || cardsSymbols[j].equals("J")) {
					value = 10;
				} else {
					value = Integer.parseInt(cardsSymbols[j]);
				}

				Card card = new Card(value, cardsFamilies[i], cardsSymbols[j]);

				fullDeck[fullDeckCounter] = card;

				fullDeckCounter++;
			}
		}
	}

	public static int decreaseFullDeckCounter() {
		return fullDeckCounter--;
	}

	public int getValueOfCard() {
		return valueOfCard;
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
}
