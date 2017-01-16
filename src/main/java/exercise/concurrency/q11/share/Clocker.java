package exercise.concurrency.q11.share;

public class Clocker {

	private boolean isDayFinished = false;
	
	private int hour = 0;
	
	private int minute = 0;
	
	public void tick() {
		if (this.hour == 23 && this.minute == 59) {
			this.isDayFinished = true;
		}
		if (this.minute == 59) {
			this.minute = 0;
			if (this.hour == 23) {
				this.hour = 0;
			} else {
				this.hour++;
			}
		} else {
			this.minute++;
		}
	}

	public boolean isDayFinished() {
		return isDayFinished;
	}

	@Override
	public String toString() {
		return String.format("now is %2d:%2d", this.hour, this.minute);
	}
	
	
}
