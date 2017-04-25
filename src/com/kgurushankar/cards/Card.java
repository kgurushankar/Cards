package com.kgurushankar.cards;

public class Card {
	private int number;
	private int suit;

	public Card(int number, String suit) {
		if (number > 0 && number < 14) {
			this.number = number;
		}
		if (suit.toLowerCase().equals("spades")) {
			this.suit = 1;
		} else if (suit.toLowerCase().equals("hearts")) {
			this.suit = 2;
		} else if (suit.toLowerCase().equals("clubs")) {
			this.suit = 3;
		} else if (suit.toLowerCase().equals("diamonds")) {
			this.suit = 4;
		}
		checkValue();

	}

	/** Will generate values randomly */
	public Card() {
		this.number = (int) (Math.random() * 13) + 1;
		this.suit = (int) (Math.random() * 4) + 1;

	}

	/**
	 * string should be in the form of "(number or face) of (suit)" e.g. Ace of
	 * spades. Case does not matter. Numbers (2-10) may be expressed either as
	 * numerals or as words.
	 */
	public Card(String string) {
		String[] read = string.toLowerCase().split(" ");
		if (!(read[1].equals("of"))) {
			this.number = (int) (Math.random() * 13) + 1;
			this.suit = (int) (Math.random() * 4) + 1;
			return;
		}
		String[] numbers = { "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack",
				"queen", "king" };
		for (int i = 1; i < 14; i++) {
			if (read[0].equals(String.valueOf(i)) || read[0].equals(numbers[i - 1])) {
				this.number = i;
				break;
			}
		}

		if (read[2].equals("spades")) {
			this.suit = 1;
		} else if (read[2].equals("hearts")) {
			this.suit = 2;
		} else if (read[2].equals("clubs")) {
			this.suit = 3;
		} else if (read[2].equals("diamonds")) {
			this.suit = 4;
		}

		if (this.number == 0) {
			this.number = (int) (Math.random() * 13) + 1;
		}
		if (this.suit == 0) {
			this.suit = (int) (Math.random() * 4) + 1;
		}
	}

	public String getValue() {
		if (number > 1 && number < 11) {
			return String.valueOf(number);
		} else if (number == 1) {
			return "ace";
		} else if (number == 11) {
			return "jack";
		} else if (number == 12) {
			return "queen";
		} else if (number == 13) {
			return "king";
		} else {
			return "Error";
		}
	}

	public String getSuit() {
		switch (suit) {
		case (1): {
			return "spades";
		}
		case (2): {
			return "hearts";
		}
		case (3): {
			return "clubs";
		}
		case (4): {
			return "diamonds";
		}
		default: {
			return "Error";
		}
		}
	}

	@Override
	public String toString() {
		String out = "";
		String[] numbers = { "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack",
				"queen", "king" };
		if (number > 0 && number < 14) {
			out += numbers[number - 1];
		} else {
			out += "Error";
		}
		out += " of ";
		out += getSuit();
		return out;

	}

	public String getColor() {
		if (this.suit % 2 == 0) {
			return "Red";
		} else {
			return "Black";
		}
	}

	public boolean equals(Card card) {
		return (this.suit == card.suit && this.number == card.suit);
	}

	public boolean sameSuit(Card card) {
		return (this.suit == card.suit);
	}

	public boolean sameValue(Card card) {
		return (this.number == card.suit);
	}

	private void checkValue() {
		if (this.number == 0) {
			this.number = (int) (Math.random() * 13) + 1;
		}
		if (this.suit == 0) {
			this.suit = (int) (Math.random() * 4) + 1;
		}
	}
	
	public int getRawValue(){
		return number;
	}

}
