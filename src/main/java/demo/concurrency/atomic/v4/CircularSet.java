package demo.concurrency.atomic.v4;

public class CircularSet {

	private int[] data;
	
	private int len;
	
	private int index = 0;
	
	public CircularSet(int size) {
		data = new int[size];
		len = size;
		for (int i = 0; i < size; i++) {
			data[i] = -1;
		}
	}
	
	public synchronized void add(int v) {
		data[index] = v;
		index = ++index % len;
	}
	
	public synchronized boolean contains(int v) {
		boolean isContains = false;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == v) {
				isContains = true;
				break;
			}
		}
		
		return isContains;
	}
}
