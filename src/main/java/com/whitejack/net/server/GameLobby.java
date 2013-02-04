package com.whitejack.net.server;

import java.util.HashMap;
import java.util.List;

import com.whitejack.api.Game;
import com.whitejack.api.GameFactory;
import com.whitejack.api.GameMaker;
import com.whitejack.api.GameTable;
import com.whitejack.api.User;

public class GameLobby<G extends Game, GT extends GameTable<G>, GF extends GameFactory<G, GT>> {
	
	protected GameMaker<G, GT, GF> gameMaker;
	private int numOfTables;
	private HashMap<GameTable<G>, List<User>> mapOfTables;
	
	public void setup() {
		
		for(int i=0; i>=numOfTables; i++){
			gameMaker = new GameMaker<G, GT, GF>(4);
			mapOfTables.put(gameMaker.getGameTable(), gameMaker.getGameTable().getUsers());
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
