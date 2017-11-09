package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card25 extends Card{

	
	
	public Card25()
	{
		//super();
		super.setName("25");
		super.setCName("Program Crashes");
		super.setCLocation("Play in Lactation Lounge");
		super.setEffect("Prerequiste: 2 Learning , Get 5 Quality Points and 1 Chip of Your Choice; Fail : Discard 1 Game Card ");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(  player.getLocation().equals("Lactation Lounge") && player.getLearning() >= 2 )
		{
			return true;
		}
		return false;
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		chooseOne(player, "gained 5 Quality Points and");
		
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
