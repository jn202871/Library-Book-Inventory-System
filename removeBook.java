

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
//import java.lang.Integer.parseInt;
public class removeBook extends javax.swing.JFrame{
	private BinarySearchTree bst;

	public removeBook(BinarySearchTree bst){
		super("Remove Book");
		this.bst = bst;
		setLayout(new BorderLayout());
		//setResizeable(false);
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250,150);
		setVisible(true);
	}
	
	void buildApp(){
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
		
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			int intCRN = java.lang.Integer.parseInt(bookCRN.getText());
			JOptionPane.showMessageDialog(null, "Removing Book");
			bst.delete(intCRN);
			dispose();
			}
		});
	}
}
