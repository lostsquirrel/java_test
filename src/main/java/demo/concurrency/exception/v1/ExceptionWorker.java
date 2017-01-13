package demo.concurrency.exception.v1;

public class ExceptionWorker implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
