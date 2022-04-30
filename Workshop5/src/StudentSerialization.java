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

public class StudentSerialization {
	private static ArrayList<Student> students;
	private static BufferedReader reader;

	public static void main(String[] args) {
		// Initializing field members and declare local members
		reader = new BufferedReader(new InputStreamReader(System.in));
		students = new ArrayList<Student>();
		char cont = 'n';
		String stringInput;

		System.out.println("**** Please Enter Information ****");

		// Try and Catch block for any IO Exceptions from BufferedReader
		// Get input from user to set it to student object
		try {
			do {
				// New student to keep adding student object to students array
				Student student = new Student();

				if (cont == 'y' || cont == 'Y') {
					System.out.println("\n**** Please Enter Information ****");
				}

				// Student ID
				System.out.print("\nEnter Student ID: ");
				if ((stringInput = reader.readLine()).length() != 0 && Integer.parseInt(stringInput) != 0) {
					student.setStdID(Integer.parseInt(stringInput));
				}

				// Student First Name
				System.out.print("\nEnter Student First Name: ");
				if ((stringInput = reader.readLine()).length() != 0) {
					student.setFirstName(stringInput);
				}

				// Student Last Name
				System.out.print("\nEnter Student Last Name: ");
				if ((stringInput = reader.readLine()).length() != 0) {
					student.setLastName(stringInput);
				}

				// Student Courses
				System.out.println("\nEnter Courses each on a new line (Enter to finish): ");

				while ((stringInput = reader.readLine()).length() != 0) {
					student.setCourse(stringInput);
				}

				// Display the student object to user
				System.out.format("New Student Information: \n%s", student);

				// Add student object in the array students
				students.add(student);

				// Display array after adding student object
				System.out.format("\n\nStudents Array: \n%s", students);

				// Ask to add another student
				System.out.print("\n\n**** Want to add another Student? [Y, y] or [N, n]: ");
				cont = reader.readLine().charAt(0);
				while ((cont != 'Y' && cont != 'y' && cont != 'N' && cont != 'n')) {
					System.out.print("\n Please enter valid input [Y, y] or [N, n]: ");
					cont = reader.readLine().charAt(0);
				}

			} while (cont == 'y' || cont == 'Y');
		} catch (IOException e) {
			System.err.println(e);
		}

		if (serializeStudent()) {
			System.out.println("Serialization successfull!");
		} else {
			System.out.println("Serialization unsuccessfull!!!");
		}
	}

	// serializeStudent method will create a file which will store state of the
	// current student array object
	public static boolean serializeStudent() {
		// Declare local variable
		boolean tf = false;

		// Try Catch block to use IO streams
		// Write the object's state to the file outStudent.out
		try {

			FileOutputStream fileOstr = new FileOutputStream("outStudent.out");

			ObjectOutputStream objectOstr = new ObjectOutputStream(fileOstr);

			objectOstr.writeObject(students);

			// Close file output stream and flush object output stream
			objectOstr.flush();
			fileOstr.close();

			// Set tf to true to log successfull serialization to the console
			tf = true;

		} catch (Throwable e) {
			System.err.println(e);
		}

		return tf;
	}

}
