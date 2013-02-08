package co.whitejack.games.blackjack;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import co.whitejack.api.Card;
import co.whitejack.api.Dealer;
import co.whitejack.api.Deck;
import co.whitejack.api.GameTable;
import co.whitejack.api.Hand;
import co.whitejack.api.User;

public class BlackJackGameTable extends GameTable<BlackJackGame> {

	private static final Logger log = Logger.getLogger("WhiteJack");
	private static final int MAX_HANDS = 4;

	/**
	 * Creates a container for the User and dealer
	 * 
	 * @param dealer
	 * @param users
	 */
	public BlackJackGameTable(Dealer dealer, List<User> users) {
		super(dealer, users);
	}

	/**
	 * Sets up the GameTable taking user bets for all players in playable <User>
	 * list.
	 */
	@Override
	public void setupTable() {
		for (User user : users) {
			Scanner bet = new Scanner(System.in);
			System.out.print(user.userName
					+ ", how much would you like to bet?");
			while (!bet.hasNextInt()) {
				System.out.println("Please enter a number!");
				bet.nextLine();
			}
			int betAmmount = bet.nextInt();
			while (betAmmount > user.balance) {
				System.out.println(user.userName
						+ ", you can't bet more than you have!");
				System.out.println(user.userName + ", for reference, you have "
						+ user.balance);
				betAmmount = bet.nextInt();
			}
			user.bet(betAmmount);
			user.hand = new Hand[MAX_HANDS];
			for(int i=0; i<MAX_HANDS; i++) {
				user.hand[i] = new Hand();
			}
		}
		deck = new Deck(52);
		deck.initDeck();
		deck.shuffle();
		super.game = new BlackJackGame();

		super.isSetUp = true;
	}

	/**
	 * Removes the User with userName matching from the GameTable
	 * 
	 * This can be called if a player can NOT play (isPlayable=false)
	 * 
	 * @param user
	 */
	@Override
	public void removePlayer(User user) {
		// Sets the boolean states to false for any system checks
		// User temp = new User(User user);
		log.debug("User name to remove is: " + user.userName);
		int index = -1;
		for (int i = 0; i < super.users.size(); i++) {
			User temp1 = super.users.get(i);
			log.debug("Temp1;s username is: " + temp1.userName);
			log.debug("Temp's name is :" + user.userName);
			if (temp1.userName.equals(user.userName)) {
				index = super.users.indexOf(temp1);
			} else {
			}
		}
		log.debug("the index to be removed is: " + index);
		super.users.remove(index);
		log.debug("[BlackJackGameTable] The requested user has been removed from the GameTable User list");
	}

	/**
	 * Starts a round of the game. Need to implement the new DeckArrayManager
	 */
	@Override
	protected void startGame() {
		this.game = new BlackJackGame();

		for (User user : users) { //Deal two cards for each user
			log.debug("The deck count is at: "+ deck.getCount());
			Card card = deck.serveCard();
			Hand hand = new Hand();
			log.debug("The deck count is at: "+ deck.getCount());
			log.debug("card is: " + card.getSuit() + " of " + card.getRank());
			hand.add(card);
			Card card1 = deck.serveCard();
			hand.add(card1);
			user.addHand(hand, MAX_HANDS);

			//			user.addCard(card, 0);
			log.info("Hey, "+user.userName+", your first hand has a:"+user.hand[0]);

		}
	}

	/**
	 * Plays a round for each user in the <User> list
	 * 
	 * End of round should request if game should be replayed
	 */
	@Override
	public void playGame() {
		initialize();
		shuffle();
		boolean run = true;
		do {
			for (User user : users) {
				run = play(user);
				if (!run)
					break;
			}
		} while (run);
		gameOver();
	}

	@Override
	public void getCard() {
		// TODO Auto-generated method stub
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
	}

	@Override
	public void initialize() {
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

}
