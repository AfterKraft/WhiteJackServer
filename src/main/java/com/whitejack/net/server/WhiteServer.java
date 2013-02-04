package com.whitejack.net.server;

import java.awt.BorderLayout;
//import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.whitejack.api.Game;
import com.whitejack.api.GameFactory;
import com.whitejack.api.GameTable;
import com.whitejack.api.net.server.Server;

public class WhiteServer<G extends Game, GT extends GameTable<G>, GF extends GameFactory<G, GT>> extends Server {

//	private final boolean onlineMode = true;
	private static final Logger log = Logger.getLogger("WhiteJack");
	private JTextArea jta = new JTextArea();
	private GameLobby<G, GT, GF> lobby;
	private static Server server;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		log.info("Welcome to WhiteJack Server!");
		server = new WhiteServer<Game, GameTable<Game>, GameFactory<Game, GameTable<Game>>>();
		log.info("Starting up server version " + server.getVersion());
	}

	/**
	 * Constructs a server instance with multithreading for multiple clients.
	 */
	private WhiteServer() {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(new JScrollPane(jta), BorderLayout.CENTER);
		frame.setTitle("WhiteJack Server v" + super.getVersion());
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		try {
			// Make a server socket!
			ServerSocket serverSocket = new ServerSocket(5170);
			jta.append("WhiteJack Server Started at" + new Date() + '\n');

			lobby.setNumOfTables(5);
			lobby.setup();
			int clientNo = 1;
			while (true) {
				Socket socket = serverSocket.accept();

				jta.append("Started Thread for client " + clientNo + "at "
						+ new Date() + "\n");

				InetAddress inetAddress = socket.getInetAddress();
				jta.append("Client " + clientNo + "'s host name is "
						+ inetAddress.getHostName() + "\n");
				jta.append("Client " + clientNo + "'s IP address is "
						+ inetAddress.getHostAddress() + "\n");

				HandleClient task = new HandleClient(socket);

				new Thread(task).start();

				clientNo++;
			}
			
		} catch (IOException ex) {
			log.warn(ex);
		} finally {
			
		}
	}

	class HandleClient implements Runnable {

		private Socket socket;

		public HandleClient(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
//				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

				while (true) {
					// Do stuff here
					outputToClient.writeChars("You've connected to WhiteJack Server v" + getVersion());
				}
			} catch (IOException ex) {
				log.warn(ex);
			}

		}

	}

}
