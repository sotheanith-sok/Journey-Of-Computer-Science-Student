package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card20 extends Card {

	public Card20(String name, String cName, String effect , GameModel model , GameView view) {
		super(name, cName ,effect, model, view);
		// TODO Auto-generated constructor stub
	}
	
	public Card20()
	{
		//super();
		super.setName("20");
		super.setCName("Make the Dean's List, Play in North Hall or South Hall");
		super.setEffect("Prerequiste: 6 Learning Chips , gain 5 Quality Points; Fail : Go to Student Parking");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if( ( (player.getLocation().equals("North Hall")) || (player.getLocation().equals("South Hall"))   ) && player.getLearning() >= 6 )
		{
			return true;
		}
		return false;
		
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
		setEffect("did not meet the requirements. Moved to the Student Parking");
		player.setLocation("Student Parking");
		
		
	}

}
