package test.v8.dsiface.ext;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StandardDeck implements Deck {

	private List<Card> entireDeck;
	
	public void sort() {
        Collections.sort(entireDeck);
    }

	public void sort(Comparator<Card> c) {
	    Collections.sort(entireDeck, c);
	}  
	
	@Override
	public List<Card> getCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deck deckFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCard(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCards(List<Card> cards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDeck(Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deckToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
