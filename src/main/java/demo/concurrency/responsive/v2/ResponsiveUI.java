package demo.concurrency.responsive.v2;

import demo.concurrency.util.ComplexWorker;

public class ResponsiveUI extends Thread {

	public ResponsiveUI() {
		this.setDaemon(true);
		this.start();
	}

	@Override
	public void run() {
		new ComplexWorker().infiniteWorker();
	}
	
}
