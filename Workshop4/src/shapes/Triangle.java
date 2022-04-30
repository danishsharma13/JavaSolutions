// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 22, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 4

package shapes;

public class Triangle implements Shape {
	private double side1;
	private double side2;
	private double side3;

	// Three argument constructor to initialize class variable side 1, 2, 3
	// Constructor will throw exception if side 1, 2, 3 are invalid
	public Triangle(double s1, double s2, double s3) throws TriangleException {
		super();
		// Check if the side 1, 2, 3 are valid
		// side 1, 2, 3 needs to be positive value
		if (validSides(s1, s2, s3) && s1 > 0 && s2 > 0 && s3 > 0) {
			this.side1 = s1;
			this.side2 = s2;
			this.side3 = s3;
		}
		// throw exception when side 1, 2, 3 are invalid
		else {
			throw new TriangleException("Invalid side(s)!");
		}
	}

	// Setter for class variable side1
	public void setSide1(double s1) throws TriangleException {
		// side1 needs to be positive value
		if (side1 > 0) {
			this.side1 = s1;
		}
		// throw exception when side1 is invalid
		else {
			throw new TriangleException("Invalid side!");
		}
	}

	// Getter for class variable side1
	public double getSide1() {
		return this.side1;
	}

	// Setter for class variable side2
	public void setSide2(double s2) throws TriangleException {
		// side2 needs to be positive value
		if (side2 > 0) {
			this.side2 = s2;
		}
		// throw exception when side2 is invalid
		else {
			throw new TriangleException("Invalid side!");
		}
	}

	// Getter for class variable side2
	public double getSide2() {
		return this.side2;
	}

	// Setter for class variable side3
	public void setSide3(double s3) throws TriangleException {
		// side3 needs to be positive value
		if (side3 > 0) {
			this.side3 = s3;
		}
		// throw exception when side3 is invalid
		else {
			throw new TriangleException("Invalid side!");
		}
	}

	// Getter for class variable side3
	public double getSide3() {
		return this.side3;
	}

	// validSides method to check if all sides of triangle are valid
	public boolean validSides(double s1, double s2, double s3) {
		return ((s1 + s2) >= s3 && (s2 + s3) >= s1 && (s1 + s3) >= s2);
	}

	// Override the getPerimeter in Shape super class
	@Override
	public double getPerimeter() {
		// Return perimeter of triangle by adding all sides
		return (getSide1() + getSide2() + getSide3());
	}

	// Override the toString to have appropriate output in the command line
	// When Shape(Triangle) is called to be printed out, it will display the
	// following toString() method.
	@Override
	public String toString() {
		// Return String format for triangle toString method.
		return String.format("%s {s1=%s, s2=%s, s3=%s} perimeter = %g", this.getClass().getSimpleName(),
				Double.toString(getSide1()), Double.toString(getSide2()), Double.toString(getSide3()), getPerimeter());
	}
}
