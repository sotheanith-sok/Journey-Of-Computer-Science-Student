package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import Cards.*;
import View.GameView;
/**
 * 
 * @author Sotheanith Sok
 *
 *This is deck used to initialize and store all cards. It is also contains function for add and remove card from the deck.
 */
public class Deck {
	private ArrayList<Card> deck;
	private ArrayList<Card> availableCards;
	private int discardCard=0 , maxDeckSize = 5;
	private GameModel model;
	private GameView view;
	public int cardIndex = 0;
	public HashMap cardMap =new HashMap();
	public Deck(GameModel model) {
		this.model = model;
		availableCards = new ArrayList<Card>();
		instantiateAvailableCards();
		deck = new ArrayList<Card>();
		instantiateDeck();
		
	}

	public void instantiateAvailableCards()
	{
		Card 
			card00 = new Card00(),
			card01 = new Card01(), 
			card02 = new Card02(),
			card03 = new Card03(),
			card04 = new Card04(),
			card05 = new Card05(),
			card06 = new Card06(),
			card07 = new Card07(),
			card08 = new Card08(),
			card09 = new Card09(model),
			card10 = new Card10();
		
		ac(card00);
		ac(card01);
		ac(card02);
		ac(card03);
		ac(card04);
		ac(card05);
		ac(card06);
		ac(card07);
		ac(card08);
		ac(card09);
		ac(card10);
		
		for(Card c : availableCards)
		{
			cardMap.put(c.getName(), c);
		}
		Collections.shuffle(availableCards);
		
	}
	public void ac(Card c)
	{
		availableCards.add(c);
	}
	public void instantiateDeck() {
		/*Scanner in=null; 
		try {
			in = new Scanner(new File("src/Images/Card_Information.txt"));
			while (in.hasNextLine()) {
				String[] cardInfo = in.nextLine().split("\\|");
				/*deck.add(new Card(cardInfo[0], cardInfo[1], cardInfo[2], Integer.parseInt(cardInfo[3]),
						Integer.parseInt(cardInfo[4]), Integer.parseInt(cardInfo[5]), Integer.parseInt(cardInfo[6]),
						Integer.parseInt(cardInfo[7]), Integer.parseInt(cardInfo[8])));
				//deck.add();
				
			}
			Collections.shuffle(deck);
		} catch (FileNotFoundException fnoe) {
			fnoe.printStackTrace();
		} finally{
			in.close();
		}
		*/
		
		for(int i = 0 ; i < maxDeckSize ; i++ )
		{
			if(availableCards.size() > 0)
			{
				deck.add(availableCards.get(0));
				availableCards.remove(0);
			}
			
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
	public int getCardIndex()
	{
		
		return cardIndex;
	}
	public void setCardIndex(int cardIndex)
	{
		
		this.cardIndex = cardIndex ;
	}
	public HashMap getCardMap()
	{
		return cardMap;
	}

}
