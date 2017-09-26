package Cards;

import Source.*;


public class Card1 extends Card{

	public Card1(String name, String effect) {
		super(name, effect);
		// TODO Auto-generated constructor stub
	}
	
	public Card1()
	{
		//super();
		super.setName("Card #1");
		super.setEffect("Just a Test");
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setLearning(player.getLearning() + 1);
		
	}
	

	
	

}
