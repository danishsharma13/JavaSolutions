// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: March 29, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 8

public class Student implements Comparable<Student> {
	// Field members
	private String firstName;
	private String lastName;
	private double grade;
	private String department;

	// 4 argument constructor
	public Student(String fName, String lName, double mark, String dept) {
		if (fName != "" && lName != "" && mark >= 0 && mark <= 100 && dept != "") {
			firstName = fName;
			lastName = lName;
			grade = mark;
			department = dept;
		}
	}

	// ******** Setters ********

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

	// grade - Setter
	public void setGrade(double mark) {
		if (mark >= 0 && mark <= 100) {
			grade = mark;
		}
	}

	// department - Setter
	public void setDepartment(String dept) {
		if (dept != "") {
			department = dept;
		}
	}

	// ******** Set End ********

	// ******** Getters ********

	// firstName - Getter
	public String getFirstName() {
		return firstName;
	}

	// lastName - Getter
	public String getLastName() {
		return lastName;
	}

	// FullName - Getter
	public String getName() {
		return firstName + " " + lastName;
	}

	// grade - Getter
	public double getGrade() {
		return grade;
	}

	// department - Getter
	public String getDepartment() {
		return department;
	}

	// ******** Get End ********

	// compareTo
	public int compareTo(Student student) {
		int compareLastName = lastName.compareTo(student.getLastName());
		if (compareLastName == 0) {
			return firstName.compareTo(student.getFirstName());
		}

		return compareLastName;
	}

	@Override
	public String toString() {
		return String.format("%-8s %-8s %2.2f   %-10s", getFirstName(), getLastName(), getGrade(), getDepartment());
	}
}
