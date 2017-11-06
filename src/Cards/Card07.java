package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card07 extends Card {

	
	
	public Card07()
	{
		//super();
		super.setName("07");
		super.setCName("Finding The Lab");
		super.setCLocation("Play At Elevators");
		super.setEffect("gain 1 Integrity Chip");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("Elevators") )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setIntegrity(player.getIntegrity() + 1);
		setEffect("gained 1 Integrity Chip");
	}


}
