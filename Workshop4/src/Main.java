// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: February 22, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 4

// Import File reading, error handling classes
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Import package shapes's classes
import shapes.Circle;
import shapes.CircleException;
import shapes.Parallelogram;
import shapes.ParallelogramException;
import shapes.Rectangle;
import shapes.RectangleException;
import shapes.Shape;
import shapes.Square;
import shapes.SquareException;
import shapes.Triangle;
import shapes.TriangleException;

public class Main {

	public static Shape createShape(String[] tokens)
			throws CircleException, RectangleException, ParallelogramException, SquareException, TriangleException {
		Shape tempShape = null;

		switch (tokens[0].toLowerCase()) {
		case "circle":
			if (tokens.length == 2)
				tempShape = new Circle(Double.parseDouble(tokens[1]));
			break;
		case "rectangle":
			if (tokens.length == 3)
				tempShape = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
			break;
		case "square":
			if (tokens.length == 2)
				tempShape = new Square(Double.parseDouble(tokens[1]));
			break;
		case "parallelogram":
			if (tokens.length == 3)
				tempShape = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
			break;
		case "triangle":
			if (tokens.length == 4)
				tempShape = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
						Double.parseDouble(tokens[3]));
			break;
		default:
			break;
		}

		return tempShape;
	}

	public static void main(String[] args) {
		int numOfLines = 0;
		int idx = 0;
		String s;
		Shape[] shapes;

		Path shapesPath = Paths.get("C:\\Users\\danis\\Desktop\\Seneca Yr 2 Sem2\\JAC444\\Week 5\\shapes.txt");

		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------");

		// try catch block to catch any exception when counting number of lines in
		// shapes file
		// numOfLines to determine the length of the shapes array
		try {
			numOfLines = (int) Files.lines(shapesPath).count();

		} catch (IOException e) {
			System.out.println("Problem counting number of lines in Shapes file!");
		}

		// Making new array of object Shape with the numOfLines as array length.
		shapes = new Shape[numOfLines];

		// Reading line by line from shapes.txt file to make new shape object
		// try catch block to catch any exception while reading line
		try (BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\danis\\Desktop\\Seneca Yr 2 Sem2\\JAC444\\Week 5\\shapes.txt"))) {
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				// try catch block to catch any shapes exception
				try {
					Shape tempShape = createShape(tokens);

					// if statement to check if the tempShape is not null
					// and can be added to the array
					if (tempShape != null) {
						shapes[idx++] = tempShape;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n" + idx + " shapes were created:");

		for (Shape elem : shapes) {
			if (elem != null)
				System.out.println(elem + "\n");
		}
		
		// Task 2 and 3
		displayTask2And3(shapes);
	}
	
	// Task 2 and 3 Display Method
	public static void displayTask2And3(Shape[] shapes) {
		double minimumTrianglePerimeter = 0;
		double maximumCirclePerimeter = 0;
		
		double totalParallelogram = 0;
		double totalTriangle = 0;
		
		// Looping through the array and checking if minimum perimeter 
		// of triangle and maximum perimeter of circle 
		for (Shape elem : shapes) {
			if(elem != null) {
				if(elem.getClass().getSimpleName().equals("Triangle")) {
					if(minimumTrianglePerimeter == 0) {
						minimumTrianglePerimeter = elem.getPerimeter();
					}
					else if (minimumTrianglePerimeter > elem.getPerimeter()) {
						minimumTrianglePerimeter = elem.getPerimeter();
					}
				}
				else if(elem.getClass().getSimpleName().equals("Circle")) {
					if(maximumCirclePerimeter == 0) {
						maximumCirclePerimeter = elem.getPerimeter();
					}
					else if (maximumCirclePerimeter < elem.getPerimeter()) {
						maximumCirclePerimeter = elem.getPerimeter();
					}
				}				
			}
		}
		
		// Looping through the array to remove the Shapes
		// with max and min perimeter as Circle and Triangle
		// Also adding the valid perimeter of triangle and
		// parallelogram to a local variable to display for
		// task 3
		for (int i = 0; i < shapes.length; i++) {
			if(shapes[i] != null) {
				if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
					if(minimumTrianglePerimeter == shapes[i].getPerimeter()) {
						shapes[i] = null;
					}
				}
				else if(shapes[i].getClass().getSimpleName().equals("Circle")) {
					if(maximumCirclePerimeter == shapes[i].getPerimeter()) {
						shapes[i] = null;
					}
				}
				
				if(shapes[i] != null) {				
					if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
						totalTriangle += shapes[i].getPerimeter();
					} 
					else if(shapes[i].getClass().getSimpleName().equals("Parallelogram")) {
						totalParallelogram += shapes[i].getPerimeter();
					} 
				}				
			}
		}
		
		System.out.println("------->Task 2 ... <-------");
		// Printing the array where element is not null
		for (Shape elem : shapes) {
			if (elem != null)
				System.out.println(elem + "\n");
		}
		
		System.out.println("------->Task 3 ... <-------");
		System.out.format("Total perimeter of Parallelogram is: %s\n", totalParallelogram);
		System.out.format("Total perimeter of Triangle is: %s\n", totalTriangle);
		
	}

}
