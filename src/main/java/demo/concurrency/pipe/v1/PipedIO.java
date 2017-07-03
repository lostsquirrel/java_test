package demo.concurrency.pipe.v1;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.util.SleepUtils;

public class PipedIO {
	public static void main(String[] args) throws IOException, InterruptedException {
		Sender s = new Sender();
		Reciver r = new Reciver(s);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(s);
		exec.execute(r);
		
		SleepUtils.sleepInSeconds(7);
		exec.shutdownNow();
	}
}
