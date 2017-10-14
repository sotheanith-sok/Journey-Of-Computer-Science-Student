package Model;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GameModel {
	private Deck deck;
	Player[] listOfPlayer;
	private int discardCard = 0;
	private int playableCard = 0;
	Location location;

	public GameModel(String n) {
		deck = new Deck();
		listOfPlayer = new Player[3];
		listOfPlayer[0] = new Player(promptName());
		listOfPlayer[1] = new Player("Abe");
		listOfPlayer[2] = new Player("Cal");
		location = new Location();
	}

	public void play() {

	}

	public Player[] getPlayerList() {
		return listOfPlayer;
	}

	public int getDeckSize() {
		return deck.size();
	}

	public int getDiscardCardSize() {
		return discardCard;
	}

	public ArrayList<String> getAvaialableLocation(Player p) {
		return location.getAvailableLocation(p);
	}
	public void humanSequencing(Player p) {
		
	}
	public void AISequencing(Player p) {
		p.setLocation(location.getAvailableLocation(p).get((int) (Math.random()*location.getAvailableLocation(p).size())));
	}
	public Point getPlayerCurrentLocationCoordinate(Player p) {
		return location.getPlayerCurrentLocationCoordinate(p);
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

}
