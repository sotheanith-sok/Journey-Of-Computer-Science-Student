package Cards;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card12 extends Card{

	public Card12(String name, String cName, String effect , GameModel model , GameView view) {
		super(name, cName ,effect, model, view);
		// TODO Auto-generated constructor stub
	}
	
	public Card12()
	{
		//super();
		super.setName("12");
		super.setCName("Late For Class");
		super.setEffect("gain 1 Craft Chip and move to the Lactation Lounge");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(!player.getLocation().equals("Forbidden Parking"))
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

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		
	}
	

	
	

}
