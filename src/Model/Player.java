package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Cards.CardNULL;

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
		playerHand.add(c);
		while (playerHand.size() > 7) {
			if (isHuman() == true) {
				ArrayList<Object> buttonList = new ArrayList<Object>();
				for (int i = 0; i < getPlayerHand().size(); i++) {
					JButton image = new JButton(getPlayerHand().get(i).getName(),
							new ImageIcon(getPlayerHand().get(i).getPath()));
					image.setHorizontalTextPosition(JButton.CENTER);
					image.setVerticalTextPosition(JButton.EAST);
					image.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							remove(image.getText());
							JOptionPane.getRootFrame().dispose();
						}
					});
					buttonList.add(image);

				}

				JOptionPane.showOptionDialog(null, "Please select a card to be remove:", "Too many cards!!!", JOptionPane.DEFAULT_OPTION,
						JOptionPane.ERROR_MESSAGE, null, buttonList.toArray(new Object[buttonList.size()]), null);
			} else {
				deck.discardCard(playerHand.remove((int) Math.random() * playerHand.size()));
			}
		}
	}

	public void getNextCard() {
		if (getPlayerHand().size() > 0) {
			Card c = playerHand.remove(0);
			playerHand.add(c);
		}
	}

	public ArrayList<Card> getPlayerHand() {
		return playerHand;
	}

	public Card getSelectedCard() {
		if (playerHand.size() == 0) {
			return new CardNULL();
		}
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
			if (getPlayerHand().get(i).getName().compareTo(s) == 0)
				break;
		}

		if (getPlayerHand().size() > 0)
			deck.discardCard(getPlayerHand().remove(i));

	}

	public void addOneMoreCard() {
		this.addCard(deck.removeCard());
	}

	public Card remove() {
		if (getPlayerHand().size() == 0) {
			return new CardNULL();
		}
		return getPlayerHand().remove(0);
	}
}
