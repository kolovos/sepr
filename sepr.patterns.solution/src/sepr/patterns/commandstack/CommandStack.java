package sepr.patterns.commandstack;

import java.util.ArrayList;
import java.util.List;

public class CommandStack {
	
	protected List<Command> stack = new ArrayList<Command>();
	protected int stackPointer = 0;
	
	public void execute(Command command) {
		stack = stack.subList(0, stackPointer);
		command.execute();
		stack.add(command);
		stackPointer++;
	}
	
	public void undo() {
		stackPointer--;
		stack.get(stackPointer).undo();
	}
	
	public boolean canUndo() {
		return stackPointer > 0;
	}
	
	public void redo() {
		stack.get(stackPointer).execute();
		stackPointer++;
	}
	
	public boolean canRedo() {
		return stackPointer < stack.size();
	}
	
}
