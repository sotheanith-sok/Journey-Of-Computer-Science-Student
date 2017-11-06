package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card04 extends Card {

	
	
	public Card04()
	{
		//super();
		super.setName("04");
		super.setCName("Professor Murgolo's CECS 174 Class");
		super.setCLocation("Play in ECS 302");
		super.setEffect("gain 1 Learning Chip");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("ECS 302") )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setLearning(player.getLearning() + 1);
		setEffect("gained 1 Learning Chip");
	}



}
