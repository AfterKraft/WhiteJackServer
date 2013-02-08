package co.whitejack.games.blackjack;

import java.util.List;

import co.whitejack.api.Dealer;
import co.whitejack.api.GameFactory;
import co.whitejack.api.User;

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
