package minderaExercices.guessingGame;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Timer {
	private ScheduledExecutorService scheduler;
	GameScanner currentGameScanner;
	private boolean timeUp = false;

	public Timer(GameScanner gameScanner) {
		this.currentGameScanner = gameScanner;

	}

	public void startTimer() {
		//need to create a new timer each user round otherwise i will betrying access previous timer that has been
		// shutdown

		scheduler = Executors.newScheduledThreadPool(1);

		scheduler.schedule(() -> {
			if (currentGameScanner.getUserFinalChoice() == 0) {
				timeUp = true;
			}
			stopTimer();
		}, 3, TimeUnit.SECONDS);
	}

	public boolean isTimeUp() {
		return timeUp;
	}

	public void resetTimer() {
		timeUp = false;
	}

	public void stopTimer() {
		scheduler.shutdown();
	}
}
