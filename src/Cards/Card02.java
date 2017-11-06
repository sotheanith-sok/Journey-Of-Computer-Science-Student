package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card02 extends Card {

	
	
	public Card02()
	{
		//super();
		super.setName("02");
		super.setCName("Lunch at Bratwurst Hall");
		super.setCLocation("Play in Bratwurst Hall");
		super.setEffect("gain 1 Craft Chip");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("Bratwurst Hall") )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setCraft(player.getCraft() + 1);
		setEffect("gained 1 Craft Chip");
	}

	

}
