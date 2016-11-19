package sepr.patterns.commandstack;

public interface Command {
	
	public void execute();
	
	public void undo();
	
}
