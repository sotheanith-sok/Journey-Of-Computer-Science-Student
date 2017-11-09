package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card28 extends Card{

	
	
	public Card28()
	{
		//super();
		super.setName("28");
		super.setCName("Professor Englert");
		super.setCLocation("Play in CECS Conference");
		super.setEffect("Prerequiste: 3 Integrity , Get 1 Chip of Your Choice; Fail : Discard 1 Game Card ");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(  player.getLocation().equals("CECS Conference Room") && player.getIntegrity() >= 3 )
		{
			return true;
		}
		return false;
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		chooseOne(player , "");
		
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
