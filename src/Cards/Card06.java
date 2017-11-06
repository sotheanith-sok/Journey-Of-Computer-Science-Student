package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card06 extends Card {

	
	public Card06()
	{
		//super();
		super.setName("06");
		super.setCName("Exercising Mind and Body");
		super.setCLocation("Play in Student Recreation");
		super.setEffect("gain 1 Integrity Chip");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("Rec Center") )
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
