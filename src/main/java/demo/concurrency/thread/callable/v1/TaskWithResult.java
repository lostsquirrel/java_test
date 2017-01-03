package demo.concurrency.thread.callable.v1;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {

	private int id;
	
	TaskWithResult(int id) {
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		return "result: " + id;
	}

}
