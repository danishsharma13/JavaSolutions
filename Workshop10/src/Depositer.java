// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: April 12, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 10

// Java Libraries
import java.util.Map;
import java.util.TreeMap;

public class Depositer extends Thread {

	private StrangeBank depositAccount;

	public Depositer(StrangeBank bank) {
		super("Rich Friend");
		this.depositAccount = bank;
	}

	// Getter
	public StrangeBank getDepositAccount() {
		return depositAccount;
	}

	// Setter
	public void setDepositAccount(StrangeBank depositAccount) {
		this.depositAccount = depositAccount;
	}

	public void run() {
		int count = 0;
		Map<String, Integer> currencies = new TreeMap<>();
		currencies.put("Dollar(s)", 1);
		currencies.put("Euro(s)", 2);
		currencies.put("Pound(s)", 3);

		// Iterate through the TreeMap to deposit currencies
		for (Map.Entry<String, Integer> itr : currencies.entrySet()) {
			// Count variable is used to let the Bank know when to stop withdrawal process
			count += currencies.get(itr.getKey());
			while (currencies.get(itr.getKey()) > 0) {
				depositAccount.deposit(itr.getKey());
				currencies.put(itr.getKey(), currencies.get(itr.getKey()) - 1);
			}
		}

		// Set the deposit in the bank to count so withrawal process knows when to stop
		depositAccount.setDeposit(count);
		System.out.println("Depositer is done . . .");
	}

}
