package co.whitejack.games.poker;

import java.util.List;

import co.whitejack.api.Dealer;
import co.whitejack.api.GameTable;
import co.whitejack.api.User;

public class PokerGameTable extends GameTable<PokerGame> {

	protected PokerGameTable(Dealer dealer, List users) {
		super(dealer, users);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setupTable() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void getCard() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void shuffle() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void removePlayer(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean play(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void startGame() {
		// TODO Auto-generated method stub

	}

}
