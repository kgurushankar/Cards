package com.kgurushankar.cards.games.blackjack;

import java.util.Scanner;

import com.kgurushankar.cards.*;

public class SinglePlayerCLI {
	private Hand dealer, player;
	private Deck deck;
	Scanner in;

	public SinglePlayerCLI() {
		deck = new Deck();
		deck.ShuffleDeck();
		dealer = new Hand();
		player = new Hand();
		in = new Scanner(System.in);

	}

	public static void main(String[] args) {
		SinglePlayerCLI game = new SinglePlayerCLI();
		String user = "y";
		while (user.equals("y")) {
			game.runGame();
			System.out.print("Play Again? (y/n)");
			user = game.in.nextLine();
			if (user.equals("y")) {
				game.reset();
			}
		}
		System.out.println();
		System.out.println("Bye!");
	}

	public void reset() {
		deck = new Deck();
		deck.ShuffleDeck();
		dealer = new Hand();
		player = new Hand();
		System.out.println();
		System.out.println("Game Resetting...");
		System.out.println();
	}

	public void runGame() {
		// autodraws four cards
		draw(0); // dealer
		draw(0); // dealer
		draw(1); // player
		draw(1); // player

		// initial prints
		PrintHand(0); // dealer
		PrintHand(1); // player
		System.out.println(); // adds an extra line in between for readability
		// Player plays
		boolean ask = true;
		while (ask) {
			ask = StayHit();
		}

		// dealer draws until dealer is over 17
		while (sum(dealer) < 17 && sum(player) <= 21) {
			draw(0);
		}

		System.out.println(); // adds an extra line in between for
								// readability
		System.out.println("Final hands:");
		PrintHand(0);
		PrintHand(1);

		System.out.println();
		if (sum(player) > 21) {
			System.out.println("Dealer Wins!");
		} else if (sum(dealer) > 21) {
			System.out.println("Player Wins!");
		} else if (sum(player) == (sum(dealer))) {
			System.out.println("Draw!");
		} else if (Math.abs(sum(player) - 21) > Math.abs(sum(dealer) - 21)) {
			System.out.println("Dealer Wins!");
		} else {
			System.out.println("Player Wins!");
		}

		/*
		 * if (sum(dealer)>21){
		 * System.out.println("You Win! Dealer has gone bust!"); }
		 */

	}

	/**
	 * draws a card for a player 0 for dealer; 1 for player
	 */
	private void draw(int person) {
		if (person == 0) {
			dealer.addCard(deck.draw());
			return;
		} else if (person == 1) {
			player.addCard(deck.draw());
			return;
		}
	}

	/** returns the value of an integer array representing cards in blackjack */
	private int sum(Card[] arr) {
		int out = 0;
		for (int i = 0; i < (arr.length); i++) {
			if (arr[i].getRawValue() > 1 && arr[i].getRawValue() < 11) {
				out += arr[i].getRawValue();
			} else if (arr[i].getRawValue() >= 11) {
				out += 10;
			} else if (arr[i].getRawValue() == 1) {
				if (out <= 10) {
					out += 11;
				} else {
					out += 1;
				}
			} else {
				out += 0;
			}
		}
		return out;
	}

	private int sum(Hand player) {
		return sum(player.toArray());
	}

	/**
	 * Asks if the player would like to hit or stay boolean returned represents
	 * if the player would like to continue or not
	 */
	private boolean StayHit() {
		try {
			// bust condition
			if (sum(player.toArray()) > 21) {
				System.out.println("Your cards have a value greater than 21!");
				System.out.println("You have gone bust!");
				return false;
			}

			System.out.println("Stay or Hit?");
			String a = in.nextLine().toLowerCase();
			// checks input
			if (a.equals("stay")) {
				return false;
			} else if (a.equals("hit")) {
				draw(1);
				PrintHand(1);
				return true;
			} else {
				// if input is bad
				throw new Exception();
			}
		} catch (Exception e) {
			// what happens if input is bad or exception occurs
			System.out.println("Please enter valid input!");
			return StayHit();
		}
	}

	/**
	 * Prints the hand of the specified player 0 for dealer; 1 for player
	 */
	private void PrintHand(int person) {
		Card[] dealer = this.dealer.toArray();
		Card[] player = this.player.toArray();
		if (person == 0) {
			System.out.print("Dealer: ");
			// both the dealer and player arrays are being checked to make sure
			// that the hand is presented nicely. (the total shows up in the
			// same spot)
			for (int i = 0; i < this.dealer.numOfCards() || i < this.player.numOfCards(); i++) {
				if (i < this.dealer.numOfCards()) {
					System.out.print(dealer[i] + " ");
					printSpaces(dealer[i].toString());

				} else {
					printSpaces("");
				}

			}
			System.out.println("Total = " + sum(dealer));
		} else if (person == 1) {
			System.out.print("Player: ");
			for (int i = 0; i < this.dealer.numOfCards() || i < this.player.numOfCards(); i++) {
				if (i < this.player.numOfCards()) {
					System.out.print(player[i] + " ");
					printSpaces(player[i].toString());
				} else {
					printSpaces("");
				}
			}
			System.out.println("Total = " + sum(player));
		}
	}

	private void printSpaces(String str) {
		int wordSize = 17; // longest number is 5, + 4 for the " of ", and 8
							// more for "diamonds"
		for (int i = str.length(); i < wordSize; i++) {
			System.out.print(" ");
		}
	}

}
