// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 22, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 4

package shapes;

public class Parallelogram extends Rectangle {

	// Two argument constructor to initialize class variable height and width
	// Constructor will throw exception if height and wide are invalid
	public Parallelogram(double width, double height) throws RectangleException, ParallelogramException {
		super(width, height);
	}

	// Setter for class variable height
	public void setHeight(double height) throws RectangleException, ParallelogramException {
		// Setters from Rectangle class will handle the exceptions
		this.setLength(height);
	}

	// Getter for class variable height
	public double getHeight() {
		return this.getLength();
	}
}