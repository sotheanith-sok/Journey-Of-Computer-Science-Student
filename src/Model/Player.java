package Model;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	int skillChips, qualityPoints, learning, craft, integrity;
	String name;
	String location = "ECS 308";
	boolean isHuman;
	ArrayList<Card> playerHand;
	Deck deck;

	public Player(String n, boolean isHuman, Deck d) {
		name = n;
		this.isHuman = isHuman;
		this.deck = d;
		playerHand = new ArrayList<Card>();
		Random rand = new Random();
		learning = rand.nextInt(3) + 1;
		craft = rand.nextInt(3) + 1;
		integrity = rand.nextInt(3) + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSkillChips() {
		return skillChips;
	}

	public void setSkillChips(int skillChips) {
		if (skillChips < 0) {
			this.skillChips = 0;
		} else {
			this.skillChips = skillChips;
		}
	}

	public int getQualityPoints() {
		return qualityPoints;
	}

	public void setQualityPoints(int qualityPoints) {
		if (qualityPoints < 0) {
			this.qualityPoints = 0;
		} else {
			this.qualityPoints = qualityPoints;
		}
	}

	public int getLearning() {
		return learning;
	}

	public void setLearning(int learning) {
		if (learning < 0) {
			this.learning = 0;
		} else {
			this.learning = learning;
		}
	}

	public int getCraft() {
		return craft;
	}

	public void setCraft(int craft) {
		if (craft < 0) {
			this.craft = 0;
		} else {
			this.craft = craft;
		}
	}

	public int getIntegrity() {
		return integrity;
	}

	public void setIntegrity(int integrity) {
		if (integrity < 0) {
			this.integrity = 0;
		} else {
			this.integrity = integrity;
		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isHuman() {
		return isHuman;
	}

	public void addCard(Card c) {
		if (playerHand.size() == 7) {
			deck.discardCard(c);
		} else {
			playerHand.add(c);
		}		
	}

	public void getNextCard() {
		Card c = playerHand.remove(0);
		playerHand.add(c);
	}

	public ArrayList<Card> getPlayerHand() {
		return playerHand;
	}

	public Card getSelectedCard() {
		return playerHand.get(0);
	}

	public ArrayList<String> getAllCardName() {
		ArrayList<String> s = new ArrayList<String>();
		for (int i = 0; i < getPlayerHand().size(); i++) {
			s.add(getPlayerHand().get(i).getName());
		}
		return s;
	}

	public void remove(String s) {
		int i = 0;
		for (; i < getPlayerHand().size(); i++) {
			if (getPlayerHand().get(i).getName() == s)
				break;
		}
		deck.discardCard(getPlayerHand().get(i));
	}

	public void addOneMoreCard() {
		this.addCard(deck.removeCard());
	}

	public Card remove() {
		return this.getPlayerHand().remove(0);
	}
}
