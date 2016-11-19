package sepr.patterns.facade;

import sepr.patterns.Blackboard;
import sepr.patterns.commandstack.CommandStack;
import sepr.patterns.factory.CommandFactory;
import sepr.patterns.listener.BlackboardListener;

public abstract class BlackboardFacade implements BlackboardListener {
	
	protected CommandStack commandStack;
	protected CommandFactory commandFactory;
	protected Blackboard blackboard;
	
	public BlackboardFacade() {
		this.commandStack = new CommandStack();
		this.commandFactory = new CommandFactory();
		this.blackboard = new Blackboard();
		blackboard.addBlackboardListener(this);
	}
	
	public void executeCommand(String text) {
		delay(3000);
		commandStack.execute(commandFactory.createCommand(blackboard, text));
	}
	
	public void undo() {
		if (commandStack.canUndo()) commandStack.undo();
	}
	
	public void redo() {
		if (commandStack.canRedo()) commandStack.redo();
	}
	
	public void delay(int ms) {
		long now = System.currentTimeMillis();
		while (System.currentTimeMillis() - now < ms) {
			
		}
	}
}
