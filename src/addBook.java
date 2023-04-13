package src;



import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class addBook extends javax.swing.JFrame{
	private static int CRN; //CRN value is predetermined and not input by user to avoid 2 books having the same value
	private BinarySearchTree bst; // bst is imported to be able to insert new node

	public addBook(BinarySearchTree bst){
		super("Add Book");
		this.bst = bst;
		CRN = loadCRN(); //Loads CRN from text file
		//GUI stuff
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250,150);
		setVisible(true);
	}
	
	void buildApp(){ //Lots and Lots of GUI stuff
		JLabel addInstruction = new JLabel("Enter title, author, and CRN of new book");
		JTextField bookName = new JTextField("Title");
		JTextField bookAuthor = new JTextField("Author");
		JLabel bookCRN = new JLabel("CRN: " + java.lang.Integer.toString(CRN));
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
		
		submit.addActionListener(new ActionListener(){ // If submit button pressed, create new node from inputs and append to tree, then close window with message that node was added
			@Override
			public void actionPerformed(ActionEvent e){
			//int intCRN = parseInt(bookCRN.getText(),5);
			LibNode newNode = new LibNode(bookName.getText(),bookAuthor.getText(),CRN);
			System.out.println("Added Book: " + newNode.getName() + " Written by: " + newNode.getAuthor() + " With a CRN of: " + newNode.getCRN());
			JOptionPane.showMessageDialog(null, "Adding Book");
			CRN++;
			bst.insert(newNode);
			saveCRN();
			dispose();
			}
		});
	}

	private int loadCRN(){ // Opens text file, reads CRN, then closes file
		try {
            FileReader reader = new FileReader("CRN.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            int tempCRN = java.lang.Integer.parseInt(bufferedReader.readLine());
            reader.close();
			System.out.println(CRN);
			return tempCRN;
 
        } catch (IOException e) {
            e.printStackTrace();
			dispose();
			return 0;
        }
    }

	private void saveCRN(){ // Overwrites textfile with new CRN value, generates new txt file if one does not exist
		try {
            FileWriter writer = new FileWriter("CRN.txt", false);
			System.out.println(CRN);
            writer.write(java.lang.Integer.toString(CRN));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
