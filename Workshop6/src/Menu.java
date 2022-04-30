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
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
	
	// Field members for the class
	private JLabel option;
	private JButton insert;
	private JButton display;
	
	// No argument constructor
	public Menu() {
		super("Student Data Menu");
		setLayout(new FlowLayout());
		
		option = new JLabel("Click button to either Insert or Display Student Data!");
		option.setVerticalTextPosition(SwingConstants.CENTER);
		add(option);
		
		// insert button with event handling
		insert = new JButton("Insert");
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentSerializationSwing studentInput = new StudentSerializationSwing();
				studentInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				studentInput.setSize(230, 350);
				studentInput.setVisible(true);
			}
		});
		add(insert);
		
		// Display button with event handling
		display = new JButton("Display");
		display.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentDeserializationSwing studentInput = new StudentDeserializationSwing();
				studentInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				studentInput.setSize(400, 350);
				studentInput.setVisible(true);
			}
		});
		add(display);
		
	}

	public static void main(String[] args) {
		Menu options = new Menu();
		options.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    options.setSize(350, 120); 
	    options.setVisible(true); 
	}

}
