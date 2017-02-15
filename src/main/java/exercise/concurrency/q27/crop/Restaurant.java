package exercise.concurrency.q27.crop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {

	public Meal meal;
	public ExecutorService exec = Executors.newCachedThreadPool();
	public Chef chef = new Chef(this);
	public Waiter waiter = new Waiter(this);
	
	public Restaurant() {
		exec.execute(chef);
		exec.execute(waiter);
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}

}
