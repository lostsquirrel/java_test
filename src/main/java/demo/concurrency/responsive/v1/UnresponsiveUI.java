package demo.concurrency.responsive.v1;

import java.io.IOException;

import demo.concurrency.util.ComplexWorker;

public class UnresponsiveUI {

	public UnresponsiveUI() throws IOException {
		new ComplexWorker().infiniteWorker();
		System.in.read(); // 死循环就是这么写的
	}
}
