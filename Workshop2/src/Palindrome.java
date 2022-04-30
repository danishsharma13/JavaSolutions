// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 8, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 2

public class Palindrome {

	public static boolean palindromeChecker(String word) {
		boolean tf = true;
		// Initialize Stack container with the size of the word
		Stack container = new Stack(word.length());

		// push the contents of word into the container
		for (int i = 0; i < word.length(); i++) {
			container.push(word.charAt(i));
		}

		// check if the word is palindrome using the pop method of Stack container
		for (int i = 0; i < word.length(); i++) {
			// if any word does not match, set tf to false
			if (word.charAt(i) != container.pop()) {
				tf = false;
			}
		}

		// return either true or false based on the palindrome check of the word
		return tf;
	}

	public static void main(String[] args) {
		String temp;
		// To check all the arguments of the command line
		for (int i = 0; i < args.length; i++) {
			temp = args[i];

			if (palindromeChecker(temp.toLowerCase())) {
				System.out.println("The word " + args[i] + " is a palindrome word.");
			} else {
				System.out.println("The word " + args[i] + " is not a palindrome word.");
			}
		}
	}
}
