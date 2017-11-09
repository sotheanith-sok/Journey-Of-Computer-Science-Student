package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card30 extends Card {

	
	
	public Card30()
	{
		//super();
		super.setName("30");
		super.setCName("Elective Class");
		super.setCLocation("Play in Library");
		super.setEffect("Prerequiste: 2 Learning Chips, Gain 1 Learning Chip and 1 Game Card; Fail : Lose 2 Quality Points");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if( player.getLocation().equals("Library")   && player.getLearning() >= 2 )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setLearning(player.getLearning() + 1);
		player.drawCard();
		setEffect("gained 1 Learning Chip");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints() + 2);
		setEffect("and lost 2 Quality Points");
		
		
		
	}

}
