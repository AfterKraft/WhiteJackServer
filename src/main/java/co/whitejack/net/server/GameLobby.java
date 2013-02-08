package co.whitejack.net.server;

import java.util.HashMap;
import java.util.List;

import co.whitejack.api.Game;
import co.whitejack.api.GameMaker;
import co.whitejack.api.GameTable;
import co.whitejack.api.User;
import co.whitejack.games.blackjack.BlackJackFactory;
import co.whitejack.games.blackjack.BlackJackGame;
import co.whitejack.games.blackjack.BlackJackGameTable;
import co.whitejack.games.gofish.GoFishFactory;
import co.whitejack.games.gofish.GoFishGame;
import co.whitejack.games.gofish.GoFishGameTable;


public class GameLobby {
	
	// Make the BlackJack Defined GameMaker
	protected GameMaker<BlackJackGame, BlackJackGameTable, BlackJackFactory> blackjackGameMaker;
	// Make the GoFish defined GameMaker
	protected GameMaker<GoFishGame, GoFishGameTable, GoFishFactory> gofishGameMaker;
	
	// Maximum number of GameTables allowed on server
	private int numOfTables;
	
	// A Map of tables to use for Lobby display and user placement
	private HashMap<GameTable<? extends Game>, List<User>> mapOfTables;
	
	/**
	 * Sets up the Lobby for the Server, containing the map of tables
	 * of all game types (thanks to generics)
	 */
	public void setup() {
		
		for(int i=0; i>=numOfTables; i++){
			blackjackGameMaker = new GameMaker<BlackJackGame, BlackJackGameTable, BlackJackFactory>(4);
			mapOfTables.put(blackjackGameMaker.getGameTable(), blackjackGameMaker.getGameTable().getUsers());
		}

		
	}
	
	/**
	 * Sets the maximum number of Tables allowed in this game lobby
	 * instance
	 */
	public void setNumOfTables(int num) {
		this.numOfTables = num;
	}

	/**
	 * Returns the set number of Tables allowed in this game lobby
	 * instance
	 * @return
	 */
	public int getNumOfTables() {
		return numOfTables;
	}
}
