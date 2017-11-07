package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card26 extends Card {

	
	
	public Card26()
	{
		//super();
		super.setName("26");
		super.setCName("Press the Right Floor");
		super.setCLocation("Play at Elevators");
		super.setEffect("Prerequiste: 4 Learning Chips; Fail : Lose 2 Quality Points");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if( player.getLocation().equals("Elevators")   && player.getLearning() >= 4 )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		
		player.setCraft(player.getCraft() + 2);
		setEffect("gained 2 Craft Chip");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		setEffect("and lost 2 Quality Points.");
		player.setQualityPoints(player.getQualityPoints() - 2);
		
		
	}

}
