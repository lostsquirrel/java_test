package exercise.concurrency.q18.sleep;

public class SleepWorker implements Runnable {

	@Override
	public void run() {
		new Sleeper().sleep();
	}

}
