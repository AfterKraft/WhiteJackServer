package com.whitejack.games.gofish;

import com.whitejack.api.*;
import java.util.Scanner;

public class GoFish extends Game {

	public Dealer dealer;
	public Deck deck;
	public User user;
	public boolean stand,bust;
	public boolean GameOver;

	public GoFish(Dealer dealer, Deck deck, User user) {
		this.dealer = dealer;
		this.deck = deck;
		this.user = user;
	}

	public void start() {

		Scanner input = new Scanner(System.in);

		if(deck.isShuffled != true) {
			//deck.shuffle();
		}

//		dealer.recieveCard(deck);
//		user.recieveCard(deck);

		while(!GameOver) {
			System.out.println("Please ask the dealer for a card.");
			int request = input.nextInt();
			if(dealer.getHandValue() == request) {
				System.out.println("You guessed!");
				GameOver = true;
			} else {
				System.out.println("Go fish!");
				GameOver = true;
			}
		}
	}

}
