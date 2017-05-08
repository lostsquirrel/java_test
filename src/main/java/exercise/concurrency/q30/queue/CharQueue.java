package exercise.concurrency.q30.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class CharQueue extends ArrayBlockingQueue<Integer> {

	private static final long serialVersionUID = 1L;

	public CharQueue() {
		super(3);
	}

}
