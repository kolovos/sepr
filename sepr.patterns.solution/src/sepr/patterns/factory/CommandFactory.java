package sepr.patterns.factory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import sepr.patterns.Blackboard;
import sepr.patterns.commandstack.WriteToBlackboardCommand;
import sepr.patterns.commandstack.ClearBlackboardCommand;
import sepr.patterns.commandstack.Command;

public class CommandFactory {
	
	public Command createCommand(Blackboard blackboard, String text) {
		
		if (text.equals("clear")) {
			return new ClearBlackboardCommand(blackboard);
		}
		else if (text.equals("time")) {
			return new WriteToBlackboardCommand(blackboard, LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
		}
		else if (text.equals("smile")) {
			return new WriteToBlackboardCommand(blackboard, ":)\n");
		}
		else if (text.equals("cry")) {
			return new WriteToBlackboardCommand(blackboard, ":'(\n");
		}
		else if (text.startsWith("write ")) {
			return new WriteToBlackboardCommand(blackboard, text.substring(6) + "\n");
		}
		else {
			return new WriteToBlackboardCommand(blackboard, "Unknown command: " + text + "\n");
		}
		
	}
	
}
