package sepr.calculator.refactored;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RefactoredCalculator extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new RefactoredCalculator();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JTextField display;
	private boolean operator = false;
	private String lastOperator = null;
	private int total = 0;
	
	public RefactoredCalculator() {
		display = new JTextField("0", 12);
		display.setHorizontalAlignment(JTextField.RIGHT);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 4, 4));
		JPanel operatorPanel = new JPanel();
		operatorPanel.setLayout(new GridLayout(4, 4, 4, 4));
		
		buttonPanel.add(new NumberButton(1, this));
		buttonPanel.add(new NumberButton(2, this));
		buttonPanel.add(new NumberButton(3, this));
		
		operatorPanel.add(new OperatorButton("+", this));			
		operatorPanel.add(new OperatorButton("-", this));			
		operatorPanel.add(new OperatorButton("=", this));			
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout(4, 4));
		contentPanel.add(display, BorderLayout.NORTH);
		contentPanel.add(buttonPanel, BorderLayout.CENTER);
		contentPanel.add(operatorPanel, BorderLayout.EAST);
		this.setContentPane(contentPanel);
		this.pack();
		this.setTitle("Calculator");
		this.setResizable(false);
	}

	public boolean isOperator() {
		return operator;
	}
	
	public void setOperator(boolean operator) {
		this.operator = operator;
	}
	
	public String getLastOperator() {
		return lastOperator;
	}
	
	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public JTextField getDisplay() {
		return display;
	}
	
}