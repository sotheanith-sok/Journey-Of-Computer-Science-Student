package Model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class GameModel {
	Location location;
	Deck deck;
	ArrayList<Player> playerList;
	private String[] possiblePlayerNameList = new String[] { "Merritt", "Darrel", "Dominic", "Daria", "Fawn", "Shelly",
			"Rona", "Merlyn", "Verna", "Hannah" };

	public GameModel(String n) {
		// Create Variable
		location = new Location();
		deck = new Deck();
		playerList = new ArrayList<Player>();
		// Create Player
		playerList.add(new Player(promptName(), true,deck));
		playerList
				.add(new Player(possiblePlayerNameList[(int) (Math.random() * possiblePlayerNameList.length)], false, deck));
		playerList
				.add(new Player(possiblePlayerNameList[(int) (Math.random() * possiblePlayerNameList.length)], false, deck));
		for (int i = 0; i < playerList.size(); i++) {
			for (int y = 0; y < 5; y++) {
				playerList.get(i).addCard(deck.removeCard());
			}
		}
		playerList.get(0).setCraft(1000);
		playerList.get(0).setLearning(1000);
		playerList.get(0).setIntegrity(1000);
	}

	public void move(Player p, String location) {
		p.setLocation(location);
	}

	public String playCard(Player p) {
		Card c = p.getPlayerHand().remove(0);
		String output = c.effect(p);
		deck.discardCard(c);
		p.addCard(deck.removeCard());
		return output;
	}

	public void drawCard(Player p) {
		p.addCard(deck.removeCard());
	}

	public ArrayList<String> getAvailableLocation(Player p) {
		return location.getAvailableLocation(p);
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public Point getPlayerCoordinate(Player p) {
		return location.getPlayerCurrentLocationCoordinate(p);
	}

	public int getInPlayCardDeckSize() {
		return deck.getInPlayCardDeckSize();
	}

	public int getDiscardCardDeckSize() {
		return deck.getDiscardCardDeckSize();
	}

	public String promptName() {
		boolean valid = false;
		String userName = null;
		while (!valid) {
			userName = (String) JOptionPane.showInputDialog("Please Enter Your Name");
			if (userName != null && userName.length() > 0) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(null, "Your name must be at least 1 character, please try again!");
			}

		}
		return userName;
	}
	public String play(Player p) {
		Card c=p.remove();
		String output=c.effect(p);
		deck.discardCard(c);
		return output;	
		
	}
}
