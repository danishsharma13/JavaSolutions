// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: April 12, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 10

// Java Libraries

public class StrangeBank {

	private double balance = 0;
	private String currency = "NA";
	private int deposit = 0;
	private int withdraw = 0;
	private boolean writeable = true;

	// Getter - Balance
	public double getBalance() {
		return balance;
	}

	// Setter - Balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Getter - Currency
	public String getCurrency() {
		return currency;
	}

	// Setter - Currency
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	// Getter - Deposit
	public int getDeposit() {
		return deposit;
	}

	// Setter - Deposit
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	// Getter - Withdraw
	public int getWithdraw() {
		return withdraw;
	}

	// Setter - Withdraw
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	// Getter - Writeable
	public boolean isWriteable() {
		return writeable;
	}

	// Setter - Writeable
	public void setWriteable(boolean writeable) {
		this.writeable = writeable;
	}

	// Synchronized for the depositer to see if the balance
	// is 0 to add different currency
	public synchronized void deposit(String currencyValue) {

		// If balance is 0, only then you can change the currency
		if (this.balance == 0) {
			this.currency = currencyValue;
		}

		// If the currency is the same as currencyValue that is sent in by
		// depositer and the balance is not 0 or less then wait
		// until balance is 0
		while (this.currency != currencyValue && this.balance > 0) {
			try {
				System.out.println("Waiting for Withdrawer . . . ");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// If balance is 0, only then you can change the currency
			// This will check the while loop condition and get out of it
			if (this.balance == 0) {
				this.currency = currencyValue;
			}
		}

		// if the currency is same as the present currency
		// only then you can add 1 more value to balance
		if (this.currency == currencyValue) {
			this.balance += 1;
			System.err.println(Thread.currentThread().getName() + ": Deposited 1 " + this.currency + "\n");
			notify();
		}
	}

	// Synchronized for the withdrawer who will wait for depositer to
	// put some currency in the account
	public synchronized boolean withdraw() {

		// If the balance is less than or equal to 0, then wait for deposit
		while (this.balance <= 0) {
			try {
				System.out.println("Waiting for Depositer . . . ");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// If there is deposit in the balance, then take money from it
		this.balance -= 1;

		// withdraw is incremented by 1 to use it in a condition to check
		// if the withdrawal process needs to end or not
		this.withdraw += 1;

		System.err.println(Thread.currentThread().getName() + ": Withdrawed 1 " + this.currency + "\n");

		notify();

		if (this.balance == 0 && this.deposit == this.withdraw) {
			return true;
		}

		return false;
	}
}
