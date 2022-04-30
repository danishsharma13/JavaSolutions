// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: March 8, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 5

// Import java libraries
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	// Field members
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;

	// No argument constructor
	// Set all field members to empty values
	public Student() {
		stdID = 0;
		firstName = "";
		lastName = "";
		courses = new ArrayList<String>();
	}

	// 4 argument constructor
	public Student(int id, String fName, String lName, ArrayList<String> courseList) {
		if (id != 0 && fName != "" && lName != "" && courseList != null) {
			stdID = id;
			firstName = fName;
			lastName = lName;
			courses = courseList;
		}
	}

	// ******** Setters ********

	// stdID - Setter
	public void setStdID(int id) {
		if (id != 0) {
			stdID = id;
		}
	}

	// firstName - Setter
	public void setFirstName(String fName) {
		if (fName != "") {
			firstName = fName;
		}
	}

	// lastName - Setter
	public void setLastName(String lName) {
		if (lName != "") {
			lastName = lName;
		}
	}

	// courses - Setter
	public void setCourses(ArrayList<String> courseList) {
		if (courseList != null) {
			courses = courseList;
		}
	}

	// course - Setter/Add
	// To add a course to the list of courses
	public void setCourse(String course) {
		if (course != "") {
			courses.add(course);
		}
	}

	// ******** Set End ********

	// ******** Getters ********

	// stdID - Getter
	public int getStdID() {
		return stdID;
	}

	// firstName - Getter
	public String getFirstName() {
		return firstName;
	}

	// lastName - Getter
	public String getLastName() {
		return lastName;
	}

	// FullName - Getter
	public String getFullName() {
		return firstName + " " + lastName;
	}

	// courses - Getter
	public ArrayList<String> getCourses() {
		return courses;
	}

	// ******** Get End ********

	@Override
	public String toString() {
		return String.format("[ID] %s : %s, Classes: %s\n", getStdID(), getFullName(), getCourses());
	}
}
