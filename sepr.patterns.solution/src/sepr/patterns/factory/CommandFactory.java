package sepr.patterns.factory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import sepr.patterns.Blackboard;
import sepr.patterns.commandstack.AppendToBlackboardCommand;
import sepr.patterns.commandstack.ClearBlackboardCommand;
import sepr.patterns.commandstack.Command;

public class CommandFactory {
	
	public Command createCommand(Blackboard blackboard, String text) {
		
		if (text.equals("clear")) {
			return new ClearBlackboardCommand(blackboard);
		}
		else if (text.startsWith("section ")) {
			return new AppendToBlackboardCommand(blackboard, text.substring(8) + "\n" + "---\n");
		}
		else if (text.startsWith("write ")) {
			return new AppendToBlackboardCommand(blackboard, text.substring(6) + "\n");
		}
		else if (text.startsWith("newline")) {
			return new AppendToBlackboardCommand(blackboard, "\n");
		}
		else {
			return new AppendToBlackboardCommand(blackboard, "Unknown command: " + text + "\n");
		}
		
	}
	
}
