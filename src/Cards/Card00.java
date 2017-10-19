package Cards;

import Model.Card;
import Model.Player;


public class Card00 extends Card{

	public Card00(String name, String effect) {
		super(name, effect);
		// TODO Auto-generated constructor stub
	}
	
	public Card00()
	{
		//super();
		super.setName("00");
		super.setEffect("Just a Test");
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
