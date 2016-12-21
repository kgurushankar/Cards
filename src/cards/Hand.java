package cards;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards = new ArrayList<Card>();

	public Hand() {
	}

	public Card[] toArray() {
		Card[] out = new Card[cards.size()];
		for (int i = 0; i < cards.size(); i++) {
			out[i] = cards.get(i);
		}
		return out;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void clearHand() {
		for (int i = 0; i < cards.size(); i++) {
			cards.remove(i);
		}
	}

	public void removeCard(Card card) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals(card)) {
				cards.remove(i);
				return;
			}
		}
	}

	public int numOfCards() {
		return cards.size();
	}
}
