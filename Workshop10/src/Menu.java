// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: April 12, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 10

public class Menu {
	public static void main(String[] args) {
		// One Bank that is passed to the threads
		StrangeBank sbc = new StrangeBank();

		// 2 friends (threads)
		Depositer friend1 = new Depositer(sbc);
		Withdrawer friend2 = new Withdrawer(sbc);

		// Starting the threads
		friend1.start();
		friend2.start();

	}
}
