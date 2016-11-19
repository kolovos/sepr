package sepr.calculator.refactored;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class CalculatorButton extends JButton {
	
	protected RefactoredCalculator calculator = null;
	
	public CalculatorButton(String text, RefactoredCalculator calculator) {
		this.calculator = calculator;
		this.setText(text);
		setupActionListener();
	}
	
	private void setupActionListener() {
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClick();
			}
		});
	}
	
	protected abstract void onClick();
	
}
