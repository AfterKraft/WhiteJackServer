package com.whitejack.net.server;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.whitejack.api.net.server.Server;


public class WhiteServer extends Server {
	
	private final boolean onlineMode = true;
	private static final Logger log = Logger.getLogger("WhiteJack");
	
	private static Server server;
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		log.info("Welcome to WhiteJack Server!");
		server = new WhiteServer();
		log.info("Starting up server version "+ server.getVersion());
	}

}
