package Cards;
import Model.Card;
import Model.Player;
public class Card06 extends Card {

	
	public Card06()
	{
		super("Exercising Mind and Body", 
				"src/Images/cardm06.png", 
				new String[] {"Rec Center"});
	}
	@Override
	public String pass(Player p) {
		// TODO Auto-generated method stub
		p.setIntegrity(p.getIntegrity()+1);
		return "1 Integrity Chip";
	}


}
