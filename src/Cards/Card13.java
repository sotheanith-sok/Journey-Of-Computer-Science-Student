package Cards;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card13 extends Card{

	
	
	public Card13()
	{
		//super();
		super.setName("13");
		super.setCName("The Big Game");
		super.setCLocation("Play in the Pyrimad");
		super.setEffect("gain 1 Craft Chip and move to the Lactation Lounge");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("Pyramid"))
		{
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setCraft(player.getCraft() + 1);
		setEffect("gained 1 Craft Chip and moved to the Lactation Lounge");
		player.setLocation("Lactation Lounge");
		
	}

	
	

	
	

}
