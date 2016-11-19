package sepr.patterns;

import java.util.ArrayList;

public class Blackboard {
	
	protected String text = "";
	
	public Blackboard() {}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
		
	}
	
}
