package cards;

import java.util.Arrays;
import java.util.Collections;

public class Deck {
	private Card[] cards;

	public Deck() {
		cards = new Card[52];
		String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
		for (int suit = 1; suit <= 4; suit++) {
			for (int number = 1; number <= 13; number++) {
				cards[(suit - 1) * 13 + (number - 1)] = new Card(number, suits[suit - 1]);
			}
		}
	}

	public void ShuffleDeck() {
		Collections.shuffle(Arrays.asList(cards));
	}

	/** Returns the first card from the deck and removes it from the deck */
	public Card draw() {
		for (int i = 0; true; i++) {
			if (cards[i] != null) {
				Card temp = cards[i];
				cards[i] = null;
				return temp;
			}
		}
	}

	/** Returns a random card from the deck and removes it from the deck */
	public Card randomDraw() {
		while (true) {
			int i = (int) (Math.random() * cards.length);
			if (cards[i] != null) {
				Card temp = cards[i];
				cards[i] = null;
				return temp;
			}
		}
	}
	/**
	 * Returns a random card from the deck without removing it from the deck
	 */
	public Card selectRandom() {
		while (true) {
			int i = (int) (Math.random() * cards.length);
			if (cards[i] != null) {
				return cards[i];
			}
		}
	}

	/**
	 * Returns the first card from the deck without removing it from the deck
	 */
	public Card select() {
		for (int i = 0; true; i++) {
			if (cards[i] != null) {
				return cards[i];
			}
		}
	}

	public static void main(String[] args) {
		Deck deck = new Deck();
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.println(deck.cards[i]);
		}
		System.out.println();
		deck.ShuffleDeck();
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.println(deck.cards[i]);
		}
	}
}
