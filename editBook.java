
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

//import java.lang.Integer.parseInt;
public class editBook extends javax.swing.JFrame{
    private LibNode temp;
	private BinarySearchTree bst;

	public editBook(BinarySearchTree bst, int key){
		super("Edit Book");
		this.bst = bst;
        temp = bst.search(key);
		setLayout(new BorderLayout());
		//setResizeable(false);
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250,150);
		setVisible(true);
	}
	
	void buildApp(){
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
		
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		submit.addActionListener(new ActionListener(){
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
