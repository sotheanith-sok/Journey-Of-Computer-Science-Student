package Cards;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card10 extends Card{

	
	
	public Card10()
	{
		//super();
		super.setName("10");
		super.setCName("CECS 105");
		super.setCLocation("Play in ECS 302 or 308");
		super.setEffect("gain 1 Learning Chip");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("ECS 308") || player.getLocation().equals("ECS 302") )
		{
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		//player.setQualityPoints();
		player.setLearning(player.getLearning() + 1);
		setEffect("gained 1 Learning Chip");
		
	}



	
	

}
