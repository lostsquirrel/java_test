package demo.v8.dsiface.ext;

import java.util.Comparator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Play {

	private static final Logger logger = LoggerFactory.getLogger(Play.class);
	
	@Test
	public void playA() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		logger.debug(myDeck.deckToString());
		myDeck.shuffle();
		logger.debug(myDeck.deckToString());
		myDeck.sort(new SortByRankThenSuit());
		logger.debug(myDeck.deckToString());
	}

	@Test
	public void playB() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort((firstCard, secondCard) -> firstCard.getRank().value() - secondCard.getRank().value());
		logger.debug(myDeck.deckToString());
	}

	@Test
	public void playC() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing((card) -> card.getRank()));
		logger.debug(myDeck.deckToString());
	}

	@Test
	public void playD() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing(Card::getRank));
		logger.debug(myDeck.deckToString());
	}

//	Rand + Site
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
		
		logger.debug(myDeck.deckToString());
	}

//	Rank + Suit
	@Test
	public void playF() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing(Card::getRank).thenComparing(Comparator.comparing(Card::getSuit)));
		logger.debug(myDeck.deckToString());
	}

//	Rand + r + Suit
	@Test
	public void playG() throws Exception {
		StandardDeck myDeck = new StandardDeck();
		myDeck.shuffle();
		myDeck.sort(Comparator.comparing(Card::getRank).reversed().thenComparing(Comparator.comparing(Card::getSuit)));
		logger.debug(myDeck.deckToString());
	}

}
