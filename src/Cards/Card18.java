package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card18 extends Card {

	
	public Card18()
	{
		//super();
		super.setName("18");
		super.setCName("Choosing a Major");
		super.setCLocation("Play in CECS Conference Room");
		super.setEffect("Prerequiste: 3 Integrity , gain 5 Quality Points;, Fail : Lose 3 Quality Points");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("CECS Conference Room") && player.getIntegrity() >= 3 )
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
		setEffect("and lost 3 quality points.");
		player.setQualityPoints(player.getQualityPoints()-3);
		
		
	}

}
