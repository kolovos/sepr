package sepr.calculator;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NumberButton extends CalculatorButton {
	
	protected int number;
	
	public NumberButton(int number, Calculator calculator) {
		super(number + "", calculator);
		this.number = number;
	}
	
	protected void onClick() {
		JTextField display = calculator.getDisplay();
		if (display.getText().equals("0") || calculator.isOperator()) {
			display.setText(number + "");
			calculator.setOperator(false);
		}
		else {
			display.setText(display.getText() + (number + ""));
		}
	}
	
}
