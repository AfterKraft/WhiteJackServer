package com.whitejack.blackjack;

import java.util.List;

import com.whitejack.api.Dealer;
import com.whitejack.api.GameFactory;
import com.whitejack.api.User;

/**
 * BlackJackFactory
 * 
 * @author gabizou
 * 
 */

public class BlackJackFactory implements
		GameFactory<BlackJackGame, BlackJackGameTable> {

	@Override
	public BlackJackGameTable createTable(Dealer dealer, List<User> users) {
		return new BlackJackGameTable(dealer, users);
	}

	@Override
	public BlackJackGame createGame() {
		// TODO Auto-generated method stub
		return new BlackJackGame();
	}

}
