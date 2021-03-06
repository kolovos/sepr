package sepr.patterns.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sepr.patterns.Blackboard;
import sepr.patterns.ui.Application;

public class Application extends JFrame implements ActionListener {
	
	protected Blackboard blackboard = null;
	
	protected JTextArea blackboardTextArea;
	protected JTextField commandTextField;
	protected JButton executeCommandButton;
	protected JButton undoButton;
	protected JButton redoButton;
	protected JLabel statusLabel;
	
	public static void main(String[] args) {
		
		new Application().run();
		
	}

	public void run() {
		initialiseUi();
		updateStatus("");
		blackboard = new Blackboard();
	}
	
	public void executeButtonPressed() {
		updateStatus("Executing...");
		
		if (commandTextField.getText().equals("clear")) {
			blackboard.setText("");
		}
		else if (commandTextField.getText().equals("smile")) {
			blackboard.setText(blackboard.getText() + "\n" + ":)");
		}
		else if (commandTextField.getText().startsWith("say ")) {
			String what = commandTextField.getText().substring(4);
			blackboard.setText(blackboard.getText() + "\n" + what);
		}
		else {
			blackboard.setText(blackboard.getText() + "\n" + "Unknown command: " + commandTextField.getText());
		}

		updateStatus("");
		
		blackboardTextArea.setText(blackboard.getText());
		commandTextField.setText("");
		commandTextField.requestFocus();
	}
	
	public void undoButtonPressed() {
	}
	
	public void redoButtonPressed() {

	}
	
	public void updateStatus(String text) {
		statusLabel.setVisible(text.length() > 0);
		statusLabel.setText(text);
	}
	
	public void initialiseUi() {
		BorderLayout mainLayout = new BorderLayout();
		getContentPane().setLayout(mainLayout);
		
		blackboardTextArea = new JTextArea();
		blackboardTextArea.setBackground(Color.BLACK);
		blackboardTextArea.setForeground(Color.WHITE);
		blackboardTextArea.setMargin(new Insets(10, 10, 10, 10));
		
		getContentPane().add(blackboardTextArea, BorderLayout.CENTER);
		
		statusLabel = new JLabel();
		statusLabel.setHorizontalAlignment(JLabel.CENTER);
		statusLabel.setBackground(SystemColor.controlHighlight);
		statusLabel.setFont(new JTextField().getFont());
		statusLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(statusLabel, BorderLayout.NORTH);
		
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new BorderLayout());
		getContentPane().add(commandPanel, BorderLayout.SOUTH);
		
		commandTextField = new JTextField();
		commandTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 10) {
					executeButtonPressed();
				}
			}
		});
		
		commandPanel.add(commandTextField, BorderLayout.CENTER);
		
		executeCommandButton = new JButton("Execute");
		executeCommandButton.addActionListener(this);
		undoButton = new JButton("Undo");
		undoButton.addActionListener(this);
		redoButton = new JButton("Redo");
		redoButton.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(executeCommandButton);
		buttonPanel.add(undoButton);
		buttonPanel.add(redoButton);
		
		commandPanel.add(buttonPanel, BorderLayout.EAST);
		
		this.setSize(600, 400);
		this.setLocation(250, 250);
		this.setVisible(true);
		commandTextField.requestFocus();
		this.setTitle("Blackboard.app");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == executeCommandButton) executeButtonPressed();
		else if (arg0.getSource() == undoButton) undoButtonPressed();
		else if (arg0.getSource() == redoButton) redoButtonPressed();
	}
	
}

