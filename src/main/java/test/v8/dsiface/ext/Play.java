package test.v8.dsiface.ext;

import java.util.Comparator;

import org.junit.Test;

public class Play {

	@Test
	public void playA() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(new SortByRankThenSuit());
	}

	@Test
	public void playB() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort((firstCard, secondCard) -> firstCard.getRank().value() - secondCard.getRank().value());
	}

	@Test
	public void playC() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing((card) -> card.getRank()));
	}

	@Test
	public void playD() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing(Card::getRank));
	}

	@Test
	public void playE() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort((firstCard, secondCard) -> {
			int compare = firstCard.getRank().value() - secondCard.getRank().value();
			if (compare != 0)
				return compare;
			else
				return firstCard.getSuit().value() - secondCard.getSuit().value();
		});
	}

	@Test
	public void playF() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing(Card::getRank).thenComparing(Comparator.comparing(Card::getSuit)));
	}

	@Test
	public void playG() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing(Card::getRank).reversed().thenComparing(Comparator.comparing(Card::getSuit)));
	}

}
