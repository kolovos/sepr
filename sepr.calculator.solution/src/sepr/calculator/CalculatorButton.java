package sepr.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public abstract class CalculatorButton extends JButton {
	
	protected Calculator calculator = null;
	
	public CalculatorButton(String text, Calculator calculator) {
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
