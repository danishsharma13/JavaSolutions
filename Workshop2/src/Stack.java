// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 8, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 2

public class Stack {
	// Class variables
	private char[] arrChar;
	private int arrSize;
	private int position;

	// Constructor with size parameter for arrChar
	public Stack(int size) {
		// Initialize class private variables
		arrChar = new char[size];
		arrSize = size;
		position = -1;
	}

	// Push method to add element in
	public void push(char charElem) {
		// If position is less than arrSize then push the element to the stack
		if (position < arrSize) {
			arrChar[++position] = charElem;
		}
		// else raise error / display error
		else {
			System.out.println("Array going out of bounds!");
		}
	}

	// Pop method to return a char
	public char pop() {
		char temp = '\0';
		// if position is greater then -1 then set temp to the last element
		if (!isEmpty()) {
			temp = arrChar[position--];
		}
		// else position is <= -1 then raise error / display error
		else {
			System.out.println("Array going out of bounds!");
		}

		// return either the character or terminating character
		return temp;
	}

	// isEmpty method to return true or false if the stack is empty or not
	public boolean isEmpty() {
		boolean tf = false;
		// if position is -1 then set tf to true since stack is empty
		if (position <= -1) {
			tf = true;
		}

		// return either true or false based on the state of stack
		return tf;
	}
}
