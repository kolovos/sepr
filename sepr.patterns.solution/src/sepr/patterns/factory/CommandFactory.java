package sepr.patterns.factory;

import sepr.patterns.Blackboard;
import sepr.patterns.commandstack.AppendToBlackboardCommand;
import sepr.patterns.commandstack.ClearBlackboardCommand;
import sepr.patterns.commandstack.Command;

public class CommandFactory {
	
	public Command createCommand(Blackboard blackboard, String text) {
		
		if (text.equals("clear")) {
			return new ClearBlackboardCommand(blackboard);
		}
		else if (text.equals("smile")) {
			return new AppendToBlackboardCommand(blackboard, ":)\n");
		}
		else if (text.equals("cry")) {
			return new AppendToBlackboardCommand(blackboard, ":'(\n");
		}
		else if (text.startsWith("say ")) {
			return new AppendToBlackboardCommand(blackboard, text.substring(4) + "\n");
		}
		else {
			return new AppendToBlackboardCommand(blackboard, "Unknown command: " + text + "\n");
		}
		
	}
	
}
