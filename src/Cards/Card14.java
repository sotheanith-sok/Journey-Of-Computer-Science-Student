package Cards;

import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;


public class Card14 extends Card{

	
	
	public Card14()
	{
		//super();
		super.setName("14");
		super.setCName("Math 123");
		super.setCLocation("Play in ECS 302 or ECS 308");
		super.setEffect("Prerequiste: 5 Learning , Get 5 Quality Points; Fail : Lose 3 Quality Points and Lose 1 Game Card ");
	}


	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if( (player.getLearning() >= 5) && ( (player.getLocation().equals("ECS 302")) || (player.getLocation().equals("ECS 308"))  ))
		{
			return true;
		}
		
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints()+ 5);
		setEffect("gained 5 Quality Points");
		
		
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		
		player.setQualityPoints(player.getQualityPoints()-3);
		if(player.getHand().size() -1 >= 0)
		{
			player.discardACard(this);
			setEffect("and lost 3 quality points and discarded a card");
		}
		else
		{
			setEffect("and lost 3 quality points, their hand was empty.");
		}
	}
	

	
	

}
