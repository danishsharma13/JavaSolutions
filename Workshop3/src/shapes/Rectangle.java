// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 15, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 3

package shapes;

public class Rectangle implements Shape {
	private double length;
	private double width;

	// Two argument constructor to initialize class variable length and width
	// Constructor will throw exception if length and wide are invalid
	public Rectangle(double width, double length) throws RectangleException {
		super();
		// Check if the length and width are valid
		// length and width needs to be positive value
		if (length > 0 && width > 0) {
			this.length = length;
			this.width = width;
		}
		// throw exception when length and width are invalid and length != width
		// Make sure it is not a square side
		else if ((length < 0 || width < 0) && length != width) {
			throw new RectangleException("Invalid side(s)!");
		}
		// Exception when square's side is not valid
		else {
			throw new RectangleException("Invalid side!");
		}
	}

	// Setter for class variable length
	public void setLength(double length) throws RectangleException {
		// length needs to be positive value
		if (length > 0) {
			this.length = length;
		}
		// throw exception when length is invalid
		else {
			throw new RectangleException("Invalid side!");
		}
	}

	// Getter for class variable length
	public double getLength() {
		return this.length;
	}

	// Setter for class variable width
	public void setWidth(double width) throws RectangleException {
		// width needs to be positive value
		if (width > 0) {
			this.width = width;
		}
		// throw exception when width is invalid
		else {
			throw new RectangleException("Invalid side!");
		}
	}

	// Getter for class variable width
	public double getWidth() {
		return this.width;
	}

	// Override the getPerimeter in Shape super class
	@Override
	public double getPerimeter() {
		// Return perimeter of rectangle by adding all sides
		return ((2 * getLength()) + (2 * getWidth()));
	}

	// Override the toString to have appropriate output in the command line
	// When Shape(Rectangle) is called to be printed out, it will display the
	// following toString() method.
	@Override
	public String toString() {
		// Return String format for Rectangle toString method.
		return String.format("%s {w=%s, h=%s} perimeter = %g", this.getClass().getSimpleName(),
				Double.toString(getWidth()), Double.toString(getLength()), getPerimeter());
	}
}
