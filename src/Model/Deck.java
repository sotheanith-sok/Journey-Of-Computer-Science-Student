package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
/**
 * 
 * @author Sotheanith Sok
 *
 *This is deck used to initialize and store all cards. It is also contains function for add and remove card from the deck.
 */
public class Deck {
	private ArrayList<Card> deck;
	private int discardCard=0;
	public Deck() {
		deck = new ArrayList<Card>();
		instantiateDeck();
	}

	public void instantiateDeck() {
		Scanner in=null; 
		try {
			in = new Scanner(new File("src/Images/Card_Information.txt"));
			while (in.hasNextLine()) {
				String[] cardInfo = in.nextLine().split("\\|");
				deck.add(new Card(cardInfo[0], cardInfo[1], cardInfo[2], Integer.parseInt(cardInfo[3]),
						Integer.parseInt(cardInfo[4]), Integer.parseInt(cardInfo[5]), Integer.parseInt(cardInfo[6]),
						Integer.parseInt(cardInfo[7]), Integer.parseInt(cardInfo[8])));
			}
			Collections.shuffle(deck);
		} catch (FileNotFoundException fnoe) {
			fnoe.printStackTrace();
		} finally{
			in.close();
		}
	}
	public Card removeCard() {
		Card c = deck.get(0);
		deck.remove(0);
		return c;
	}
	public void addCard(Card c) {
		deck.add(c);
	}
	public boolean isEmpty() {
		return deck.isEmpty();
	}
	public int size() {
		return deck.size();
	}
	
	public ArrayList<Card> getDeck()
	{
		return deck;
	}

}
