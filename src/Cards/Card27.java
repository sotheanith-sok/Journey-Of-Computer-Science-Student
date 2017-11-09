package Cards;

import javax.swing.JOptionPane;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card27 extends Card{

	
	
	public Card27()
	{
		//super();
		super.setName("27");
		super.setCName("Loud Buzzing");
		super.setCLocation("Play in EAT Room");
		super.setEffect("Prerequiste: 3 Craft , Get 1 Chip of Your Choice; Fail : Lose 2 Quality Points");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(  player.getLocation().equals("Eat Club") && player.getCraft() >= 3 )
		{
			return true;
		}
		return false;
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		chooseOne(player , "gained");
		
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		
		
			player.setQualityPoints(player.getQualityPoints()-2);
			setEffect("and lost 2 Quality Points.");
		
	}
	

	
	

}
