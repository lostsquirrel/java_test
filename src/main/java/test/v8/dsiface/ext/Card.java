package test.v8.dsiface.ext;

public interface Card extends Comparable<Card> {
	public Suit getSuit();
    public Rank getRank();
}
