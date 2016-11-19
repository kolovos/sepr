package sepr.calculator.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sepr.calculator.Calculator;

public class CalculatorTestCase {

	protected SwingBot bot = null;
	
	@Before
	public void createBot() {
		bot = new SwingBot(new Calculator());
	}
	
	@Test
	public void testAddition() {
		bot.click("1", "+", "2", "=");
		assertEquals(bot.getTextField().getText(), "3");
	}
	
	@Test
	public void testSubtraction() {
		bot.click("3", "-", "2", "=");
		assertEquals(bot.getTextField().getText(), "1");
		
	}
	
}
