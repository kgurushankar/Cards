package cards;

public class Card {
	private int number;
	private int suit;

	public Card(int number, String suit) {
		if (number > 0 && number < 14) {
			this.number = number;
		}
		if (suit.equals("Spades")) {
			this.suit = 1;
		} else if (suit.equals("Hearts")) {
			this.suit = 2;
		} else if (suit.equals("Clubs")) {
			this.suit = 3;
		} else if (suit.equals("Diamonds")) {
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
			}
		}

		if (read[2].equals("Spades")) {
			this.suit = 1;
		} else if (read[2].equals("Hearts")) {
			this.suit = 2;
		} else if (read[2].equals("Clubs")) {
			this.suit = 3;
		} else if (read[2].equals("Diamonds")) {
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
			return "Ace";
		} else if (number == 11) {
			return "Jack";
		} else if (number == 12) {
			return "Queen";
		} else if (number == 13) {
			return "King";
		} else {
			return "Error";
		}
	}

	public int getRawValue() {
		return number;
	}

	public String getSuit() {
		switch (suit) {
		case (1): {
			return "Spades";
		}
		case (2): {
			return "Hearts";
		}
		case (3): {
			return "Clubs";
		}
		case (4): {
			return "Diamonds";
		}
		default: {
			return "Error";
		}
		}
	}

	public int getRawSuit() {
		return suit;
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

	private void checkValue() {
		if (this.number == 0) {
			this.number = (int) (Math.random() * 13) + 1;
		}
		if (this.suit == 0) {
			this.suit = (int) (Math.random() * 4) + 1;
		}
	}

}
