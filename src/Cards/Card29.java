package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card29 extends Card {

	
	
	public Card29()
	{
		//super();
		super.setName("29");
		super.setCName("Soccer Goalie");
		super.setCLocation("Play in the George Allen Field");
		super.setEffect("Prerequiste: 3 Learning Chips and 3 Craft Chips , Gain 5 Quality Points and 1 Game Card; Fail : Go to Student Parking");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if( player.getLocation().equals("George Allen Field")   && player.getLearning() >= 3 && player.getCraft() >= 3 )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints() + 5);
		player.drawCard();
		setEffect("gained 5 Quality Points");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		setEffect("and was moved to the Student Parking");
		player.setLocation("Student Parking");
		
		
	}

}
