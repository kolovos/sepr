package sepr.patterns.commandstack;

import sepr.patterns.Blackboard;

public class ClearBlackboardCommand implements Command {
	
	protected String previousText;
	protected Blackboard blackboard;
	
	public ClearBlackboardCommand(Blackboard blackboard) {
		this.blackboard = blackboard;
	}
	
	@Override
	public void execute() {
		this.previousText = blackboard.getText();
		 blackboard.setText("");
	}

	@Override
	public void undo() {
		blackboard.setText(previousText);
	}
	
}
