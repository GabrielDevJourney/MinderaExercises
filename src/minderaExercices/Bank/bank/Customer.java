package minderaExercices.Bank.bank;

import minderaExercices.experiments.carExerciseOOP.Car;

public class Customer {
	private String name;
	private String nif;
	private int cardsIdsCounter;

	private int[] cardId;

	public Customer(String name, String nif) {
		this.name = name;
		this.nif = nif;
		this.cardsIdsCounter = 0;
		this.cardId = new int[10];
	}

	//*GETTERS
	public int getCardsIdsCounter() {
		return cardsIdsCounter;
	}

	public int[] getCardId() {
		return cardId;
	}

	public String getNif() {
		return nif;
	}

	public void addCardIdToCustomer(int newCardId){
		if(cardsIdsCounter >= cardId.length){
			System.out.println("You reached max amount of card for this account");

		}else{
			cardId[cardsIdsCounter] = newCardId;
			cardsIdsCounter++;
		}
	}

	//*SETTERS




}
