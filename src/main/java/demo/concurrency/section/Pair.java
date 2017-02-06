package demo.concurrency.section;

/**
 * @author lisong
 * 要保证x 与 y 始终相等，所以此类线程不安全
 */
public class Pair {

	private int x;
	
	private int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void incrementX() {
		x++;
	}
	
	public void incrementY() {
		y++;
	}
	
	public void checkState() {
		if (x != y) {
			throw new PairValuesNotEqualException(this);
		}
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
	
}
