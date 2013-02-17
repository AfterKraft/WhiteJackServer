package co.whitejack.games.poker;

import java.util.List;

import co.whitejack.api.Dealer;
import co.whitejack.api.GameFactory;
import co.whitejack.api.User;

public class PokerFactory implements GameFactory<PokerGame,PokerGameTable> {

	@Override
	public PokerGameTable createTable(Dealer dealer, List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PokerGame createGame() {
		// TODO Auto-generated method stub
		return null;
	}

}
