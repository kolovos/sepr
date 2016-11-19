package sepr.patterns;

import java.util.ArrayList;

import sepr.patterns.listener.BlackboardListener;



public class Blackboard {
	
	protected String text = "";
	
	public Blackboard() {}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
		for (BlackboardListener listener : listeners) {
			listener.textChanged(text);
		}
	}
	
	protected ArrayList<BlackboardListener> listeners = new ArrayList<BlackboardListener>();
	
	public void addBlackboardListener(BlackboardListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeBlackboardListener(BlackboardListener listener) {
		this.listeners.remove(listener);
	}
	
}
