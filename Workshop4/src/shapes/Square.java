// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 22, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 4

package shapes;

public class Square extends Rectangle {

	// One argument constructor to initialize class variable side
	// Constructor will throw exception if side is invalid
	public Square(double side) throws RectangleException, SquareException {
		super(side, side);
	}

	// Setter for class variable length
	public void setSide(double side) throws RectangleException, SquareException {
		// Setters from Rectangle class will handle the exceptions
		this.setLength(side);
		this.setWidth(side);
	}

	// Getter for class variable side
	public double getSide() {
		return this.getLength();
	}

	// Override the toString to have appropriate output in the command line
	// When Shape(Square) is called to be printed out, it will display the
	// following toString() method.
	@Override
	public String toString() {
		// Return String format for Square toString method.
		return String.format("%s {s=%s} perimeter = %6g", this.getClass().getSimpleName(), Double.toString(getSide()),
				getPerimeter());
	}
}
