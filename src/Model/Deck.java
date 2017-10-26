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
public class Deck extends ArrayList<Card>{
//	private ArrayList<Card> deck;
	//private ArrayList<Card> hand;
	//private ArrayList<Card> availableCards;
	private int discardCard=0 , maxDeckSize = 5;
	private GameModel model;
	private GameView view;
	//public int cardIndex = 0;
	public HashMap cardMap =new HashMap();
	
	
	
	public Deck(GameModel model)  {
		this.model = model;
		instantiateDeck();
		//availableCards = new ArrayList<Card>();
		//instantiateDeck();
		
	}

	public void instantiateDeck()
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
		
		add(card00);
		add(card01);
		add(card02);
		add(card03);
		add(card04);
		add(card05);
		add(card06);
		add(card07);
		add(card08);
		add(card09);
		add(card10);
		
		for(Card c : this)
		{
			cardMap.put(c.getName(), c);
		}
		Collections.shuffle(this);
		
	}
/*
	public void instantiateDeck() {
		
		for(int i = 0 ; i < maxDeckSize ; i++ )
		{
			if(availableCards.size() > 0)
			{
				deck.add(availableCards.get(0));
				availableCards.remove(0);
			}
			
		}
	}
	*/
	public Card removeCard() {
		Card c = this.get(0);
		this.remove(0);
		return c;
	}
	
	
	/*public ArrayList<Card> getHand()
	{
		return hand;
	}*/
	/*
	public ArrayList<Card> getDeck()
	{
		return deck;
	}*/
	
	/*
	public int getCardIndex()
	{
		
		return cardIndex;
	}
	public void setCardIndex(int cardIndex)
	{
		
		this.cardIndex = cardIndex ;
	}*/
	public HashMap getCardMap()
	{
		return cardMap;
	}

}
