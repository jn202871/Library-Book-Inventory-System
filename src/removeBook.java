package src;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class removeBook extends javax.swing.JFrame{
	private BinarySearchTree bst; //stores bst

	public removeBook(BinarySearchTree bst){
		super("Remove Book");
		this.bst = bst;
		//GUI stuff
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250,150);
		setVisible(true);
	}
	
	void buildApp(){ //Moar GUI stuff
		JLabel addInstruction = new JLabel("Enter CRN of book to remove");
		JTextField bookCRN = new JTextField("CRN");
		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(cancel);
		buttonPanel.add(submit);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		textPanel.add(bookCRN);
		add(addInstruction, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		cancel.addActionListener(new ActionListener(){ // If cancel button pressed close window
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		submit.addActionListener(new ActionListener(){ // If submit button pressed call remove function of BST for the given CRN
			public void actionPerformed(ActionEvent e){
			int intCRN = java.lang.Integer.parseInt(bookCRN.getText());
			JOptionPane.showMessageDialog(null, "Removing Book");
			bst.delete(intCRN);
			dispose();
			}
		});
	}
}
