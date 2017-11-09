package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card32 extends Card {

	
	
	public Card32()
	{
		//super();
		super.setName("32");
		super.setCName("The Outpost");
		super.setCLocation("Play in any space outside ECS except Forbidden Parking");
		super.setEffect("Get 1 Chip of Your Choice");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		
		boolean valid = true;
		
			for(String room : getECS())
			{
				
				if(player.getLocation().equals(room) || player.getLocation().equals("Forbidden Parking"))
				{
					valid = false;
					break;
				}
				
			}
		
		return valid;
		
		
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		
		setEffect("gained 5 Quality Points");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		player.setQualityPoints(player.getQualityPoints() -5);
		setEffect("and lost 5 Quality Points.");
		
		
		
	}

}
