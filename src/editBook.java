package src;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class editBook extends javax.swing.JFrame{
    private LibNode temp; // temp node to store node to be edited
	private BinarySearchTree bst; // binary search tree

	public editBook(BinarySearchTree bst, int key){
		super("Edit Book");
		this.bst = bst;
        temp = bst.search(key); // finds node to be edited and points temp to it
		//GUI stuff
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250,150);
		setVisible(true);
	}
	
	void buildApp(){ // More GUI stuff
		JLabel addInstruction = new JLabel("Enter changes to title and author");
		JTextField bookName = new JTextField("Name");
		JTextField bookAuthor = new JTextField("Author");
		JLabel bookCRN = new JLabel("CRN: " + java.lang.Integer.toString(temp.getCRN()));
		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(cancel);
		buttonPanel.add(submit);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		textPanel.add(bookName);
		textPanel.add(bookAuthor);
		textPanel.add(bookCRN);
		add(addInstruction, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		cancel.addActionListener(new ActionListener(){ // If cancel button pressed, close window
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		submit.addActionListener(new ActionListener(){ // If submit button pressed, change the node to the input values from the user then close window
			@Override
			public void actionPerformed(ActionEvent e){
			//int intCRN = parseInt(bookCRN.getText(),5);
			JOptionPane.showMessageDialog(null, "Editing Book");
            temp.setName(bookName.getText());
            temp.setAuthor(bookAuthor.getText());
			dispose();
			}
		});
	}
}
