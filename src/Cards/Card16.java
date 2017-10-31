package Cards;
import Model.Card;
import Model.GameModel;
import Model.Player;
import View.GameView;
public class Card16 extends Card {

	public Card16(String name, String cName, String effect , GameModel model , GameView view) {
		super(name, cName ,effect, model, view);
		// TODO Auto-generated constructor stub
	}
	
	public Card16()
	{
		//super();
		super.setName("16");
		super.setCName("KIN 253 Learning the Rules of Soccer , Play in George Allen Field");
		super.setEffect("Prerequiste: 4 Integrity Chips , gain 2 Craft Chips; Fail : Go to Room of Retirement");
	}
	
	
	@Override
	public Boolean requirement(Player player ,String location, int stat) {
		if(player.getLocation().equals("George Allen Field") && player.getIntegrity() >= 4 )
		{
			return true;
		}
		return false;
		
	}


	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		player.setCraft(player.getCraft()+ 2);
		setEffect("gained 2 Craft Chips");
	}

	@Override
	public void fail(Player player) {
		// TODO Auto-generated method stub
		setEffect("did not meet the requirements. Moved to the Room of Retirement");
		player.setLocation("Room of Retirement");
		
		
	}

}
