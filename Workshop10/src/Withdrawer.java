// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: April 12, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 10

public class Withdrawer extends Thread {

	private StrangeBank withdrawAccount;

	public Withdrawer(StrangeBank bank) {
		super("Opposite of Rich Friend");
		this.withdrawAccount = bank;
	}

	// Getter
	public StrangeBank getWithdrawAccount() {
		return withdrawAccount;
	}

	// Setter
	public void setWithdrawAccount(StrangeBank withdrawAccount) {
		this.withdrawAccount = withdrawAccount;
	}

	public void run() {
		// tf is a variable used to see when to exit do while loop
		boolean tf;
		do {
			// If tf becomes true then exit the loop
			tf = withdrawAccount.withdraw();
		} while (!tf);

		System.out.println("Withdrawer is done . . . ");
	}
}
