package Cards;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card00 extends Card{

	public Card00(String name, String cName, String effect , GameModel model , GameView view) {
		super(name, cName ,effect, model, view);
		// TODO Auto-generated constructor stub
	}
	
	public Card00()
	{
		//super();
		super.setName("00");
		super.setCName("CECS 100");
		super.setEffect("gained 1 Learning Chip");
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
		
	}


	

	
	

}
