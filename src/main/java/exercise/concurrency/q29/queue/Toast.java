package exercise.concurrency.q29.queue;

public class Toast {

	public enum Status {DRY, PEANUT, JELLY, BUTTERED, JAMMED};
	
	private Status status = Status.DRY;
	
	private final int id;

	public Toast(int id) {
		this.id = id;
	}
	
	public void peanut() {
		status = Status.PEANUT;
	}
	
	public void jelly() {
		status = Status.JELLY;
	}
	
	public void butter() {
		status = Status.BUTTERED;
	}
	
	public void jam() {
		status = Status.JAMMED;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Toast [" + id + ":" + status + "]";
	}
	
}
