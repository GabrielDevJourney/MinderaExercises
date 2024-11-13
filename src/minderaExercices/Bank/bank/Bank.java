package minderaExercices.Bank.bank;

public class Bank {
	private Account[] accounts;
	private Customer[] customers = new Customer[10];
	private static Card[] allCards = new Card[100];
	private int customersCounter = 0;
	private int accountsCounter = 0;
	private static int ibanCounter = 0;
	private static int allCardsCounter = 0;
	private static int cardId = 0;

	//private Customer[] customers;
	public Bank() {
		this.accounts = new Account[100];
	}

	public void createCustomer(String name, String nif) {
		if (findCustomer(nif) != null) {
			System.out.println("Customer already exists!");
			return;
		}
		if(isFullCapacity()){
			System.out.println("Bank has reached full capacity");
			return;
		}

		customers[customersCounter] = new Customer(name, nif);
		customersCounter++;
		System.out.println("Customer created with sucess");
	}


	private boolean isFullCapacity() {
		if (customersCounter >= customers.length) {
			System.out.println("Max clients capacity reached");
			return true;
		}
		return false;
	}


	private Customer findCustomer(String nif) {
		for (int i = 0; i < customersCounter; i++) {

			if (customers[i] != null && customers[i].getNif().equals(nif)) {
				return customers[i];
			}
		}
		return null;
	}


	public DebitAccount createDebitAccount(String nif) {
		//customer exists?
		Customer currentCustomer = findCustomer(nif);

		if (currentCustomer == null || !currentCustomer.getNif().equals(nif)) {
			System.out.println("This customer doesn't exist, please create one");
			return null;
		}

		//check if the bank has sapce for customer
		if(isFullCapacity()){
			return null;
		}

		DebitAccount newDebitAccount = new DebitAccount();

		//setting specific nif to that account for later usage when trying to do transactions
		newDebitAccount.ownerNif = nif;

		//generate iban
		newDebitAccount.iban = generateNewIban();


		//give account its id
		//first add account to bank accounts
		accounts[accountsCounter] = newDebitAccount;
		accountsCounter++;

		System.out.println("Debit account created iban is " + newDebitAccount.getIban());
		//create or generate a new iban for acount
		return newDebitAccount;
	}


	public CreditAccount createCreditAccount(String nif) {

		Customer currentCustomer = findCustomer(nif);

		if (currentCustomer == null || !currentCustomer.getNif().equals(nif)) {
			System.out.println("Invalid NIF");
			return null;
		}

		if(isFullCapacity()){
			return null;
		}

		if (hasAlreadyCreditAccount(nif)) {
			System.out.println("Customer already has credit account max of one per customer reached");
			return null;
		}

		CreditAccount newCreditAccount = new CreditAccount();


		//link account to current customer nif
		newCreditAccount.ownerNif = nif;

		//first add account to bank accounts
		accounts[accountsCounter] = newCreditAccount;
		accountsCounter++;

		//add to the account iban it generated iban
		newCreditAccount.iban = generateNewIban();

		System.out.println("Credit account created iban is " + newCreditAccount.getIban());

		return newCreditAccount;
	}

	//generate iban
	private int generateNewIban() {
		int newIban = ibanCounter;
		ibanCounter++;
		return newIban;
	}


	//generate cardId
	private int generateNewCardId() {
		int newCardId = cardId;
		cardId++;
		return newCardId;
	}


	public int askCard(int iban, String nif) {

		Customer customer = findCustomer(nif);
		int newCardId = -1;

		if (customer == null) {
			System.out.println("Customer not found");
			return -1;
		}

		//find account matching iban passed
		for (int i = 0; i < accountsCounter; i++) {
			if (accounts[i].getIban() == iban) {

				//get the current account for easier current usage
				Account currentAccount = accounts[i];

				if (!currentAccount.getOwnerNif().equals(nif)) {
					System.out.println("This account doesnt belong to the this customer");
					return -1; //error because card doesnt belong to that acc
				}

				//see if here is space in the current account to store more cards
				//if yes create otherwise dont

				newCardId = createNewCardToCustomer(currentAccount, customer);
				return newCardId;
			}
		}
		System.out.println("Account doesn't exists");
		return -1;
	}

