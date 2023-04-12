import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
//import java.lang.Integer.parseInt;
public class removeBook extends javax.swing.JFrame{
	public removeBook(){
		super("Remove Book");
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
		JLabel addInstruction = new JLabel("Enter CRN of book to remove");
		JTextField bookCRN = new JTextField("Input CRN");
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
			public void actionPreformed(ActionEvent e) {
				dispose();
			}
		});
		
		submit.addActionListener(new ActionListener(){
			public void actionPreformed(ActionEvent e){
			//int intCRN = parseInt(bookCRN.getText(),5);
			//System.out.println(intCRN);
			JOptionPane.showMessageDialog(null, "Removing Book");
			dispose();
			}
		});
	}
}
