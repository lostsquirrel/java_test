package test.v8.dsiface.ext;

public enum Rank {
	DEUCE(2, "Two"), 
	THREE(3, "Three"), 
	FOUR(4, "Four"), 
	FIVE(5, "Five"), 
	SIX(6, "Six"), 
	SEVEN(7, "Seven"), 
	EIGHT(8, "Eight"), 
	NINE(9, "Nine"), 
	TEN(10, "Ten"), 
	JACK(11, "Jack"), 
	QUEEN(12, "Queen"), 
	KING(13, "King"), 
	ACE(14, "Ace");
	private final int value;
	private final String text;

	Rank(int value, String text) {
		this.value = value;
		this.text = text;
	}

	public int value() {
		return value;
	}

	public String text() {
		return text;
	}
}
