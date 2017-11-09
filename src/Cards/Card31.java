package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card31 extends Card {

	
	
	public Card31()
	{
		//super();
		super.setName("31");
		super.setCName("Professor Hoffman");
		super.setCLocation("Play in any room in ECS except Lactation Lounge");
		super.setEffect("Prerequiste: 3 Learning Chips , Gain 5 Quality Points and 2 Game Cards; Fail : Lose 5 Quality Points and Go to Lactation Lounge");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		
		boolean valid = false;
		if(player.getLearning() >= 3)
		{
			for(String room : getECS())
			{
				
				if(player.getLocation().equals(room) && !player.getLocation().equals("Lactation Lounge"))
				{
					valid = true;
					break;
				}
				
			}
		}
		else
		{
			return false;
		}
		return valid;
		
		
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints() + 5);
		player.drawCard();
		player.drawCard();
		setEffect("gained 5 Quality Points");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints() -5);
		setEffect("and lost 5 Quality Points.");
		
		
		
	}

}
