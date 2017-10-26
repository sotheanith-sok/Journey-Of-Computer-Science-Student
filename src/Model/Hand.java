package Model;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

	//private ArrayList<Card> hand;
	private int cardIndex = 0;
	private int maxSize = 5;
	Deck deck;
	public Hand(GameModel model)
	{
		deck = model.getDeck();
		instantiateHand(maxSize);
		//hand = new ArrayList<Card>();
		
	}
	private void instantiateHand(int maxSize)
	{
		for(int i = 0 ; i < maxSize ; i++ )
		{
			if(deck.size() > 0)
			{
				add(deck.removeCard());
				//deck.remove(0);
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
	
	

}
