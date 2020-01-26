package sepr.patterns.commandstack;

import sepr.patterns.Blackboard;

public class WriteToBlackboardCommand implements Command {
	
	protected String toAppend;
	protected Blackboard blackboard;
	
	public WriteToBlackboardCommand(Blackboard blackboard, String toAppend) {
		this.toAppend = toAppend;
		this.blackboard = blackboard;
	}
	
	@Override
	public void execute() {
		blackboard.setText(blackboard.getText() + toAppend);
	}

	@Override
	public void undo() {
		
		String blackboardText = blackboard.getText();
		
		blackboard.setText(
				blackboardText.substring(0, blackboardText.length() - toAppend.length()));
	}
	
}
