package sepr.calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new Calculator();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JTextField display;
	private boolean operator = false;
	private String lastOperator = null;
	private int total = 0;
	
	public Calculator() {
		display = new JTextField("0", 12);
		display.setHorizontalAlignment(JTextField.RIGHT);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 4, 4));
		JPanel operatorPanel = new JPanel();
		operatorPanel.setLayout(new GridLayout(4, 4, 4, 4));
		
		Button button1 = new Button("1");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (display.getText().equals("0") || operator) {
					display.setText("1");
					operator = false;
				}
				else {
					display.setText(display.getText() + "1");
				}
			}
		});
		buttonPanel.add(button1);

		Button button2 = new Button("2");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (display.getText().equals("0") || operator) {
					display.setText("2");
					operator = false;
				}
				else {
					display.setText(display.getText() + "2");
				}
			}
		});
		buttonPanel.add(button2);

		Button button3 = new Button("3");
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (display.getText().equals("0") || operator) {
					display.setText("3");
					operator = false;
				}
				else {
					display.setText(display.getText() + "3");
				}
			}
		});
		buttonPanel.add(button3);
		
		Button plusButton = new Button("+");
		plusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (operator) {
					lastOperator = "+";
					return;
				}
				
				if (lastOperator != null) {
					if (lastOperator.equals("+")) {
						total = total + Integer.parseInt(display.getText());
						display.setText(total + "");
					}
					else if (lastOperator.equals("-")) {
						total = total - Integer.parseInt(display.getText());
						display.setText(total + "");
					}
				}
				else {
					total = Integer.parseInt(display.getText());
				}
				
				operator = true;				
				lastOperator = "+";
			}
		});
		operatorPanel.add(plusButton);

		Button minusButton = new Button("-");
		minusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (operator) {
					lastOperator = "-";
					return;
				}
				
				if (lastOperator != null) {
					if (lastOperator.equals("+")) {
						total = total + Integer.parseInt(display.getText());
						display.setText(total + "");
					}
					else if (lastOperator.equals("-")) {
						total = total - Integer.parseInt(display.getText());
						display.setText(total + "");						
					}
				}
				else {
					total = Integer.parseInt(display.getText());
				}
				
				operator = true;
				lastOperator = "-";
			}
		});
		operatorPanel.add(minusButton);	

		Button equalsButton = new Button("=");
		equalsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (operator) {
					lastOperator = "-";
					return;
				}
				
				if (lastOperator != null) {
					if (lastOperator.equals("+")) {
						total = total + Integer.parseInt(display.getText());
						display.setText(total + "");
					}
					else if (lastOperator.equals("-")) {
						total = total - Integer.parseInt(display.getText());
						display.setText(total + "");						
					}
				}
				
				operator = true;
				lastOperator = null;
			}
		});
		operatorPanel.add(equalsButton);			
		
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

}