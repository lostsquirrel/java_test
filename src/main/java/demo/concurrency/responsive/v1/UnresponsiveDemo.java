package demo.concurrency.responsive.v1;

import java.io.IOException;

public class UnresponsiveDemo {

	public static void main(String[] args) {
		try {
			new UnresponsiveUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
