package exercise.concurrency.q26.crop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.concurrency.corp.v2.Meal;

/**
 * @author lisong
 * 有问题，需要修改
 */
public class Restaurant {

	public Meal meal;
	public ExecutorService exec = Executors.newCachedThreadPool();
	public Chef chef = new Chef(this);
	public Waiter waiter = new Waiter(this);
	public BusyBoy bb = new BusyBoy(this);
	
	public Restaurant() {
		exec.execute(chef);
		exec.execute(waiter);
		exec.execute(bb);
	}
	
	public static void main(String[] args) {
		new Restaurant();
	}

}
