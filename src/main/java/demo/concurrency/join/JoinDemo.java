package demo.concurrency.join;

public class JoinDemo {

	public static void main(String[] args) {
		Sleeper sleeper = new Sleeper("Sleeper", 1500);
		Sleeper grumpy = new Sleeper("Grumpy", 1500);
		
		Joiner dopey = new Joiner("Dopey", sleeper);
		Joiner doc = new Joiner("Doc", grumpy);
		
		grumpy.interrupt();
		
	}
}
