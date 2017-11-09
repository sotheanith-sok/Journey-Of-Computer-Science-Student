package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card23 extends Card{

	
	
	public Card23()
	{
		//super();
		super.setName("23");
		super.setCName("A New Laptop");
		super.setCLocation("Play in the Computer Lab");
		super.setEffect("Prerequiste: 4 Integrity , Get 3 Quality Points and 1 Chip of Your Choice; Fail : Discard 1 Game Card ");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if((player.getLocation().equals("Computer Lab") && player.getIntegrity() >= 4 ))
		{
			return true;
		}
		
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		
		chooseOne(player, "gained 3 Quality Points and");
		
		
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		
		if(player.getHand().size() -1 >= 0)
		{
			player.discardACard(this);
			setEffect("and discarded a card");
		}
		else
		{
			setEffect("but their hand was empty.");
		}
	}
	

	
	

}
