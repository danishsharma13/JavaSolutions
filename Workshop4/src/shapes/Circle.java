// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 22, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 4

package shapes;

public class Circle implements Shape {
	private double radius;

	// One argument constructor to initialize class variable radius
	// Constructor will throw exception if radius is invalid
	public Circle(double radius) throws CircleException {
		super();
		// Check if the radius is valid
		// radius needs to be positive value
		if (radius > 0) {
			this.radius = radius;
		}
		// throw exception when radius is invalid
		else {
			throw new CircleException("Invalid radius!");
		}
	}

	// Setter for class variable radius
	public void setRadius(double radius) throws CircleException {
		// Check if the radius is valid
		// radius needs to be positive value
		if (radius > 0) {
			this.radius = radius;
		}
		// throw exception when radius is invalid
		else {
			new CircleException("Invalid radius!");
		}
	}

	// Getter for class variable radius
	public double getRadius() {
		return this.radius;
	}

	// Override the getPerimeter in Shape super class
	@Override
	public double getPerimeter() {
		// Return perimeter of circle with the use of Math.PI and circle perimeter
		// formula
		return (2 * Math.PI * getRadius());
	}

	// Override the toString to have appropriate output in the command line
	// When Shape(Circle) is called to be printed out, it will display the following
	// toString() method.
	@Override
	public String toString() {
		// Return String format for circle toString method.
		return String.format("%s {r=%s} perimeter = %g", this.getClass().getSimpleName(),
				Double.toString(getRadius()), getPerimeter());
	}
}
