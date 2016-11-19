package sepr.patterns.commandstack;

import sepr.patterns.Blackboard;

public class CommandStackWorkbench {
	
	public static void main(String[] args) {
		
		Blackboard blackboard = new Blackboard();
		CommandStack stack = new CommandStack();
		
		System.err.println("Can undo = " + stack.canUndo());
		
		stack.execute(new AppendToBlackboardCommand(blackboard, "a"));
		stack.execute(new AppendToBlackboardCommand(blackboard, "b"));
		stack.execute(new AppendToBlackboardCommand(blackboard, "c"));
		
		System.err.println("Can undo = " + stack.canUndo());
		
		stack.undo();
		stack.redo();
		
		stack.execute(new ClearBlackboardCommand(blackboard));
		
		System.err.println(stack.canUndo());
		
		stack.undo();
		
		System.err.println(blackboard.getText());
	}
	
}
