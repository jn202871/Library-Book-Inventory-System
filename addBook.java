import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
//import java.lang.Integer.parseInt;
public class addBook extends javax.swing.JFrame{
	public addBook(){
		super("Add Book");
		setLayout(new BorderLayout());
		//setResizeable(false);
		setLocationRelativeTo(null);
		buildApp();
		pack();
		setSize(250,110);
		setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	void buildApp(){
		JLabel addInstruction = new JLabel("Enter name, author, and CRN of new book");
		JTextField bookName = new JTextField("Input Name");
		JTextField bookAuthor = new JTextField("Input Author");
		JTextField bookCRN = new JTextField("Input CRN");
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
			public void actionPreformed(ActionEvent e) {
				dispose();
			}
		});
		
		submit.addActionListener(new ActionListener(){
			public void actionPreformed(ActionEvent e){
			//int intCRN = parseInt(bookCRN.getText(),5);
			LibNode newNode = new LibNode(bookName.getText(),bookAuthor.getText(),1000);
			JOptionPane.showMessageDialog(null, "Adding Book");
			dispose();
			}
		});
	}
}