	private int createNewCardToCustomer(Account currentAccount, Customer customer) {
		if (currentAccount.askCard()) {
			int newCardId = generateNewCardId();
			currentAccount.cardId[currentAccount.accountCardIdCounter] = newCardId;
			currentAccount.accountCardIdCounter++;

			//create card and pass it the cardId
			createCardBasedOnAccountType(currentAccount, newCardId);

			//add number to customer cards id
			customer.addCardIdToCustomer(newCardId);

			System.out.println("Your card number for iban account " + currentAccount.getIban() + " is " + newCardId);

			return newCardId;
		}
		return -1; //error since there will be not cardid < 0
	}

	private static void createCardBasedOnAccountType(Account currentAccount, int newCardId) {
		if (currentAccount instanceof CreditAccount) {
			//casting otherwise will be passing account type and not creditaccount which is the arg type
			CreditCard newCreditCard = new CreditCard((CreditAccount) currentAccount);

			//give the card its type cardNumbers
			newCreditCard.cardId = newCardId;
			allCards[allCardsCounter] = newCreditCard;
			allCardsCounter++;

		} else if (currentAccount instanceof DebitAccount) {
			DebitCard newDebitCard = new DebitCard((DebitAccount) currentAccount);

			newDebitCard.cardId = newCardId;
			allCards[allCardsCounter] = newDebitCard;
			allCardsCounter++;

		}
	}

	private Card findCard(int cardId, String nif) {

		Customer currentCustomer = findCustomer(nif);
		int[] currentCustomerCards;
		boolean hasCardId = false;

		if (currentCustomer != null) {
			currentCustomerCards = currentCustomer.getCardId();
		} else {
			System.out.println("Customer doesnt exist");
			return null;
		}

		//find card id in customer card id to see if it belongs
		for (int i = 0; i < currentCustomerCards.length; i++) {
			if (currentCustomerCards[i] == cardId) {
				hasCardId = true;
				break;
			}
		}

		if (!hasCardId) return null;
		//find the card in bank to acess the object

		//i need to find the card object to use operations
		for (int i = 0; i < allCardsCounter; i++) {
			if (allCards[i].cardId == cardId) {
				return allCards[i];
			}
		}
		return null;
	}


	//check if customer already has credit account since each one can only have one credit account
	private boolean hasAlreadyCreditAccount(String nif) {
		//go to all accounts check for those account with that nif
		//then chek if that nif has any account of instance of creditaccon

		for (int i = 0; i < accountsCounter; i++) {
			//account must return not null, same nif and check for creditaccount type with instance of
			if (accounts[i] != null && accounts[i].getOwnerNif() == nif && accounts[i] instanceof CreditAccount) {
				return true;
			}
		}
		return false;
	}

	//*METHODS FOR OPERATIONS

	public void deposit(int cardId, String nif, double amount) {
		//bank.deposit(cardid,nif,amount)
		//call find card(cardid)
		//findcustomer(nif)
		//call card.deposit(amount)

		Card currentCard = findCard(cardId, nif);

		if (currentCard == null) {
			System.out.println("This card doesnt belong to thi nif");
		} else {
			currentCard.deposit(amount);
		}
	}


	public void withdraw(int cardId, String nif, double amount) {
		Card currentCard = findCard(cardId, nif);
		if (currentCard == null) {
			System.out.println("This card doesnt belong to this nif");
		} else {
			currentCard.withdraw(amount);
		}
	}

	public void pay(int cardId, String nif, double amount) {
		Card currentCard = findCard(cardId, nif);
		if (currentCard == null) {
			System.out.println("This card doesnt belong to this nif");
		} else {
			currentCard.payment(amount);
		}
	}





}
