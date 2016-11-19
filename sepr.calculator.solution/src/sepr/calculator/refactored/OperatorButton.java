package sepr.calculator.refactored;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButton extends CalculatorButton {
	
	protected String symbol;
	
	public OperatorButton(String symbol, RefactoredCalculator calculator) {
		super(symbol, calculator);
		this.symbol = symbol;
	}
	
	protected void onClick() {
				
		if (calculator.isOperator()) {
			calculator.setLastOperator(symbol);
			return;
		}
		else {
			calculator.setOperator(true);
		}
		
		String lastOperator = calculator.getLastOperator();
		
		if (lastOperator != null) {
			if (lastOperator.equals("+")) {
				calculator.setTotal(calculator.getTotal() + getDisplayValue());	
			}
			else if (lastOperator.equals("-")) {
				calculator.setTotal(calculator.getTotal() - getDisplayValue());						
			}
			calculator.getDisplay().setText(calculator.getTotal() + "");
		}
		else {
			calculator.setTotal(getDisplayValue());
		}
		
		if (symbol.equals("=")) {
			calculator.setLastOperator(null);
		}
		else {
			calculator.setLastOperator(symbol);
		}
	}
	
	private int getDisplayValue() {
		return Integer.parseInt(calculator.getDisplay().getText());
	}
	
}
