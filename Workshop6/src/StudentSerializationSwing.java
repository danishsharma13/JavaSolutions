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

public class StudentSerializationSwing extends JFrame {

	// Field members for the class

	// GUI fields
	private JPanel panel;
	private JTextField stdId;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField courses;
	private JTextArea courseList;
	private JLabel invalidLabel;

	// Student Object
	private ArrayList<Student> students;
	private Student student;

	// No argument constructor
	// Will be used to display GUI
	public StudentSerializationSwing() {

		// Frame Setup
		super("Insert Student Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// Student
		students = new ArrayList<Student>();
		student = new Student();

		// Student ID
		JLabel idLabel = new JLabel("Student ID : ");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		stdId = new JTextField(10);
		
		JPanel idPanel = new JPanel();
		TitledBorder idTitle = new TitledBorder("Add ID");
		idPanel.setBorder(idTitle);
		idPanel.add(idLabel);
		idPanel.add(stdId);
	
		add(idPanel);

		// Student FirstName
		JLabel firstNameLabel = new JLabel("First Name : ");
		firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		firstName = new JTextField(10);

		JPanel firstPanel = new JPanel();
		TitledBorder firstTitle = new TitledBorder("Add First Name");
		firstPanel.setBorder(firstTitle);
		firstPanel.add(firstNameLabel);
		firstPanel.add(firstName);
		
		add(firstPanel);

		// Student LastName
		JLabel lastNameLabel = new JLabel("Last Name : ");
		lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lastName = new JTextField(10);

		JPanel lastPanel = new JPanel();
		TitledBorder lastTitle = new TitledBorder("Add Last Name");
		lastPanel.setBorder(lastTitle);
		lastPanel.add(lastNameLabel);
		lastPanel.add(lastName);
		
		add(lastPanel);

		// Student Classes
		JLabel coursesLabel = new JLabel("Course List : ");
		coursesLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		courses = new JTextField(10); 
		
		JPanel coursePanel = new JPanel();
		TitledBorder courseTitle = new TitledBorder("Add Course");
		coursePanel.setBorder(courseTitle);
		coursePanel.add(coursesLabel);
		coursePanel.add(courses);
		
		add(coursePanel);
		
		
		courseList = new JTextArea("");
		JPanel courseListPanel = new JPanel();
		TitledBorder coursesTitle = new TitledBorder("Display Courses");
		courseListPanel.setBorder(coursesTitle);
		courseListPanel.add(courseList);
		courseList.setVisible(false);
		add(courseListPanel);
		courses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					student.setCourse(courses.getText());
					
					if(student.getCourses().size() != 0) {
						courseList.setText(student.getCourses().toString());
						courseList.setVisible(true);
					}
					
					courses.setText("");
				}
				catch (Throwable error) {
					System.out.println("Problem at courses!");
					invalidLabel.setVisible(true);
				}
			}
		});

		// Frame Setup after adding components to panels	

		// Save Button
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(invalidLabel.isVisible()) {
						invalidLabel.setVisible(false);
					}
					
					student.setStdID(Integer.parseInt(stdId.getText()));
					student.setFirstName(firstName.getText());
					student.setLastName(lastName.getText());
					students.add(student);
					
					// After saving, clear the fields for new entry
					clearData();
				}
				catch (Throwable error) {
					System.out.println("Problem at Save!");
					invalidLabel.setVisible(true);
				}
			}
		});
		add(save);

		// Submit Button
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!serializeStudent()) {
						System.out.println("Serialization (Submit) came out false!");
					}
					else {
						System.out.println("Serialization (Submit) came out true!");
					}
					
					System.exit(0);
				}
				catch (Throwable error) {
					System.out.println("Problem at Submit!");
					invalidLabel.setVisible(true);
				}
			}
		});
		add(submit);
		
		// Invalid Data
		invalidLabel = new JLabel("Invalid Data!");
		add(invalidLabel);
		invalidLabel.setVisible(false);
		
        setVisible(true);
	}

	public void clearData() {
		stdId.setText("");
		firstName.setText("");
		lastName.setText("");
		courses.setText("");
		courseList.setText("");
		courseList.setVisible(false);

		if (invalidLabel.isVisible()) {
			invalidLabel.setVisible(false);
		}

		student = new Student();
	}

	// serializeStudent method will create a file which will store state of the
	// current student array object
	public boolean serializeStudent() {
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

			// Set tf to true to log successful serialization to the console
			tf = true;

		} catch (Throwable e) {
			System.err.println(e);
		}

		return tf;
	}
}
