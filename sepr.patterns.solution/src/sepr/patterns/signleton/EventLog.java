package sepr.patterns.signleton;

public class EventLog {
	
	private static EventLog instance = null;
	
	public static EventLog getInstance() {
		if (instance == null) {
			instance = new EventLog();
		}
		return instance;
	}
	
	public void log(String str) {
		System.out.println("LOG: " + str);
	}
	
}
