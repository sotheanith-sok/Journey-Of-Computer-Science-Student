package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card05 extends Card {

	
	
	public Card05()
	{
		//super();
		super.setName("05");
		super.setCName("CECS 100");
		super.setCLocation("Play in ECS 308");
		super.setEffect("gain 1 Craft Token");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("ECS 308") )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setCraft(player.getCraft() + 1);
		setEffect("gained 1 Craft Token");
	}

	
}
