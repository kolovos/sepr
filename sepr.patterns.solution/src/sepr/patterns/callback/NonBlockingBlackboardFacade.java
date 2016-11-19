package sepr.patterns.callback;

import java.util.Timer;
import java.util.TimerTask;

import sepr.patterns.facade.BlackboardFacade;



public abstract class NonBlockingBlackboardFacade extends BlackboardFacade {
	
	public void executeCommand(final String text, final Callback callback) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				executeCommand(text);
				callback.finished();
			}
		};
		new Timer().schedule(timerTask, 0);
	}
	
}
