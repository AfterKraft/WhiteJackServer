package co.whitejack.net.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.whitejack.api.Game;
import co.whitejack.api.GameFactory;
import co.whitejack.api.GameMaker;
import co.whitejack.api.GameTable;
import co.whitejack.api.User;
import co.whitejack.games.blackjack.BlackJackFactory;
import co.whitejack.games.blackjack.BlackJackGame;
import co.whitejack.games.blackjack.BlackJackGameTable;
import co.whitejack.games.gofish.GoFishFactory;
import co.whitejack.games.gofish.GoFishGame;
import co.whitejack.games.gofish.GoFishGameTable;
import co.whitejack.games.poker.PokerFactory;
import co.whitejack.games.poker.PokerGame;
import co.whitejack.games.poker.PokerGameTable;

public class GameLobby {

	// Make the BlackJack Defined GameMaker
	protected GameMaker<BlackJackGame, BlackJackGameTable, BlackJackFactory> blackjackGameMaker;
	// Make the GoFish defined GameMaker
	protected GameMaker<GoFishGame, GoFishGameTable, GoFishFactory> gofishGameMaker;
	// Make the Poker defined GameMaker
	protected GameMaker<PokerGame, PokerGameTable, PokerFactory> pokerGameMaker;

	protected List<GameMaker<? extends Game, ? extends GameTable<? extends Game>, ? extends GameFactory<? extends Game, ? extends GameTable<? extends Game>>>> gameMakers;

	// Maximum number of GameTables allowed on server
	private int numOfTables;

	// A Map of tables to use for Lobby display and user placement
	private HashMap<GameTable<? extends Game>, List<User>> mapOfTables;

	/**
	 * Sets up the Lobby for the Server, containing the map of tables of all
	 * game types (thanks to generics)
	 */
	public void setup() {
		blackjackGameMaker = new GameMaker<BlackJackGame, BlackJackGameTable, BlackJackFactory>(4);
		gofishGameMaker = new GameMaker<GoFishGame, GoFishGameTable, GoFishFactory>(1);
		pokerGameMaker = new GameMaker<PokerGame, PokerGameTable, PokerFactory>(1);

		gameMakers.add(blackjackGameMaker);
		gameMakers.add(gofishGameMaker);
		gameMakers.add(pokerGameMaker);
		addTables(gameMakers);
		setupTables(mapOfTables);
	}

	/**
	 * Adds a GameTable<? extends Game> to the map of tables.
	 * Holy Generics Batman. 
	 * 
	 * @param gameMakers
	 */
	private void addTables(
			List<GameMaker<? extends Game, ? extends GameTable<? extends Game>, ? extends GameFactory<? extends Game, ? extends GameTable<? extends Game>>>> gameMakers) {
		for (GameMaker<? extends Game, ? extends GameTable<? extends Game>, ? extends GameFactory<? extends Game, ? extends GameTable<? extends Game>>> gameMaker : gameMakers) {
			mapOfTables.put(gameMaker.getGameTable(), gameMaker.getGameTable().getUsers());
		}
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the maximum number of Tables allowed in this game lobby instance
	 */
	public void setNumOfTables(int num) {
		this.numOfTables = num;
	}

	/**
	 * Returns the set number of Tables allowed in this game lobby instance
	 * 
	 * @return
	 */
	public int getNumOfTables() {
		return numOfTables;
	}

	/**
	 * Returns the map of Tables 
	 */
	public HashMap<GameTable<? extends Game>, List<User>> getTables() {
		return mapOfTables;
	}
}
