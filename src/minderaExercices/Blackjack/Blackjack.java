package minderaExercices.Blackjack;

import minderaExercices.experiments.carExerciseOOP.Car;

public class Blackjack {
	//card instance to acess card class but not actually create a single card itself
	Card[] deck;

	//everytime a new blackjack game is created will it start everythig from zero
	public Blackjack() {
		Card.generateArrayOfAllCards();
		deck = Card.getFullDeck();
	}

	//gerar indice aleatorio para ir buscar carta random
	private int randomIndexFullDeck() {
		return (int) (Math.random() * Card.getFullDeckCounter());
	}

	public Card dealCard() {
		int randomIndex = randomIndexFullDeck();
		//if in 51 index is 50 and so on
		int lastIndex = Card.getFullDeckCounter() - 1;
		Card currentCard = deck[randomIndex];

		//swapp last card with the current card
		//need to grab the last card from last index based on the current getFullDeckCounter
		//place in the current deck[randomindex] the last card
		//place in current last index the current card delt

		//swap current card with last card based on the last index and the random index generated
		Card lastCard = deck[lastIndex];
		deck[randomIndex] = lastCard;
		deck[lastIndex] = currentCard;


		//after card is dealt i need to magane deck otherwise will not work since the index is random it can break
		//this way a card cant be drawn twice

		Card.decreaseFullDeckCounter();
		Card.resetDeck();
		return currentCard;
	}

	//decrease the deck size to by going to the original counter that goes fro  0 to 52 when all cards are created
	//and based on that decreasing for every card delt update the new current deck size to the decreaseFullDeckCounter

}
