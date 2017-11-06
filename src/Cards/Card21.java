package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card21 extends Card {

	
	
	public Card21()
	{
		//super();
		super.setName("21");
		super.setCName("Pass Soccer Class , Play in George Allen Field");
		super.setEffect("Prerequiste: 5 Craft Chips , gain 5 Quality Points; Fail : Lose 3 Quality Points");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("George Allen Field") && player.getCraft() >= 5 )
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
		setEffect("and was moved to the Room of Retirement");
		player.setLocation("Room of Retirement");
		player.setQualityPoints(player.getQualityPoints()-3);
		
		
	}

}
