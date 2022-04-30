// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: March 8, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 5

// Import java libraries
import java.io.*;
import java.util.ArrayList;

public class StudentDeserialization {
	// Eclipse was showing error on the downcast ArrayList<Student>
	// Need to use @SuppressWarnings("unchecked") to remove of the error.
	@SuppressWarnings("unchecked")
	
	public static void main(String[] args) {
		// Declare local students array list
		ArrayList<Student> students = null;
		
		// Try Catch block to use IO streams
		// Read data from the outStudent.out file and convert it into students array list
		try {

			FileInputStream fileIstr = new FileInputStream("outStudent.out");

			ObjectInputStream objectIstr = new ObjectInputStream(fileIstr);

			students = (ArrayList<Student>) objectIstr.readObject();
			
			// Check if the file had data inside and was able to assign it to students array list
			if(students != null) {
				// Total number of objects created
				// And List of students
				System.out.format("Total number of Student object created: %s\n\n", students.size());
				System.out.println("Students Information:");
				// for loop to get the newly assigned data of students
				for (int i = 0; i < students.size(); i++) {
					System.out.format("%s", students.get(i));
				}
			}
			
			// Close file and object input stream
			objectIstr.close();
			fileIstr.close();

		} catch (Throwable e) {
			System.err.println(e);
		}

	}

}
