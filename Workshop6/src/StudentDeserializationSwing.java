// Name: Danish Sharma
// ID: 148201205
// Email: dsharma115@myseneca.ca
// Professor: Reza Khojasteh
// Date: March 15, 2022
// I have done all the coding by myself and only copied the code that my 
// professor provided to complete my workshops and assignments.

// Workshop 6

// Import java libraries
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class StudentDeserializationSwing extends JFrame {
	
	// Need to add this to make eclipse run the program
	@SuppressWarnings("unchecked")

	// No argument constructor
	public StudentDeserializationSwing() {
		
		// Frame Setup
		super("Display Student Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// Declare local students array list
		ArrayList<Student> students = null;
		
		// Label for Student's list
		JLabel studentLabel = new JLabel("***** Student Data *****");
		add(studentLabel);

		// Try Catch block to use IO streams
		// Read data from the outStudent.out file and convert it into students array
		// list
		try {

			FileInputStream fileIstr = new FileInputStream("outStudent.out");

			ObjectInputStream objectIstr = new ObjectInputStream(fileIstr);

			students = (ArrayList<Student>) objectIstr.readObject();

			// Check if the file had data inside and was able to assign it to students array
			// list
			if (students != null) {
				// for loop to get the newly assigned data of students
				for (int i = 0; i < students.size(); i++) {
					JPanel panel = new JPanel();
					TitledBorder panelTitle = new TitledBorder(String.format("%s", students.get(i).getStdID()));
					panel.setBorder(panelTitle);
					JTextArea student = new JTextArea(students.get(i).toString());
					student.setEditable(false);
					
					panel.add(student);
					add(panel);
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
