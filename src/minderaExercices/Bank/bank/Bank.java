package minderaExercices.Bank.bank;

public class Bank {
	private Account[] accounts;
	private Customer[] customers = new Customer[10];
	private int customersCounter = 0;
	private int accountsCounter = 0;
	private static int ibanCounter = 0;
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


	public void askCard(int iban, String nif) {

		Customer customer = findCustomer(nif);

		if (customer == null) {
			System.out.println("Customer not found");
			return;//error since it doesnt exist
		}

		//find account matching iban passed
		for (int i = 0; i < accountsCounter; i++) {
			if (accounts[i].getIban() == iban) {

				//get the current account for easier current usage
				Account currentAccount = accounts[i];

				if (!currentAccount.getOwnerNif().equals(nif)) {
					System.out.println("This account doesnt belong to the this customer");
					return; //error because card doesnt belong to that acc
				}

				//see if here is space in the current account to store more cards
				//if yes create otherwise dont
				if (currentAccount.askCard()) {
					int newCardId = generateNewCardId();
					currentAccount.cardId[currentAccount.accountCardIdCounter] = newCardId;
					currentAccount.accountCardIdCounter++;

					//add number to customer cards id
					customer.addCardIdToCustomer(newCardId);

					System.out.println("Your card number for iban account " + currentAccount.getIban() + " is " + newCardId);

					return;
				}

				return;// meaning something went wrong
			}
		}
		System.out.println("Account doesn't exists");
	}


	//?check if current customer based on nif has already account since it can only have one of each max

	//TODO mehtod pay this i will have has args nif, cardNumber, amount
	//TODO cardNumber will be associated with an accountNumber since when i create an account i can askForCard to itself
	//this will link both

}
