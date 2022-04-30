// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: March 29, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 8

// Importing libraries 
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StudentProcess {
	public static void main(String[] args) {
		Student[] students = { 
				new Student("Jack", "Smith", 50.0, "IT"), 
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"), 
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"), 
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media") 
		};

		// Create a List of students using the hard coded array of students
		List<Student> studentList = Arrays.asList(students);
		// Task 1
		task1(studentList);

		// Task 2
		task2(studentList);
		
		// Task 3
		task3(studentList);
		
		// Task 4
		task4(studentList);
		
		// Task 5
		task5(studentList);
		
		// Task 6
		task6(studentList);
		
		// Task 7
		task7(studentList);
		
		// Task 8
		task8(studentList);
		
		// Task 9
		task9(studentList);
		
		// Task 10
		task10(studentList);
	}

	public static void task1(List<Student> studentList) {
		System.out.println("Task1: \n");
		System.out.println("Complete Student list:");
		
		// Use forEach to loop to each element in the studentList to display students
		studentList.forEach(student -> System.out.println(student));
	}
	
	public static void task2(List<Student> studentList) {
		System.out.println("\nTask2: \n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		
		// Use stream lambda expression to get students who have grades >= 50
		List<Student> studentList2 = studentList.stream()
				.filter(student -> student.getGrade() >= 50)
				.sorted(Comparator.comparingDouble(Student::getGrade))
				.collect(Collectors.toList());
		
		// Use forEach to loop to each element in the studentList to display students
		studentList2.forEach(student -> System.out.println(student));
	}
	
	public static void task3(List<Student> studentList) {
		System.out.println("\nTask3: \n");
		System.out.println("First Student who got 50.0-100.0:");
		
		// Use stream lambda expression to get student who have grade >= 50
		Student studentOutput = studentList.stream()
				.filter(student -> student.getGrade() >= 50)
				.findFirst()
				.orElse(null);
		
		// print the student
		System.out.println(studentOutput);
	}
	
	public static void task4(List<Student> studentList) {
		System.out.println("\nTask4: \n");
		System.out.println("Students in ascending order by last name then first:");

		// Use stream lambda expression to get students in ascending order
		List<Student> studentList2 = studentList.stream()
				.sorted((s1, s2) -> s1.compareTo(s2))
				.collect(Collectors.toList());

		// Use forEach to loop to each element in the studentList to display ascending students
		studentList2.forEach(student -> System.out.println(student));
		
		System.out.println("\nStudents in descending order by last name then first:");
		
		// Use forEach to loop to each element in the studentList to display descending students
		Collections.reverse(studentList2);
		studentList2.forEach(student -> System.out.println(student));
	}
	
	public static void task5(List<Student> studentList) {
		System.out.println("\nTask5: \n");
		System.out.println("Unique Student last names:");
		
		// Use Set<String> to only have distinct last names
		Set<String> lastNames = new TreeSet<>();
		
		// Adding last names to the Set lastNames
		studentList.forEach(student -> lastNames.add(student.getLastName()));
		
		// Use forEach to loop to each element in the lastNames to display distinct last names
		lastNames.forEach(last -> System.out.println(last));
	}
	
	public static void task6(List<Student> studentList) {
		System.out.println("\nTask6: \n");
		System.out.println("Student names in order by last name then first name:");

		// Use stream lambda expression to get students in ascending order
		List<Student> studentList2 = studentList.stream()
				.sorted((s1, s2) -> s1.compareTo(s2))
				.collect(Collectors.toList());

		// Use forEach to loop to each element in the studentList to display ascending
		// students
		studentList2.forEach(student -> System.out.println(student.getFirstName() + " "  + student.getLastName()));
	}
	
	public static void task7(List<Student> studentList) {
		System.out.println("\nTask7: \n");
		System.out.println("Students by department:");
		
		// Use stream lambda expression to get students grouped in a department
		Map<String, List<Student>> departmentMap = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment));
		
		// Using forEach on departmentMap to display data in each grouped departments
		departmentMap.forEach((key, value) -> {
			System.out.println(key);
			value.forEach(student -> System.out.println("   " + student));
			
		});	
	}
	
	public static void task8(List<Student> studentList) {
		System.out.println("\nTask8: \n");
		System.out.println("Count of Students by department:");
		
		// Use stream lambda expression to get students grouped in a department
		Map<String, List<Student>> departmentMap = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, TreeMap::new, Collectors.toList()));

		// Using forEach on departmentMap to display data in each grouped departments
		departmentMap.forEach((key, value) -> {
			System.out.println(key + " has " + value.size() + " Student(s)");
		});
	}
	
	public static void task9(List<Student> studentList) {
		System.out.println("\nTask9: \n");

		// Use stream lambda, mapToDouble expression to get sum of student's marks
		double studentsGradeSum = studentList.stream()
				.mapToDouble(student -> student.getGrade())
				.sum();

		// Display the sum of student's marks
		System.out.println("Sum of Students' grades: " + studentsGradeSum);
	}
	
	public static void task10(List<Student> studentList) {
		System.out.println("\nTask10: \n");

		// Use stream lambda, mapToDouble expression to get average of student's marks
		// and then convert the average into getAsDouble
		double studentsGradeSum = studentList.stream()
				.mapToDouble(student -> student.getGrade())
				.average()
				.getAsDouble();

		// Display the sum of student's marks
		System.out.format("Average of Students' grades: %.2f", studentsGradeSum);
	}
}

