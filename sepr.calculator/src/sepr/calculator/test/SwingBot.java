package sepr.calculator.test;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextField;

public class SwingBot {
	
	protected Container root = null;
	
	public SwingBot(Container root) {
		this.root = root;
	}
	
	public void click(String... buttonLabels) {
		for (String buttonLabel : buttonLabels) {
			JButton button = findButton(buttonLabel, root);
			button.doClick();
		}
	}
	
	public JTextField getTextField() {
		return findTextField(root);
	}
	
	protected JTextField findTextField(Container root) {
		for (Component component : root.getComponents()) {
			if (component instanceof JTextField) {
				return (JTextField) component;
			}
			else if (component instanceof Container){
				JTextField textField = findTextField((Container) component);
				if (textField != null) return textField;
			}
		}
		
		return null;
	}
	
	protected JButton findButton(String label, Container root) {
		
		for (Component component : root.getComponents()) {
			if (component instanceof JButton && ((JButton) component).getText().equals(label)) {
				return (JButton) component;
			}
			else if (component instanceof Container){
				JButton button = findButton(label, (Container) component);
				if (button != null) return button;
			}
		}
		
		return null;
		
	}
	
}
