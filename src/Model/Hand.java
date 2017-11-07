package Model;

import java.util.ArrayList;

import Cards.Card14;

public class Hand extends ArrayList<Card> {

	//private ArrayList<Card> hand;
	private int cardIndex = 0;
	private int maxSize = 5;
	Deck deck;
	GameModel model;
	public Hand(GameModel model)
	{
		this.model = model;
		deck = model.getDeck();
		instantiateHand(maxSize);
		//hand = new ArrayList<Card>();
		
	}
	private void instantiateHand(int maxSize)
	{
		
		
		for(int i = size() ; i < maxSize ; i++ )
		{
			if(deck.size() > 0)
			{
				
				add(deck.removeCard());
				
			}
			else
			{
				System.out.println("Deck is Empty");
			}
			
		}
		
	}
	public int getCardIndex()
	{
		
		return cardIndex;
	}
	public void setCardIndex(int cardIndex)
	{
		
		this.cardIndex = cardIndex ;
	}
	
	public int getMaxSize()
	{
		return maxSize;
		
	}
	
	
	
	
	

}
