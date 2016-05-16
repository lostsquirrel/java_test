package test.v8.dsiface.ext;

public enum Suit {
	DIAMONDS(1, "Diamonds"), CLUBS(2, "Clubs"), HEARTS(3, "Hearts"), SPADES(4, "Spades");

	private final int value;
	private final String text;

	Suit(int value, String text) {
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
